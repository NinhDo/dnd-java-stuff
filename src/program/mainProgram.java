package program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class mainProgram extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	private static void writeToFile(String cleanedList) {
		String filename = "monsters.json";
		System.out.println("Writing " + filename + "...");
		try (FileWriter file = new FileWriter(new File("./out/" + filename))) {
			file.write(cleanedList);
			System.out.println("Writing successfully.");
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/*

	private static void run() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

		List<String> moList = new ArrayList<>();

		try {
			List<monsterObject> mos = mapper.readValue(new File("C:\\Users\\Guest\\Documents\\GitHub\\dnd-java-stuff\\monsters.json"), new TypeReference<List<monsterObject>>() {
			});
			for (monsterObject monsterObject : mos) {
				moList.add(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(monsterObject));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String cleanedList = cleanList(moList);
		System.out.println(cleanedList);

		// Writes to monster.json
		//writeToFile(cleanedList);
	}

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
*/

	@Override
	public void start(Stage primaryStage) throws Exception {
		// reads monster.json in root and makes a new monster.json in /out/
		// after creating monsterObjects in a list
		//run();
		// Creates window and displays it
		Parent root = FXMLLoader.load(getClass().getResource("mainInterface.fxml"));
		primaryStage.setTitle("Monsters");
		primaryStage.setScene(new Scene(root, 850, 600));
		primaryStage.setMinHeight(300);
		primaryStage.setMinWidth(600);
		primaryStage.show();
	}
}
