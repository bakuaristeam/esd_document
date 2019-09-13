package com.Aris.esd_document.proxy.proxyDitel;

public class ResponseDocInfo {

    private int serverCode;
    private String serverMessage;
    private Doc document;
    private  Applicant applicant;

    public ResponseDocInfo(int serverCode, String serverMessage, Doc document, Applicant applicant) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.document = document;
        this.applicant = applicant;
    }

    public ResponseDocInfo() {
    }

    @Override
    public String toString() {
        return "ResponseDocInfo{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", document=" + document +
                ", applicant=" + applicant +
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

    public Doc getDocument() {
        return document;
    }

    public void setDocument(Doc document) {
        this.document = document;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
