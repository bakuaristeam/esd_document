package com.aris.ESD_Document.db.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "document")
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDocument", nullable = false, unique = true)
    private long idDocument;
    private String documentCode;
    private long idDocumentType;
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
    private int orgNo;
    @Nullable
    private long orgDate;
    @Nullable
    private String organisation;

    @Nullable
    private long idOrganisation;


    public Document(String documentCode, long idDocumentType, long documentEnteredDate, long expiredDate, long idApplicant, long idDepartment, String note, int isVisible, int isDelete, long idCreatedEmp, int isControl, int isMoved, int vereqSayi, int qosma, int qosmaSayi, String combineDocument, int orgNo, long orgDate, @Nullable String organisation, long idOrganisation) {
        this.documentCode = documentCode;
        this.idDocumentType = idDocumentType;
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
        this.organisation = organisation;
        this.idOrganisation = idOrganisation;
    }

    public Document() {
    }

    @Override
    public String toString() {
        return "Document{" +
                "idDocument=" + idDocument +
                ", documentCode='" + documentCode + '\'' +
                ", idDocumentType=" + idDocumentType +
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
                ", orgNo=" + orgNo +
                ", orgDate=" + orgDate +
                ", organisation='" + organisation + '\'' +
                ", idOrganisation=" + idOrganisation +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public int getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(int orgNo) {
        this.orgNo = orgNo;
    }

    public long getOrgDate() {
        return orgDate;
    }

    public void setOrgDate(long orgDate) {
        this.orgDate = orgDate;
    }

    @Nullable
    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(@Nullable String organisation) {
        this.organisation = organisation;
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
