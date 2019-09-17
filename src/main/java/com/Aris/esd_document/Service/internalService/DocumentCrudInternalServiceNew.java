package com.Aris.esd_document.Service.internalService;

import com.Aris.esd_document.Service.internal.DocumentResponse;
import com.Aris.esd_document.Service.internal.crud.DeleteDocumentRequest;
import com.Aris.esd_document.Service.internal.crud.SaveDocumentRequest;
import com.Aris.esd_document.Service.internal.crud.UpdateDocumentRequest;
import com.Aris.esd_document.db.entities.Document;
import com.Aris.esd_document.db.repo.RepoDocument;
import com.Aris.esd_document.proxy.*;
import com.Aris.esd_document.proxy.proxyDitel.*;
import com.Aris.esd_document.util.HazelCastUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DocumentCrudInternalServiceNew {

    private final RepoDocument repoDocument;
    private final HazelCastUtility hazelCastUtility;
    private final DocInfoProxy docInfoProxy;
    private final DocElasticProxy docElasticProxy;
    private final ProxyApplicant proxyApplicant;
    private final ProxyDocType proxyDocType;
    private final ProxyDepartment proxyDepartment;

    public DocumentCrudInternalServiceNew(RepoDocument repoDocument, HazelCastUtility hazelCastUtility, DocInfoProxy docInfoProxy, DocElasticProxy docElasticProxy, ProxyApplicant proxyApplicant, ProxyDocType proxyDocType, ProxyDepartment proxyDepartment) {
        this.repoDocument = repoDocument;
        this.hazelCastUtility = hazelCastUtility;
        this.docInfoProxy = docInfoProxy;
        this.docElasticProxy = docElasticProxy;
        this.proxyApplicant = proxyApplicant;
        this.proxyDocType = proxyDocType;
        this.proxyDepartment = proxyDepartment;
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public DocumentResponse saveDocument(SaveDocumentRequest saveDocumentRequest) {
        DocumentResponse documentResponse = new DocumentResponse();
        try {
            Document document = new Document();

            document.setDocumentCode("");

            document.setIdDocumentType(saveDocumentRequest.getIdDocumentType());
            document.setIdApplicant(saveDocumentRequest.getIdApplicant());
            document.setIdDepartment(saveDocumentRequest.getIdDepartment());
            document.setNote(saveDocumentRequest.getNote());
            document.setIdCreatedEmp(saveDocumentRequest.getIdCreatedEmp());
            document.setIsVisible(1);
            document.setIsDelete(0);
            document.setIsControl(saveDocumentRequest.getIsControl());
            document.setVereqSayi(saveDocumentRequest.getVereqSayi());
            document.setQosma(saveDocumentRequest.getQosma());
            document.setQosmaSayi(saveDocumentRequest.getQosmaSayi());

            document.setExpiredDate(saveDocumentRequest.getExpiredDate());
            document.setDocumentEnteredDate(saveDocumentRequest.getDocumentEnteredDate());
            document.setIsMoved(saveDocumentRequest.getIsMoved());
            document.setOrgDate(saveDocumentRequest.getOrgDate());
            document.setOrgNo(saveDocumentRequest.getOrgNo());

            document.setCombineDocument(saveDocumentRequest.getCombineDocument());
            document.setIdOrganisation(saveDocumentRequest.getIdOrganisation());

//          document= repoDocument.save(document);
            document = hazelCastUtility.save(document);
            logger.info("step1-----------------document :{}", document);

            ResponseApplicant responseApplicant = proxyApplicant.getApplicantIdApplicant(document.getIdApplicant());
            logger.info("responseApplicant :{}", responseApplicant.toString());
            ResponseSearchDocType responseDocType = proxyDocType.getDocMovByIdDocType(document.getIdDocumentType());
            logger.info(" responseDocType:{}", responseDocType.toString());

            ResponseSearchDepartmentByIdDep responseDep = proxyDepartment.getDepartmentIdDep(document.getIdDepartment());
            logger.info(" responseDep:{}", responseDep.toString());

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

                String docCode1 = responseDocType.getDocumentMovByidDocumentType().getDocNumber() + "-" + s;
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
//          document=repoDocument.save(document);
            document = hazelCastUtility.save(document);
            documentResponse.setDocument(document);
            logger.info("Doc----hazelCast----documentResponse-- :{}", documentResponse.toString());

            saveDocElastic(document);

            logger.info("step9 docda saveDocElastic : {} ", saveDocElastic(document).toString());

            documentResponse.setServerCode(200);
            documentResponse.setServerMessage("OK");
            documentResponse.setStatusMessage("Saved");
            logger.info("Document response : {}", saveDocumentRequest.toString());

            logger.info("step10");

        } catch (Exception e) {
            documentResponse.setServerCode(100);
            documentResponse.setServerMessage("error");
            documentResponse.setStatusMessage("No Saved");
            logger.error("Error save file text : {}", e);
        }
        return documentResponse;
    }

    private String makeDocCode(Document document) {
        String s = "";
        s += getDocCount(document.getIdDocumentTypeRoot());
        while (s.length() < 5) {
            s = "0" + s;
        }
        return s;
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

    private DocumentResponse saveDocElastic(Document document) {
        DocumentResponse documentResponse = new DocumentResponse();
        try {
            logger.info("step1");

            ResponseDocInfo docInfo = docInfoProxy.getDocInfo(document.getIdDocument());
            logger.info("--step2----------docInfo---------- : {}", docInfo.toString());

            RequestDocElastic requestDocElastic = new RequestDocElastic();

            requestDocElastic.setApplicant(docInfo.getApplicant());
            requestDocElastic.setDocument(docInfo.getDocument());
            requestDocElastic.setDocumentType(docInfo.getDocumentType());
            requestDocElastic.setOrganisation(docInfo.getOrganisation());

            logger.info("step3 :{}", requestDocElastic.toString());

            docElasticProxy.saveDocElastic(requestDocElastic);

            logger.info("step4 :{}", requestDocElastic.toString());
            documentResponse.setServerCode(200);
            documentResponse.setStatusMessage("Saved");


            logger.info("trying to send data to elastic service ");
        } catch (Exception e) {
            documentResponse.setServerCode(100);
            documentResponse.setServerMessage("error");
            documentResponse.setStatusMessage("No Saved");
            logger.error("Error save file text : {}", e);
        }
        return documentResponse;
    }

//    private long convertDateToDateTime(String date){
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        try {
//            Date d = f.parse(date);
//            long milliseconds = d.getTime();
//            return milliseconds;
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }

    public DocumentResponse updateIsMoved(long idDoc) {
        DocumentResponse documentResponse = new DocumentResponse();
        Document doc = repoDocument.findByIdDocumentAndIsVisible(idDoc, 1);
        try {
            if (doc != null) {
                documentResponse.setServerCode(200);
                documentResponse.setServerMessage("OK");
                documentResponse.setStatusMessage("Update");

                doc.setIsMoved(1);
                doc = repoDocument.save(doc);
                documentResponse.setDocument(doc);
            }
        } catch (Exception e) {
            documentResponse.setServerCode(100);
            documentResponse.setStatusMessage("No Update");
            documentResponse.setServerMessage("error");
            logger.error("Error save file text : {}", e);
        }
        return documentResponse;
    }


    public DocumentResponse updateDocument(UpdateDocumentRequest updateDocumentRequest) {
        DocumentResponse documentResponse = new DocumentResponse();
        Document doc = repoDocument.findByIdDocumentAndIsVisible(updateDocumentRequest.getIdDocument(), 1);
        try {
            if (doc != null) {
                documentResponse.setServerCode(200);
                documentResponse.setServerMessage("OK");
                documentResponse.setStatusMessage("Update");
                logger.info("updateDocument response : {}", updateDocumentRequest.toString());

                doc.setDocumentCode(updateDocumentRequest.getDocumentCode());
                doc.setIdDocumentType(updateDocumentRequest.getIdDocumentType());
                doc.setIdApplicant(updateDocumentRequest.getIdApplicant());
                doc.setIdDepartment(updateDocumentRequest.getIdDepartment());
                doc.setNote(updateDocumentRequest.getNote());
                doc.setIsVisible(1);
                doc.setIsDelete(0);
                doc.setIsControl(updateDocumentRequest.getIsControl());
                doc.setIdCreatedEmp(updateDocumentRequest.getIdCreatedEmp());

                doc.setExpiredDate(updateDocumentRequest.getExpiredDate());
                doc.setIsMoved(updateDocumentRequest.getIsMoved());
                doc.setDocumentEnteredDate(updateDocumentRequest.getDocumentEnteredDate());
                doc.setVereqSayi(updateDocumentRequest.getVereqSayi());
                doc.setQosma(updateDocumentRequest.getQosma());
                doc.setQosmaSayi(updateDocumentRequest.getQosmaSayi());
                doc.setOrgDate(updateDocumentRequest.getOrgDate());
                doc.setOrgNo(updateDocumentRequest.getOrgNo());
                doc.setCombineDocument(updateDocumentRequest.getCombineDocument());

                doc.setIdOrganisation(updateDocumentRequest.getIdOrganisation());
//                doc=repoDocument.save(doc);
                doc = hazelCastUtility.save(doc);
                documentResponse.setDocument(doc);
            } else {
                documentResponse.setServerCode(220);
                documentResponse.setServerMessage("OK");
                documentResponse.setStatusMessage("file not found");
                logger.info("updateDocument response : {}", documentResponse.toString());
            }
        } catch (Exception e) {
            documentResponse.setServerCode(100);
            documentResponse.setServerMessage("error");
            documentResponse.setStatusMessage("No Update");
            logger.error("Error save file text : {}", e);
        }
        return documentResponse;
    }


    public DocumentResponse deleteIdDocument(DeleteDocumentRequest deleteDocumentRequest) {
        DocumentResponse documentResponse = new DocumentResponse();
        try {
            Document doc = repoDocument.findByIdDocumentAndIsVisible(deleteDocumentRequest.getIdDocument(), 1);
            if (doc == null) {
                documentResponse.setServerMessage("OK");
                documentResponse.setServerCode(220);
                documentResponse.setStatusMessage("Document not found!!!");
            } else {
                if (deleteDocumentRequest.getIdDocument() == deleteDocumentRequest.getEmpId()) {
                    //icaze verirsenki silmeye
                    documentResponse.setServerCode(200);
                    documentResponse.setServerMessage("OK");
                    documentResponse.setStatusMessage("Deleted");
                    doc.setIsVisible(0);
                    repoDocument.save(doc);
                } else {
                    //silinmesine icaze yoxdu
                    documentResponse.setServerCode(220);
                    documentResponse.setServerMessage("OK");
                    documentResponse.setStatusMessage("You have not access to delete this document");
                }
            }
        } catch (Exception e) {
            documentResponse.setServerCode(100);
            documentResponse.setServerMessage("error");
            documentResponse.setStatusMessage("Error from server side");
            logger.error("Error delete : {}", e);
        }
        return documentResponse;
    }
}


