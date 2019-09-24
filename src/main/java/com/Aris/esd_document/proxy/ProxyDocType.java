package com.Aris.esd_document.proxy;

import com.Aris.esd_document.proxy.proxyDitel.DocTypeViewRootModel;
import com.Aris.esd_document.proxy.proxyDitel.DocumentTypeResponse;
import com.Aris.esd_document.proxy.proxyDitel.ResponseSearchDocType;
import com.Aris.esd_document.proxy.proxyDitel.ResponseSearchListDocType;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "doctype",name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "esd_document_type")
public interface ProxyDocType {

    @GetMapping("/esd_document_type/searchServices/getDocTypeIdDocType/{idDocType}")
    public ResponseSearchDocType getDocMovByIdDocType(@PathVariable("idDocType") long idDocType);


    @GetMapping("/esd_document_type/searchServices/resolveCode/{id}")
    public DocumentTypeResponse resolveCode(@PathVariable("id") long idDocType);

    @GetMapping("/esd_document_type/searchServices/getDocOneType")
    public ResponseSearchListDocType getDocTypeOne();

    @GetMapping("/esd_document_type/searchServices/getDocTypeByType/getRootDocumentType/{idDocumentType}")
    DocTypeViewRootModel getRootDocumentType(@PathVariable("idDocumentType") long idDocumentType) ;
}
