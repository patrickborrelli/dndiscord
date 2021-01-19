package com.patrickborrelli.dndiscord.model.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * Singleton instance responsible for adding, modifying, and deleting 
 * back end data.
 * 
 * @author Patrick Borrelli
 */
public class WebserviceManager {
	private volatile static WebserviceManager instance;
	private static final Logger LOGGER = LogManager.getLogger(WebserviceManager.class.getName());
	public static final String BASE_URL = "https://api2.gotsport.com/api/Registrations.asmx";
	
	private WebserviceManager() {
		
	}
	
	/**
	 * Retrieve the instance of this singleton WebserviceManager.
	 * 
	 * @return the one and only instance of the WebserviceManager
	 */
	public static WebserviceManager getInstance() {
		if(instance == null) {
			synchronized (WebserviceManager.class) {
				if(instance == null) {
					instance = new WebserviceManager();
				}
			}
		}
		return instance;
	}
	
	
	private NodeList getResultSet(String url, String nodeName) {
		NodeList result = null;
		BufferedReader in = null;
		HttpURLConnection con = null;
		
		try {
			URL obj = new URL(url);
			con = (HttpURLConnection) obj.openConnection();
			int responseCode = con.getResponseCode();
			
			if(responseCode != 200) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer errorResponse = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					errorResponse.append(inputLine);
				}
				
				//print in String
				LOGGER.debug(errorResponse.toString());
				in.close();
				con.disconnect();
				throw new IOException(errorResponse.toString());
			} else {
				LOGGER.debug("Response Code : " + responseCode);
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				
				//print in String
				LOGGER.debug(response.toString());
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
						.parse(new InputSource(new StringReader(response.toString())));
				
				result = doc.getElementsByTagName(nodeName);				
				
				in.close();
				con.disconnect();
			}		
		} catch(MalformedURLException murl) {
			LOGGER.debug(murl.getMessage());
			murl.printStackTrace();
		} catch(IOException ioex) {
			LOGGER.debug(ioex.getMessage());
			ioex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
}
