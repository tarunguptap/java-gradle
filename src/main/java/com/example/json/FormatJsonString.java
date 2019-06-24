package com.example.json;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.json.model.JsonRequest;
import com.example.json.model.PrimaryRequest;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormatJsonString {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        // Create JsonRequest object
        JsonRequest jsonRequest = new JsonRequest(getJsonInformation(), getPrimaryRequest());

        // Convert JsonRequest to JsonInfo
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.setSerializationInclusion(Include.NON_EMPTY);

        String jsonInfo = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonRequest);
        System.out.println(jsonInfo);
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
        return jsonInformation;
    }
}
