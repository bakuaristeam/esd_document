package com.Aris.esd_document.util;

import com.Aris.esd_document.db.entities.Document;
import com.Aris.esd_document.db.repo.RepoDocument;
import com.Aris.esd_document.db.service.DataBaseService;
import com.Aris.esd_document.proxy.ProxyApplicant;
import com.Aris.esd_document.proxy.ProxyDocType;
import com.Aris.esd_document.proxy.proxyDitel.DocTypeViewRootModel;
import com.Aris.esd_document.proxy.proxyDitel.ResponseApplicant;
import com.Aris.esd_document.proxy.proxyDitel.ResponseSearchDepartmentByIdDep;
import com.Aris.esd_document.proxy.proxyDitel.ResponseSearchDocType;
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
    RepoDocument repoDocument;

    @PostConstruct
    public void init() {
        mapOfDocument.clear();
        setOfDocument.clear();
        mapOfDocument.destroy();
        setOfDocument.destroy();
        startChacing();

    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private void startChacing(){
        List<Document> listOfDoc = dataBaseService.findAllAsList();
        for (Document document : listOfDoc) {
            mapOfDocument.put(document.getIdDocument(), document);
            setOfDocument.add(document);
        }
    }

    private Document fromDb;

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

//          document= repoDocument.save(document);
            document = dataBaseService.insertUpdate(document);

            logger.info("HazelcastUtility step3--------");

            ResponseApplicant responseApplicant = proxyApplicant.getApplicantIdApplicant(document.getIdApplicant());
            logger.info("responseApplicant :{}", responseApplicant.toString());
            ResponseSearchDocType responseDocType = proxyDocType.getDocMovByIdDocType(document.getIdDocumentType());
            logger.info(" responseDocType:{}", responseDocType.toString());


            DocTypeViewRootModel docTypeViewRootModel = proxyDocType.getRootDocumentType(document.getIdDocumentType());
            logger.info(" responseDocType:{}", responseDocType.toString());
            document.setIdDocumentTypeRoot(docTypeViewRootModel.getDocumentType().getIdDocumentType());

            String s = makeDocCode(document);

            if (responseApplicant.getApplicant() != null) {
                if (responseApplicant.getApplicant().getIsKollektiv() == 0) {
                    logger.info(" responseApplicant :{}", responseApplicant.getApplicant().toString());
                    String docCode1 = responseApplicant.getApplicant().getSurName().substring(0, 1) + "-" + s + "-" + responseDocType.getDocumentMovByidDocumentType().getDocNumber();
                    document.setDocumentCode(docCode1);
                    if (document.getDocumentCode().substring(0, 1).equalsIgnoreCase("-")) {
                        document.setDocumentCode(document.getDocumentCode().substring(1));
                    }
                    logger.info("document.SetDocCode :{}", document.toString());
                } else {
                    logger.info("responseApplicant.getApplicant():{}", responseApplicant.getApplicant());

                    String docCode1 = "Kol-" + s + "-" + responseDocType.getDocumentMovByidDocumentType().getDocNumber();
                    document.setDocumentCode(docCode1);
                    if (document.getDocumentCode().substring(0, 1).equalsIgnoreCase("-")) {
                        document.setDocumentCode(document.getDocumentCode().substring(1));
                    }
                }
            } else if (responseDocType.getDocumentMovByidDocumentType().getParentId() > 0) {
                logger.info("responseApplicant :{}", responseApplicant.toString());

                String docCode1 = responseDocType.getDocumentMovByidDocumentType().getDocNumber() + "-" + s;
                document.setDocumentCode(docCode1);
                if (document.getDocumentCode().substring(0, 1).equalsIgnoreCase("-")) {
                    document.setDocumentCode(document.getDocumentCode().substring(1));
                }
                logger.info("Document :{} ", document.toString());
            } else if (responseDocType.getDocumentMovByidDocumentType().getParentId() == 0) {
                logger.info("responseApplicant :{}", responseApplicant.toString());

                String docCode1;
                if(responseDocType.getDocumentMovByidDocumentType().getDocNumber().contains("%count%")){
                    docCode1 = responseDocType.getDocumentMovByidDocumentType().getDocNumber().replace("%count%", s);
                }else{
                    docCode1=responseDocType.getDocumentMovByidDocumentType().getDocNumber() + "-" + s;
                }
                document.setDocumentCode(docCode1);
                if (document.getDocumentCode().substring(0, 1).equalsIgnoreCase("-")) {
                    document.setDocumentCode(document.getDocumentCode().substring(1));
                }
                logger.info("Document :{} ", document.toString());
            } else {
                logger.info("responseApplicant :{}", responseApplicant.toString());

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

    private String makeDocCode(Document document) {
        String s = "";
        s += getDocCount(document.getIdDocumentTypeRoot());
        while (s.length() < 5) {
            s = "0" + s;
        }
        return s;
    }

    public Document getDoC(Long idDoc) {

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
