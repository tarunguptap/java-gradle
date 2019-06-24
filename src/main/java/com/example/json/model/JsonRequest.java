package com.example.json.model;

import java.util.Map;

public class JsonRequest {
    private Map<String, String> jsonInformation;
    private PrimaryRequest user;

    public JsonRequest() {

    }

    public JsonRequest(Map<String, String> jsonInformation, PrimaryRequest user) {
        this.jsonInformation = jsonInformation;
        this.user = user;
    }

    public Map<String, String> getJsonInformation() {
        return jsonInformation;
    }

    public void setJsonInformation(Map<String, String> jsonInformation) {
        this.jsonInformation = jsonInformation;
    }

    public PrimaryRequest getUser() {
        return user;
    }

    public void setUser(PrimaryRequest user) {
        this.user = user;
    }

}
