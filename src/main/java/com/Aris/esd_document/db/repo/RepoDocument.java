package com.Aris.esd_document.db.repo;

import com.Aris.esd_document.db.entities.Document;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoDocument extends JpaRepository<Document,Long> {

    Document findByIdDocumentAndIsVisible(long idDoc,int isVisible);

    Document findByDocumentCodeAndIsVisibleAndIsDelete(String docCode, int isVisible,int isDelete);

    Document findByDocumentEnteredDateAndIsVisible(long docEnteredDate,int isVisible);
    Document findByExpiredDateAndIsVisible(long expiredDate,int isVisible);

    Document findByIsControlAndIdDocumentIsAndIsVisible(int isControl,long idDoc,int isVisible);

    List<Document> findByIdDocumentTypeAndIsVisible(long idDocType,int isVisible);


    List<Document> findByIdDepartmentAndIsVisible(long idDep,int isVisible);
    List<Document> findByIdApplicantAndIsVisible(long idApplicant,int isVisible);
    List<Document> findByIsMovedAndIdCreatedEmpAndIsVisibleAndIsDeleteOrderByIdDocumentDesc(int isMoved,long idCreatedEmp,int isVisible,int isDelete);

    List<Document> findByIsControlAndIsVisible(int isControl,int isVisible);

    List<Document> findByIdCreatedEmp(long idCreatedEmp);

    List<Document> getAllByDocumentEnteredDateBetween(long from,long to);

    List<Document> findByIsControlAndIsVisibleAndIdCreatedEmp(int isControl,int isVisible,long idCreatedEmp);

    List<Document> findByIsVisible(int isVisible);

    long countByIdDocumentType(long idDocType);
    long countByIdDocumentTypeRoot(long idDocTypeRoot);

}
