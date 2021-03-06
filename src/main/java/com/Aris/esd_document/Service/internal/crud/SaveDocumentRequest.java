package com.Aris.esd_document.Service.internal.crud;


import org.springframework.lang.Nullable;

public class SaveDocumentRequest {


    private String documentCode;
    private long idDocumentType;
    private long idDocumentTypeRoot;
    private long documentEnteredDate;
    private long expiredDate;
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
    private String combineDocument;
    @Nullable
    private String orgNo;
    @Nullable
    private long orgDate;
    @Nullable
    private long idOrganisation;


    public SaveDocumentRequest(String documentCode, long idDocumentType, long idDocumentTypeRoot, long documentEnteredDate, long expiredDate, long idApplicant, long idDepartment, String note, int isVisible, int isDelete, long idCreatedEmp, int isControl, int isMoved, int vereqSayi, int qosma, int qosmaSayi, String combineDocument, @Nullable String orgNo, long orgDate, long idOrganisation) {
        this.documentCode = documentCode;
        this.idDocumentType = idDocumentType;
        this.idDocumentTypeRoot = idDocumentTypeRoot;
        this.documentEnteredDate = documentEnteredDate;
        this.expiredDate = expiredDate;
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
        this.combineDocument = combineDocument;
        this.orgNo = orgNo;
        this.orgDate = orgDate;
        this.idOrganisation = idOrganisation;
    }

    public SaveDocumentRequest() {
    }

    @Override
    public String toString() {
        return "SaveDocumentRequest{" +
                "documentCode='" + documentCode + '\'' +
                ", idDocumentType=" + idDocumentType +
                ", idDocumentTypeRoot=" + idDocumentTypeRoot +
                ", documentEnteredDate=" + documentEnteredDate +
                ", expiredDate=" + expiredDate +
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
                ", combineDocument='" + combineDocument + '\'' +
                ", orgNo='" + orgNo + '\'' +
                ", orgDate=" + orgDate +
                ", idOrganisation=" + idOrganisation +
                '}';
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

    public long getIdDocumentTypeRoot() {
        return idDocumentTypeRoot;
    }

    public void setIdDocumentTypeRoot(long idDocumentTypeRoot) {
        this.idDocumentTypeRoot = idDocumentTypeRoot;
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

    public String getCombineDocument() {
        return combineDocument;
    }

    public void setCombineDocument(String combineDocument) {
        this.combineDocument = combineDocument;
    }

    @Nullable
    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(@Nullable String orgNo) {
        this.orgNo = orgNo;
    }

    public long getOrgDate() {
        return orgDate;
    }

    public void setOrgDate(long orgDate) {
        this.orgDate = orgDate;
    }

    public long getIdOrganisation() {
        return idOrganisation;
    }

    public void setIdOrganisation(long idOrganisation) {
        this.idOrganisation = idOrganisation;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

