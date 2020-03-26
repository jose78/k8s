package com.github.demo.controller;

import com.github.demo.services.ProducerSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.TreeMap;


@RestController
@RequestMapping(value = "/kafka")
public class DemoController {

    @Autowired
    private ProducerSvc producerSvc;

    @Value(value = "${app.version}")
    private String  version;

    @Value(value = "${app.env}")
    private String  env;

    @GetMapping("/status")
    public Map<String , String> status() {
        Map<String , String> map=  new TreeMap<String,String>();
        map.put("Status" , "ok");
        map.put("version", version);
        map.put("env", env);
        return map;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producerSvc.sendMessage(message);
    }
}