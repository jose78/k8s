package com.demo.micrometer.prometheus.service;

import com.demo.micrometer.prometheus.model.Account;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class AccountService {

    @Autowired
    private MeterRegistry meterRegistry;
    private List<Account> lstAccount = new ArrayList<>();

    public AccountService() {
        Gauge.builder("beer.ordersInQueue", lstAccount, Collection::size)
                .description("Number of served account")
                .register(meterRegistry);
    }

    public void registerAccount(Account account) {
        lstAccount.add(account);

        meterRegistry.counter("demo.metrics.type", "value", account.type).increment();
        meterRegistry.counter("demo.metrics.bic", "value", account.bic).increment();
        meterRegistry.counter("demo.metrics.value", "value", account.value).increment();
    }
}