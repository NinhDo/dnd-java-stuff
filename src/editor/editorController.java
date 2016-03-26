package editor;

import javafx.beans.Observable;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class editorController implements Initializable {

	final private PseudoClass errorClass = PseudoClass.getPseudoClass("error");
	public GridPane basicInfo;
	public TextField monsterName;
	public ComboBox<String> size;
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
	public Button actionBtn;
	public Button legendaryActionBtn;
	public TextField savingThrows;
	public TextField skills;
	public TextField damageResistances;
	public TextField damageVulnerabilities;
	public TextField damageImmunities;
	public TextField conditionImmunities;
	public TextField senses;
	public TextField languages;
	public TextField challenge;
	public CheckBox legendaryActionsBox;
	public TextField legendaryPoints;
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
	public BorderPane editorInterface;
	public Button saveMonster;
	public Button closeMonster;
	public Button saveMonsterNoVal;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Add items to Size ComboBox
		size.getItems().addAll("Tiny", "Small", "Medium", "Large", "Huge", "Gargantuan");

		// Add keyListeners for validation
		monsterName.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		type.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		alignment.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		acDesc.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		hpDesc.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		speed.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		savingThrows.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		skills.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		damageResistances.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		damageVulnerabilities.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		damageImmunities.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		conditionImmunities.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		senses.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		languages.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		challenge.addEventHandler(KeyEvent.KEY_TYPED, validateChallenge());
		multiattackDescription.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		regionalEffectsDesc.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		regionalEffectsFadeDesc.addEventHandler(KeyEvent.KEY_TYPED, validateTextIn());
		ac.addEventHandler(KeyEvent.KEY_TYPED, validateNumbers(3));
		hp.addEventHandler(KeyEvent.KEY_TYPED, validateNumbers(5));
		strength.addEventHandler(KeyEvent.KEY_TYPED, validateStats());
		strength.textProperty().addListener(this::calculateStats);
		dexterity.addEventHandler(KeyEvent.KEY_TYPED, validateStats());
		dexterity.textProperty().addListener(this::calculateStats);
		constitution.addEventHandler(KeyEvent.KEY_TYPED, validateStats());
		constitution.textProperty().addListener(this::calculateStats);
		intelligence.addEventHandler(KeyEvent.KEY_TYPED, validateStats());
		intelligence.textProperty().addListener(this::calculateStats);
		wisdom.addEventHandler(KeyEvent.KEY_TYPED, validateStats());
		wisdom.textProperty().addListener(this::calculateStats);
		charisma.addEventHandler(KeyEvent.KEY_TYPED, validateStats());
		charisma.textProperty().addListener(this::calculateStats);
		legendaryPoints.addEventHandler(KeyEvent.KEY_TYPED, validateNumbers(1));

		// Deactivate special stuff
		multiattackBox.setSelected(false);
		legendaryActionsBox.setSelected(false);
		lairActionsBox.setSelected(false);
		regionalEffectsBox.setSelected(false);
		toggleMultiattack();
		toggleLegendaryActions();
		toggleLairActions();
		toggleRegionalEffects();
	}

	public void addTrait(ActionEvent ae) {
		System.out.println("add trait");
		System.out.println(ae);
	}

	public void toggleMultiattack() {
		boolean show = (multiattackBox.isSelected());
		multiattackDescription.setDisable(!show);
	}

	public void toggleLegendaryActions() {
		boolean show = (legendaryActionsBox.isSelected());
		legendaryPoints.setDisable(!show);
		legendaryActionBtn.setDisable(!show);
	}

	public void toggleLairActions() {
		boolean show = (lairActionsBox.isSelected());
		lairActionBtn.setDisable(!show);
	}

	public void toggleRegionalEffects() {
		boolean show = (regionalEffectsBox.isSelected());
		regionalEffectsGrid.setDisable(!show);
	}

	public void openLairActionEditor(ActionEvent ae) {
		System.out.println(ae.getSource());
		Stage stage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("lairActionEditor.fxml"));
			stage.setScene(new Scene(root));
			stage.setTitle("Lair Action Editor");
			stage.getScene().getStylesheets().add(getClass().getResource("editor.css").toExternalForm());
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(editorInterface.getScene().getWindow());
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void openActionEditor(ActionEvent ae) {
		System.out.println(ae.getSource());
		Stage stage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("actionEditor.fxml"));
			stage.setScene(new Scene(root));
			stage.setTitle("Action Editor");
			stage.getScene().getStylesheets().add(getClass().getResource("editor.css").toExternalForm());
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(editorInterface.getScene().getWindow());
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void openLegendaryActionEditor(ActionEvent ae) {
		System.out.println(ae.getSource());
		Stage stage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("legendaryActionEditor.fxml"));
			stage.setScene(new Scene(root));
			stage.setTitle("Legendary Action Editor");
			stage.getScene().getStylesheets().add(getClass().getResource("editor.css").toExternalForm());
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(editorInterface.getScene().getWindow());
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void close(ActionEvent ae) {
		System.out.println(ae);
		// Check if monster exists, and then if there are any changes
		// Prompt user if they really want to close
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Close");
		alert.setContentText("Are you sure you want to close? Unsaved changes will be disregarded.");
		ButtonType closeBtn = new ButtonType("Close");
		ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(closeBtn, cancelBtn);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent() && result.get() == closeBtn) {
			alert.close();
			Stage stage = (Stage) (editorInterface.getScene().getWindow());
			stage.close();
		} else {
			alert.close();
		}
	}

	public void save(ActionEvent ae) {
		// Run validation
		if (validateMonster()) {
			// Check if monster already exist and prompt user if they want to override
			// else create new and save (saveNoValidation)
			saveNoValidation(ae);
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Validation");
			alert.setHeaderText("Validation Failed");
			alert.setContentText("Please go through the highlighted fields and see if they are formatted correctly, or save without validating if you believe this is an error.");
			alert.showAndWait();
		}
	}

	public void saveNoValidation(ActionEvent ae) {
		System.out.println(ae);
		// Check if monster already exist and prompt user if they want to override
		// else create new and save
	}


	private EventHandler<KeyEvent> validateTextIn() {
		return ke -> {
			if (!ke.getCharacter().matches("[A-Za-z0-9'\";,.()\\+\\- ]")) ke.consume();
		};
	}

	private EventHandler<KeyEvent> validateNumbers(final Integer maxLength) {
		return ke -> {
			TextField txt = (TextField) ke.getSource();
			if (txt.getText().length() >= maxLength && maxLength != 0 && txt.getSelectedText().length() != txt.getText().length())
				ke.consume();
			if (!ke.getCharacter().matches("[0-9]")) ke.consume();
		};
	}

	private EventHandler<KeyEvent> validateChallenge() {
		return ke -> {
			TextField txt = (TextField) ke.getSource();
			if (txt.getText().length() >= 3 && txt.getSelectedText().length() != txt.getText().length()) ke.consume();
			if (!ke.getCharacter().matches("[0-9/]")) ke.consume();
		};
	}

	private EventHandler<KeyEvent> validateStats() {
		return ke -> {
			TextField txt = (TextField) ke.getSource();
			if (txt.getText().length() >= 2 && txt.getSelectedText().length() != txt.getText().length()) ke.consume();
			if (!ke.getCharacter().matches("[0-9]")) ke.consume();
		};
	}

	private void calculateStats(Observable observable) {
		int mod;
		String pre;
		if (strength.getText().length() > 0) {
			mod = (int) (Math.floor((Integer.parseInt(strength.getText()) - 10) / 2.0));
			pre = (mod < 0) ? "" : "+";
			strengthMod.setText("(" + pre + mod + ")");
		}
		if (dexterity.getText().length() > 0) {
			mod = (int) (Math.floor((Integer.parseInt(dexterity.getText()) - 10) / 2.0));
			pre = (mod < 0) ? "" : "+";
			dexterityMod.setText("(" + pre + mod + ")");
		}
		if (constitution.getText().length() > 0) {
			mod = (int) (Math.floor((Integer.parseInt(constitution.getText()) - 10) / 2.0));
			pre = (mod < 0) ? "" : "+";
			constitutionMod.setText("(" + pre + mod + ")");
		}
		if (intelligence.getText().length() > 0) {
			mod = (int) (Math.floor((Integer.parseInt(intelligence.getText()) - 10) / 2.0));
			pre = (mod < 0) ? "" : "+";
			intelligenceMod.setText("(" + pre + mod + ")");
		}
		if (wisdom.getText().length() > 0) {
			mod = (int) (Math.floor((Integer.parseInt(wisdom.getText()) - 10) / 2.0));
			pre = (mod < 0) ? "" : "+";
			wisdomMod.setText("(" + pre + mod + ")");
		}
		if (charisma.getText().length() > 0) {
			mod = (int) (Math.floor((Integer.parseInt(charisma.getText()) - 10) / 2.0));
			pre = (mod < 0) ? "" : "+";
			charismaMod.setText("(" + pre + mod + ")");
		}
	}

	private boolean validateMonster() {
		monsterName.pseudoClassStateChanged(errorClass, false);
		size.pseudoClassStateChanged(errorClass, false);
		type.pseudoClassStateChanged(errorClass, false);
		alignment.pseudoClassStateChanged(errorClass, false);
		ac.pseudoClassStateChanged(errorClass, false);
		acDesc.pseudoClassStateChanged(errorClass, false);
		hp.pseudoClassStateChanged(errorClass, false);
		hpDesc.pseudoClassStateChanged(errorClass, false);
		speed.pseudoClassStateChanged(errorClass, false);
		skills.pseudoClassStateChanged(errorClass, false);
		senses.pseudoClassStateChanged(errorClass, false);
		challenge.pseudoClassStateChanged(errorClass, false);

		boolean ok = true;

		if (monsterName.getText().length() <= 0) {
			monsterName.pseudoClassStateChanged(errorClass, true);
			ok = false;
		}
		if (size.getValue() == null) {
			size.pseudoClassStateChanged(errorClass, true);
			ok = false;
		}
		if (type.getText().length() <= 0) {
			type.pseudoClassStateChanged(errorClass, true);
			ok = false;
		}
		if (alignment.getText().length() <= 0) {
			alignment.pseudoClassStateChanged(errorClass, true);
			ok = false;
		}
		if (ac.getText().length() <= 0) {
			ac.pseudoClassStateChanged(errorClass, true);
			ok = false;
		}
		if (!acDesc.getText().matches("[A-Za-z0-9.,\\+\\- ]*")) {
			acDesc.pseudoClassStateChanged(errorClass, true);
			ok = false;
		}
		if (hp.getText().length() <= 0) {
			hp.pseudoClassStateChanged(errorClass, true);
			ok = false;
		}
		if (!hpDesc.getText().matches("[0-9]+d[0-9]+(\\+[0-9]*)?")) {
			System.out.println(hpDesc.getPseudoClassStates());
			hpDesc.pseudoClassStateChanged(errorClass, true);
			ok = false;
		}
		if (!speed.getText().matches("[0-9]+ ft\\.(, ((fly|swim|burrow|climb) )?[0-9]+ ft\\.( \\(hover\\))?)*")) {
			speed.pseudoClassStateChanged(errorClass, true);
			ok = false;
		}
		if (!skills.getText().matches("(([A-Z][a-z ]*)*(\\+|\\-)[0-9]{1,2}(, ([A-Z][a-z ]*)*(\\+|\\-)[0-9]{1,2})*)?")) {
			skills.pseudoClassStateChanged(errorClass, true);
			ok = false;
		}
		if (!senses.getText().matches("((blindsight|darkvision|tremorsense|truesight)( \\d+ ft\\.)?, )*passive Perception \\d+")) {
			senses.pseudoClassStateChanged(errorClass, true);
			ok = false;
		}
		if (!challenge.getText().matches("(1/(2|4|8))|([0-9]|[1-9][0-9])")) {
			challenge.pseudoClassStateChanged(errorClass, true);
			ok = false;
		}

		return ok;
	}

}