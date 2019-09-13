package com.Aris.esd_document.Service.internal.search;

import com.Aris.esd_document.db.entities.Document;

import java.util.List;

public class ResponseSearchListDocument {

    private int serverCode;
    private String serverMessage;
    private List<Document> listOfDocument;

    public ResponseSearchListDocument(int serverCode, String serverMessage, List<Document> listOfDocument) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.listOfDocument = listOfDocument;
    }

    public ResponseSearchListDocument() {
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

    public List<Document> getListOfDocument() {
        return listOfDocument;
    }

    public void setListOfDocument(List<Document> listOfDocument) {
        this.listOfDocument = listOfDocument;
    }

    @Override
    public String toString() {
        return "ResponseSearchListDocument{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", listOfDocument=" + listOfDocument +
                '}';
    }
}
