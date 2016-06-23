package com.example.hibernate.xml.mapping.OneToMany.set.example1.model;

import com.example.hibernate.xml.mapping.OneToMany.set.example1.enums.ContactType;
import com.example.hibernate.xml.mapping.OneToMany.set.example1.model.PersistentEntity;
public class Contact extends PersistentEntity  {

    private static final long serialVersionUID = 2613720764073625897L;
    
    private Long empAddrId;
    
		private Name name = new Name();

    private String companyTitle;

    /**
		 * @return the contactType
		 */
		public ContactType getContactType() {
			return contactType;
		}


		/**
		 * @param contactType the contactType to set
		 */
		public void setContactType(ContactType contactType) {
			this.contactType = contactType;
		}

		private String companyName;
    
    private ContactType contactType = ContactType.STANDARD;
    
    public Long getEmpAddrId() {
			return empAddrId;
		}
    
    
		public Contact(Name name, String companyTitle, String companyName) {
			this.name = name;
			this.companyTitle = companyTitle;
			this.companyName = companyName;
		}
		public void setEmpAddrId(Long empAddrId) {
			this.empAddrId = empAddrId;
		}
    
    /** Clones the current Contact */
    public Object clone(){
    	
    	try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
    }
    
    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * @param companyName
     *            the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    /**
     * @return Returns the companyTitle.
     */
    public String getCompanyTitle() {
        return this.companyTitle;
    }

    /**
     * @param companyTitle
     *            The companyTitle to set.
     */
    public void setCompanyTitle(String companyTitle) {
        this.companyTitle = companyTitle;
    }


    /**
     * @return Returns the name.
     */
    public Name getName() {
        return this.name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(Name name) {
        this.name = name;
    }
}