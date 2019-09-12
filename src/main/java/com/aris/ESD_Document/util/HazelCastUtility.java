package com.aris.ESD_Document.util;

import com.aris.ESD_Document.Service.internalService.ResponseDocCount;
import com.aris.ESD_Document.db.entities.Document;
import com.aris.ESD_Document.db.repo.RepoDocument;
import com.aris.ESD_Document.db.service.DataBaseService;
import com.aris.ESD_Document.proxy.ProxyApplicant;
import com.aris.ESD_Document.proxy.ProxyDepartment;
import com.aris.ESD_Document.proxy.ProxyDocType;
import com.aris.ESD_Document.proxy.proxyDitel.DocTypeViewRootModel;
import com.aris.ESD_Document.proxy.proxyDitel.ResponseApplicant;
import com.aris.ESD_Document.proxy.proxyDitel.ResponseSearchDepartmentByIdDep;
import com.aris.ESD_Document.proxy.proxyDitel.ResponseSearchDocType;
import com.hazelcast.core.IMap;
import com.hazelcast.core.ISet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class HazelCastUtility {

    @Autowired
    DataBaseService dataBaseService;

    @Autowired
    IMap<Long, Document> mapOfDocument;

    @Autowired
    ISet<Document> setOfDocument;


    @Autowired
    ProxyApplicant proxyApplicant;

    @Autowired
    ProxyDocType proxyDocType;

    @Autowired
    ProxyDepartment proxyDepartment;

    @Autowired
    RepoDocument repoDocument;

    @PostConstruct
    public void init() {
        startChacing();
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void startChacing() {
        List<Document> listOfDoc = dataBaseService.findAllAsList();
        for (Document document : listOfDoc) {
            mapOfDocument.put(document.getIdDocument(), document);
            setOfDocument.add(document);
        }
    }

    Document fromDb;

    private long getLastRootDocumentTypeId(List<DocTypeViewRootModel> responseCount) {
        DocTypeViewRootModel docTypeViewRootModel = new DocTypeViewRootModel();
        for (int i = 0; i < responseCount.size(); i++) {
            DocTypeViewRootModel d = responseCount.get(i);
            logger.info("*************************************************************************");
            logger.info("d :{}", d.toString());
            logger.info("*************************************************************************");
            if (d.getRoot() == null) {
                docTypeViewRootModel = d;
                break;
            } else {
                i=0;
                responseCount.clear();
                responseCount.addAll(d.getRoot());
            }
        }
        return docTypeViewRootModel.getId();
    }

    public Document save(Document document) throws Exception {

        logger.info("HazelcastUtility step1--------");
        if (document.getIdDocument() > 0) {
            fromDb = dataBaseService.findByIdDocumentAndIsVisible(document.getIdDocument());
            logger.info("HazelcastUtility step2--------");

            fromDb.setDocumentCode("");
            fromDb.setIdDocumentType(document.getIdDocumentType());
            fromDb.setIdApplicant(document.getIdApplicant());
            fromDb.setIdDepartment(document.getIdDepartment());
            fromDb.setIsVisible(1);
            fromDb.setNote(document.getNote());
            fromDb.setIdCreatedEmp(document.getIdCreatedEmp());
            fromDb.setIsDelete(0);
            fromDb.setQosma(document.getQosma());
            fromDb.setIsControl(document.getIsControl());
            fromDb.setVereqSayi(document.getVereqSayi());
            fromDb.setQosmaSayi(document.getQosmaSayi());
            fromDb.setExpiredDate(document.getExpiredDate());
            fromDb.setDocumentEnteredDate(document.getDocumentEnteredDate());
            fromDb.setIsMoved(document.getIsMoved());
            fromDb.setOrgNo(document.getOrgNo());
            fromDb.setOrgDate(document.getOrgDate());
            fromDb.setCombineDocument(document.getCombineDocument());

            fromDb.setIdOrganisation(document.getIdOrganisation());

//            document= repoDocument.save(document);

            document = dataBaseService.insertUpdate(document);

            logger.info("HazelcastUtility step3--------");

            //senedin codunun alinmasi
            //01 BNA nin kodu veya butun idarenin kodu
//            String docCode ="01-"+document.getIdDepartment()+"-";
//            String docIDForCode = document.getIdDocument()+"";
//            for(int i = 0;i<10-docIDForCode.length();i++){
//                docCode+="0";
//            }
//
//            docCode+=docIDForCode;
//            document.setDocumentCode(docCode);
//            document=dataBaseService.insertUpdate(document);
//            logger.info("step4--------");

            ResponseApplicant responseApplicant = proxyApplicant.getApplicantIdApplicant(document.getIdApplicant());
            logger.info("responseApplicant :{}", responseApplicant.toString());
            ResponseSearchDocType responseDocType = proxyDocType.getDocMovByIdDocType(document.getIdDocumentType());
            logger.info(" responseDocType:{}", responseDocType.toString());

            ResponseSearchDepartmentByIdDep responseDep = proxyDepartment.getDepartmentIdDep(document.getIdDepartment());
            logger.info(" responseDep:{}", responseDep.toString());

            List<DocTypeViewRootModel> responseCount = proxyDocType.getRootDocumentType(document.getIdDocumentType());
            logger.info(" responseDocType:{}", responseDocType.toString());
            document.setIdDocumentTypeRoot(getLastRootDocumentTypeId(responseCount));


            // TODO: 26/08/2019
            // vetendaslardan daxil olan senedlere gore kodun verilmesi

            if (responseApplicant.getApplicant() != null) {
                if (responseApplicant.getApplicant().getIsKollektiv() == 0) {

                    logger.info(" responseApplicant :{}", responseApplicant.getApplicant().toString());
                    String s = "";
                    s += getDocCount(document.getIdDocumentTypeRoot());

//                    String docIDForCode = document.getIdDocument() + "";
//                    for (int i = 0; i < 1 - docIDForCode.length(); i++) {
//                        s += "0";
//
//                    }


                    while (s.length() < 5) {
                        s = "0" + s;
                    }
//                    ResponseSearchDocType responseDocTypeLocal = proxyDocType.getDocMovByIdDocType(responseDocType.getDocumentMovByidDocumentType().getParentId());
                    String docCode1 = responseApplicant.getApplicant().getSurName().substring(0, 1) + "-" + s + "-" + responseDocType.getDocumentMovByidDocumentType().getDocNumber();
                    document.setDocumentCode(docCode1);
                    if (document.getDocumentCode().substring(0, 1).equalsIgnoreCase("-")) {
                        document.setDocumentCode(document.getDocumentCode().substring(1));
                    }
                    logger.info("document.SetDocCode :{}", document.toString());
                }

//                kollectiv
                else {
                    logger.info("responseApplicant.getApplicant():{}", responseApplicant.getApplicant());
                    String s = "";
                    s += getDocCount(document.getIdDocumentTypeRoot());

                    while (s.length() < 5) {
                        s = "0" + s;
                    }
//                    ResponseSearchDocType responseDocTypeLocal = proxyDocType.getDocMovByIdDocType(responseDocType.getDocumentMovByidDocumentType().getParentId());
                    String docCode1 = "Kol-" + s + "-" + responseDocType.getDocumentMovByidDocumentType().getDocNumber();
                    document.setDocumentCode(docCode1);
                    if (document.getDocumentCode().substring(0, 1).equalsIgnoreCase("-")) {
                        document.setDocumentCode(document.getDocumentCode().substring(1));
                    }
                }
            }
            //Daxil olan  senedler
            else if (responseDocType.getDocumentMovByidDocumentType().getParentId() > 0) {
                logger.info("responseApplicant :{}", responseApplicant.toString());
                String s = "";
                s += getDocCount(document.getIdDocumentTypeRoot());

                while (s.length() < 5) {
                    s = "0" + s;
                }
//                ResponseSearchDocType responseDocTypeLocal = proxyDocType.getDocMovByIdDocType(responseDocType.getDocumentMovByidDocumentType().getParentId());
                String docCode1 = responseDocType.getDocumentMovByidDocumentType().getDocNumber() + "-" + s;
                document.setDocumentCode(docCode1);
                if (document.getDocumentCode().substring(0, 1).equalsIgnoreCase("-")) {
                    document.setDocumentCode(document.getDocumentCode().substring(1));
                }
                logger.info("Document :{} ", document.toString());
            } else if (responseDocType.getDocumentMovByidDocumentType().getParentId() == 0) {
                logger.info("responseApplicant :{}", responseApplicant.toString());
                String s = "";
                s += getDocCount(document.getIdDocumentTypeRoot());

                while (s.length() < 5) {
                    s = "0" + s;
                }
//                ResponseSearchDocType responseDocTypeLocal = proxyDocType.getDocMovByIdDocType(responseDocType.getDocumentMovByidDocumentType().getParentId());
                String docCode1 = responseDocType.getDocumentMovByidDocumentType().getDocNumber() + "-" + s;
                document.setDocumentCode(docCode1);
                if (document.getDocumentCode().substring(0, 1).equalsIgnoreCase("-")) {
                    document.setDocumentCode(document.getDocumentCode().substring(1));
                }
                logger.info("Document :{} ", document.toString());
            } else {
                logger.info("responseApplicant :{}", responseApplicant.toString());
                String s = "";
                s += getDocCount(document.getIdDocumentTypeRoot());

                while (s.length() < 5) {
                    s = "0" + s;
                }
                String docCode1;
                if (responseDocType.getDocumentMovByidDocumentType().getDocNumber().length() > 0 && responseDocType.getDocumentMovByidDocumentType().getDocNumber() != null) {
                    docCode1 = responseDocType.getDocumentMovByidDocumentType().getDocNumber().replace("%count%", s);
                } else {
                    docCode1 = s;
                }
                document.setDocumentCode(docCode1);
                if (document.getDocumentCode().substring(0, 1).equalsIgnoreCase("-")) {
                    document.setDocumentCode(document.getDocumentCode().substring(1));
                }
                logger.info("Document :{} ", document.toString());
            }


        } else {
            fromDb = document;
        }
        document = dataBaseService.insertUpdate(document);
        mapOfDocument.put(document.getIdDocument(), document);
        setOfDocument.add(document);

        logger.info("HazelcastUtility step5--------");
        return document;
    }


    public Document getDoC(Long idDoc) throws Exception {

        if (mapOfDocument.isEmpty()) {
            startChacing();
        }
        fromDb = mapOfDocument.get(idDoc);
        if (fromDb == null) {
            startChacing();
        }

        return mapOfDocument.get(idDoc);
    }

    private long getDocCount(long idDocType) {
        try {
            long count = repoDocument.countByIdDocumentTypeRoot(idDocType);
            logger.info("Doc Count idEmpFrom count :{}", count);
            return count;
        } catch (Exception e) {
            logger.error("error :", e);
            return 0;
        }

    }
}
