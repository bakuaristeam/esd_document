package com.Aris.ESD_Document.Service.api;

import com.Aris.ESD_Document.Service.internal.crud.DeleteDocumentRequest;
import com.Aris.ESD_Document.Service.internal.DocumentResponse;
import com.Aris.ESD_Document.Service.internal.crud.SaveDocumentRequest;
import com.Aris.ESD_Document.Service.internal.crud.UpdateDocumentRequest;
import com.Aris.ESD_Document.Service.internal.search.ResponseSearchDocument;
import com.Aris.ESD_Document.Service.internalService.DocumentCrudInternalService;
import com.Aris.ESD_Document.Service.internalService.DocumentSearchInternalService;
import com.Aris.ESD_Document.db.repo.RepoDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crudServices")
public class DocumentCrudService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DocumentCrudInternalService documentCrudInternalService;

    @Autowired
    DocumentSearchInternalService documentSearchInternalService;


    @PostMapping("/add")
    public DocumentResponse saveDocument(@RequestBody SaveDocumentRequest saveDocumentRequest) {

        logger.info("esd_document->add->request : {}"+saveDocumentRequest.toString());

        return documentCrudInternalService.saveDocument(saveDocumentRequest);

    }

    @PostMapping("/update")
    public DocumentResponse updateDocument(@RequestBody UpdateDocumentRequest updateDocumentRequest) {

        logger.info("esd_document->update->request : {}"+updateDocumentRequest.toString());

        return documentCrudInternalService.updateDocument(updateDocumentRequest);

    }




    @GetMapping("/docIsMoved/{idDoc}")
    public DocumentResponse docIsMoved(@PathVariable("idDoc") long idDoc){

        return documentCrudInternalService.updateIsMoved(idDoc);
    }



    @GetMapping("/delete1/{idDocument}")
    public DocumentResponse deleteDocument1(@PathVariable("idDocument") long idDocument){

        return documentCrudInternalService.deleteIdDocument(idDocument);
    }




}
