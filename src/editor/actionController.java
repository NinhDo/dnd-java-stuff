package editor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class actionController implements Initializable {
	public CheckBox reachBox;
	public CheckBox rangeBox;
	public CheckBox targetBox;
	public CheckBox attackBox;
	public CheckBox dmgBox;
	public CheckBox altDmgBox;
	public CheckBox SecDmgBox;
	public CheckBox saveBox;
	public CheckBox saveDmgBox;
	public CheckBox effectsBox;
	public CheckBox rechargeBox;
	public GridPane actionNamePane;
	public TextField actionName;
	public ComboBox<String> actionType;
	public TextField actionReach;
	public TextField actionRange;
	public TextField actionHit;
	public TextField actionDmg;
	public TextField actionDmgType;
	public TextField actionDmgCrit;
	public TextField actionAltDmg;
	public TextField actionAltDmgReason;
	public TextField actionAltDmgCrit;
	public TextField actionSecDmg;
	public TextField actionSecDmgType;
	public TextField actionSecDmgCrit;
	public ComboBox<String> actionSaveStat;
	public TextField actionSaveDC;
	public TextArea actionOnSave;
	public TextField actionSaveDmg;
	public TextField actionSaveDmgType;
	public TextArea actionEffects;
	public TextField actionRecharge;
	public Button addActionSaveBtn;
	public Button addActionSaveAndCloseBtn;
	public Button addActionCloseBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		actionType.getItems().addAll("Melee", "Ranged", "Thrown", "Area", "Cone", "Line");
		actionSaveStat.getItems().addAll("Str", "Dex", "Con", "Int", "Wis", "Cha");
		actionName.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionReach.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionRange.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionHit.addEventFilter(KeyEvent.KEY_TYPED, validateNumbers(2));
		actionDmg.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionDmgType.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionDmgCrit.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionAltDmg.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionAltDmgCrit.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionSecDmg.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionSecDmgType.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionSecDmgCrit.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionSaveDC.addEventFilter(KeyEvent.KEY_TYPED, validateNumbers(2));
		actionSaveDmg.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionOnSave.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionSaveDmgType.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionEffects.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
		actionRecharge.addEventFilter(KeyEvent.KEY_TYPED, validateTextIn());
	}


	public void toggleReach(ActionEvent ae) {
	}

	public void toggleRange(ActionEvent ae) {
	}

	public void toggleTarget(ActionEvent ae) {
	}

	public void toggleAttack(ActionEvent ae) {
	}

	public void toggleDmg(ActionEvent ae) {
	}

	public void toggleAltDmg(ActionEvent ae) {
	}

	public void toggleSecDmg(ActionEvent ae) {
	}

	public void toggleSave(ActionEvent ae) {
	}

	public void toggleSaveDmg(ActionEvent ae) {
	}

	public void toggleEffects(ActionEvent ae) {
	}

	public void toggleRecharge(ActionEvent ae) {
	}


	private EventHandler<KeyEvent> validateNumbers(final Integer maxLength) {
		return ke -> {
			TextField txt = (TextField) ke.getSource();
			if (txt.getText().length() >= maxLength && maxLength != 0 && txt.getSelectedText().length() != txt.getText().length())
				ke.consume();
			if (ke.getCharacter().matches("[0-9]")) ke.consume();
		};
	}

	private EventHandler<KeyEvent> validateTextIn() {
		return ke -> {
			if (!ke.getCharacter().matches("[A-Za-z0-9.,\\(\\)\\+\\- ]")) ke.consume();
		};
	}

	public void addActionSave(ActionEvent ae) {
		Stage stage = (Stage) addActionCloseBtn.getScene().getWindow();
		Stage owner = (Stage) stage.getOwner();

	}

	public void addActionSaveAndClose(ActionEvent ae) {
		addActionSave(ae);
		addActionClose(ae);
	}

	public void addActionClose(ActionEvent ae) {
		Stage stage = (Stage) addActionCloseBtn.getScene().getWindow();
		stage.close();
	}
}
