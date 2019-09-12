package com.aris.ESD_Document.proxy;

import com.aris.ESD_Document.proxy.proxyDitel.DocTypeViewRootModel;
import com.aris.ESD_Document.proxy.proxyDitel.ResponseSearchDocType;
import com.aris.ESD_Document.proxy.proxyDitel.ResponseSearchListDocType;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(contextId = "doctype",name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "esd_document_type")
public interface ProxyDocType {

    @GetMapping("/esd_document_type/searchServices/getDocTypeIdDocType/{idDocType}")
    public ResponseSearchDocType getDocMovByIdDocType(@PathVariable("idDocType") long idDocType);

    @GetMapping("/esd_document_type/searchServices/getDocOneType")
    public ResponseSearchListDocType getDocTypeOne();

    @GetMapping("/esd_document_type/searchServices/getDocTypeByType/getRootDocumentType/{idDocumentType}")
    public List<DocTypeViewRootModel> getRootDocumentType(@PathVariable("idDocumentType") long idDocumentType) ;
}
