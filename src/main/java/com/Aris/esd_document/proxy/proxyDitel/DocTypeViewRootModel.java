package com.Aris.esd_document.proxy.proxyDitel;

public class DocTypeViewRootModel {
    private int code;
    private String message;
    private DocumentType documentType;

    public DocTypeViewRootModel() {
    }

    public DocTypeViewRootModel(int code, String message, DocumentType documentType) {
        this.code = code;
        this.message = message;
        this.documentType = documentType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    @Override
    public String toString() {
        return "DocTypeViewRootModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", documentType=" + documentType +
                '}';
    }
}
