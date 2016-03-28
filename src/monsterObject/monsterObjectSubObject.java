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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "text", "recharge", "cost"})
public class monsterObjectSubObject {
	private String name, text, recharge, cost;

	public monsterObjectSubObject() {
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}

	@JsonProperty("recharge")
	public String getRecharge() {
		return recharge;
	}

	@JsonProperty("recharge")
	public void setRecharge(String recharge) {
		this.recharge = recharge;
	}

	@JsonProperty("cost")
	public String getCost() {
		return cost;
	}

	@JsonProperty("cost")
	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "monsterObjectSubObject{" +
				"name='" + name + '\'' +
				", text='" + text + '\'' +
				", recharge='" + recharge + '\'' +
				", cost='" + cost + '\'' +
				'}';
	}
}
