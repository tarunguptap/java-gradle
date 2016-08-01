package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model;

/**
 * @author 
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
