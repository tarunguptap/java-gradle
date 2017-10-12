package com.example.java8feature.dto;

public class Address {
    private Long addressId;
    private String firstName;
    private String addressType;

    public Address() {

    }

    public Address(Long addressId, String firstName, String addressType) {
        this.addressId = addressId;
        this.firstName = firstName;
        this.addressType = addressType;
    }

    /**
     * @return the addressId
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * @param addressId
     *            the addressId to set
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the addressType
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * @param addressType
     *            the addressType to set
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

}
