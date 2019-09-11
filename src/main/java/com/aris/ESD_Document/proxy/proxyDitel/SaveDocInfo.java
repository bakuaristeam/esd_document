package com.aris.ESD_Document.proxy.proxyDitel;

public class SaveDocInfo {

    private Applicant applicant;
    private Doc doc;
    private DocumentType documentType;

    public SaveDocInfo(Applicant applicant, Doc doc, DocumentType documentType) {
        this.applicant = applicant;
        this.doc = doc;
        this.documentType = documentType;
    }

    public SaveDocInfo() {
    }

    @Override
    public String toString() {
        return "SaveDocInfo{" +
                "applicant=" + applicant +
                ", doc=" + doc +
                ", documentType=" + documentType +
                '}';
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
}
