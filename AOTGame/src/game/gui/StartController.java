package game.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToInstructionsScene(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SceneInstruction.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToStartScene(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SceneStart.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToGameScene(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SceneGameMode.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/*
	
	

	public void switchToInstructionsScene(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("instructions.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToBattleScene(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("BattleScene.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	*/
}
