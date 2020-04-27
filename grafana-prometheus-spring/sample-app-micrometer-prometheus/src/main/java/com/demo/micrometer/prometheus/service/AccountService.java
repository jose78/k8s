package com.demo.micrometer.prometheus.service;

import com.demo.micrometer.prometheus.controler.SimpleController;
import com.demo.micrometer.prometheus.model.Account;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class AccountService {

    @Autowired
    private MeterRegistry meterRegistry;
    private List<Account> lstAccount = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(AccountService.class);

    @PostConstruct
    public void init() {
        Gauge.builder("beer.ordersInQueue", lstAccount, Collection::size)
                .description("Number of served account")
                .register(meterRegistry);
    }

    public void registerAccount(Account account) {
        lstAccount.add(account);

        logger.info("1");

        meterRegistry.counter("demo.metrics.type", "value", account.type).increment();
        logger.info("1");
        meterRegistry.counter("demo.metrics.bic", "value", account.bic).increment();
        logger.info("2");
        meterRegistry.counter("demo.metrics.value", "value", account.value).increment();
    }
}