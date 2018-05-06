package com.suru.netclient;

import com.suru.netclient.model.SampleModel;

import java.io.IOException;
import java.net.URISyntaxException;

public class AppTest {
    public static void main(String[] args) {
        SampleModel sampleModel = new SampleModel();
        System.out.println(sampleModel.getHeaders());
        System.out.println(sampleModel.getQueryParams());
        System.out.println(sampleModel.getUrl());
        try {
            NetClient netClient1 = new NetClient(sampleModel);
            String s = netClient1.doGet();
            System.out.println("resp: " + s);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
