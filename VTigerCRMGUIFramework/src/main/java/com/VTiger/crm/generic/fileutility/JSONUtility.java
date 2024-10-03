package com.VTiger.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {

public String getDataFromJSONFile(String key) throws IOException, ParseException {
      FileReader fir=new FileReader("./src/test/resources/appcommonData.json");
      JSONParser pars=new JSONParser();
      Object obj=pars.parse(fir);
      JSONObject map=(JSONObject)obj;
      String value=(String)map.get(key);
	return value;
}
}
