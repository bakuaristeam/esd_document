package com.Aris.ESD_Document.Service.api;

import com.Aris.ESD_Document.Service.internal.search.ResponseSearchListCombineDoc;
import com.Aris.ESD_Document.Service.internalService.CombineDocSearchInternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combineDocSearchService")
public class CombineDocSearchServices {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    final CombineDocSearchInternalService combineDocSearchInternalService;

    public CombineDocSearchServices(CombineDocSearchInternalService combineDocSearchInternalService) {
        this.combineDocSearchInternalService = combineDocSearchInternalService;
    }

    @GetMapping("/getCombineDocs/{mainIdDoc}")
    public ResponseSearchListCombineDoc getCombineDocByIdDoc(@PathVariable("mainIdDoc") long mainIdDoc){
        logger.info("esd_CombineDoc_mainIdDoc->search->request : {}",mainIdDoc);
        return combineDocSearchInternalService.getCombineDocByIdDoc(mainIdDoc);
    }



}
