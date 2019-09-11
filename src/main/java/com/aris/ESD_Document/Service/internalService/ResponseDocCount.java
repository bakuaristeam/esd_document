package com.aris.ESD_Document.Service.internalService;

public class ResponseDocCount {

    private int serverCode;
    private String serverMessage;
    private long docType;

    public ResponseDocCount(int serverCode, String serverMessage, long docType) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.docType = docType;
    }

    public ResponseDocCount() {
    }

    @Override
    public String toString() {
        return ""+docType;
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

    public long getDocType() {
        return docType;
    }

    public void setDocType(long docType) {
        this.docType = docType;
    }
}

