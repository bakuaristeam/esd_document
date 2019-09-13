package com.Aris.esd_document.proxy.proxyDitel;


public class ResponseSearchDepartmentByIdDep {

    private int serverCode;
    private String serverMessage;
    private Department department;

    public ResponseSearchDepartmentByIdDep() {
    }

    public ResponseSearchDepartmentByIdDep(int serverCode, String serverMessage, Department department) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "ResponseSearchDepartmentByIdDep{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", department=" + department +
                '}';
    }
}
