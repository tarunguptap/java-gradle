package com.example.hibernate.xml.inheritence.OneTablePerClassInheritance.LabelTestPack.model;

public class WipeoutStatus extends LabelConstant{

	private static final long serialVersionUID = 1L;
	
	private Boolean defaultLabel;
	
	public Boolean getDefaultLabel() {
		return defaultLabel;
	}

	public void setDefaultLabel(Boolean defaultLabel) {
		this.defaultLabel = defaultLabel;
	}

	public WipeoutStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WipeoutStatus(String code, String localizedText,
			String nonLocalizedText, String enLocaleText, Boolean defaultLabel) {
		super(code, localizedText, nonLocalizedText, enLocaleText);
		this.defaultLabel = defaultLabel;
		// TODO Auto-generated constructor stub
	}
	
}
