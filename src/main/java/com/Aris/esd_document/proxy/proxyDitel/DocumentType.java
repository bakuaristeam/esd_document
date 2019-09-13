package com.Aris.esd_document.proxy.proxyDitel;

public class DocumentType  {

    private long idDocumentType;
    private String documentTitle;
    private int parentId;
    private int type;
    private String docNumber;

    public DocumentType() {
    }

    public DocumentType(String documentTitle, int parentId, int type, String docNumber) {
        this.documentTitle = documentTitle;
        this.parentId = parentId;
        this.type = type;
        this.docNumber = docNumber;
    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "idDocumentType=" + idDocumentType +
                ", documentTitle='" + documentTitle + '\'' +
                ", parentId=" + parentId +
                ", type=" + type +
                ", docNumber='" + docNumber + '\'' +
                '}';
    }


    public long getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(long idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }
}
