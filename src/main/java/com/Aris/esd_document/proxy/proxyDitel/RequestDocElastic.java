package com.Aris.esd_document.proxy.proxyDitel;



public class RequestDocElastic {

    private Applicant applicant;
    private Doc document;
    private Organisation organisation;
    private DocumentType documentType;

    public RequestDocElastic(Applicant applicant, Doc document, Organisation organisation, DocumentType documentType) {
        this.applicant = applicant;
        this.document = document;
        this.organisation = organisation;
        this.documentType = documentType;
    }

    public RequestDocElastic() {
    }

    @Override
    public String toString() {
        return "RequestDocElastic{" +
                "applicant=" + applicant +
                ", document=" + document +
                ", organisation=" + organisation +
                ", documentType=" + documentType +
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

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
}
