package com.patrickborrelli.dndiscord.model.dndiscord;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.patrickborrelli.dndiscord.model.type.ArmorType;
import com.patrickborrelli.dndiscord.model.type.AttackType;
import com.patrickborrelli.dndiscord.model.type.CategoryType;
import com.patrickborrelli.dndiscord.model.type.DamageType;
import com.patrickborrelli.dndiscord.model.type.FilterType;
import com.patrickborrelli.dndiscord.model.type.ResetType;
import com.patrickborrelli.dndiscord.model.type.WeaponPropertyType;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model of dDnDiscord Item.
 * 
 * @author Patrick Borrelli
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	@JsonProperty("_id")
	private String id;
	private String name;
	private String description;
	private String snippet;
	private int quantity;
	private String imageUrl;
	private String largeImageUrl;
	private String cost;
	private String weight;
	private String type;
	private String subType;
	private String[] tags;
	
	//qualifiers
	private boolean isConsumable;
	private boolean isMonkWeapon;
	private boolean requiresAttunement;
	private boolean attuned;
	private boolean equipped;
	private boolean attack;
	private boolean stealthDisadvantage;
	private boolean strengthRequirement;
	private boolean magic;
	
	private int armorClass;
	private ArmorType armorType;
	private int strengthRequired;	
	
	//damage parameters for damage inducing items:
	private DamageType damageType;
	private int dieCount;
	private int dieValue;
	private int dieMultiplier;
	private String diceString;
	private int fixedDamage;
	private int versatileDieCount;
	private int versatileDieValue;
	private int versatileDieMultiplier;
	private String versatileDiceString;
	private int versatileFixedDamage;
	private AttackType attackType;
	private CategoryType categoryType;

	private FilterType filterType;
	private List<Feature> grantedModifiers;
	private int range;
	private int longRange;
	private Set<WeaponPropertyType> properties;
	
	//limited use items:
	private int maxUses;
	private int numberUsed;
	private ResetType resetType;
	private String resetTypeDescription;	
	
	/**
	 * @param versatileDiceString String the versatileDiceString to set
	 */
	public void setVersatileDiceString(String versatileDiceString) {
		this.versatileDiceString = versatileDiceString;
		//parse format xdy:
		String[] parsed = versatileDiceString.split("d");
		this.versatileDieCount = Integer.valueOf(parsed[0]);
		this.versatileDieValue = Integer.valueOf(parsed[1]);		
	}
}
