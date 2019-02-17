package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch();
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/MainWindow.fxml"));
		Parent root = loader.load();
		Scene mainScene = new Scene(root);
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
	}
	
	@Override
	public void stop() {
		System.exit(0);
	}
	
}
