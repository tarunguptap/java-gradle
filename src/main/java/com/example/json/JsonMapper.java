package com.example.json;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.json.model.JsonRequest;
import com.example.json.model.PrimaryRequest;
import com.example.json.model.Transaction;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        // Create JsonRequest object
        JsonRequest jsonRequest = new JsonRequest(getJsonInformation(), getPrimaryRequest());

        // Convert JsonRequest to JsonInfo
        String jsonInfo = new ObjectMapper().writeValueAsString(jsonRequest);
        System.out.println(jsonInfo);
        // Output is
        // {"jsonInformation":{"KEY2":"Value2","KEY1":"Value1","1":"YES","2":"YES","KEY5":"Value5","KEY4":"Value4","KEY3":"Value3"},"user":{"userId":"500","userFirstName":"test","userLastName":"user","date":"Tue Apr 23 11:31:14 IST 2019","userName":"test_user","status":null,"errorCode":null,"errorMessage":null}}

        // Create Transaction Object
        Transaction transaction = new Transaction();
        transaction.setPayload(jsonInfo);

        JsonRequest jsonRequest1 = new ObjectMapper().readValue(transaction.getPayload(), JsonRequest.class);
        transaction.setJsonInformation(jsonRequest1.getJsonInformation());
        System.out.println(transaction);

    }

    private static PrimaryRequest getPrimaryRequest() {
        PrimaryRequest primaryRequest = new PrimaryRequest();
        primaryRequest.setUserId("500");
        primaryRequest.setUserFirstName("test");
        primaryRequest.setUserLastName("user");
        primaryRequest.setUserName("test_user");
        primaryRequest.setStatus(null);
        primaryRequest.setErrorCode(null);
        primaryRequest.setDate(new Date().toString());
        return primaryRequest;
    }

    private static Map<String, String> getJsonInformation() {
        Map<String, String> jsonInformation = new HashMap<>();
        jsonInformation.put("KEY1", "Value1");
        jsonInformation.put("KEY2", "Value2");
        jsonInformation.put("KEY3", "Value3");
        jsonInformation.put("KEY4", "Value4");
        jsonInformation.put("KEY5", "Value5");
        jsonInformation.put("2", "YES");
        jsonInformation.put("1", "YES");
        jsonInformation.put("", "YES");
        jsonInformation.put("3", "");
        jsonInformation.put("4", null);
        return jsonInformation;
    }
}
