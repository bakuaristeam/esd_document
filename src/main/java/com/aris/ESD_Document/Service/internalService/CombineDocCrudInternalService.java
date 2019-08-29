package com.aris.ESD_Document.Service.internalService;


import com.aris.ESD_Document.Service.internal.CombineDocResponse;
import com.aris.ESD_Document.Service.internal.crud.RequestSaveCombineDoc;
import com.aris.ESD_Document.db.entities.CombineDocument;
import com.aris.ESD_Document.db.repo.RepoCombineDocument;
import com.aris.ESD_Document.db.repo.RepoDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CombineDocCrudInternalService {

    final RepoCombineDocument repoCombineDocument;
    final RepoDocument repoDocument;


    public CombineDocCrudInternalService(RepoCombineDocument repoCombineDocument, RepoDocument repoDocument) {
        this.repoCombineDocument = repoCombineDocument;
        this.repoDocument = repoDocument;

    }




    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public CombineDocResponse saveCombineDocument(RequestSaveCombineDoc saveCombineDoc) {
        CombineDocResponse combineDocResponse = new CombineDocResponse();
        try {
            CombineDocument combineDocument = new CombineDocument();
            combineDocResponse.setServerCode(200);
            combineDocResponse.setStatusMessage("Saved");
            combineDocResponse.setServerMessage("OK");
            logger.info("CombineDocument response : {}", saveCombineDoc.toString());

            combineDocument.setIdDocMain(saveCombineDoc.getIdDocMain());
            combineDocument.setIdDocCombined(saveCombineDoc.getIdDocCombined());
            combineDocument.setIsActive(1);

            combineDocument = repoCombineDocument.save(combineDocument);
            combineDocResponse.setCombineDoc(combineDocument);

        }catch (Exception e) {
            combineDocResponse.setServerCode(100);
            combineDocResponse.setServerMessage("error");
            combineDocResponse.setStatusMessage("No Saved");
            logger.error("Error save file text : {}", e);
        }
        return combineDocResponse;

}
//
//
//
//
//
//
//    public CombineDocResponse updateCombineDocument(RequestUpdateCombineDoc updateCombineDoc) {
//        CombineDocResponse combineDocResponse = new CombineDocResponse();
//        try {
//            if (combineDocResponse != null) {
//                CombineDocument combineDocument = repoCombineDocument.findByIdCombineDocumentAndIsActive(updateCombineDoc.getIdCombineDocument(),1);
//                combineDocResponse.setStatusMessage("Saved");
//                combineDocResponse.setServerCode(200);
//                combineDocResponse.setServerMessage("OK");
//                logger.info("CombineDocument response : {}", updateCombineDoc.toString());
//
//                combineDocument.setIdDocCombined(updateCombineDoc.getIdDocCombined());
////                combineDocument.setIdDoc(updateCombineDoc.getIdDoc());
//                combineDocument.setIsActive(1);
//
//                combineDocument = repoCombineDocument.save(combineDocument);
//                combineDocResponse.setCombineDoc(combineDocument);
//
//            }else{
//                    combineDocResponse.setServerCode(200);
//                    combineDocResponse.setServerMessage("OK");
//                    combineDocResponse.setStatusMessage("file not found");
//                    logger.info("updateCombined response : {}", updateCombineDoc.toString());
//
//            }
//        }
//
//        catch (Exception e) {
//            combineDocResponse.setServerCode(100);
//            combineDocResponse.setServerMessage("error");
//            combineDocResponse.setStatusMessage("No Saved");
//            logger.error("Error save file text : {}", e);
//        }
//        return combineDocResponse;
//
//    }

    public CombineDocResponse deleteCombineDoc(long idCombineDoc) {
        CombineDocResponse combineDocResponse= new CombineDocResponse();
        try {
            CombineDocument combineDocument= repoCombineDocument.findByIdCombineDocumentAndIsActive(idCombineDoc,1);
            if(combineDocument!=null) {
                combineDocResponse.setServerCode(200);
                combineDocResponse.setServerMessage("OK");
                combineDocResponse.setStatusMessage("Deleted");
                logger.info("deleteCombineDocument response : {}", combineDocResponse.toString());

                combineDocument.setIsActive(0);
                combineDocument=repoCombineDocument.save(combineDocument);
                combineDocResponse.setCombineDoc(combineDocument);
            }else {
                combineDocResponse.setServerCode(200);
                combineDocResponse.setServerMessage("OK");
                combineDocResponse.setStatusMessage("file not found");
                logger.info("updateCombineDocument response : {}", combineDocResponse.toString());
            }
        } catch (Exception e) {
            combineDocResponse.setServerCode(100);
            combineDocResponse.setServerMessage("error");
            combineDocResponse.setStatusMessage("No Update");
            logger.error("Error delete file text : {}", e);
        }
        return combineDocResponse;
    }





}
