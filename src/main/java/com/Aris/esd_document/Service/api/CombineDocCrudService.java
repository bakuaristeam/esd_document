package com.Aris.esd_document.Service.api;

import com.Aris.esd_document.Service.internal.CombineDocResponse;
import com.Aris.esd_document.Service.internalService.CombineDocCrudInternalService;
import com.Aris.esd_document.Service.internal.crud.RequestSaveCombineDoc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/combineCrudService")
public class CombineDocCrudService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    final CombineDocCrudInternalService combineDocCrudInternalService;

    public CombineDocCrudService(CombineDocCrudInternalService combineDocCrudInternalService) {
        this.combineDocCrudInternalService = combineDocCrudInternalService;
    }

    @PostMapping("/add")
    public CombineDocResponse saveCombineDocument(@RequestBody RequestSaveCombineDoc saveCombineDoc) {
        logger.info("esd_CombineDocument->add->request : {}"+saveCombineDoc.toString());

        return combineDocCrudInternalService.saveCombineDocument(saveCombineDoc);

    }

//    @PostMapping("/update")
//    public CombineDocResponse updateCombineDocument(@RequestBody RequestUpdateCombineDoc updateCombineDoc) {
//
//        logger.info("esd_CombineDocument->update->request : {}"+updateCombineDoc.toString());
//
//        return combineDocCrudInternalService.updateCombineDocument(updateCombineDoc);
//
//    }


    @GetMapping("/delete/{idCombineDoc}")
    public CombineDocResponse deleteDoc(@PathVariable("idCombineDoc")long idCombineDoc) {
        return combineDocCrudInternalService.deleteCombineDoc(idCombineDoc);
    }

}
