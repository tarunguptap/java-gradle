package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model;

import com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model.PersistentEntity;


public class LabelConstant extends PersistentEntity {

    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

    private String localizedText;

    private String nonLocalizedText;

    private String enLocaleText;
    
    private String discriminatorValue;
    
    public LabelConstant() {
	}
    
    public LabelConstant(String code, String localizedText,
			String nonLocalizedText, String enLocaleText) {
		super();
		this.code = code;
		this.localizedText = localizedText;
		this.nonLocalizedText = nonLocalizedText;
		this.enLocaleText = enLocaleText;
	}



	public String getEnLocaleText() {
    	 if (this.enLocaleText == null)
             return this.nonLocalizedText;
         else
             return this.enLocaleText;
	}

	public void setEnLocaleText(String enLocaleText) {
		this.enLocaleText = enLocaleText;
	}

	/**
     * @return Returns the code.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @param code
     *            The code to set.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return Returns the text.
     */
    public final String getText() {
        if (this.localizedText == null)
            return this.nonLocalizedText;
        else
            return this.localizedText;
    }

    /**
     * @return the localizedText
     */
    public String getLocalizedText() {
        return this.localizedText;
    }

    /**
     * @param localizedText
     *            the localizedText to set
     */
    public void setLocalizedText(String localizedText) {
        this.localizedText = localizedText;
    }

    /**
     * @return the nonLocalizedText
     */
    String getNonLocalizedText() {
        return this.nonLocalizedText;
    }

    /**
     * @param nonLocalizedText
     *            the nonLocalizedText to set
     */
    public void setNonLocalizedText(String nonLocalizedText) {
        this.nonLocalizedText = nonLocalizedText;
    }
    
    public String getDiscriminatorValue() {
		return discriminatorValue;
	}

	public void setDiscriminatorValue(String discriminatorValue) {
		this.discriminatorValue = discriminatorValue;
	}

	/*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result
                + ((this.code == null) ? 0 : this.code.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final LabelConstant other = (LabelConstant) obj;
        if (this.code == null) {
            if (other.code != null)
                return false;
        } else if (!this.code.equals(other.code))
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getText();
    }

}
