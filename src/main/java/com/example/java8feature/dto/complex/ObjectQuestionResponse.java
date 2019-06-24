package com.example.java8feature.dto.complex;

public class ObjectQuestionResponse {

    private Long id;

    private String response;

    private ObjectQuestion objectQuestion;

    public ObjectQuestionResponse(Long id, String response, ObjectQuestion objectQuestion) {
        super();
        this.id = id;
        this.response = response;
        this.objectQuestion = objectQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ObjectQuestion getObjectQuestion() {
        return objectQuestion;
    }

    public void setObjectQuestion(ObjectQuestion objectQuestion) {
        this.objectQuestion = objectQuestion;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
