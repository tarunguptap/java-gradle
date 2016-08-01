package com.example.hibernate.xml.inheritence.OneTablePerSubClassInheritance.model;


public class Cheque extends Payment{

	private static final long serialVersionUID = 1L;
	private String chequeType;
	/**
	 * @return the chequeType
	 */
	public String getChequeType() {
		return chequeType;
	}
	/**
	 * @param chequeType the chequeType to set
	 */
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}


}
