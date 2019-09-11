package com.aris.ESD_Document.proxy.proxyDitel;

import javax.persistence.*;
import java.io.Serializable;

public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    private long idDep;
    private String depTitle;
    private long parentId;
    private int orderNo;
    private int isVisible;
    private int depIndex;

    public Department() {
    }

    public Department(String depTitle, long parentId, int orderNo, int isVisible, int depIndex) {
        this.depTitle = depTitle;
        this.parentId = parentId;
        this.orderNo = orderNo;
        this.isVisible = isVisible;
        this.depIndex = depIndex;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDep=" + idDep +
                ", depTitle='" + depTitle + '\'' +
                ", parentId=" + parentId +
                ", orderNo=" + orderNo +
                ", isVisible=" + isVisible +
                ", depIndex=" + depIndex +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getIdDep() {
        return idDep;
    }

    public void setIdDep(long idDep) {
        this.idDep = idDep;
    }

    public String getDepTitle() {
        return depTitle;
    }

    public void setDepTitle(String depTitle) {
        this.depTitle = depTitle;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    public int getDepIndex() {
        return depIndex;
    }

    public void setDepIndex(int depIndex) {
        this.depIndex = depIndex;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
