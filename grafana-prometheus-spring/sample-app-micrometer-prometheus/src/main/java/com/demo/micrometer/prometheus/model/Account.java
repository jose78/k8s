package com.demo.micrometer.prometheus.model;

public class Account {
    public String bic;
    public String type;
    public String value;
    public String damage;

    public Account(){

    }

    public Account(String bic, String type, String value, String damage) {
        this.bic = bic;
        this.type = type;
        this.value = value;
        this.damage = damage;
    }


    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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