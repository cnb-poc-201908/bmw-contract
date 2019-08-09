package com.bmw.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("bmw-contract-template")
public interface TemplateClient {
    @GetMapping(value = "/contract-template/templates/{templateId}", consumes = "application/json")
    String getTemplate(@PathVariable("templateId") String templateId);
}
