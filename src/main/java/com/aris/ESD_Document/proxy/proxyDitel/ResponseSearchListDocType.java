package com.aris.ESD_Document.proxy.proxyDitel;

import java.util.List;

public class ResponseSearchListDocType {

    private int serverCode;
    private String serverMessage;
    private List<DocumentType> listOfDoctype;

    public ResponseSearchListDocType(int serverCode, String serverMessage, List<DocumentType> listOfDoctype) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.listOfDoctype = listOfDoctype;
    }

    public ResponseSearchListDocType() {
    }

    @Override
    public String
    toString() {
        return "ResponseSearchListDocType{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", listOfDoctype=" + listOfDoctype +
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

    public List<DocumentType> getListOfDoctype() {
        return listOfDoctype;
    }

    public void setListOfDoctype(List<DocumentType> listOfDoctype) {
        this.listOfDoctype = listOfDoctype;
    }
}
