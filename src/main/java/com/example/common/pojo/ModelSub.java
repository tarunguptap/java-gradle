package com.example.common.pojo;

public class ModelSub {
    private Integer id;
    private String uid;
    private String uname;

    public ModelSub() {

    }

    public ModelSub(Integer id, String uid, String uname) {
        this.id = id;
        this.uid = uid;
        this.uname = uname;
    }

    public ModelSub(String uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringBuffer().append(" userid : " + uid).append(" | username : " + uname).toString();
    }
}
