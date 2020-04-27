package com.demo.micrometer.prometheus;

import com.demo.micrometer.prometheus.model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
public class TestRestApp {

    @Test
    public void testHello() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/hello";
        URI uri = new URI(baseUrl);
        Object result = restTemplate.getForObject(uri, String.class);
        System.out.println("obj:" + result);
    }

    @Test
    public void testAddAccountMissingHeader() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/accounts";
        URI uri = new URI(baseUrl);
        Account employee = new Account("BIC", "Adam", "Gilly", "test@email.com");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Account> request = new HttpEntity<>(employee, headers);
        restTemplate.postForObject(uri, request, Account.class);

    }
}

