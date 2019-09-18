package com.Aris.esd_document.proxy.proxyDitel;

import javax.persistence.*;
import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private long idEmp;
    private String name;
    private String surName;
    private String paternalName;
    private long idJob;
    private long idDep;
    private long parentEmpId;
    private int isDeleted;
    private int userRole;
    private String empCode;

    public Employee() {
    }

    public Employee(String name, String surName, String paternalName, long idJob, long idDep, long parentEmpId, int isDeleted, int userRole, String empCode) {
        this.name = name;
        this.surName = surName;
        this.paternalName = paternalName;
        this.idJob = idJob;
        this.idDep = idDep;
        this.parentEmpId = parentEmpId;
        this.isDeleted = isDeleted;
        this.userRole = userRole;
        this.empCode = empCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmp=" + idEmp +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", paternalName='" + paternalName + '\'' +
                ", idJob=" + idJob +
                ", idDep=" + idDep +
                ", parentEmpId=" + parentEmpId +
                ", isDeleted=" + isDeleted +
                ", userRole=" + userRole +
                ", empCode='" + empCode + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(long idEmp) {
        this.idEmp = idEmp;
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

    public String getPaternalName() {
        return paternalName;
    }

    public void setPaternalName(String paternalName) {
        this.paternalName = paternalName;
    }

    public long getIdJob() {
        return idJob;
    }

    public void setIdJob(long idJob) {
        this.idJob = idJob;
    }

    public long getIdDep() {
        return idDep;
    }

    public void setIdDep(long idDep) {
        this.idDep = idDep;
    }

    public long getParentEmpId() {
        return parentEmpId;
    }

    public void setParentEmpId(long parentEmpId) {
        this.parentEmpId = parentEmpId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}