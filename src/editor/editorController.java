package editor;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class editorController {
	public GridPane basicInfo;
	public TextField monsterName;
	public ComboBox size;
	public ComboBox alignment;
	public ComboBox type;
	public TextField subtype;
	public GridPane combatInfo;
	public TextField ac;
	public TextField hp;
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
	public VBox traits;
	public TextField traitName;
	public TextArea traitDesc;
	public Button addTraitBtn;
	public VBox multiattack;
	public CheckBox multiattackBox;
	public TextArea multiattackDescription;
	public VBox actions;
	public TextField actionName;
	public TextArea actionDesc;

	public void addTrait(ActionEvent ae) {
		System.out.println("add trait");
		System.out.println(ae);
	}


}