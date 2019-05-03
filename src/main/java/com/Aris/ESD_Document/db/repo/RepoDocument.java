package com.Aris.ESD_Document.db.repo;

import com.Aris.ESD_Document.db.entities.Document;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface RepoDocument extends CrudRepository<Document,Long>{


    Document findByIdDocumentAndIsVisible(long idDoc,int isVisible);
    Document findByDocumentCodeAndIsVisible(String docCode,int isVisible);
    Document findByDocumentEnteredDateAndIsVisible(long docEnteredDate,int isVisible);
    Document findByExpiredDateAndIsVisible(long expiredDate,int isVisible);

    Document findByIsControlAndIdDocumentIsAndIsVisible(int isControl,long idDoc,int isVisible);

    List<Document> findByIdDocumentTypeAndIsVisible(long idDocType,int isVisible);
    List<Document> findByIdOrganisationAndIsVisible(long idOrg,int isVisible);
    List<Document> findByIdDepartmentAndIsVisible(long idDep,int isVisible);
    List<Document> findByIdApplicantAndIsVisible(long idApplicant,int isVisible);
    List<Document> findByIsMovedAndIdCreatedEmpAndIsVisibleAndIsDeleteOrderByIdDocumentDesc(int isMoved,long idCreatedEmp,int isVisible,int isDelete);

//

}
