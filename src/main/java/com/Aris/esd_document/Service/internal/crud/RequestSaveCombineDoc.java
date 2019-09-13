package com.Aris.esd_document.Service.internal.crud;

public class RequestSaveCombineDoc {
    private long idDocMain;
    private long idDocCombined;
    private  int isActive;

    public RequestSaveCombineDoc() {
    }

    public RequestSaveCombineDoc(long idDocMain, long idDocCombined, int isActive) {
        this.idDocMain = idDocMain;
        this.idDocCombined = idDocCombined;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "RequestSaveCombineDoc{" +
                "idDocMain=" + idDocMain +
                ", idDocCombined=" + idDocCombined +
                ", isActive=" + isActive +
                '}';
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
