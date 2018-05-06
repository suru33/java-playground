package com.suru.netclient;

import com.suru.netclient.domain.NetClientRunUnit;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class NetClient {
    private final URI uri;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final CloseableHttpClient httpClient;

    public NetClient(NetClientRunUnit netClientRunUnit) throws URISyntaxException {
        this(netClientRunUnit.getUrl(), netClientRunUnit.getHeaders(), netClientRunUnit.getQueryParams());
    }

    public NetClient(String url, Map<String, String> headers, Map<String, String> queryParams) throws URISyntaxException {
        this.headers = headers;
        this.queryParams = queryParams;
        this.uri = this.processQueryParams(url);
        this.httpClient = HttpClients.createDefault();
    }

    public String doGet() throws IOException {
        HttpGet httpGet = new HttpGet(uri);
        System.out.println(httpGet);
        headers.forEach((key, value) -> {
            if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
                httpGet.addHeader(key, value);
            }
        });
        CloseableHttpResponse response = httpClient.execute(httpGet);
        StringWriter writer = new StringWriter();
        return getOutput(response, writer);
    }

    public String doPost(String body) throws IOException {
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setEntity(new StringEntity(body));
        headers.forEach((key, value) -> {
            if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
                httpPost.addHeader(key, value);
            }
        });
        CloseableHttpResponse response = httpClient.execute(httpPost);
        StringWriter writer = new StringWriter();
        return getOutput(response, writer);
    }

    public String doPatch(String body) throws IOException {
        HttpPatch httpPatch = new HttpPatch(uri);
        httpPatch.setEntity(new StringEntity(body));
        headers.forEach((key, value) -> {
            if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
                httpPatch.addHeader(key, value);
            }
        });
        CloseableHttpResponse response = httpClient.execute(httpPatch);
        StringWriter writer = new StringWriter();
        return getOutput(response, writer);
    }

    public String doPut(String body) throws IOException {
        HttpPut httpPut = new HttpPut(uri);
        httpPut.setEntity(new StringEntity(body));
        headers.forEach((key, value) -> {
            if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
                httpPut.addHeader(key, value);
            }
        });
        CloseableHttpResponse response = httpClient.execute(httpPut);
        StringWriter writer = new StringWriter();
        return getOutput(response, writer);
    }

    private String getOutput(CloseableHttpResponse response, StringWriter writer) throws IOException {
        try {
            IOUtils.copy(response.getEntity().getContent(), writer, StandardCharsets.UTF_8);
            EntityUtils.consume(response.getEntity());
            return writer.getBuffer().toString();
        } finally {
            writer.close();
            response.close();
        }
    }

    private URI processQueryParams(String url) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(url);
        queryParams.forEach((key, value) -> uriBuilder.addParameter(key, value));
        return uriBuilder.build();
    }
}
