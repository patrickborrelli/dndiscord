package com.patrickborrelli.dndiscord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrickborrelli.dndiscord.model.dndiscord.Action;
import com.patrickborrelli.dndiscord.model.type.ActionType;
import com.patrickborrelli.dndiscord.model.type.ActivationType;
import com.patrickborrelli.dndiscord.model.type.AttackSubtype;
import com.patrickborrelli.dndiscord.model.type.DamageType;
import com.patrickborrelli.dndiscord.model.type.FeatureType;
import com.patrickborrelli.dndiscord.model.type.ResetType;
import com.patrickborrelli.dndiscord.model.type.StatType;
import com.patrickborrelli.dndiscord.utilities.ApplicationObjectMapper;

import lombok.Data;


public class InventoryEvaluation {

	private static final String FILENAME = "C:\\Users\\patri\\Dropbox\\AwareSoftwareSolutions\\DiscordDev\\currentDNDBeyond\\combine.json";
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(FILENAME));
		log("Attempting to read from " + FILENAME);
		
		List<ItemDetail> details = new ArrayList<>();		

		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}		
		in.close();
		
		ObjectMapper mapper = ApplicationObjectMapper.getInstance();
		
		JsonNode rootNode = mapper.readTree(content.toString());
		JsonNode inventory = rootNode.path("inventory");
		Iterator<JsonNode> items = inventory.elements();
		
		while(items.hasNext()) {
			JsonNode item = items.next();
			JsonNode iD = item.path("definition");
			
			ItemDetail detail = new ItemDetail(iD.path("name").toString(), 
					iD.path("type").toString(), iD.path("subType").toString(), 
					iD.path("gearTypeId").asLong(), iD.path("filterType").toString(), 
					iD.path("id").asLong(), iD.path("baseItemId").asLong(), iD.path("attackType").asLong(), iD.path("categoryId").asLong());
			details.add(detail);
		}
		
		for(ItemDetail detail : details) {
			log(detail.toString());
		}
	}
	
	private static void log(String toLog) {
		System.out.println(toLog);
	}	
}

@Data
class ItemDetail {
	String name;
	String type;
	String subtype;
	Long gearTypeId;
	String filterType;
	Long id;
	Long baseItemId;
	Long attackType;
	Long categoryId;
	
	public ItemDetail(String name, String type, String subtype, Long gearTypeId, String filterType, Long id,
			Long baseItemId, Long attackType, Long categoryId) {
		super();
		this.name = name;
		this.type = type;
		this.subtype = subtype;
		this.gearTypeId = gearTypeId;
		this.filterType = filterType;
		this.id = id;
		this.baseItemId = baseItemId;
		this.attackType = attackType;
		this.categoryId = categoryId;
	}		
}
