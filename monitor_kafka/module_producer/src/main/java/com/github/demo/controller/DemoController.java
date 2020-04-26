package com.github.demo.controller;

import com.github.demo.models.User;
import com.github.demo.services.ProducerSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;


@RestController
@RequestMapping(value = "/kafka")
public class DemoController {

    @Autowired
    private ProducerSvc producerSvc;

    @Value(value = "${kafka_host}")
    private String kafkaHost;

    @Value(value = "${app.version}")
    private String version;

    @Value(value = "${app.env}")
    private String env;

    @GetMapping("/status")
    public Map<String, String> status() {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("Status", "ok");
        map.put("version", version);
        map.put("env", env);
        map.put("kafkaHost", kafkaHost);
        return map;
    }

    @PostMapping(value = "/publish", consumes = "application/json")
    public void sendMessageToKafkaTopic(@RequestBody User user) {
        for (int index = 0; index  < user.getTimes() ; index++)
            this.producerSvc.sendMessage(user.toString());
    }


}