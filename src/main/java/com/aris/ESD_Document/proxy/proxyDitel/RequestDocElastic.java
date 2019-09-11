package com.aris.ESD_Document.proxy.proxyDitel;



public class RequestDocElastic {

    private Applicant applicant;
    private Doc document;

    public RequestDocElastic(Applicant applicant, Doc document) {
        this.applicant = applicant;
        this.document = document;
    }

    public RequestDocElastic() {
    }

    @Override
    public String toString() {
        return "RequestDocElastic{" +
                "applicant=" + applicant +
                ", document=" + document +
                '}';
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Doc getDocument() {
        return document;
    }

    public void setDocument(Doc document) {
        this.document = document;
    }
}
