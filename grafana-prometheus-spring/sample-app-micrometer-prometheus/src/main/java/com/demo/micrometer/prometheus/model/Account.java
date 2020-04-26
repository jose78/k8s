package com.demo.micrometer.prometheus.model;

public class Account {
    public String bic;
    public String type;
    public String value;
    public String damage;

    public Account(){

    }

    public Account(String bic, String type, String value, String damage) {
        bic = this.bic;
        type = this.type;
        value = this.value;
        damage = this.damage;
    }


    @Override
    public String toString() {
        return "Account{" +
                "bic='" + bic + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", damage='" + damage + '\'' +
                '}';
    }
}