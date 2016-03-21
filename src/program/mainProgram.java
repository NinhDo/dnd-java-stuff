package program;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import monsterObject.monsterObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class mainProgram {

	public static void main(String[] args) {
		// reads monster.json in root and makes a new monster.json in /out/
		// after creating monsterObjects in a list
		run();
	}

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

		writeToFile(cleanedList);
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
}
