package com.Aris.esd_document.proxy.proxyDitel;


public class ResponseSearchEmployee {

    private int serverCode;
    private String serverMessage;
    private Employee employee;

    public ResponseSearchEmployee() {
    }

    public ResponseSearchEmployee(int serverCode, String serverMessage, Employee employee) {
        this.serverCode = serverCode;
        this.serverMessage = serverMessage;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "ResponseSearchEmployee{" +
                "serverCode=" + serverCode +
                ", serverMessage='" + serverMessage + '\'' +
                ", employee=" + employee +
                '}';
    }
}
