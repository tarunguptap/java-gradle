package com.example.java8feature.dto.complex;

public class Model {
    private String stringA;
    private String stringB;

    public Model(String stringA, String stringB) {
        super();
        this.stringA = stringA;
        this.stringB = stringB;
    }

    public String getStringA() {
        return stringA;
    }

    public void setStringA(String stringA) {
        this.stringA = stringA;
    }

    public String getStringB() {
        return stringB;
    }

    public void setStringB(String stringB) {
        this.stringB = stringB;
    }

}
