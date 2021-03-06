package com.example.java8feature.dto;

public class ContactDetail {
    private Long id;
    private String custId;
    private String mobnum;
    private String contacttype;
    private Address address;

    public ContactDetail(Long id, String custId, String mobnum, String contacttype) {
        this.id = id;
        this.custId = custId;
        this.mobnum = mobnum;
        this.contacttype = contacttype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getMobnum() {
        return mobnum;
    }

    public void setMobnum(String mobnum) {
        this.mobnum = mobnum;
    }

    public String getContacttype() {
        return contacttype;
    }

    public void setContacttype(String contacttype) {
        this.contacttype = contacttype;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return (custId + " | " + mobnum + " | " + contacttype);
    }

}
