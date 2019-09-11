package com.aris.ESD_Document.proxy.proxyDitel;


import java.util.List;

public class ResponseDocElastic {

    private int serverCode;
    private String serverMessage;
    private List<Doc> document;
    private List<Applicant> applicant;

    public ResponseDocElastic(int serverCode, String serverMessage, List<Doc> document, List<Applicant> applicant) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.document = document;
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "ResponseDocElastic{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", document=" + document +
                ", applicant=" + applicant +
                '}';
    }

    public ResponseDocElastic() {
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

    public List<Doc> getDocument() {
        return document;
    }

    public void setDocument(List<Doc> document) {
        this.document = document;
    }

    public List<Applicant> getApplicant() {
        return applicant;
    }

    public void setApplicant(List<Applicant> applicant) {
        this.applicant = applicant;
    }
}
