package game.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GameModeController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToStartScene(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SceneStart.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToBattleh(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("BatlleH.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToBattlee(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("BattelE.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
