package com.demo.micrometer.prometheus.controler;

import com.demo.micrometer.prometheus.model.Account;
import com.demo.micrometer.prometheus.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {
    private static Logger logger = LoggerFactory.getLogger(SimpleController.class);

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
                    @RequestBody Account account
            ) throws Exception {
        logger.info("--> " + account);
        accountService.registerAccount(account);
    }
}
