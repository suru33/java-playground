package com.suru.netclient.domain;

import org.apache.http.NameValuePair;

public class QueryParam implements NameValuePair {

    private final String name;
    private final String value;

    public QueryParam(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }
}
