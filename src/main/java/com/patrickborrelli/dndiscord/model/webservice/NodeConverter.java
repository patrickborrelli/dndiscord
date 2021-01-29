package com.patrickborrelli.dndiscord.model.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.patrickborrelli.dndiscord.model.DiscordUser;

/**
 * Class responsible for converting DOM NodeList data to program usable formats.
 *
 * @author Patrick Borrelli
 */
public class NodeConverter {
	private static final Logger LOGGER = LogManager.getLogger(NodeConverter.class.getName());
	public NodeConverter() {
		
	}
	
	/**
	 * 
	 * @param nodes a NodeList containing the http response
	 * @return a list of DiscordUsers.
	 */
	public static List<DiscordUser> convertDiscordUser(NodeList nodes) {
		List<DiscordUser> user = new ArrayList<>();
		return user;
	}
}
