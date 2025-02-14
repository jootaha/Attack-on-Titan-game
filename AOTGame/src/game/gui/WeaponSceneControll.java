package game.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WeaponSceneControll {
Stage stage;
Scene scene;
Parent root;

public void switchToBattleScene(ActionEvent e) throws IOException{
	Parent root = FXMLLoader.load(getClass().getResource("BatlleH.fxml"));
	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}

}
