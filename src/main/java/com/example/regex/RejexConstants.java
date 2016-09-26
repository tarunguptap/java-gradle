package com.example.regex;

public class RejexConstants {
	
	public final static String PATTERN_ALPHANUMERIC = "[,\\w]+";
	
	public final static String PATTERN_ALPHANUMERIC_WITH_STARCAP = "[,\\w^*]+";
	
	public final static String PATTERN_NUMBERS = "[,\\d]+";
	
	public final static String PATTERN_NUMBERS_COLON = "[\\d:]+";
	
	public final static String PATTERN_ALPHABETS = "[,\\D]+";
	
	public final static String PATTERN_HEXADECIMAL = "[0-9A-Fa-f]+";
	
	public final static String PATTERN_ALPHANUMERIC_WITHOUT_ZERO = "[1-9A-Za-z]+";
	
	public final static String PATTERN_ALPHANUMERIC_WITH_STAR = "[,\\w*]+";
	
	public final static String PATTERN_ALPHANUMERIC_WITH_SLASH_DOLLAR = "[,\\w$.\\\\]+";
	
	public final static String PATTERN_ALPHANUMERIC_WITH_HASH_SLASH_DOLLAR = "[,\\w$.#\\\\]+";
	
	public final static String PATTERN_ALPHABETS_WITH_A_F = "[A-Fa-f]+";
	
	public final static String PATTERN_IP_ADDRESS = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$"; 
	
	public final static String PATTERN_EMAIL = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	
	public final static String PATTERN_ALPHABETS_WITH_A_Z = "[A-Z]+";
	public final static String PATTERN_ALPHANUMERIC_WITH_ZERO = "[0-9A-Za-z]+";
	public final static String PATTERN_NUMBERS_WITH_ZERO = "[0-9]+";
	//public final static String PATTERN_SPECIAL_CHARACTERS = "[~`!@#$%^&*()+=-[]\\\';,./{}|\":<>?_]";
	public final static String PATTERN_SPECIALCHARACTERS_WITHSPACE = "[ /~`!@#$%^&*|:';,.{}\\\\<>?_()+=-]+";
	public final static String PATTERN_ALPHANUMERIC_SPECIALCHARACTERS_WITHOUTSPACE = "[,\\w/~`!@#$%^&*|:';,.{}\\\\<>?_()+=-]+";
	/**
	 * First character starts with A
	 * (?i) indicates the case-insensitivity
	 */
	public final static String PATTERN_SPECIFIC_FIRST_CHARACTER = "^[T]+[a-zA-Z ]*";
  public final static String PATTERN_SPECIFIC_FIRST_CHARACTER_1 = "^[A](?:[a-zA-Z ])";
	
	
	/**
	 * First character is Capital
	 */
	public final static String PATTERN_FIRST_CHARACTER_CAPITAL = "^[A-Z]+[a-zA-Z ]*$";
	
	/**
	 * First 8 digits are numeric 
	 * Next 6 or 7 digits are Hexa
	 */
	public static final String VALIDATE_HEXA_DECIMAL_IMEI = "[0-9]{8}(?:[a-fA-F0-9]){6,7}";
	
	/**
	 * First character starts with A
	 * (?i) indicates the case-insensitivity
	 */
	public final static String PATTERN_CASEINSENSITIVE_FIRST_CHARACTER_HEXADECIMAL = "^(?i)[A]+[a-fA-F0-9]*";
	
    public static final String NUMERIC_WITH_DYNAMIC_MIN_MAX_LENGTH = "[0-9]{%1$s,%2$s}";

}
