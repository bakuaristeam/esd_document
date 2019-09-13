package com.Aris.esd_document.Service.api;

import com.Aris.esd_document.Service.internal.crud.DeleteDocumentRequest;
import com.Aris.esd_document.Service.internal.DocumentResponse;
import com.Aris.esd_document.Service.internal.crud.SaveDocumentRequest;
import com.Aris.esd_document.Service.internal.crud.UpdateDocumentRequest;
import com.Aris.esd_document.Service.internalService.DocumentCrudInternalServiceNew;
import com.Aris.esd_document.Service.internalService.DocumentSearchInternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crudServices")
public class DocumentCrudService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DocumentCrudInternalServiceNew documentCrudInternalService;

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



    @PostMapping("/delete")
    public DocumentResponse deleteDocument(@RequestBody DeleteDocumentRequest deleteDocumentRequest){

        return documentCrudInternalService.deleteIdDocument(deleteDocumentRequest);
    }

//
//
//    @GetMapping("/getDocCount/{idDocType}")
//    public ResponseDocCount getCount(@PathVariable("idDocType")long idDocType){
//        return documentCrudInternalService.getDocCount(idDocType);
//    }

}
