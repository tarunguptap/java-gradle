package com.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators 
{
	public Validators()
	{
		
	}

    private String updateDynamicArgsInString(String inputString, String parameterizedValue) {
        return String.format(inputString, (Object[]) parameterizedValue.split(","));
    }

    public boolean checkANumericDynamicMinMaxLength(String inputValue, String minMaxLengthParameterValue) {
        return validateInput(
                updateDynamicArgsInString(RejexConstants.NUMERIC_WITH_DYNAMIC_MIN_MAX_LENGTH,
                        minMaxLengthParameterValue), inputValue);
    }

	public boolean checkAlphaNumeric(String temp)
	{
		return validateInput(RejexConstants.PATTERN_ALPHANUMERIC, temp);
	}

	public boolean checkAlphaBets(String temp)
	{
		return validateInput(RejexConstants.PATTERN_ALPHABETS, temp);
	}
	
	public boolean checkNumbers(String temp)
	{
		return validateInput(RejexConstants.PATTERN_NUMBERS, temp);
	}
	
	public boolean checkHexaDecimalValues(String temp)
	{
		return validateInput(RejexConstants.PATTERN_HEXADECIMAL, temp);
	}
	
	public boolean checkAlphaNumericWithStar(String temp)
	{
		return validateInput(RejexConstants.PATTERN_ALPHANUMERIC_WITH_STAR, temp);
	}
	
	public boolean checkAlphaNumericWithDollarSlash(String temp)
	{
		return validateInput(RejexConstants.PATTERN_ALPHANUMERIC_WITH_SLASH_DOLLAR, temp);
	}
	
	public boolean checkAlphabetsWithAToF(String temp)
	{
		return validateInput(RejexConstants.PATTERN_ALPHABETS_WITH_A_F, temp);
	}
	
	
	public boolean checkAlphabetsWithAToZ(String temp)
	{
		return validateInput(RejexConstants.PATTERN_ALPHABETS_WITH_A_Z, temp);
	}
	
	public boolean checkAlphaNumericWithOutZero(String temp)
	{
		return validateInput(RejexConstants.PATTERN_ALPHANUMERIC_WITHOUT_ZERO, temp);
	}
	
	public boolean checkIPAddress(String temp)
	{
		return validateInput(RejexConstants.PATTERN_IP_ADDRESS, temp);
	}
	
	public boolean checkNumbersWithColon(String temp)
	{
		return validateInput(RejexConstants.PATTERN_NUMBERS_COLON, temp);
	}
	
	public boolean checkAlphaNumericWithHashDollarSlashDot(String temp)
	{
		return validateInput(RejexConstants.PATTERN_NUMBERS_COLON, temp);
	}
	
	public boolean checkAlphaNumericWithStarCap(String temp)
	{
		return validateInput(RejexConstants.PATTERN_ALPHANUMERIC_WITH_STARCAP, temp);
	}
	
	public boolean checkEmail(String temp)
	{
		return validateInputWithCaseInsensitive(RejexConstants.PATTERN_EMAIL, temp);
	}
	
	@SuppressWarnings("unused")
	private static boolean validateInput(String pattern, String temp)
	{
		boolean result = false;
		Pattern pat = Pattern.compile(pattern);
		Matcher match = pat.matcher(temp);
		result = match.matches();
		return result;
	}
	
	@SuppressWarnings("unused")
	private static boolean validateInputWithCaseInsensitive(String pattern, String temp)
	{
		boolean result = false;
		Pattern pat = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		Matcher match = pat.matcher(temp);
		result = match.matches();
		return result;
	}
	
	public static void main(String agr[])
	{
		Validators val=new Validators();
		boolean result = val.checkSpecialChars("//##^&#&#&#############*(");
		if(result){
		System.out.println("only special characters are present");
		}else{
			System.out.println("other characters are also present");
		}
	}
	public boolean checkSpecialChars(String temp)
	{
		return validateInput(RejexConstants.PATTERN_SPECIALCHARACTERS_WITHSPACE, temp);
	}
	public boolean checkFirstChar(String temp)
	{
		return validateInput(RejexConstants.PATTERN_SPECIFIC_FIRST_CHARACTER, temp);
	}
	public boolean checkNameFirstCharCaps(String temp)
	{
		return validateInput(RejexConstants.PATTERN_FIRST_CHARACTER_CAPITAL, temp);
	}
}
