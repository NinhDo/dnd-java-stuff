package editor;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class editorController implements Initializable {

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
	public ScrollPane editorInterface;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Add items to comboBoxes
		// Size
		size.getItems().addAll("Tiny", "Small", "Medium", "Large", "Huge", "Gargantuan");


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


	public void meleeEditor(ActionEvent ae) {
		openActionEditor('m', ae);
	}

	public void rangedEditor(ActionEvent ae) {
		openActionEditor('r', ae);
	}

	public void otherEditor(ActionEvent ae) {
		openActionEditor('o', ae);
	}

	public void customEditor(ActionEvent ae) {
		openActionEditor('c', ae);
	}

	public void toggleMultiattack() {
		boolean show = (multiattackBox.isSelected());
		multiattackDescription.setDisable(!show);
	}

	public void toggleLegendaryActions() {
		boolean show = (legendaryActionsBox.isSelected());
		for (int i = 0; i < legendaryActions.getChildren().size(); i++) {
			if (legendaryActions.getChildren().get(i).getId() == null) {
				legendaryActions.getChildren().get(i).setDisable(!show);
			}
		}
	}

	public void toggleLairActions() {
		boolean show = (lairActionsBox.isSelected());
		lairActionBtn.setDisable(!show);
	}

	public void lairActionEditor(ActionEvent ae) {
		openActionEditor('o', ae);
	}

	public void toggleRegionalEffects() {
		boolean show = (regionalEffectsBox.isSelected());
		regionalEffectsGrid.setDisable(!show);
	}

	private void openActionEditor(char type, ActionEvent ae) {
		Stage stage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("actionEditor.fxml"));
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(editorInterface.getScene().getWindow());
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
		switch (type) {
			case 'm':

				break;
			case 'r':

				break;
			case 'o':

				break;
			case 'c':

				break;
		}
	}

	public void legendaryMeleeEditor(ActionEvent ae) {
		openLegendaryActionEditor('m', ae);
	}


	public void legendaryRangedEditor(ActionEvent ae) {
		openLegendaryActionEditor('r', ae);
	}

	public void legendaryOtherEditor(ActionEvent ae) {
		openLegendaryActionEditor('o', ae);
	}

	public void legendaryCustomEditor(ActionEvent ae) {
		openLegendaryActionEditor('c', ae);
	}


	private void openLegendaryActionEditor(char type, ActionEvent ae) {
		Stage stage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("legendaryActionEditor.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		switch (type) {
			case 'm':

				break;
			case 'r':

				break;
			case 'o':

				break;
			case 'c':

				break;
		}
	}
}