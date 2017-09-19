package com.suru.java8.com.suru.java8.model;

import java.util.Date;

public class Invoice {
    private int id;
    private String data;
    private double amount;
    private Date created;

    public Invoice() {
    }

    public Invoice(int id, String data, double amount, Date created) {
        this.id = id;
        this.data = data;
        this.amount = amount;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", amount=" + amount +
                ", created=" + created +
                '}';
    }
}
