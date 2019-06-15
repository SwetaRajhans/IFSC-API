package com.bank.utilities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Utility {
	
	private Utility() {
		
	}
	
	
	public static synchronized Map<String,Object> getResponse(String status, int count, Object data){
		Map<String,Object> response = new LinkedHashMap<>();
		response.put("status", status);
		response.put("count", count);
		response.put("data", data);
		return response;
	}

}
