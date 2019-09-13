package com.Aris.esd_document.db.service;

import com.Aris.esd_document.db.entities.Document;
import com.Aris.esd_document.db.repo.RepoDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataBaseService {

    @Autowired
    RepoDocument repoDocument;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Document insertUpdate(Document document) throws Exception{
        document=repoDocument.save(document);
        logger.info("DataBaseService document :{]",document);
        return document;
    }

    public List<Document> findAllAsList(){
        return repoDocument.findAll();
    }

    public Document findByIdDocumentAndIsVisible(Long idDoc){
        return repoDocument.findByIdDocumentAndIsVisible(idDoc,1);
    }


}
