package com.Aris.esd_document.proxy.proxyDitel;

public class RegistredDocs {

    private  Doc document;
    private  Applicant applicant;
    private  DocumentType documentType;

    public RegistredDocs(Doc document, Applicant applicant, DocumentType documentType) {
        this.document = document;
        this.applicant = applicant;
        this.documentType = documentType;
    }

    public RegistredDocs() {
    }

    @Override
    public String toString() {
        return "RegistredDocs{" +
                "document=" + document +
                ", applicant=" + applicant +
                ", documentType=" + documentType +
                '}';
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

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
}
