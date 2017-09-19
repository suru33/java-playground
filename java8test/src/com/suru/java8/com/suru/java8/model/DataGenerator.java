package com.suru.java8.com.suru.java8.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataGenerator {
    public static List<Invoice> getInvoices() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1, "invoice - 1", 200, new Date()));
        invoices.add(new Invoice(1, "invoice - 1", 200, new Date()));
        invoices.add(new Invoice(1, "invoice - 1", 200, new Date()));
        invoices.add(new Invoice(1, "invoice - 1", 200, new Date()));
        invoices.add(new Invoice(1, "invoice - 1", 200, new Date()));
        invoices.add(new Invoice(1, "invoice - 1", 200, new Date()));
        invoices.add(new Invoice(1, "invoice - 1", 200, new Date()));
        invoices.add(new Invoice(1, "invoice - 1", 200, new Date()));

        return invoices;
    }
}
