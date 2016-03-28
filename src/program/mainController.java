package program;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import monsterObject.monsterObject;
import monsterObject.monsterObjectNew;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;

public class mainController implements Initializable {

	public Button newBtn;
	public Button editBtn;
	public Button jsonBtn;
	public Button roll20Btn;
	public Button importBtn;
	public ListView monsterList;
	public TextField searchBar;
	public WebView leftColumn;
	public WebView rightColumn;
	private WebEngine leftView;
	private WebEngine rightView;

	private boolean isNew;
	private List<monsterObject> monsterObjects;
	private List<monsterObjectNew> monsterObjectNews;
	private List<String> allMonstersInList = new ArrayList<>();
	private String selectedMonster = "";
	private String previousMonster = "";

	private static String cleanList(List<String> moList) {
		String cleanedList = "[\n";
		for (String mo : moList) {
			mo = mo.replaceAll("\\r", "");
			mo = mo.replaceAll("\", \"", "\",\n\t\t\t\"");
			mo = mo.replaceAll("\\{", "\t{");
			mo = mo.replaceAll("\\}", "\t}");
			mo = mo.replaceAll("  ", "\t\t");
			mo = mo.replaceAll("\\[ ", "[\n\t\t\t");
			mo = mo.replaceAll(" ]", "\n\t\t]");
			cleanedList += mo + ",\n";
		}
		cleanedList = cleanedList.substring(0, cleanedList.length() - 2) + "\n]";
		return cleanedList;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		searchBar.textProperty().addListener(((observable, oldValue, newValue) -> search(newValue, oldValue)));
		searchBar.setDisable(true);
		System.out.println("Trying to load monsters.json...");
		leftView = leftColumn.getEngine();
		rightView = rightColumn.getEngine();
		try {
			initializeUpdateList();
		} catch (IOException e) {
			System.out.println("Failed to load monsters.json on load.");
		}
	}

	public void newMonster(ActionEvent ae) {
	}

	public void editMonster(ActionEvent ae) {
	}

	public void saveJson(ActionEvent ae) {
	}

	public void saveRoll20(ActionEvent ae) {
	}

	private void search(String newValue, String oldValue) {
		if (newValue.length() > oldValue.length()) {
			removeMonsters(newValue);
		} else {
			monsterList.getItems().clear();
			for (String s : allMonstersInList) monsterList.getItems().add(s);
			removeMonsters(newValue);
		}
		monsterList.refresh();
		System.out.println(monsterList.getItems().toArray().length);
	}

	private void removeMonsters(String newValue) {
		for (int i = monsterList.getItems().toArray().length - 1; i >= 0; i--) {
			if (!monsterList.getItems().get(i).toString().toLowerCase().contains(newValue)) {
				//System.out.println(monsterList.getItems().get(i).toString().toLowerCase().contains(newValue));
				//System.out.println(monsterList.getItems().get(i).toString().toLowerCase() + "\t" + newValue);
				// System.out.println(monsterList.getItems().get(i));
				monsterList.getItems().remove(i);
			}
		}
	}

	public void importMonsters(ActionEvent ae) throws IOException {
		Stage stage = (Stage) ((Button) ae.getSource()).getScene().getWindow();
		FileChooser fc = new FileChooser();
		fc.setTitle("Import monsters");
		fc.setInitialDirectory(new File(System.getProperty("user.dir")));
		File selectedFile = fc.showOpenDialog(stage);
		List<String> moList = new ArrayList<>();
		// String cleanedList;

		boolean readOK = true;
		isNew = false;

		if (selectedFile != null) {
			try {
				String fileToString = new Scanner(selectedFile).useDelimiter("\\Z").next();
				if (fileToString.substring(0, 1).equals("[")) {
					moList = readJson(selectedFile);
				} else {
					moList = readJS(fileToString);
				}
			} catch (Exception e) {
				System.out.println("Unable to read file.");
				e.printStackTrace();
				readOK = false;
				showAlert();
			}

			if (readOK) {
				System.out.println("File read correctly");

				//cleanedList = cleanList(moList);
				//System.out.println(cleanedList);

				System.out.println("\n\nAdding list to interface...");
				updateList(moList);
				System.out.println("Adding done.\n");
			}
		}
	}

	private void initializeUpdateList() throws IOException {
		List<String> moList = readJson(new File("./monsters.json"));
		updateList(moList);
	}

	private void updateList(List<String> moList) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		String listToString = moList.toString();
		if (isNew) {
			monsterObjectNews = mapper.readValue(listToString, new TypeReference<List<monsterObjectNew>>() {
			});
			List<String> monsterNames = monsterObjectNews.stream().map(monsterObject -> monsterObject.getName()).collect(Collectors.toList());
			allMonstersInList = monsterObjects.stream().map(monsterObject -> monsterObject.getName()).collect(Collectors.toList());
			monsterList.setItems(FXCollections.observableList(monsterNames));
		} else {
			monsterObjects = mapper.readValue(listToString, new TypeReference<List<monsterObject>>() {
			});
			List<String> monsterNames = monsterObjects.stream().map(monsterObject -> monsterObject.getName()).collect(Collectors.toList());
			allMonstersInList = monsterObjects.stream().map(monsterObject -> monsterObject.getName()).collect(Collectors.toList());
			monsterList.setItems(FXCollections.observableList(monsterNames));
		}
		monsterList.refresh();
		searchBar.setDisable(false);
		monsterList.setOnMouseClicked(this::loadMonster);
	}

	private void loadMonster(MouseEvent event) {
		selectedMonster = monsterList.getSelectionModel().getSelectedItem().toString();
		if (!selectedMonster.equals(previousMonster)) {
			System.out.println("Loading " + selectedMonster);
			previousMonster = selectedMonster;
			if (isNew) {
				for (monsterObjectNew moN : monsterObjectNews) {
					if (moN.getName().toLowerCase().equals(selectedMonster.toLowerCase())) {
						updateWebViewsNew(moN);
						break;
					}
				}
			} else {
				for (monsterObject mo : monsterObjects) {
					if (mo.getName().toLowerCase().equals(selectedMonster.toLowerCase())) {
						updateWebViews(mo);
						break;
					}
				}
			}
		} else {
			System.out.println("Monster already loaded or multiple monsters selected");
		}
	}

	private void updateWebViews(monsterObject mo) {
		int[] abilities = new int[6];
		String[] abilitiesStrings = mo.getAbilities().split(" ");
		for (int i = 1; i < abilitiesStrings.length; i += 2) {
			abilities[(i - 1) / 2] = Integer.parseInt(abilitiesStrings[i]);
		}
		int[] abilitiesMod = new int[6];
		for (int i = 0; i < 6; i++) {
			abilitiesMod[i] = (int) Math.floor((abilities[i] - 10) / 2.0);
		}
		String leftText = String.format("<h1>%s</h1>" +
				"<p>%s, %s, %s</p>" +
				"<p><strong>Armor Class:</strong>%s</p>" +
				"<p><strong>Hit Points:</strong>%s</p>" +
				"<p><strong>Speed:</strong>%s</p>" +
				"<table style=\"width:100&amp\">" +
				"<tr><td>STR</td><td>DEX</td><td>CON</td><td>INT</td><td>WIS</td><td>CHA</td></tr>" +
				"<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>" +
				"<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr></table>", mo
				.getName(), mo.getSize(), mo.getType(), mo.getAlignment(), mo.getAC(), mo.getHP(), mo.getSpeed(), abilities[0], abilities[1], abilities[2], abilities[3], abilities[4], abilities[5], abilitiesMod[0], abilitiesMod[1], abilitiesMod[2], abilitiesMod[3], abilitiesMod[4], abilitiesMod[5]);
		leftView.loadContent(leftText);
		System.out.println(leftText);
	}

	private void updateWebViewsNew(monsterObjectNew moN) {
	}

	private void showAlert() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Import Failed");
		alert.setHeaderText("Unable to import monsters from the file");
		alert.setContentText("Maybe you selected the wrong file." +
				"\nIf you downloaded a file, try downloading the one on mlenser's github.");
		alert.showAndWait();
	}

	private List<String> readJson(File file) throws IOException {
		List<String> moList = new ArrayList<>();
		List<monsterObject> mos;
		List<monsterObjectNew> mosN;

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		System.out.println("Reading old json file...");
		try {
			isNew = false;
			mos = mapper.readValue(file, new TypeReference<List<monsterObject>>() {
			});
			//
			for (monsterObject mo : mos) {
				moList.add(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mo));
			}
			//
		} catch (UnrecognizedPropertyException e) {
			isNew = true;
			System.out.println("Unable to read old json file");
			e.printStackTrace();
			System.out.println("Reading new json file");
			mosN = mapper.readValue(file, new TypeReference<List<monsterObjectNew>>() {
			});
			//
			for (monsterObjectNew mo : mosN) {
				moList.add(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mo));
			}
			//
		}
		return moList;
	}

	private List<String> readJS(String file) throws IOException {
		List<String> moList = new ArrayList<>();
		List<monsterObject> mos;
		List<monsterObjectNew> mosN;

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		System.out.println("Reading old javascript file...");
		try {
			isNew = false;
			int i = file.indexOf("monsters:") + "monsters:".length();
			String longString = file.substring(i, file.length() - 2);
			mos = mapper.readValue(longString, new TypeReference<List<monsterObject>>() {
			});
			//
			for (monsterObject mo : mos) {
				moList.add(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mo));
			}
			//
		} catch (UnrecognizedPropertyException e) {
			isNew = true;
			System.out.println("Unable to read old javascript file");
			e.printStackTrace();
			int i = file.indexOf("monsters:") + "monsters:".length();
			String longString = file.substring(i, file.length() - 2);
			mosN = mapper.readValue(longString, new TypeReference<List<monsterObjectNew>>() {
			});
			//
			for (monsterObjectNew mo : mosN) {
				moList.add(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mo));
			}
			//
		}
		return moList;
	}
}
