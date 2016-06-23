package com.example.hibernate.xml.mapping.OneToMany.set.example1.model;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class Name implements Serializable {
    
    private static final long serialVersionUID = 5229168439034087924L;

    private String firstName;

    private String middleInitial;

    private String lastName;

    /**
     * @param firstName
     * @param middleInitial
     * @param lastName
     */
    public Name(String firstName, String middleInitial, String lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
    }

    /**
     * @param firstName
     * @param lastName
     */
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name() {
    }

    /**
     * @return Returns the firstName.
     * @hibernate.property column="FIRST_NAME" not-null="true"
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @param firstName
     *            The firstName to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Returns the lastName.
     * @hibernate.property column="LAST_NAME" not-null="true"
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @param lastName
     *            The lastName to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Returns the middleInitial.
     * @hibernate.property column="MIDDLE_INITIAL" length="1"
     */
    public String getMiddleInitial() {
        return this.middleInitial;
    }

    /**
     * @param middleInitial
     *            The middleInitial to set.
     */
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    /**
     * Returns the full name in the format lastName, firstName MI.
     * 
     * @return The full name
     */
    public String getFullNameLastFirst() {
        StringBuffer sb = new StringBuffer();

        if (!StringUtils.isBlank(lastName)) {
            sb.append(lastName);
        }

        if (!StringUtils.isBlank(firstName)) {
            sb.append(", ");
            sb.append(firstName);
        }

        if (!StringUtils.isBlank(middleInitial)) {
            sb.append(" ");
            sb.append(middleInitial);
            sb.append(".");
        }

        return sb.toString();
    }

    /**
     * Returns the full name in the format firstName MI lastName
     * 
     * @return The full name
     */
    public String getFullName() {
        StringBuffer sb = new StringBuffer();

        if (!StringUtils.isBlank(firstName)) {
            sb.append(firstName);
        }

        if (!StringUtils.isBlank(middleInitial)) {
            sb.append(" ");
            sb.append(middleInitial);
            sb.append(".");
        }

        if (!StringUtils.isBlank(lastName)) {
            sb.append(" ");
            sb.append(lastName);
        }

        return sb.toString();
    }
}