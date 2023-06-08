package com.example.pts_sabdanabi;

import java.util.ArrayList;

public class News {
    private static News instance;
    private ArrayList<String> dataListEmail;
    private ArrayList<String> dataListPassword;

    private News() {
        dataListEmail = new ArrayList<>();
        dataListPassword = new ArrayList<>();
    }

    public static News getInstance() {
        if (instance == null) {
            instance = new News();
        }
        return instance;
    }

    public ArrayList<String> getDataListEmail() {
        return dataListEmail;
    }

    public void addToDataListEmail(String data) {
        dataListEmail.add(data);
    }
    public ArrayList<String> getDataListPassword() {
        return dataListPassword;
    }

    public void addToDataListPassword(String data) {
        dataListPassword.add(data);
    }
}