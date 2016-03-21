/**
 * Copyright (c) 2016 Ninh Do (https://github.com/NinhDo)
 * Source code found at https://github.com/NinhDo/dnd-java-stuff
 * Object structure is based on mlenser's (https://github.com/mlenser) roll20 dnd 5e shaped scripts
 * importer. Structure here: https://github.com/mlenser/roll20/blob/master/scripts/dist/5e-monsters.js
 */
package monsterObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "size", "type", "alignment", "AC", "HP", "speed", "abilities", "savingThrows", "skills", "damageResistances", "damageImmunities", "conditionImmunities", "senses", "languages", "challenge", "traits", "actions", "lairActions", "regionalEffects", "regionalEffectsFade", "legendaryPoints", "legendaryActions"})
public class monsterObject {

	private String name, size, type, alignment, AC, HP, speed, abilities, savingThrows, skills, damageResistances, damageVulnerabilities, damageImmunities, conditionImmunities, senses, languages, challenge, regionalEffectsFade, legendaryPoints;
	private List<String> traits, actions, lairActions, regionalEffects, legendaryActions;

	// Constructor
	public monsterObject() {
	}

	// GETTERS AND SETTERS
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("size")
	public String getSize() {
		return size;
	}

	@JsonProperty("size")
	public void setSize(String size) {
		this.size = size;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("alignment")
	public String getAlignment() {
		return alignment;
	}

	@JsonProperty("alignment")
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	@JsonProperty("AC")
	public String getAC() {
		return AC;
	}

	@JsonProperty("AC")
	public void setAC(String ac) {
		this.AC = ac;
	}

	@JsonProperty("HP")
	public String getHP() {
		return HP;
	}

	@JsonProperty("HP")
	public void setHP(String hp) {
		this.HP = hp;
	}

	@JsonProperty("speed")
	public String getSpeed() {
		return speed;
	}

	@JsonProperty("speed")
	public void setSpeed(String speed) {
		this.speed = speed;
	}

	@JsonProperty("abilities")
	public String getAbilities() {
		return abilities;
	}

	@JsonProperty("abilities")
	public void setAbilities(String abilities) {
		this.abilities = abilities;
	}

	@JsonProperty("savingThrows")
	public String getSavingThrows() {
		return savingThrows;
	}

	@JsonProperty("savingThrows")
	public void setSavingThrows(String savingThrows) {
		this.savingThrows = savingThrows;
	}

	@JsonProperty("skills")
	public String getSkills() {
		return skills;
	}

	@JsonProperty("skills")
	public void setSkills(String skills) {
		this.skills = skills;
	}

	@JsonProperty("damageResistances")
	public String getDamageResistances() {
		return damageResistances;
	}

	@JsonProperty("damageResistances")
	public void setDamageResistances(String damageResistances) {
		this.damageResistances = damageResistances;
	}

	@JsonProperty("damageVulnerabilities")
	public String getDamageVulnerabilities() {
		return damageVulnerabilities;
	}

	@JsonProperty("damageVulnerabilities")
	public void setDamageVulnerabilities(String damageVulnerabilities) {
		this.damageVulnerabilities = damageVulnerabilities;
	}

	@JsonProperty("damageImmunities")
	public String getDamageImmunities() {
		return damageImmunities;
	}

	@JsonProperty("damageImmunities")
	public void setDamageImmunities(String damageImmunities) {
		this.damageImmunities = damageImmunities;
	}

	@JsonProperty("conditionImmunities")
	public String getConditionImmunities() {
		return conditionImmunities;
	}

	@JsonProperty("conditionImmunities")
	public void setConditionImmunities(String conditionImmunities) {
		this.conditionImmunities = conditionImmunities;
	}

	@JsonProperty("senses")
	public String getSenses() {
		return senses;
	}

	@JsonProperty("senses")
	public void setSenses(String senses) {
		this.senses = senses;
	}

	@JsonProperty("languages")
	public String getLanguages() {
		return languages;
	}

	@JsonProperty("languages")
	public void setLanguages(String languages) {
		this.languages = languages;
	}

	@JsonProperty("challenge")
	public String getChallenge() {
		return challenge;
	}

	@JsonProperty("challenge")
	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}

	@JsonProperty("traits")
	public List<String> getTraits() {
		return traits;
	}

	@JsonProperty("traits")
	public void setTraits(List<String> traits) {
		this.traits = traits;
	}

	@JsonProperty("actions")
	public List<String> getActions() {
		return actions;
	}

	@JsonProperty("actions")
	public void setActions(List<String> actions) {
		this.actions = actions;
	}

	@JsonProperty("lairActions")
	public List<String> getLairActions() {
		return lairActions;
	}

	@JsonProperty("lairActions")
	public void setLairActions(List<String> lairActions) {
		this.lairActions = lairActions;
	}

	@JsonProperty("regionalEffects")
	public List<String> getRegionalEffects() {
		return regionalEffects;
	}

	@JsonProperty("regionalEffects")
	public void setRegionalEffects(List<String> regionalEffects) {
		this.regionalEffects = regionalEffects;
	}

	@JsonProperty("regionalEffectsFade")
	public String getRegionalEffectsFade() {
		return regionalEffectsFade;
	}

	@JsonProperty("regionalEffectsFade")
	public void setRegionalEffectsFade(String regionalEffectsFade) {
		this.regionalEffectsFade = regionalEffectsFade;
	}

	@JsonProperty("legendaryPoints")
	public String getLegendaryPoints() {
		return legendaryPoints;
	}

	@JsonProperty("legendaryPoints")
	public void setLegendaryPoints(String legendaryPoints) {
		this.legendaryPoints = legendaryPoints;
	}

	@JsonProperty("legendaryActions")
	public List<String> getLegendaryActions() {
		return legendaryActions;
	}

	@JsonProperty("legendaryActions")
	public void setLegendaryActions(List<String> legendaryActions) {
		this.legendaryActions = legendaryActions;
	}
}
