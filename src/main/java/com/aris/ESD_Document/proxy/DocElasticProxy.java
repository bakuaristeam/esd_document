package com.aris.ESD_Document.proxy;

import com.aris.ESD_Document.proxy.proxyDitel.RequestDocElastic;
import com.aris.ESD_Document.proxy.proxyDitel.ResponseDocElastic;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(contextId = "elastic",name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "esd_elastic")
public interface DocElasticProxy {

    @PostMapping("/esd_elastic/add")
    public ResponseDocElastic saveDocElastic(RequestDocElastic requestDocElastic);


}
