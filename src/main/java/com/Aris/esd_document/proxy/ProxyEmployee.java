package com.Aris.esd_document.proxy;

import com.Aris.esd_document.proxy.proxyDitel.ResponseSearchEmployee;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "employee",name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "esd_employee")
public interface ProxyEmployee {

    @GetMapping("/esd_employee/esd_employee/searchService/getEmployeeIdEmp/{idEmp}")
    public ResponseSearchEmployee getEmployeeIdEmp(@PathVariable("idEmp") long idEmp) ;

}
