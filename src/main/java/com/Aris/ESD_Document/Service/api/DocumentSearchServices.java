package com.Aris.ESD_Document.Service.api;

import com.Aris.ESD_Document.Service.internal.search.*;
import com.Aris.ESD_Document.Service.internalService.DocumentSearchInternalService;
import com.Aris.ESD_Document.db.entities.Document;
import com.Aris.ESD_Document.db.repo.RepoDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/searchServices")
public class DocumentSearchServices {

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    DocumentSearchInternalService documentSearchInternalService;

    @Autowired
    RepoDocument repoDocument;

    @GetMapping("/getDocByIdApplicant/{idApplicant}")
    public ResponseSearchListDocument getDocByIdApplicant(@PathVariable("idApplicant") long idApplicant){
        logger.info("esd_Document_idApplicant->search->request : {}",idApplicant);
        return documentSearchInternalService.getDocByIdApplicant(idApplicant);
    }

    @GetMapping("/getDocByIdCreatedEmp/{idCreatedEmp}")
    public ResponseSearchListDocument getDocByIdCreatedEmp(@PathVariable("idCreatedEmp") long idCreatedEmp){
        logger.info("esd_Document_IdCreatedEmp ->search->request : {}",idCreatedEmp);
        return documentSearchInternalService.getDocByIdCreatedEmp(idCreatedEmp);
    }

    @GetMapping("/getDocByIdDocType/{idDocType}")
    public ResponseSearchListDocument getDocByIdDocType(@PathVariable("idDocType") long idDocType){
        logger.info("esd_Document_idDocumentType->search->request : {}",idDocType);
        return documentSearchInternalService.getDocByIdDocType(idDocType);
    }

    @GetMapping("/getDocByIdDep/{idDep}")
    public ResponseSearchListDocument getDocByIdDep(@PathVariable("idDep") long idDep){
        logger.info("esd_Document_idDepartment->search->request : {}",idDep);
        return documentSearchInternalService.getDocByIdDep(idDep);
    }

    @GetMapping("/getDocByIdDoc/{idDoc}")
    public ResponseSearchDocument getDocByIdDoc(@PathVariable("idDoc") long idDoc){
        logger.info("esd_Document_idDocument->search->request : {}",idDoc);
        return documentSearchInternalService.getDocByIdDoc(idDoc);
//
    }

    @GetMapping("/getDocByIdOrg/{idOrg}")
    public ResponseSearchListDocument getDocByIdOrg(@PathVariable("idOrg") long idOrg){
        logger.info("esd_Document_idOrganisation->search->request : {}",idOrg);
        return documentSearchInternalService.getDocByIdOrg(idOrg);
    }


    @GetMapping("/getDocByDocCode/{docCode}")
    public ResponseSearchDocument getDocByDocCode(@PathVariable("docCode") String docCode){
        logger.info("esd_Document_documentCode->search->request : {}",docCode);
        return documentSearchInternalService.getDocByDocCode(docCode);
    }

    @GetMapping("/getDocByExpiredDate/{expiredDate}")
    public ResponseSearchDocument getDocByExpiredDate(@PathVariable("expiredDate") long expiredDate){
        logger.info("esd_Document_expiredDate->search->request : {}",expiredDate);
        return documentSearchInternalService.getDocByExpiredDate(expiredDate);
    }

    @GetMapping("/getDocByEnteredDate/{enteredDate}")
    public ResponseSearchDocument getDocByEnteredDate(@PathVariable("enteredDate") long enteredDate){
        logger.info("esd_Document_enteredDate->search->request : {}",enteredDate);
        return documentSearchInternalService.getDocByEnteredDate(enteredDate);
    }

    @GetMapping("/getDocByIsControl/{isControl}{idDoc}")
    public ResponseSearchDocument getDocByIsControl(@PathVariable("isControl") int isControl,
                                                    @PathVariable("idDoc")long idDoc){
        logger.info("esd_Document_isControl->search->request : {}",isControl);
        return documentSearchInternalService.getDocByIsControl(isControl,idDoc);
    }


    @GetMapping("/document/all")
    public List<Document> getStudents(){
        Iterator<Document> iterator= repoDocument.findAll().iterator();
        List<Document> documents=new ArrayList<>();
        while(iterator.hasNext()){
            documents.add(iterator.next());
        }
        return documents;
    }

}
