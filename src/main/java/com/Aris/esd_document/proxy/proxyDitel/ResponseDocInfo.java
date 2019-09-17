package com.Aris.esd_document.proxy.proxyDitel;

import org.springframework.lang.Nullable;

public class ResponseDocInfo {

    private int serverCode;
    private String serverMessage;
    private Doc document;
    private DocumentType documentType;
    @Nullable
    private Applicant applicant;
    @Nullable
    private Organisation organisation;

    public ResponseDocInfo(int serverCode, String serverMessage, Doc document, DocumentType documentType, @Nullable Applicant applicant, @Nullable Organisation organisation) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.document = document;
        this.documentType = documentType;
        this.applicant = applicant;
        this.organisation = organisation;
    }

    public ResponseDocInfo() {
    }

    @Override
    public String toString() {
        return "ResponseDocInfo{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", document=" + document +
                ", documentType=" + documentType +
                ", applicant=" + applicant +
                ", organisation=" + organisation +
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

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    @Nullable
    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(@Nullable Applicant applicant) {
        this.applicant = applicant;
    }

    @Nullable
    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(@Nullable Organisation organisation) {
        this.organisation = organisation;
    }
}
