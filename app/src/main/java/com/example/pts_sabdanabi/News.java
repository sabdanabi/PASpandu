package com.example.pts_sabdanabi;

import java.util.ArrayList;

public class DataHolder {
    private static DataHolder instance;
    private ArrayList<String> dataListEmail;
    private ArrayList<String> dataListPassword;

    private DataHolder() {
        dataListEmail = new ArrayList<>();
        dataListPassword = new ArrayList<>();
    }

    public static DataHolder getInstance() {
        if (instance == null) {
            instance = new DataHolder();
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