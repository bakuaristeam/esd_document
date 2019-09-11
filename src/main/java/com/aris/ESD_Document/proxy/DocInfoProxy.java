package com.aris.ESD_Document.proxy;

import com.aris.ESD_Document.proxy.proxyDitel.ResponseDocInfo;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "docinfo",name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "esd_doc_info")
public interface DocInfoProxy {

    @GetMapping("/esd_doc_info/getDocInfo/{idDoc}")
    public ResponseDocInfo getDocInfo(@PathVariable("idDoc") long idDoc);
}
