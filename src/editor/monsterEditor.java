package editor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class monsterEditor extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("editorInterface.fxml"));
		primaryStage.setTitle("Monster Editor");
		primaryStage.setScene(new Scene(root, 850, 600));
		primaryStage.show();
	}
}
