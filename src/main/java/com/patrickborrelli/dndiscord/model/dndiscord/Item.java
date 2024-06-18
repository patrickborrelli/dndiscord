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
	@JsonProperty("image_url")
	private String imageUrl;
	@JsonProperty("large_image_url")
	private String largeImageUrl;
	private String cost;
	private String weight;
	private String type;
	@JsonProperty("sub_type")
	private String subType;
	private String[] tags;
	
	//qualifiers
	@JsonProperty("is_consumable")
	private boolean isConsumable;
	@JsonProperty("is_monk_weapon")
	private boolean isMonkWeapon;
	@JsonProperty("requires_attunement")
	private boolean requiresAttunement;
	private boolean attuned;
	private boolean equipped;
	private boolean attack;
	@JsonProperty("stealth_disadvantage")
	private boolean stealthDisadvantage;
	@JsonProperty("strength_requirement")
	private boolean strengthRequirement;
	private boolean magic;
	
	@JsonProperty("armor_class")
	private int armorClass;
	@JsonProperty("armor_type")
	private ArmorType armorType;	
	@JsonProperty("strength_required")
	private int strengthRequired;	
	
	//damage parameters for damage inducing items:
	@JsonProperty("damage_type")
	private DamageType damageType;
	@JsonProperty("die_count")
	private int dieCount;
	@JsonProperty("die_value")
	private int dieValue;
	@JsonProperty("die_multiplier")
	private int dieMultiplier;
	@JsonProperty("dice_string")
	private String diceString;
	@JsonProperty("fixed_damage")
	private int fixedDamage;
	@JsonProperty("versatile_die_count")
	private int versatileDieCount;
	@JsonProperty("versatile_die_value")
	private int versatileDieValue;
	@JsonProperty("versatile_die_multiplier")
	private int versatileDieMultiplier;
	@JsonProperty("versatile_dice_string")
	private String versatileDiceString;
	@JsonProperty("versatile_fixed_damage")
	private int versatileFixedDamage;
	@JsonProperty("attack_type")
	private AttackType attackType;
	@JsonProperty("category_type")
	private CategoryType categoryType;

	@JsonProperty("filter_type")
	private FilterType filterType;
	@JsonProperty("granted_modifiers")
	private List<Feature> grantedModifiers;
	private int range;
	@JsonProperty("long_range")
	private int longRange;
	private Set<WeaponPropertyType> properties;
	
	//limited use items:
	@JsonProperty("max_uses")
	private int maxUses;
	@JsonProperty("number_used")
	private int numberUsed;
	@JsonProperty("reset_type")
	private ResetType resetType;
	@JsonProperty("reset_type_description")
	private String resetTypeDescription;	
	
	/**
	 * @param versatileDiceString String the versatileDiceString to set
	 */
	public void setVersatileDiceString(String versatileDiceString) {
		this.versatileDiceString = versatileDiceString;
		
		if(versatileDiceString != null) {
			//parse format xdy:
			String[] parsed = versatileDiceString.split("d");
			this.versatileDieCount = Integer.valueOf(parsed[0]);
			this.versatileDieValue = Integer.valueOf(parsed[1]);	
		}
	}
}
