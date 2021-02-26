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
public class Options<T> {

	private List<T> race;
	@JsonProperty("class")
	private List<T> classOptions;
	private List<T> feat;
	
	public Options() {
		
	}

	/**
	 * @return List<T> the race
	 */
	public List<T> getRace() {
		return race;
	}

	/**
	 * @param race List<T> the race to set
	 */
	public void setRace(List<T> race) {
		this.race = race;
	}

	/**
	 * @return List<T> the classOptions
	 */
	public List<T> getClassOptions() {
		return classOptions;
	}

	/**
	 * @param classOptions List<T> the classOptions to set
	 */
	public void setClassOptions(List<T> classOptions) {
		this.classOptions = classOptions;
	}

	/**
	 * @return List<T> the feat
	 */
	public List<T> getFeat() {
		return feat;
	}

	/**
	 * @param feat List<T> the feat to set
	 */
	public void setFeat(List<T> feat) {
		this.feat = feat;
	}

	@Override
	public String toString() {
		return "Options [race=" + race + ", classOptions=" + classOptions + ", feat=" + feat + "]";
	}
	
}
