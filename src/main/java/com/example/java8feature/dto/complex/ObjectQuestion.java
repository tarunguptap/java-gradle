package com.example.java8feature.dto.complex;

import java.util.ArrayList;
import java.util.List;

public class ObjectQuestion {

    private Long id;

    private String objectCode;

    private List<ObjectQuestionResponse> validObjectQuestionResponses = new ArrayList<>();

    public ObjectQuestion(Long id, String objectCode) {
        super();
        this.id = id;
        this.objectCode = objectCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    public List<ObjectQuestionResponse> getValidObjectQuestionResponses() {
        return validObjectQuestionResponses;
    }

    public void setValidObjectQuestionResponses(List<ObjectQuestionResponse> validObjectQuestionResponses) {
        this.validObjectQuestionResponses = validObjectQuestionResponses;
    }
}
