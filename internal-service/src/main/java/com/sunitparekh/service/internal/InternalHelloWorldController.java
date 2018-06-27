package com.sunitparekh.service.internal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class InternalHelloWorldController {

    @GetMapping("/hello-internal")
    public Map<String, String> hello(@RequestParam String name) {
        Logger.getLogger(InternalHelloWorldController.class.getName()).info("************* InternalService: InternalHelloWorldController");
        return new HashMap() {{
            put("internalService", "hello " + name);
        }};
    }
}
