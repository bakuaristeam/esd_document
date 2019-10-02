package com.Aris.esd_document.proxy.proxyDitel;

public class DocumentType  {

    private long idDocumentType;
    private String documentTitle;
    private int parentId;
    private int type;
    private String docNumber;
    private String antonimDocCode;
    private String documentHeader;

    public DocumentType() {
    }


    public String getAntonimDocCode() {
        return antonimDocCode;
    }

    public DocumentType setAntonimDocCode(String antonimDocCode) {
        this.antonimDocCode = antonimDocCode;
        return this;
    }

    public DocumentType(long idDocumentType, String documentTitle, int parentId, int type, String docNumber, String antonimDocCode, String documentHeader) {
        this.idDocumentType = idDocumentType;
        this.documentTitle = documentTitle;
        this.parentId = parentId;
        this.type = type;
        this.docNumber = docNumber;
        this.antonimDocCode = antonimDocCode;
        this.documentHeader = documentHeader;
    }


    public String getDocumentHeader() {
        return documentHeader;
    }

    public DocumentType setDocumentHeader(String documentHeader) {
        this.documentHeader = documentHeader;
        return this;
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
