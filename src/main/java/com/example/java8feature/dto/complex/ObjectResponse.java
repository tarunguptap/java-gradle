package com.example.java8feature.dto.complex;

import java.util.List;

public class ObjectResponse {

    private Long objectResponseId;

    private ObjectQuestionResponse objectQuestionResponse;

    private String textResponse;

    private List<ObjectAddress> ObjectAddressSet;

    public ObjectResponse(Long objectResponseId, ObjectQuestionResponse objectQuestionResponse,
            List<ObjectAddress> objectAddressSet) {
        super();
        this.objectResponseId = objectResponseId;
        this.objectQuestionResponse = objectQuestionResponse;
        ObjectAddressSet = objectAddressSet;
    }

    public ObjectResponse() {

    }

    public Long getObjectResponseId() {
        return objectResponseId;
    }

    public void setObjectResponseId(Long objectResponseId) {
        this.objectResponseId = objectResponseId;
    }

    public ObjectQuestionResponse getObjectQuestionResponse() {
        return objectQuestionResponse;
    }

    public void setObjectQuestionResponse(ObjectQuestionResponse objectQuestionResponse) {
        this.objectQuestionResponse = objectQuestionResponse;
    }

    public String getTextResponse() {
        return textResponse;
    }

    public void setTextResponse(String textResponse) {
        this.textResponse = textResponse;
    }

    public List<ObjectAddress> getObjectAddressSet() {
        return ObjectAddressSet;
    }

    public void setObjectAddressSet(List<ObjectAddress> objectAddressSet) {
        ObjectAddressSet = objectAddressSet;
    }

}
