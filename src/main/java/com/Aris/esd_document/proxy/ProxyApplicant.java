package com.Aris.esd_document.proxy;

import com.Aris.esd_document.proxy.proxyDitel.ResponseApplicant;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "applicant",name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "esd_applicant")
public interface ProxyApplicant {



    @GetMapping("/esd_applicant/searchService//getApplicantIdApplicant/{idApplicant}")
    public ResponseApplicant getApplicantIdApplicant(@PathVariable("idApplicant")long idApplicant);
}
