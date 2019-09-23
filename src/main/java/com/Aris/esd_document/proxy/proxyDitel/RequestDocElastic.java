package com.Aris.esd_document.proxy.proxyDitel;


import org.springframework.lang.Nullable;

public class RequestDocElastic {

    @Nullable
    private Applicant applicant;
    @Nullable
    private Doc document;
    @Nullable
    private Organisation organisation;
    @Nullable
    private DocumentType documentType;

    public RequestDocElastic(@Nullable Applicant applicant, @Nullable Doc document, @Nullable Organisation organisation, @Nullable DocumentType documentType) {
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

    @Nullable
    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(@Nullable Applicant applicant) {
        this.applicant = applicant;
    }

    @Nullable
    public Doc getDocument() {
        return document;
    }

    public void setDocument(@Nullable Doc document) {
        this.document = document;
    }

    @Nullable
    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(@Nullable Organisation organisation) {
        this.organisation = organisation;
    }

    @Nullable
    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(@Nullable DocumentType documentType) {
        this.documentType = documentType;
    }
}
