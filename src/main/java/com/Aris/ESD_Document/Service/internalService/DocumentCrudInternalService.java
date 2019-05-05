package com.Aris.ESD_Document.Service.internalService;

import com.Aris.ESD_Document.Service.internal.*;
import com.Aris.ESD_Document.Service.internal.crud.DeleteDocumentRequest;
import com.Aris.ESD_Document.Service.internal.crud.SaveDocumentRequest;
import com.Aris.ESD_Document.Service.internal.crud.UpdateDocumentRequest;
import com.Aris.ESD_Document.Service.internal.search.*;
import com.Aris.ESD_Document.db.entities.Document;
import com.Aris.ESD_Document.db.repo.RepoDocument;
import com.Aris.ESD_Document.testEnv.TestApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class DocumentCrudInternalService {

    @Autowired
    RepoDocument repoDocument;

    private Logger logger = LoggerFactory.getLogger("DocumentInternalServices");

    public DocumentResponse saveDocument(SaveDocumentRequest saveDocumentRequest) {
        DocumentResponse documentResponse = new DocumentResponse();
        try {
            Document document = new Document();
            documentResponse.setServerCode(200);
            documentResponse.setServerMessage("OK");
            documentResponse.setStatusMessage("Saved");
            logger.info("Document response : {}", saveDocumentRequest.toString());

//
            document.setIdDocumentType(saveDocumentRequest.getIdDocumentType());
            document.setDocumentCode("");
            document.setIdApplicant(saveDocumentRequest.getIdApplicant());
            document.setIdDepartment(saveDocumentRequest.getIdDepartment());
            document.setIdOrganisation(saveDocumentRequest.getIdOrganisation());
            document.setNote(saveDocumentRequest.getNote());
            document.setIdCreatedEmp(saveDocumentRequest.getIdCreatedEmp());
            document.setIsVisible(1);
            document.setIsDelete(0);
            document.setIsControl(saveDocumentRequest.getIsControl());

            document.setExpiredDate(saveDocumentRequest.getExpiredDate());
            document.setDocumentEnteredDate(saveDocumentRequest.getDocumentEnteredDate());
            document.setIsMoved(saveDocumentRequest.getIsMoved());

            document= repoDocument.save(document);

            //senedin codunun alinmasi
            //01 BNA nin kodu veya butun idarenin kodu
            String docCode ="01-"+document.getIdDepartment()+"-";
            String docIDForCode = document.getIdDocument()+"";
            for(int i = 0;i<10-docIDForCode.length();i++){
                docCode+="0";
            }

            docCode+=docIDForCode;
            document.setDocumentCode(docCode);
            document=repoDocument.save(document);

            documentResponse.setDocument(document);
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
        Document doc=repoDocument.findByIdDocumentAndIsVisible(idDoc,1);
        try {
            if(doc!=null) {
                documentResponse.setServerCode(200);
                documentResponse.setServerMessage("OK");
                documentResponse.setStatusMessage("Update");

                doc.setIsMoved(1);
                doc=repoDocument.save(doc);
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
        Document doc = repoDocument.findByIdDocumentAndIsVisible(updateDocumentRequest.getIdDocument(),1);

        try {
            if(doc!=null) {

                documentResponse.setServerCode(200);
                documentResponse.setServerMessage("OK");
                documentResponse.setStatusMessage("Update");
                logger.info("updateDocument response : {}", updateDocumentRequest.toString());

                doc.setDocumentCode(updateDocumentRequest.getDocumentCode());
                doc.setIdDocumentType(updateDocumentRequest.getIdDocumentType());
                doc.setIdApplicant(updateDocumentRequest.getIdApplicant());
                doc.setIdOrganisation(updateDocumentRequest.getIdOrganisation());
                doc.setIdDepartment(updateDocumentRequest.getIdDepartment());
                doc.setNote(updateDocumentRequest.getNote());
                doc.setIsVisible(1);
                doc.setIsDelete(0);
                doc.setIsControl(updateDocumentRequest.getIsControl());
                doc.setIdCreatedEmp(updateDocumentRequest.getIdCreatedEmp());

                doc.setExpiredDate(updateDocumentRequest.getExpiredDate());
                doc.setIsMoved(updateDocumentRequest.getIsMoved());
                doc.setDocumentEnteredDate(updateDocumentRequest.getDocumentEnteredDate());
                doc=repoDocument.save(doc);
                documentResponse.setDocument(doc);
            }else{
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





    public DocumentResponse deleteIdDocument(long idDocument) {
        DocumentResponse documentResponse = new DocumentResponse();
        try {
            Document doc = repoDocument.findByIdDocumentAndIsVisible(idDocument,1);
            DeleteDocumentRequest deleteDocumentRequest=new DeleteDocumentRequest();
            if (doc == null) {
                documentResponse.setServerMessage("OK");
                documentResponse.setServerCode(220);
                documentResponse.setStatusMessage("Document not found!!!");
            } else {
                if (doc.getIdCreatedEmp() == deleteDocumentRequest.getEmpId()) {
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
