package com.example.hibernate.annotation.dbsequence.SequenceGeneratorOverrideDemo.enums;

import java.math.BigDecimal;

public enum RoundingType {
	ROUND_HALF_UP(BigDecimal.ROUND_HALF_UP),
	ROUND_DOWN(BigDecimal.ROUND_DOWN),
	NONE(-1);
	
	private final int roundingKey;
	
	private RoundingType(int roundingKey){
		this.roundingKey= roundingKey;
	}
	/**
	 * @return the roundingKey
	 */
	public int getRoundingKey() {
		return roundingKey;
	}

}