package game.gui;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		
			Parent root = FXMLLoader.load(getClass().getResource("SceneStart.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			
		
	
	}
	
	public static void main(String[] args) {
		launch(args);
		javafx.geometry.Rectangle2D sc = Screen.getPrimary().getVisualBounds();
				System.out.print(sc.getWidth());
		System.out.print(sc.getWidth());

		
	}
}
