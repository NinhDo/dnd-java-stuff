package monsterObject;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Guest on 20.03.2016.
 */


public class monsterObject {

	private String name;
	private String size;
	private String type;
	private String alignment;
	private int ac;
	private String acDesc;
	private int hp;
	private String hpDesc;
	private String speed;
	private String abilities;
	private String savingThrows;
	private String skills;
	private String damageResistances;
	private String damageImmunities;
	private String conditionImmunities;
	private String senses;
	private String languages;
	private int challenge;
	private ArrayList<String> traits;
	private ArrayList<String> actions;
	private ArrayList<String> lairActions;
	private ArrayList<String> regionalEffects;
	private ArrayList<String> regionalEffectsFade;
	private int legendaryPoints;
	private ArrayList<String> legendaryActions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public String getAcDesc() {
		return acDesc;
	}

	public void setAcDesc(String acDesc) {
		this.acDesc = acDesc;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getHpDesc() {
		return hpDesc;
	}

	public void setHpDesc(String hpDesc) {
		this.hpDesc = hpDesc;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getAbilities() {
		return abilities;
	}

	public void setAbilities(String abilities) {
		this.abilities = abilities;
	}

	public String getSavingThrows() {
		return savingThrows;
	}

	public void setSavingThrows(String savingThrows) {
		this.savingThrows = savingThrows;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getDamageResistances() {
		return damageResistances;
	}

	public void setDamageResistances(String damageResistances) {
		this.damageResistances = damageResistances;
	}

	public String getDamageImmunities() {
		return damageImmunities;
	}

	public void setDamageImmunities(String damageImmunities) {
		this.damageImmunities = damageImmunities;
	}

	public String getConditionImmunities() {
		return conditionImmunities;
	}

	public void setConditionImmunities(String conditionImmunities) {
		this.conditionImmunities = conditionImmunities;
	}

	public String getSenses() {
		return senses;
	}

	public void setSenses(String senses) {
		this.senses = senses;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public int getChallenge() {
		return challenge;
	}

	public void setChallenge(int challenge) {
		this.challenge = challenge;
	}

	public String[] getTraits() {
		return (String[]) traits.toArray();
	}

	public void setTraits(ArrayList<String> traits) {
		this.traits = traits;
	}

	public String[] getActions() {
		return (String[]) actions.toArray();
	}

	public void setActions(ArrayList<String> actions) {
		this.actions = actions;
	}

	public String[] getLairActions() {
		return (String[]) lairActions.toArray();
	}

	public void setLairActions(ArrayList<String> lairActions) {
		this.lairActions = lairActions;
	}

	public String[] getRegionalEffects() {
		return (String[]) regionalEffects.toArray();
	}

	public void setRegionalEffects(ArrayList<String> regionalEffects) {
		this.regionalEffects = regionalEffects;
	}

	public String[] getRegionalEffectsFade() {
		return (String[]) regionalEffectsFade.toArray();
	}

	public void setRegionalEffectsFade(ArrayList<String> regionalEffectsFade) {
		this.regionalEffectsFade = regionalEffectsFade;
	}

	public int getLegendaryPoints() {
		return legendaryPoints;
	}

	public void setLegendaryPoints(int legendaryPoints) {
		this.legendaryPoints = legendaryPoints;
	}

	public String[] getLegendaryActions() {
		return (String[]) legendaryActions.toArray();
	}

	public void setLegendaryActions(ArrayList<String> legendaryActions) {
		this.legendaryActions = legendaryActions;
	}

	public monsterObject() {
		this.name = "monster not set";
		this.size = "size not set";
		this.type = "type not set";
		this.alignment = "alignment not set";
		this.ac = 1;
		this.hp = 1;
		this.speed = "speed not set";
		this.abilities = "STR 0 DEX 0 CON 0 INT 0 WIS 0 CHA 0";
		this.challenge = 0;
	}
}
