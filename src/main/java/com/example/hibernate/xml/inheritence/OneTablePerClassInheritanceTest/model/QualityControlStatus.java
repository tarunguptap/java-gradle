/*
 * @(#)QualityControlStatus.java December 21, 2011
 * 
 * Copyright (c)2005 Flipswap, Inc.
 * U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Flipswap, Inc.
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Flipswap, Inc.
 */
package com.example.hibernate.xml.inheritence.OneTablePerClassInheritanceTest.model;

/**
 * @author Achauhan
 * @hibernate.subclass discriminator-value="QC_STATUS_RESPONSE"
 */


public class QualityControlStatus extends LabelConstant{

	private static final long serialVersionUID = 1L;
	
	public enum Code {
    	PASS_QUALITY_CONTROL
    }

	public QualityControlStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QualityControlStatus(String code, String localizedText,
			String nonLocalizedText, String enLocaleText) {
		super(code, localizedText, nonLocalizedText, enLocaleText);
		// TODO Auto-generated constructor stub
	}
	
}
