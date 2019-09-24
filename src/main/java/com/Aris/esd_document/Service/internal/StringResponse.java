package com.Aris.esd_document.Service.internal;

public class StringResponse  {

    private int serverCode;
    private String serverMessage;
    private String statusMessage;
    private String docCode;


    public int getServerCode() {
        return serverCode;
    }

    public StringResponse setServerCode(int serverCode) {
        this.serverCode = serverCode;
        return this;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public StringResponse setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
        return this;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public StringResponse setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
        return this;
    }

    public String getDocCode() {
        return docCode;
    }

    public StringResponse setDocCode(String docCode) {
        this.docCode = docCode;
        return this;
    }
}
