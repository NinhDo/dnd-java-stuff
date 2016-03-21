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
	public VBox actionsParent;
	public VBox traitsParent;
	public VBox actionList;
	public VBox attackAction;

	public void addTrait(ActionEvent ae) {
		System.out.println("add trait");
		System.out.println(ae);
	}


}