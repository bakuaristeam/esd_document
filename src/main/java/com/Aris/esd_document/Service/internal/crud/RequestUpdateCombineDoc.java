package com.Aris.esd_document.Service.internal.crud;

public class RequestUpdateCombineDoc {

    private long idCombineDocument;
    private long idDocMain;
    private long idDocCombined;
    private  int isActive;
    public RequestUpdateCombineDoc() {
    }

    public RequestUpdateCombineDoc(long idCombineDocument, long idDocMain, long idDocCombined, int isActive) {
        this.idCombineDocument = idCombineDocument;
        this.idDocMain = idDocMain;
        this.idDocCombined = idDocCombined;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "RequestUpdateCombineDoc{" +
                "idCombineDocument=" + idCombineDocument +
                ", idDocMain=" + idDocMain +
                ", idDocCombined=" + idDocCombined +
                ", isActive=" + isActive +
                '}';
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
