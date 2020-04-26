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
    public void testAddAccountMissingHeader() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:" + 8080 + "/accounts/";
        URI uri = new URI(baseUrl);
        Account employee = new Account("BIC", "Adam", "Gilly", "test@email.com");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Account> request = new HttpEntity<>(employee, headers);
        restTemplate.postForEntity(uri, request, String.class);

    }
}

