package com.aris.ESD_Document.Service.internal.crud;

public class DeleteDocumentRequest {

    private long idDocument;
    private long empId;

    public DeleteDocumentRequest(long idDocument, long empId) {
        this.idDocument = idDocument;
        this.empId = empId;
    }

    public DeleteDocumentRequest() {
    }

    public long getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(long idDocument) {
        this.idDocument = idDocument;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "DeleteDocumentRequest{" +
                "idDocument=" + idDocument +
                ", empId=" + empId +
                '}';
    }

//
}
