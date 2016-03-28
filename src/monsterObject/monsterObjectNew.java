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
@JsonPropertyOrder({"name", "size", "type", "alignment", "AC", "HP", "speed", "strength", "dexterity",
		"constitution", "intelligence", "wisdom", "charisma", "savingThrows", "skills", "damageResistances",
		"damageImmunities", "conditionImmunities", "senses", "languages", "challenge", "traits", "spells", "actions",
		"lairActions", "regionalEffects", "regionalEffectsFade", "legendaryPoints", "legendaryActions"})
public class monsterObjectNew {

	private String name, size, type, alignment, AC, HP, speed, strength, dexterity, constitution,
			intelligence, wisdom, charisma, savingThrows, skills, damageResistances, damageVulnerabilities,
			damageImmunities, conditionImmunities, senses, languages, challenge, regionalEffectsFade, legendaryPoints,
			spells;
	private List<monsterObjectSubObject> traits, actions, legendaryActions;
	private List<String> lairActions, regionalEffects;

	// Constructor
	public monsterObjectNew() {
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

	@JsonProperty("strength")
	public String getStrength() {
		return strength;
	}

	@JsonProperty("strength")
	public void setStrength(String strength) {
		this.strength = strength;
	}

	@JsonProperty("dexterity")
	public String getDexterity() {
		return dexterity;
	}

	@JsonProperty("dexterity")
	public void setDexterity(String dexterity) {
		this.dexterity = dexterity;
	}

	@JsonProperty("constitution")
	public String getConstitution() {
		return constitution;
	}

	@JsonProperty("constitution")
	public void setConstitution(String constitution) {
		this.constitution = constitution;
	}

	@JsonProperty("intelligence")
	public String getIntelligence() {
		return intelligence;
	}

	@JsonProperty("intelligence")
	public void setIntelligence(String intelligence) {
		this.intelligence = intelligence;
	}

	@JsonProperty("wisdom")
	public String getWisdom() {
		return wisdom;
	}

	@JsonProperty("wisdom")
	public void setWisdom(String wisdom) {
		this.wisdom = wisdom;
	}

	@JsonProperty("charisma")
	public String getCharisma() {
		return charisma;
	}

	@JsonProperty("charisma")
	public void setCharisma(String charisma) {
		this.charisma = charisma;
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
	public List<monsterObjectSubObject> getTraits() {
		return traits;
	}

	@JsonProperty("traits")
	public void setTraits(List<monsterObjectSubObject> traits) {
		this.traits = traits;
	}

	@JsonProperty("actions")
	public List<monsterObjectSubObject> getActions() {
		return actions;
	}

	@JsonProperty("actions")
	public void setActions(List<monsterObjectSubObject> actions) {
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
	public List<monsterObjectSubObject> getLegendaryActions() {
		return legendaryActions;
	}

	@JsonProperty("legendaryActions")
	public void setLegendaryActions(List<monsterObjectSubObject> legendaryActions) {
		this.legendaryActions = legendaryActions;
	}

	@JsonProperty("spells")
	public String getSpells() {
		return spells;
	}

	@JsonProperty("spells")
	public void setSpells(String spells) {
		this.spells = spells;
	}

	@Override
	public String toString() {
		return "monsterObjectNew{" +
				"name='" + name + '\'' +
				", size='" + size + '\'' +
				", type='" + type + '\'' +
				", alignment='" + alignment + '\'' +
				", AC='" + AC + '\'' +
				", HP='" + HP + '\'' +
				", speed='" + speed + '\'' +
				", strength='" + strength + '\'' +
				", dexterity='" + dexterity + '\'' +
				", constitution='" + constitution + '\'' +
				", intelligence='" + intelligence + '\'' +
				", wisdom='" + wisdom + '\'' +
				", charisma='" + charisma + '\'' +
				", savingThrows='" + savingThrows + '\'' +
				", skills='" + skills + '\'' +
				", damageResistances='" + damageResistances + '\'' +
				", damageVulnerabilities='" + damageVulnerabilities + '\'' +
				", damageImmunities='" + damageImmunities + '\'' +
				", conditionImmunities='" + conditionImmunities + '\'' +
				", senses='" + senses + '\'' +
				", languages='" + languages + '\'' +
				", challenge='" + challenge + '\'' +
				", regionalEffectsFade='" + regionalEffectsFade + '\'' +
				", legendaryPoints='" + legendaryPoints + '\'' +
				", traits=" + traits +
				", spells='" + spells + '\'' +
				", actions=" + actions +
				", lairActions=" + lairActions +
				", regionalEffects=" + regionalEffects +
				", legendaryActions=" + legendaryActions +
				'}';
	}
}
