package com.example.core.comparable;

//category
public class Identity implements Comparable<Identity> {

    public enum Code {
        TEST_CODE;
    }

    private Long id = new Long(-1);
    private Code code;
    private String description;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the code
     */
    public Code getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(Code code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Identity o) {
        String s1 = description == null ? "" : description;
        String s2 = o.getDescription() == null ? "" : o.getDescription();
        return s1.compareTo(s2);
    }

}
