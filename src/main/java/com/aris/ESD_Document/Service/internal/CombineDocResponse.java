package com.aris.ESD_Document.Service.internal;

import com.aris.ESD_Document.db.entities.CombineDocument;

public class CombineDocResponse {

    private int serverCode;
    private String serverMessage;
    private String statusMessage;
    private CombineDocument combineDoc;

    public CombineDocResponse(int serverCode, String serverMessage, String statusMessage, CombineDocument combineDoc) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.statusMessage = statusMessage;
        this.combineDoc = combineDoc;
    }

    public CombineDocResponse() {
    }

    @Override
    public String toString() {
        return "CombineDocResponse{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", combineDoc=" + combineDoc +
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

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public CombineDocument getCombineDoc() {
        return combineDoc;
    }

    public void setCombineDoc(CombineDocument combineDoc) {
        this.combineDoc = combineDoc;
    }
}
