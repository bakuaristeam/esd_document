package com.Aris.esd_document.proxy.proxyDitel;

import org.springframework.lang.Nullable;

import java.io.Serializable;

public class Applicant implements Serializable {
    private static final long serialVersionUID = 1L;


    @Nullable
    private long idApplicant;
    private String name;
    private String surName;
    @Nullable
    private String paternalName;
    @Nullable
    private String passportNo;
    private int isVisible;
    private int isKollektiv;

    @Nullable
    private String address;
    @Nullable
    private String telNO;
    @Nullable
    private String mail;


    public Applicant(long idApplicant, String name, String surName, @Nullable String paternalName, @Nullable String passportNo, int isVisible, int isKollektiv, @Nullable String address, @Nullable String telNO, @Nullable String mail) {
        this.idApplicant = idApplicant;
        this.name = name;
        this.surName = surName;
        this.paternalName = paternalName;
        this.passportNo = passportNo;
        this.isVisible = isVisible;
        this.isKollektiv = isKollektiv;
        this.address = address;
        this.telNO = telNO;
        this.mail = mail;
    }

    public Applicant() {
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "idApplicant=" + idApplicant +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", paternalName='" + paternalName + '\'' +
                ", passportNo='" + passportNo + '\'' +
                ", isVisible=" + isVisible +
                ", isKollektiv=" + isKollektiv +
                ", address='" + address + '\'' +
                ", telNO='" + telNO + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getIdApplicant() {
        return idApplicant;
    }

    public void setIdApplicant(long idApplicant) {
        this.idApplicant = idApplicant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Nullable
    public String getPaternalName() {
        return paternalName;
    }

    public void setPaternalName(@Nullable String paternalName) {
        this.paternalName = paternalName;
    }

    @Nullable
    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(@Nullable String passportNo) {
        this.passportNo = passportNo;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    public int getIsKollektiv() {
        return isKollektiv;
    }

    public void setIsKollektiv(int isKollektiv) {
        this.isKollektiv = isKollektiv;
    }

    @Nullable
    public String getAddress() {
        return address;
    }

    public void setAddress(@Nullable String address) {
        this.address = address;
    }

    @Nullable
    public String getTelNO() {
        return telNO;
    }

    public void setTelNO(@Nullable String telNO) {
        this.telNO = telNO;
    }

    @Nullable
    public String getMail() {
        return mail;
    }

    public void setMail(@Nullable String mail) {
        this.mail = mail;
    }
}
