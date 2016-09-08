package com.example.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateJsonComplexExample {

    public static void main(String[] args) throws JSONException {
        createJson(); // Output : {"userName":"Test","custmers":[{"customerRefNumber":1,"details":[{"orderId":101,"orderValue":50,"resetCustomer":"false"},{"orderId":102,"orderValue":50,"resetCustomer":"false"}]},{"customerRefNumber":2,"details":[{"orderId":101,"orderValue":50,"resetCustomer":"false"},{"orderId":102,"orderValue":50,"resetCustomer":"false"}]}]}

    }
    
    private static void createJson() throws JSONException {
        /*{
            "userName": "Test",
            "custmers": [
              {
                "customerRefNumber": "30082416000008",
                "details": [
                  {
                    "orderId": 1,
                    "orderValue": 100,
                    "resetCustomer": "true"
                  },{
                    "orderId": 2,
                    "orderValue": 100,
                    "resetCustomer": "true"
                  }
                ]
              },{
                "customerRefNumber": "30082416000009",
                "details": [
                  {
                    "orderId": 3,
                    "orderValue": 100,
                    "resetCustomer": "true"
                  }
                ]
              }
            ]
          }*/

        /**
         * DTO example 
         * CustomerDetailDto : Long orderId, BigDecimal orderValue, boolean resetCustomer                              
         * CustomerDto : Long customerRefNumber, List<CustomerDetailDto> details 
         * UpdateCustomerDTO : String userName, List<CustomerDto> custmers
         * 
         */
        System.out.println(customerJson());

    }

    private static String customerJson() throws JSONException {
        JSONObject customerOrder1 = new JSONObject().put("orderId", 101).put("orderValue", 50)
                .put("resetCustomer", "false");
        JSONObject customerOrder2 = new JSONObject().put("orderId", 102).put("orderValue", 50)
                .put("resetCustomer", "false");
        JSONObject customerOrder3 = new JSONObject().put("orderId", 103).put("orderValue", 50)
                .put("resetCustomer", "false");

        JSONArray orderJsonArray = new JSONArray();
        orderJsonArray.put(customerOrder1);
        orderJsonArray.put(customerOrder2);

        JSONObject customerObject = new JSONObject();
        customerObject.put("customerRefNumber", 1);
        customerObject.put("details", orderJsonArray);
        
        JSONArray orderJsonArray1 = new JSONArray();
        orderJsonArray1.put(customerOrder3);

        JSONObject customerObject1 = new JSONObject();
        customerObject1.put("customerRefNumber", 2);
        customerObject1.put("details", orderJsonArray);

        JSONArray customerJsonArray = new JSONArray();
        customerJsonArray.put(customerObject);
        customerJsonArray.put(customerObject1);

        JSONObject updateCustomerJSONObject = new JSONObject();
        updateCustomerJSONObject.put("userName", "Test");
        updateCustomerJSONObject.put("custmers", customerJsonArray);

        return updateCustomerJSONObject.toString();
    }
}
