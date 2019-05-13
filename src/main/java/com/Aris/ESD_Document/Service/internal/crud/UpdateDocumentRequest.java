package com.Aris.ESD_Document.Service.internal.crud;

import org.springframework.lang.Nullable;

import java.util.Date;

public class UpdateDocumentRequest {

    private long idDocument;
    private String documentCode;
    private long idDocumentType;
    private long documentEnteredDate;
    private long expiredDate;
    @Nullable
    private long idOrganisation;
    @Nullable
    private long idApplicant;
    @Nullable
    private long idDepartment;
    private String note;
    private int isVisible;
    private int isDelete;
    private long idCreatedEmp;
    private int isControl;
    private int isMoved;
    private int vereqSayi;
    private int qosma;
    private int qosmaSayi;

    public UpdateDocumentRequest(long idDocument, String documentCode, long idDocumentType, long documentEnteredDate, long expiredDate, long idOrganisation, long idApplicant, long idDepartment, String note, int isVisible, int isDelete, long idCreatedEmp, int isControl, int isMoved, int vereqSayi, int qosma, int qosmaSayi) {
        this.idDocument = idDocument;
        this.documentCode = documentCode;
        this.idDocumentType = idDocumentType;
        this.documentEnteredDate = documentEnteredDate;
        this.expiredDate = expiredDate;
        this.idOrganisation = idOrganisation;
        this.idApplicant = idApplicant;
        this.idDepartment = idDepartment;
        this.note = note;
        this.isVisible = isVisible;
        this.isDelete = isDelete;
        this.idCreatedEmp = idCreatedEmp;
        this.isControl = isControl;
        this.isMoved = isMoved;
        this.vereqSayi = vereqSayi;
        this.qosma = qosma;
        this.qosmaSayi = qosmaSayi;
    }

    public UpdateDocumentRequest() {
    }

    @Override
    public String toString() {
        return "UpdateDocumentRequest{" +
                "idDocument=" + idDocument +
                ", documentCode='" + documentCode + '\'' +
                ", idDocumentType=" + idDocumentType +
                ", documentEnteredDate=" + documentEnteredDate +
                ", expiredDate=" + expiredDate +
                ", idOrganisation=" + idOrganisation +
                ", idApplicant=" + idApplicant +
                ", idDepartment=" + idDepartment +
                ", note='" + note + '\'' +
                ", isVisible=" + isVisible +
                ", isDelete=" + isDelete +
                ", idCreatedEmp=" + idCreatedEmp +
                ", isControl=" + isControl +
                ", isMoved=" + isMoved +
                ", vereqSayi=" + vereqSayi +
                ", qosma=" + qosma +
                ", qosmaSayi=" + qosmaSayi +
                '}';
    }

    public long getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(long idDocument) {
        this.idDocument = idDocument;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    public long getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(long idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public long getDocumentEnteredDate() {
        return documentEnteredDate;
    }

    public void setDocumentEnteredDate(long documentEnteredDate) {
        this.documentEnteredDate = documentEnteredDate;
    }

    public long getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(long expiredDate) {
        this.expiredDate = expiredDate;
    }

    public long getIdOrganisation() {
        return idOrganisation;
    }

    public void setIdOrganisation(long idOrganisation) {
        this.idOrganisation = idOrganisation;
    }

    public long getIdApplicant() {
        return idApplicant;
    }

    public void setIdApplicant(long idApplicant) {
        this.idApplicant = idApplicant;
    }

    public long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public long getIdCreatedEmp() {
        return idCreatedEmp;
    }

    public void setIdCreatedEmp(long idCreatedEmp) {
        this.idCreatedEmp = idCreatedEmp;
    }

    public int getIsControl() {
        return isControl;
    }

    public void setIsControl(int isControl) {
        this.isControl = isControl;
    }

    public int getIsMoved() {
        return isMoved;
    }

    public void setIsMoved(int isMoved) {
        this.isMoved = isMoved;
    }

    public int getVereqSayi() {
        return vereqSayi;
    }

    public void setVereqSayi(int vereqSayi) {
        this.vereqSayi = vereqSayi;
    }

    public int getQosma() {
        return qosma;
    }

    public void setQosma(int qosma) {
        this.qosma = qosma;
    }

    public int getQosmaSayi() {
        return qosmaSayi;
    }

    public void setQosmaSayi(int qosmaSayi) {
        this.qosmaSayi = qosmaSayi;
    }
}
