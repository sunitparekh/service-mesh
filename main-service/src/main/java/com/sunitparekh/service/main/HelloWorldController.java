package com.sunitparekh.service.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

@RestController
public class HelloWorldController {

    @Value("${app.service.1.host}")
    String serviceName1;

    @Value("${app.service.2.host}")
    String serviceName2;

    @Autowired
    RestTemplate template;

    @GetMapping("/hello")
    public Map<String, String> hello(@RequestParam String name) {
        Logger.getLogger(HelloWorldController.class.getName()).info("************* MainService: HelloWorldController");
        Map result = new HashMap();
        try {
            result.putAll(Objects.requireNonNull(template.getForObject("http://" + serviceName1 + "/hello-internal?name=" + name, Map.class)));
            result.putAll(Objects.requireNonNull(template.getForObject("http://" + serviceName2 + "/hello-another-internal/" + name, Map.class)));
        } catch (Exception e) {
            Logger.getLogger(HelloWorldController.class.getName()).severe(e.getMessage());
        }
        result.put("mainService", "hello " + name);
        return result;
    }
}
