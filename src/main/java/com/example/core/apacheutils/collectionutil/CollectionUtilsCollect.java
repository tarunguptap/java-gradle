package com.example.core.apacheutils.collectionutil;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.TransformerUtils;

public class CollectionUtilsCollect 
{
	public static void main(String[] args) {
		
	
	Map nameToLetter = new HashMap();
	nameToLetter.put("ALPHA","a");
	nameToLetter.put("BETA","b");
	nameToLetter.put("GAMMA","g");
	nameToLetter.put("DELTA","d");
    String[] values = {"ALPHA","BETA","GAMMA","GAMMA","DELTA","EPSILON"};
    List valueList = Arrays.asList(values);
    
//     convert that valueList to the letters:
    Collection resultCollection = CollectionUtils.collect
    (
      valueList,
      TransformerUtils.mapTransformer(nameToLetter)
    );

    System.out.println(resultCollection);
    
//     go back the other way…
    Map letterToName = MapUtils.invertMap(nameToLetter);

    resultCollection = CollectionUtils.collect
    (
      resultCollection,
      TransformerUtils.mapTransformer(letterToName)
    );
    System.out.println(resultCollection);
	}
}
