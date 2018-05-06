package com.suru.netclient.model;

import com.suru.netclient.domain.NetClientRunUnit;

import java.util.HashMap;
import java.util.Map;

public class SampleModel implements NetClientRunUnit {
    @Override
    public String getUrl() {
        return "https://postman-echo.com/status/500";
    }

    @Override
    public Map<String, String> getHeaders() {
        Map<String, String> h = new HashMap<>();
        h.put("my-sample-header", "Lorem ipsum dolor sit amet");
        h.put("postman-token", "3c8ea80b-f599-fba6-e0b4-a0910440e7b6");
        return h;
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> q = new HashMap<>();
        q.put("foo1", "bar1");
        q.put("foo2", "bar2");
        return q;
    }
}
