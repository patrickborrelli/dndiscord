package com.patrickborrelli.dndiscord.utilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * A singleton ObjectMapper utility.
 * 
 * @author Patrick Borrelli
 */
public class ApplicationObjectMapper {
	
	private static volatile ObjectMapper instance;
	
	/**
	 * Returns an instance of the ApplicationObjectMapper to the 
	 * calling client.
	 * 
	 * @return the ApplicationObjectMapper
	 */
	public static ObjectMapper getInstance() {
		if(instance == null) {
			synchronized(ApplicationObjectMapper.class) {
				if(instance == null) {
					instance = new ObjectMapper();
					instance.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
					instance.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
					instance.setSerializationInclusion(JsonInclude.Include.NON_NULL);
					instance.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
				}
			}
		}
		return instance;
	}
	
	private ApplicationObjectMapper() {
		 instance = ApplicationObjectMapper.getInstance();
	}

}
