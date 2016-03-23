package editor;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class editorController {
	public GridPane basicInfo;
	public TextField monsterName;
	public ComboBox size;
	public TextField alignment;
	public TextField type;
	public GridPane combatInfo;
	public TextField ac;
	public TextField acDesc;
	public TextField hp;
	public TextField hpDesc;
	public TextField speed;
	public GridPane abilities;
	public Text strengthMod;
	public Text dexterityMod;
	public Text constitutionMod;
	public Text intelligenceMod;
	public Text wisdomMod;
	public Text charismaMod;
	public TextField strength;
	public TextField dexterity;
	public TextField constitution;
	public TextField intelligence;
	public TextField wisdom;
	public TextField charisma;
	public GridPane otherInfo;
	public VBox traitsList;
	public Button addTraitBtn;
	public VBox multiattack;
	public CheckBox multiattackBox;
	public TextArea multiattackDescription;
	public VBox actions;
	public VBox traits;
	public VBox actionsList;
	public SplitPane leftColumn;
	public SplitPane rightColumn;
	public Button btnMeleeAction;
	public Button btnRangedAction;
	public Button btnOtherAction;
	public Button btnCustomAction;
	public Button btnMeleeActionLegendary;
	public Button btnRangedActionLegendary;
	public Button btnOtherActionLegendary;
	public Button btnCustomActionLegendary;
	public TextField savingThrows;
	public TextField skills;
	public TextField damageResistances;
	public TextField damageImmunities;
	public TextField conditionImmunities;
	public TextField senses;
	public TextField languages;
	public TextField challenge;
	public CheckBox legendaryActionsBox;
	public VBox legendaryActionsList;
	public CheckBox lairActionsBox;
	public CheckBox regionalEffectsBox;
	public VBox lairActionsList;
	public Button lairActionBtn;
	public VBox lairActions;
	public GridPane regionalEffectsGrid;
	public VBox legendaryActions;
	public TextArea regionalEffectsDesc;
	public TextArea regionalEffectsFadeDesc;
	public VBox regionalEffects;

	public void addTrait(ActionEvent ae) {
		System.out.println("add trait");
		System.out.println(ae);
	}


	public void meleeEditor(ActionEvent ae) {
	}

	public void rangedEditor(ActionEvent ae) {
	}

	public void otherEditor(ActionEvent ae) {
	}

	public void customEditor(ActionEvent ae) {
	}

	public void toggleLegendaryActions(ActionEvent ae) {
	}

	public void toggleLairActions(ActionEvent ae) {
	}

	public void lairActionEditor(ActionEvent ae) {
	}

	public void toggleRegionalEffects(ActionEvent ae) {
	}
}