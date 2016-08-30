package com.example.core.apacheutils.string.stringutil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.example.common.pojo.ModelSub;

public class StringWordMapUtilNullChecks 
{
	public static void main(String[] args) 
	{
		ModelSub modsub=new ModelSub();
		modsub.setUid("5");
		String id = modsub.getUid();
		// String Util Test
		String color = "        ";
		String color1 ="";
		StringUtils.trimToEmpty(color);
		StringUtils.trimToNull(color);
		if (StringUtils.isNotBlank(color))
		{
			System.out.println("color is not blank");
		}
		if (StringUtils.isBlank(color))
		{
			System.out.println("color is blank");
		}
		if( StringUtils.equalsIgnoreCase(modsub.getUid(),id))
		{
			System.out.println("both strings are equal");
		}
		if (!StringUtils.isNumeric("asdf123")) {
			System.out.println("not numeric @@@@@@@@@@@@@@@@@@@");
		}
		if (!StringUtils.contains("abcdef", '3')) {
			System.out.println("not contained");
        }
		
//List<Long> itemIds = new ArrayList();
//StringUtils.join(displayIds.iterator(),COMMA_DELIMITER_SPACE);
								

		//char util
		 if (CharUtils.isAsciiAlpha('1')) {
			 System.out.println("its ascii");
		 }
		
		//WordUtil
		 String str = "12345dfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfg";
		 String message=WordUtils.wrap(str,20);
		 System.out.println(message);
		
		//DateUtil
		 
		//boolean util
		System.out.println(BooleanUtils
				.toBoolean(StringUtils.defaultIfEmpty(color1,"Y"),"Y","N"));
		if(BooleanUtils.isTrue(BooleanUtils.toBoolean(StringUtils.defaultIfEmpty(color1,"Y"),"Y","N")))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		
		// Map Util
		SortedMap smap=new TreeMap();
		MapUtils.safeAddToMap(smap,"1","tarun");
		MapUtils.safeAddToMap(smap,"2","arun");
		MapUtils.safeAddToMap(smap,"3","varun");
		MapUtils.safeAddToMap(smap,"4","karun");
		System.out.println(smap);
		
		System.out.println(MapUtils.getObject(smap, "1"));
		
		System.out.println(MapUtils.getObject(smap, "1", new ArrayList()));
		
		//Number Util
		
		String companyId="12345";
		if (!StringUtils.isBlank(companyId) && NumberUtils.isDigits(companyId)) 
		{
			System.out.println(NumberUtils.createLong(StringUtils.trim(companyId)));
			System.out.println(NumberUtils.createInteger(StringUtils.trimToNull(companyId)));
			System.out.println(NumberUtils.createBigDecimal(StringUtils.trim(companyId)).divide(new BigDecimal(12), 4,BigDecimal.ROUND_HALF_UP));
		} 
		else
		{
			System.out.println("company id is not a digit");
		}
		
		//collection util	
		List alst=new ArrayList();
		CollectionUtils.addIgnoreNull(alst, "1");
		CollectionUtils.addIgnoreNull(alst, null);
		CollectionUtils.addIgnoreNull(alst, "2");
		CollectionUtils.addIgnoreNull(alst, "3");
		if (!CollectionUtils.isEmpty(alst)) 
		{
			System.out.println(alst);
		}
		
		//string number util
		String displayId="1234-5678-9123";
		if(displayId.contains("-"))
		{
			System.out.println(NumberUtils.createLong((StringUtils.split(displayId, "-")[1]).trim()));
		}
		else
		{
			System.out.println(NumberUtils.createLong(displayId.trim()));
		}
		HashMap<String, String> hmp = new HashMap<String, String>();
	}
}

