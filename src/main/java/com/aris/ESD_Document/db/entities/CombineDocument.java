package com.aris.ESD_Document.db.entities;


import javax.persistence.*;

@Entity
@Table(name = "combineDocument")
public class CombineDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCombineDocument", nullable = false, unique = true)
    private long idCombineDocument;
    private long idDocMain;
    private long idDocCombined;
    private  int isActive;

    public CombineDocument(long idDocMain, long idDocCombined, int isActive) {
        this.idDocMain = idDocMain;
        this.idDocCombined = idDocCombined;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "CombineDocument{" +
                "idCombineDocument=" + idCombineDocument +
                ", idDocMain=" + idDocMain +
                ", idDocCombined=" + idDocCombined +
                ", isActive=" + isActive +
                '}';
    }

    public CombineDocument() {
    }

    public long getIdCombineDocument() {
        return idCombineDocument;
    }

    public void setIdCombineDocument(long idCombineDocument) {
        this.idCombineDocument = idCombineDocument;
    }

    public long getIdDocMain() {
        return idDocMain;
    }

    public void setIdDocMain(long idDocMain) {
        this.idDocMain = idDocMain;
    }

    public long getIdDocCombined() {
        return idDocCombined;
    }

    public void setIdDocCombined(long idDocCombined) {
        this.idDocCombined = idDocCombined;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
