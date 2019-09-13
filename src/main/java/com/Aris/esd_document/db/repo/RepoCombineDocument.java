package com.Aris.esd_document.db.repo;

import com.Aris.esd_document.db.entities.CombineDocument;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoCombineDocument extends CrudRepository<CombineDocument,Long> {

    List<CombineDocument> findByIdDocMainAndIsActive(long mainIdDoc,int isActive);

    CombineDocument findByIdCombineDocumentAndIsActive(long idCombineDoc,int isActive );

}
