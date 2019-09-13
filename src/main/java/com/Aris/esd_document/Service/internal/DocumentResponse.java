package com.Aris.esd_document.Service.internal;

import com.Aris.esd_document.db.entities.Document;

public class DocumentResponse {

    private int serverCode;
    private String serverMessage;
    private String statusMessage;
    private Document document;


    public DocumentResponse(int serverCode, String serverMessage, String statusMessage, Document document) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.statusMessage = statusMessage;
        this.document = document;
    }

    public DocumentResponse() {
    }

    @Override
    public String toString() {
        return "DocumentResponse{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", document=" + document +
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

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
