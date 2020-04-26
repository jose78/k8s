package com.demo.micrometer.prometheus.controler;

import com.demo.micrometer.prometheus.model.Account;
import com.demo.micrometer.prometheus.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {
    Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @Autowired
    private AccountService accountService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello from test service!!";
    }


    @PostMapping(path = "/accounts",
            consumes = "application/json")
    public void addAccount
            (
                    @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                    @RequestHeader(name = "X-COM-LOCATION", defaultValue = "ASIA") String headerLocation,
                    @RequestBody Account account
            ) throws Exception {

        accountService.registerAccount(account);
    }
}
