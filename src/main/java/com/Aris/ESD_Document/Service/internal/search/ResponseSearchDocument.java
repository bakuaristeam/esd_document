package com.Aris.ESD_Document.Service.internal.search;

import com.Aris.ESD_Document.db.entities.Document;

public class ResponseSearchDocument {

    private int serverCode;
    private String serverMessage;
    private Document document;

    public ResponseSearchDocument(int serverCode, String serverMessage, Document document) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.document = document;
    }

    public ResponseSearchDocument() {
    }

    @Override
    public String toString() {
        return "ResponseSearchDocument{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
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

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
