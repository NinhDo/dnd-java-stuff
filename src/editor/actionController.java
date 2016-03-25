package editor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

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
		actionName.addEventFilter(KeyEvent.KEY_TYPED, validateText("[]"));
		actionReach.addEventFilter(KeyEvent.KEY_TYPED, validateText("[]"));
		actionRange.addEventFilter(KeyEvent.KEY_TYPED, validateText("[]"));
		actionHit.addEventFilter(KeyEvent.KEY_TYPED, validateNumbers(2));
		actionDmg.addEventFilter(KeyEvent.KEY_TYPED, validateText("[]"));
		actionDmgType.addEventFilter(KeyEvent.KEY_TYPED, validateText("[]"));

	}


	public void toggleReach(ActionEvent actionEvent) {
	}

	public void toggleRange(ActionEvent actionEvent) {
	}

	public void toggleTarget(ActionEvent actionEvent) {
	}

	public void toggleAttack(ActionEvent actionEvent) {
	}

	public void toggleDmg(ActionEvent actionEvent) {
	}

	public void toggleAltDmg(ActionEvent actionEvent) {
	}

	public void toggleSecDmg(ActionEvent actionEvent) {
	}

	public void toggleSave(ActionEvent actionEvent) {
	}

	public void toggleSaveDmg(ActionEvent actionEvent) {
	}

	public void toggleEffects(ActionEvent actionEvent) {
	}

	public void toggleRecharge(ActionEvent actionEvent) {
	}


	public EventHandler<KeyEvent> validateNumbers(final Integer maxLength) {
		return ke -> {
			TextField txtField = (TextField) ke.getSource();
			if (txtField.getText().length() >= maxLength) ke.consume();
			if (ke.getCharacter().matches("[0-9]")) ke.consume();
		};
	}

	public EventHandler<KeyEvent> validateText(final String regex) {
		return ke -> {
			TextField txtField = (TextField) ke.getSource();
			if (!txtField.getText().matches(regex)) {
				ke.consume();
			}
		};
	}

	public void addActionSave(ActionEvent actionEvent) {
	}

	public void addActionSaveAndClose(ActionEvent actionEvent) {
	}

	public void addActionClose(ActionEvent actionEvent) {
	}
}
