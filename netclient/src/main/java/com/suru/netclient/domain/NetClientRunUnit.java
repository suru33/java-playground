package com.suru.netclient.domain;

import java.util.Map;

public interface NetClientRunUnit {
    public String getUrl();

    public Map<String, String> getHeaders();

    public Map<String, String> getQueryParams();

}
