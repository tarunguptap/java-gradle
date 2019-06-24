package com.example.json.model;

import java.util.Map;

public class Transaction {
    public String payload;
    public Map<String, String> jsonInformation;

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Map<String, String> getJsonInformation() {
        return jsonInformation;
    }

    public void setJsonInformation(Map<String, String> jsonInformation) {
        this.jsonInformation = jsonInformation;
    }

}
