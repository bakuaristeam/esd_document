package com.aris.ESD_Document.proxy;

import com.aris.ESD_Document.proxy.proxyDitel.ResponseSearchDepartmentByIdDep;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "department",name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "esd_department")
public interface ProxyDepartment {

    @GetMapping("/esd_department/esd_dep/searchService/getDepartmentIdDep/{idDep}")
    public ResponseSearchDepartmentByIdDep getDepartmentIdDep(@PathVariable("idDep")long idDep);

}
