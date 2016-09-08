package com.example.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateJsonListExample {

    public static void main(String[] args) throws JSONException {
        getJsonArrayList();// Output : [{"emplyeeNumber":123},{"emplyeeNumber":223},{"emplyeeNumber":323},{"emplyeeNumber":423}]
    }

    private static void getJsonArrayList() throws JSONException {
        /*[
        {
           "emplyeeNumber": ""
        }, {
           "emplyeeNumber": ""
        }
        ]*/
        // The json object needs to be created in above format

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("emplyeeNumber", 123);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("emplyeeNumber", 223);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("emplyeeNumber", 323);
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("emplyeeNumber", 423);

        JSONArray quotesJsonArray = new JSONArray();
        quotesJsonArray.put(jsonObject);
        quotesJsonArray.put(jsonObject1);
        quotesJsonArray.put(jsonObject2);
        quotesJsonArray.put(jsonObject3);

        System.out.println(quotesJsonArray.toString());

        /**
         * For api, we will create a dto EmployeeDto with one property "private Long emplyeeNumber" In the api method
         * signature, we will have '@RequestBody List<EmployeeDto> EmployeeDto'
         */
    }

}
