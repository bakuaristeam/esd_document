package com.aris.ESD_Document.proxy.proxyDitel;


public class ResponseSearchDocType {

    private int serverCode;
    private String serverMessage;
    private DocumentType documentMovByidDocumentType;

    public ResponseSearchDocType(int serverCode, String serverMessage, DocumentType documentMovByidDocumentType) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.documentMovByidDocumentType = documentMovByidDocumentType;
    }

    public ResponseSearchDocType() {
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

    public DocumentType getDocumentMovByidDocumentType() {
        return documentMovByidDocumentType;
    }

    public void setDocumentMovByidDocumentType(DocumentType documentMovByidDocumentType) {
        this.documentMovByidDocumentType = documentMovByidDocumentType;
    }

    @Override
    public String toString() {
        return "ResponseSearchDocumentTypeByidDocumentType{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", documentMovByidDocumentType=" + documentMovByidDocumentType +
                '}';
    }
}
