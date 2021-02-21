package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple model for an options collection json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Options {

	private List<Option> race;
	@JsonProperty("class")
	private List<Option> classOptions;
	private List<Option> feat;
	
	public Options() {
		
	}

	/**
	 * @return List<Option> the race
	 */
	public List<Option> getRace() {
		return race;
	}

	/**
	 * @param race List<Option> the race to set
	 */
	public void setRace(List<Option> race) {
		this.race = race;
	}

	/**
	 * @return List<Option> the classOptions
	 */
	public List<Option> getClassOptions() {
		return classOptions;
	}

	/**
	 * @param classOptions List<Option> the classOptions to set
	 */
	public void setClassOptions(List<Option> classOptions) {
		this.classOptions = classOptions;
	}

	/**
	 * @return List<Option> the feat
	 */
	public List<Option> getFeat() {
		return feat;
	}

	/**
	 * @param feat List<Option> the feat to set
	 */
	public void setFeat(List<Option> feat) {
		this.feat = feat;
	}

	@Override
	public String toString() {
		return "Options [race=" + race + ", classOptions=" + classOptions + ", feat=" + feat + "]";
	}
	
}
