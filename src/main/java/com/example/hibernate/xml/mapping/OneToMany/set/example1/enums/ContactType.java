package com.example.hibernate.xml.mapping.OneToMany.set.example1.enums;


public enum ContactType {

    PRIMARY("primary contact"), STANDARD("standard contact");

    /**
     * The key used to for looking up the display text in messages.properties
     */
    private final String displayKey;

    /**
     * Enum constructor for ContactType
     * 
     * @param state
     *            Value of state.
     */
    private ContactType(final String displayKey) {
        this.displayKey = displayKey;
    }

    public String getDisplayKey() {
        return this.displayKey;
    }
}
