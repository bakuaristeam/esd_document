package com.aris.ESD_Document.proxy.proxyDitel;

import java.util.List;

public class DocTypeViewRootModel {
    private long Id;
    private String label;
    private DocumentType documentType;
    private List<DocTypeViewRootModel> root;

    public DocTypeViewRootModel() {
    }

    public DocTypeViewRootModel(long id, String label, DocumentType documentType, List<DocTypeViewRootModel> root) {
        Id = id;
        this.label = label;
        this.documentType = documentType;
        this.root = root;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public List<DocTypeViewRootModel> getRoot() {
        return root;
    }

    public void setRoot(List<DocTypeViewRootModel> root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "DocTypeViewRootModel{" +
                "Id=" + Id +
                ", label='" + label + '\'' +
                ", documentType=" + documentType +
                ", root=" + root +
                '}';
    }
}
