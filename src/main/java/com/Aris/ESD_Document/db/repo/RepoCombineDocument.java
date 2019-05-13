package com.Aris.ESD_Document.db.repo;

import com.Aris.ESD_Document.db.entities.CombineDocument;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoCombineDocument extends CrudRepository<CombineDocument,Long> {

    List<CombineDocument> findByIdDocMainAndIsActive(long mainIdDoc,int isActive);

    CombineDocument findByIdCombineDocumentAndIsActive(long idCombineDoc,int isActive );

}
