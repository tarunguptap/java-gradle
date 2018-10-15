package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model;


public class QualityCheckStatus extends LabelConstant{

	private static final long serialVersionUID = 1L;
	
	public enum Code {
    	PASS_QUALITY_CONTROL
    }

	public QualityCheckStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QualityCheckStatus(String code, String localizedText,
			String nonLocalizedText, String enLocaleText) {
		super(code, localizedText, nonLocalizedText, enLocaleText);
		// TODO Auto-generated constructor stub
	}
	
}
