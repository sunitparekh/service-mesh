package com.sunitparekh.service.another;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class AnotherInternalHelloWorldController {

    @GetMapping("/hello-another-internal")
    public Map<String, String> hello(@RequestParam String name) {
        Logger.getLogger(AnotherInternalHelloWorldController.class.getName()).info("************* AnotherInternalHelloWorldController: called with name: " + name);
        return new HashMap() {{
            put("anotherInternalService", "hello " + name);
        }};
    }
}
