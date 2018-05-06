package com.suru.netclient.domain;

public class HttpResponse {
    private String response;
    private int status;
    private String httpMethod;

    public HttpResponse() {
    }

    public HttpResponse(String response, int status, String httpMethod) {
        this.response = response;
        this.status = status;
        this.httpMethod = httpMethod;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }
}
