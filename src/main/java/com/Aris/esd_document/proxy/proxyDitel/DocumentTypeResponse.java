package com.Aris.esd_document.proxy.proxyDitel;

public class DocumentTypeResponse {

    private int serverCode;
    private String serverMessage;
    private String statusMessage;
    private DocumentType documentType;

    public DocumentTypeResponse(int serverCode, String serverMessage, String statusMessage, DocumentType documentType) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.statusMessage = statusMessage;
        this.documentType = documentType;
    }

    public DocumentTypeResponse() {
    }

    @Override
    public String toString() {
        return "DocumentTypeResponse{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", documentType=" + documentType +
                '}';
    }

    public int getServerCode() {
        return serverCode;
    }

    public void setServerCode(int serverCode) {
        this.serverCode = serverCode;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
}

