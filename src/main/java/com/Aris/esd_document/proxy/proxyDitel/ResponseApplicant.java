package com.Aris.esd_document.proxy.proxyDitel;

import org.springframework.lang.Nullable;

public class ResponseApplicant {
    private int serverCode;
    private String serverMessage;
    @Nullable
    private Applicant applicant;

    public ResponseApplicant(int serverCode, String serverMessage, @Nullable Applicant applicant) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.applicant = applicant;
    }

    public ResponseApplicant() {
    }

    @Override
    public String toString() {
        return "ResponseApplicant{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", applicant=" + applicant +
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

    @Nullable
    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(@Nullable Applicant applicant) {
        this.applicant = applicant;
    }
}
