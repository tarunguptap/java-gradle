package com.example.java8feature.dto.complex;

public class ObjectAddress {
    private Long id;
    private String addressName;
    private String addressType;

    public ObjectAddress() {

    }

    public ObjectAddress(Long id, String addressName, String addressType) {
        super();
        this.id = id;
        this.addressName = addressName;
        this.addressType = addressType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

}
