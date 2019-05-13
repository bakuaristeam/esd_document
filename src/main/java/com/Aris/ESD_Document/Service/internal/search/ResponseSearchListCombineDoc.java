package com.Aris.ESD_Document.Service.internal.search;

import com.Aris.ESD_Document.db.entities.CombineDocument;

import java.util.List;

public class ResponseSearchListCombineDoc {

    private int serverCode;
    private String serverMessage;
    private List<CombineDocument> listOfCombineDoc;

    public ResponseSearchListCombineDoc(int serverCode, String serverMessage, List<CombineDocument> listOfCombineDoc) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.listOfCombineDoc = listOfCombineDoc;
    }

    public ResponseSearchListCombineDoc() {
    }

    @Override
    public String toString() {
        return "ResponseSearchListCombineDoc{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", listOfCombineDoc=" + listOfCombineDoc +
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

    public List<CombineDocument> getListOfCombineDoc() {
        return listOfCombineDoc;
    }

    public void setListOfCombineDoc(List<CombineDocument> listOfCombineDoc) {
        this.listOfCombineDoc = listOfCombineDoc;
    }
}
