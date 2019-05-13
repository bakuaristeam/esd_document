package com.Aris.ESD_Document.Service.internalService;

import com.Aris.ESD_Document.Service.internal.search.*;
import com.Aris.ESD_Document.db.entities.Document;
import com.Aris.ESD_Document.db.repo.RepoDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DocumentSearchInternalService {
    @Autowired
    RepoDocument repoDocument;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ResponseSearchListDocument getDocByIdApplicant(long idApplicant){
        List<Document> listOfDocument= repoDocument.findByIdApplicantAndIsVisible(idApplicant,1);
        ResponseSearchListDocument response = new ResponseSearchListDocument();

        try {
            if (listOfDocument != null && listOfDocument.size()>0) {
                response.setListOfDocument(listOfDocument);
                response.setServerCode(200);
                response.setServerMessage(" Document found");
                logger.info("SearchDocument response : {}", response.toString());
            } else {
                response.setListOfDocument(null);
                response.setServerCode(220);
                response.setServerMessage("document not found");
            }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }

    public ResponseSearchListDocument getDocByIdDocType(long idDocType){
        List<Document> listOfDocument= repoDocument.findByIdDocumentTypeAndIsVisible(idDocType,1);
        ResponseSearchListDocument response = new ResponseSearchListDocument();

        try {
            if (listOfDocument != null && listOfDocument.size()>0) {

                response.setListOfDocument(listOfDocument);
                response.setServerCode(200);
                response.setServerMessage(" Document found");
                logger.info("searchDocument response : {}", response.toString());
            } else {
                response.setListOfDocument(null);
                response.setServerCode(220);
                response.setServerMessage("document not found ");
            }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }

    public ResponseSearchListDocument getDocByIdOrg(long idOrg){
        List<Document> listOfidOrganisation= repoDocument.findByIdOrganisationAndIsVisible(idOrg,1);
        ResponseSearchListDocument response = new ResponseSearchListDocument();
        try{
        if (listOfidOrganisation!=null&& listOfidOrganisation.size()>0){
            response.setListOfDocument(listOfidOrganisation);
            response.setServerCode(200);
            response.setServerMessage("Document found");
            logger.info("SearchDocument response : {}",response.toString());
        }else {
            response.setListOfDocument(null);
            response.setServerCode(220);
            response.setServerMessage("document not found search");
        }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }

    public ResponseSearchListDocument getDocByIdDep(long idDep){
        List<Document> listOfidDepartment= repoDocument.findByIdDepartmentAndIsVisible(idDep,1);
        ResponseSearchListDocument response = new ResponseSearchListDocument();
        try{
        if (listOfidDepartment!=null&&listOfidDepartment.size()>0){
            response.setListOfDocument(listOfidDepartment);
            response.setServerCode(200);
            response.setServerMessage("Document found");
            logger.info("SearchDocument response : {}",response.toString());
        }else {
            response.setListOfDocument(null);
            response.setServerCode(220);
            response.setServerMessage("Document not found search");
        }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }


    public ResponseSearchListDocument getDocByIdCreatedEmp(long idCreatedEmp){
        List<Document> listOfidCreatedEmp= repoDocument.findByIsMovedAndIdCreatedEmpAndIsVisibleAndIsDeleteOrderByIdDocumentDesc(0,idCreatedEmp,1,0);
        ResponseSearchListDocument response = new ResponseSearchListDocument();
        try{
        if (listOfidCreatedEmp!=null&&listOfidCreatedEmp.size()>0){

            response.setListOfDocument(listOfidCreatedEmp);
            response.setServerCode(200);
            response.setServerMessage(" Document found");
            logger.info(" searchDocument response : {}",response.toString());
        }else {
            response.setListOfDocument(null);
            response.setServerCode(220);
            response.setServerMessage("Document not found");
        }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }


    public ResponseSearchDocument getDocByIdDoc(long idDoc){
        Document document = repoDocument.findByIdDocumentAndIsVisible(idDoc,1);
        ResponseSearchDocument response = new ResponseSearchDocument();
        try{
        if (document!=null){
            response.setDocument(document);
            response.setServerCode(200);
            response.setServerMessage(" Document found");
            logger.info("searchDocument response : {}",response.toString());
        }else {
            response.setDocument(null);
            response.setServerCode(220);
            response.setServerMessage("Document not found");
        }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }

    public ResponseSearchDocument getDocByDocCode (String docCode){
        Document documentByDocumentCode = repoDocument.findByDocumentCodeAndIsVisibleAndIsDelete(docCode,1,0);
        ResponseSearchDocument response = new ResponseSearchDocument();
        try {
            if (documentByDocumentCode != null) {
                response.setDocument(documentByDocumentCode);
                response.setServerCode(200);
                response.setServerMessage(" DocumentCode found");
                logger.info("SearchDocumentCode response : {}", response.toString());
            } else {
                response.setDocument(null);
                response.setServerCode(220);
                response.setServerMessage("document not found");
            }
        }catch (Exception e){
                response.setServerCode(100);
                response.setServerMessage("error"+e);
                logger.info("error",e);
            }
        return response;

}

    public ResponseSearchDocument getDocByEnteredDate (long enteredDate){
        Document documentEnteredDate = repoDocument.findByDocumentEnteredDateAndIsVisible(enteredDate,1);
        ResponseSearchDocument response = new ResponseSearchDocument();
        try{
        if (documentEnteredDate!=null){
            response.setDocument(documentEnteredDate);
            response.setServerCode(200);
            response.setServerMessage(" Document found");
            logger.info("SearchDocument response : {}",response.toString());
        }else {
            response.setServerCode(220);
            response.setDocument(null);
            response.setServerMessage("document not found");
        }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }

    public ResponseSearchDocument getDocByExpiredDate (long expiredDate){
        Document documentExpiredDate = repoDocument.findByExpiredDateAndIsVisible(expiredDate,1);
        ResponseSearchDocument response = new ResponseSearchDocument();
        try{
        if (documentExpiredDate!=null){

            response.setDocument(documentExpiredDate);
            response.setServerCode(200);
            response.setServerMessage(" Document found");
            logger.info("SearchDocument response : {}",response.toString());

        }else {
            response.setDocument(null);
            response.setServerCode(220);
            response.setServerMessage("document not found");
        }
        }catch (Exception e){
                response.setServerCode(100);
                response.setServerMessage("error"+e);
                logger.info("error",e);
            }
        return response;
    }

    public ResponseSearchDocument getDocByIsControl(int isControl,long idDoc){
        Document documentExpiredDate = repoDocument.findByIsControlAndIdDocumentIsAndIsVisible(isControl,idDoc,1);

        ResponseSearchDocument response = new ResponseSearchDocument();
        try {
            if (documentExpiredDate != null) {

                response.setDocument(documentExpiredDate);
                response.setServerCode(200);
                response.setServerMessage(" Document found");
                logger.info(" searchDocument response : {}", response.toString());


            } else {
                response.setServerMessage("Document not Found");
                response.setDocument(null);
                response.setServerCode(220);
            }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }




}
