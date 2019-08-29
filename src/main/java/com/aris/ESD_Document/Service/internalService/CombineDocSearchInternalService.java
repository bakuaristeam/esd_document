package com.aris.ESD_Document.Service.internalService;

import com.aris.ESD_Document.Service.internal.search.ResponseSearchListCombineDoc;
import com.aris.ESD_Document.db.entities.CombineDocument;
import com.aris.ESD_Document.db.repo.RepoCombineDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CombineDocSearchInternalService {

    final RepoCombineDocument repoCombineDocument;

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    public CombineDocSearchInternalService(RepoCombineDocument repoCombineDocument) {
        this.repoCombineDocument = repoCombineDocument;
    }

    public ResponseSearchListCombineDoc getCombineDocByIdDoc(long mainIdDoc){
        List<CombineDocument> listOfCombineDoc= repoCombineDocument.findByIdDocMainAndIsActive(mainIdDoc,1);
        ResponseSearchListCombineDoc response = new ResponseSearchListCombineDoc();

        try {
            if (listOfCombineDoc != null && listOfCombineDoc.size()>0) {
                response.setListOfCombineDoc(listOfCombineDoc);
                response.setServerCode(200);
                response.setServerMessage(" CombineDocument found");
                logger.info("SearchCombineDocument response : {}", response.toString());
            } else {
                response.setListOfCombineDoc(null);
                response.setServerCode(220);
                response.setServerMessage("CombineDocument not found");
            }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }

}
