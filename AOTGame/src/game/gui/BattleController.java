package game.gui;

import game.engine.Battle;
import game.engine.base.Wall;
import game.engine.exceptions.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import game.engine.*;
import game.engine.lanes.Lane;
import game.engine.titans.Titan;
import game.engine.weapons.PiercingCannon;
import game.engine.weapons.SniperCannon;
import game.engine.weapons.VolleySpreadCannon;
import game.engine.weapons.WallTrap;
public class BattleController {
	
 Stage stage;
 Scene scene;
 Parent root;
 Image PureTitani=new Image("PureTitan.png");
 Image AbnormalTitani=new Image("AbnormalTitan.png");
 Image ArmoredTitani=new Image("ArmoredTitan (1).png");
 Image ColasslaTitani=new Image("ColassalTitan.png");
 Image walli=new Image("wall.jpg");
 Image fire=new Image("423 .png");
 ImageView PureTitaniv=new ImageView(PureTitani);
 ImageView ArmoredTitaniv=new ImageView(ArmoredTitani);
 ImageView AbnormalTitaniv=new ImageView(AbnormalTitani);
 ImageView ColasslaTitaniv=new ImageView(ColasslaTitani);
 @FXML
 AnchorPane a=new AnchorPane(); 
 
 
 Image PiercingCannoni=new Image ("231.png");
 Image SniperCannoni=new Image("SniperCannon (1).png");
 Image volleySpreadCannoni=new Image("VolleySpreadCannon.png");
 Image wallTrapi=new Image("WallTrap (2).png");
 


   public BattleController()throws IOException{};
        Battle battle=new Battle(0,0,23,5,125);
        
     ArrayList<Integer> dangerlevels=new ArrayList<>();
     ArrayList<Integer> Health=new ArrayList<>();
     ArrayList<Integer> weaponimagelane1=new ArrayList<>();
     ArrayList<Integer> weaponimagelane2=new ArrayList<>();
     ArrayList<Integer> weaponimagelane3=new ArrayList<>();
     ArrayList<Integer> weaponimagelane4=new ArrayList<>();
     ArrayList<Integer> weaponimagelane5=new ArrayList<>();
     

   @FXML
  GridPane gpp;
   
   @FXML
   Label Health1text;
   @FXML
   Label Health2text;
   @FXML
   Label Health3text;
   @FXML
   Label Health4text;
   @FXML
   Label Health5text;
   @FXML
   Button StartScene;
   @FXML
   Button exit;
   @FXML
   Label lscore=new Label("Your Total Score:"+battle.getScore());
     
 @FXML
Label dangerlevel1text;

     @FXML
Label dangerlevel2text;
     @FXML
Label dangerlevel3text;
     @FXML
Label dangerlevel4text;
     @FXML
Label dangerlevel5text;
     
@FXML
	TextArea topTextArea;


   
@FXML
Button p1;
@FXML
Button p2;
@FXML
Button p3;
@FXML
Button p4;
@FXML
Button p5;

@FXML
Button w1;
@FXML
Button w2;
@FXML
Button w3;
@FXML
Button w4;
@FXML
Button w5;

@FXML
Button v1;
@FXML
Button v2;
@FXML
Button v3;
@FXML
Button v4;
@FXML
Button v5;

@FXML
Button s1;
@FXML
Button s2;
@FXML
Button s3;
@FXML
Button s4;
@FXML
Button s5;

private static int finalScore;
public static int getFinalScore() {
	return finalScore;
}

public static void setFinalScore(int finalscore) {
	BattleController.finalScore = finalscore;
}
public void  finalScore(){
	lscore.setText("Your Total Score is:"+getFinalScore());
}
public void showGameOverMessage(ActionEvent e) throws IOException{
	Parent root = FXMLLoader.load(getClass().getResource("GameOverMessage.fxml"));
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
public void showInvalidLaneMessage(){
	 Stage messageStage = new Stage();
	 Image wallpaperImage = new Image("istockphoto-537282082-612x612.jpg");
	 messageStage.setWidth(550);
	 messageStage.setHeight(400);
	  BackgroundImage backgroundImage = new BackgroundImage(
             wallpaperImage,
             BackgroundRepeat.NO_REPEAT, // or BackgroundRepeat.REPEAT, BackgroundRepeat.ROUND, etc.
             BackgroundRepeat.NO_REPEAT,
             BackgroundPosition.DEFAULT,
             new BackgroundSize(
                     BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false
             )
     );
	  StackPane sp=new StackPane();
	  sp.setBackground(new Background(backgroundImage));
     sp.setPadding(new Insets(10));
	 Label messageLabel = new Label("Invalid Lane");
	 sp.getChildren().add(messageLabel);
	 messageLabel.setTextFill(Color.web("#FF5733")); // Set text color
    messageLabel.setFont(Font.font("Chiller", 40));
	 Scene messageScene = new Scene(sp);
	 messageStage.setScene(messageScene);
    messageStage.setResizable(false);
	 messageStage.show();
	}
	public void showInsufficientResourcesMessage(){
		Stage messageStage = new Stage();
		 Image wallpaperImage = new Image("how-much-money-is-enough-1-1024x614.jpg");
		 messageStage.setWidth(550);
		 messageStage.setHeight(360);
		  BackgroundImage backgroundImage = new BackgroundImage(
	              wallpaperImage,
	              BackgroundRepeat.NO_REPEAT, // or BackgroundRepeat.REPEAT, BackgroundRepeat.ROUND, etc.
	              BackgroundRepeat.NO_REPEAT,
	              BackgroundPosition.DEFAULT,
	              new BackgroundSize(
	                      BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false
	              )
	      );
		  StackPane sp=new StackPane();
		  sp.setBackground(new Background(backgroundImage));
	      sp.setPadding(new Insets(10));
		 Label messageLabel = new Label("Insufficient resources");
		 sp.getChildren().add(messageLabel);
		 messageLabel.setTextFill(Color.web("#FF5733")); // Set text color
	     messageLabel.setFont(Font.font("Chiller", 40));
		 Scene messageScene = new Scene(sp);
		 messageStage.setScene(messageScene);
	     messageStage.setResizable(false);
		 messageStage.show();
	}
	public void exitGame(){
		Platform.exit();
	}


	


public void p11(ActionEvent e) throws IOException,InsufficientResourcesException,InvalidLaneException{
	
	
	try{
		 if(battle.isGameOver())
			showGameOverMessage(e);
		 else{
      battle.purchaseWeapon(1, battle.getOriginalLanes().get(0));
     
      battle.getOriginalLanes().get(0).addWeapon(new PiercingCannon(10));
        weaponimagelane1.add(weaponimagelane1.size());
        ImageView PiercingCannoniv =new ImageView(PiercingCannoni);
        gpp.add( PiercingCannoniv, weaponimagelane1.size()-1, 0);
        Titan();
        setFinalScore(battle.getScore());
      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
      uptadelabels();
	}
	}
	 catch (InsufficientResourcesException ex) {
		 showInsufficientResourcesMessage();
		 
	    } catch (InvalidLaneException ex) {
	        // Handle InvalidLaneException
	    	showInvalidLaneMessage();
	    	} catch (Exception ex) {
	        // Handle any other exception
	    	
	    }
      
}
public void p22(ActionEvent e) throws IOException,InsufficientResourcesException,InvalidLaneException{
	
	try{
		 if(battle.isGameOver())
			 showGameOverMessage(e);
		 else{
      battle.purchaseWeapon(1, battle.getOriginalLanes().get(1));
     
      battle.getOriginalLanes().get(1).addWeapon(new PiercingCannon(10));
      weaponimagelane2.add(weaponimagelane2.size());
      ImageView PiercingCannoniv =new ImageView(PiercingCannoni);
      gpp.add( PiercingCannoniv, weaponimagelane2.size()-1, 1);
      Titan();
      setFinalScore(battle.getScore());
      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
      uptadelabels();
	}}
	 catch (InsufficientResourcesException ex) {
	        
		 showInsufficientResourcesMessage();
		 } catch (InvalidLaneException ex) {
	    	showInvalidLaneMessage();
	    } catch (Exception ex) {
	        // Handle any other exceptio
	    	System.out.println("not available lane");
	    }
      
}
public void p33(ActionEvent e) throws IOException,InsufficientResourcesException,InvalidLaneException{
	
	
	try{
		 if(battle.isGameOver())
			 showGameOverMessage(e);
		 else{
	      battle.purchaseWeapon(1, battle.getOriginalLanes().get(2));
	     
	      battle.getOriginalLanes().get(2).addWeapon(new PiercingCannon(10));
	      weaponimagelane3.add(weaponimagelane3.size());
	      ImageView PiercingCannoniv =new ImageView(PiercingCannoni);
	      gpp.add( PiercingCannoniv, weaponimagelane3.size()-1, 2);
	      Titan();
	      setFinalScore(battle.getScore());
	      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
	      uptadelabels();}}
	 catch (InsufficientResourcesException ex) {
		 showInsufficientResourcesMessage();
	    } catch (InvalidLaneException ex) {
	    	showInvalidLaneMessage();
	    } catch (Exception ex) {
	        // Handle any other exceptio
	    	System.out.println("not available lane");
	    }
	      
      
}
public void p44(ActionEvent e) throws IOException,InsufficientResourcesException,InvalidLaneException{
	
	try{
		 if(battle.isGameOver())
			 showGameOverMessage(e);
		 else{
      battle.purchaseWeapon(1, battle.getOriginalLanes().get(03));
     
      battle.getOriginalLanes().get(3).addWeapon(new PiercingCannon(10));
      weaponimagelane4.add(weaponimagelane4.size());
      ImageView PiercingCannoniv =new ImageView(PiercingCannoni);
      gpp.add( PiercingCannoniv, weaponimagelane4.size()-1, 3);
      Titan();
      setFinalScore(battle.getScore());
      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
      uptadelabels();
	}}
	 catch (InsufficientResourcesException ex) {
		 showInsufficientResourcesMessage();
	    } catch (InvalidLaneException ex) {
	        // Handle InvalidLaneException
	    	showInvalidLaneMessage();
	    } catch (Exception ex) {
	        // Handle any other exceptio
	    	System.out.println("not available lane");
	    }
      
}
public void p55(ActionEvent e) throws IOException,InsufficientResourcesException,InvalidLaneException{
	try{
		 if(battle.isGameOver())
			 showGameOverMessage(e);
		 else{
      battle.purchaseWeapon(1, battle.getOriginalLanes().get(4));
     
      battle.getOriginalLanes().get(4).addWeapon(new PiercingCannon(10));
      weaponimagelane5.add(weaponimagelane5.size());
      
      ImageView PiercingCannoniv =new ImageView(PiercingCannoni);
      gpp.add( PiercingCannoniv, weaponimagelane5.size()-1, 4);
      Titan();
      setFinalScore(battle.getScore());
      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
      uptadelabels();
	}}
	 catch (InsufficientResourcesException ex) {
		 showInsufficientResourcesMessage();
			} catch (InvalidLaneException ex) {
				showInvalidLaneMessage();
	    } catch (Exception ex) {
	        // Handle any other exceptio
	    	System.out.println("not available lane");
	    }
      
}


public void s11(ActionEvent e) throws IOException,InsufficientResourcesException,InvalidLaneException{
	
	
	try{
		 if(battle.isGameOver())
			 showGameOverMessage(e);
		 else{
      battle.purchaseWeapon(2, battle.getOriginalLanes().get(0));
     
      battle.getOriginalLanes().get(0).addWeapon(new SniperCannon(35));
        weaponimagelane1.add(weaponimagelane1.size());
        ImageView SniperCannoniv =new ImageView(SniperCannoni);
        gpp.add( SniperCannoniv, weaponimagelane1.size()-1, 0);
        Titan();
        setFinalScore(battle.getScore());
      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
      uptadelabels();
	}
	}
	 catch (InsufficientResourcesException ex) {
		 showInsufficientResourcesMessage();
	    } catch (InvalidLaneException ex) {
	    	showInvalidLaneMessage();
	    } catch (Exception ex) {
	        // Handle any other exceptio
	    	System.out.println("not available lane");
	    }
}

public void s22(ActionEvent e) throws IOException,InsufficientResourcesException,InvalidLaneException{
	
	
	try{
		 if(battle.isGameOver())
			 showGameOverMessage(e);
		 else{
      battle.purchaseWeapon(2, battle.getOriginalLanes().get(1));
     
      battle.getOriginalLanes().get(1).addWeapon(new SniperCannon(35));
        weaponimagelane2.add(weaponimagelane2.size());
        ImageView SniperCannoniv =new ImageView(SniperCannoni);
        gpp.add( SniperCannoniv, weaponimagelane2.size()-1, 1);
        Titan();
        setFinalScore(battle.getScore());
      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
      uptadelabels();
	}}
	 catch (InsufficientResourcesException ex) {
		 showInsufficientResourcesMessage();
	    } catch (InvalidLaneException ex) {
	    	showInvalidLaneMessage();
	    } catch (Exception ex) {
	        // Handle any other exceptio
	    	System.out.println("not available lane");
	    }
}
public void s33(ActionEvent e) throws IOException,InsufficientResourcesException,InvalidLaneException{
	
	
	try{
		 if(battle.isGameOver())
			 showGameOverMessage(e);
		 else{
      battle.purchaseWeapon(2, battle.getOriginalLanes().get(2));
     
      battle.getOriginalLanes().get(2).addWeapon(new SniperCannon(35));
        weaponimagelane3.add(weaponimagelane3.size());
        ImageView SniperCannoniv =new ImageView(SniperCannoni);
        gpp.add( SniperCannoniv, weaponimagelane3.size()-1, 2);
        Titan();
        setFinalScore(battle.getScore());
      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
      uptadelabels();
	}}
	 catch (InsufficientResourcesException ex) {
		 showInsufficientResourcesMessage();
	    } catch (InvalidLaneException ex) {
	    	showInvalidLaneMessage();
	    } catch (Exception ex) {
	        // Handle any other exceptio
	    	System.out.println("not available lane");
	    }
}


public void s44(ActionEvent e) throws IOException,InsufficientResourcesException,InvalidLaneException{
	
	
	try{
		 if(battle.isGameOver())
			 showGameOverMessage(e);
		 else{
      battle.purchaseWeapon(2, battle.getOriginalLanes().get(3));
     
      battle.getOriginalLanes().get(3).addWeapon(new SniperCannon(35));
        weaponimagelane4.add(weaponimagelane4.size());
        ImageView SniperCannoniv =new ImageView(SniperCannoni);
        gpp.add( SniperCannoniv, weaponimagelane4.size()-1, 3);
        Titan();
        setFinalScore(battle.getScore());
      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
      uptadelabels();
	}}
	 catch (InsufficientResourcesException ex) {
		 showInsufficientResourcesMessage();
	    } catch (InvalidLaneException ex) {
	        showInvalidLaneMessage();
	    } catch (Exception ex) {
	        // Handle any other exceptio
	    	System.out.println("not available lane");
	    }
}
public void s55(ActionEvent e) throws IOException,InsufficientResourcesException,InvalidLaneException{
	
	
	try{
		 if(battle.isGameOver())
			 showGameOverMessage(e);
		 else{
      battle.purchaseWeapon(2, battle.getOriginalLanes().get(4));
     
      battle.getOriginalLanes().get(4).addWeapon(new SniperCannon(35));
        weaponimagelane5.add(weaponimagelane5.size());
        ImageView SniperCannoniv =new ImageView(SniperCannoni);
        gpp.add( SniperCannoniv, weaponimagelane5.size()-1, 4);
        Titan();
        setFinalScore(battle.getScore());
      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
      uptadelabels();
	}}
	 catch (InsufficientResourcesException ex) {
		 showInsufficientResourcesMessage();
	    } catch (InvalidLaneException ex) {
	    	showInvalidLaneMessage();
	    } catch (Exception ex) {
	        // Handle any other exceptio
	    	System.out.println("not available lane");
	    }
}

public void v11(ActionEvent e)throws IOException,InsufficientResourcesException,InvalidLaneException{
	try{
		 if(battle.isGameOver())
			 showGameOverMessage(e);
		 else{
	      battle.purchaseWeapon(3, battle.getOriginalLanes().get(0));
	     
	      battle.getOriginalLanes().get(0).addWeapon(new VolleySpreadCannon(5,20,50));
	        weaponimagelane1.add(weaponimagelane1.size());
	        ImageView VolleySpreadCannoniv =new ImageView(volleySpreadCannoni);
	        gpp.add( VolleySpreadCannoniv, weaponimagelane1.size()-1, 0);
	        Titan();
	        setFinalScore(battle.getScore());
	      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
	      uptadelabels();
		}}
		 catch (InsufficientResourcesException ex) {
			 showInsufficientResourcesMessage();
		    } catch (InvalidLaneException ex) {
		    	showInvalidLaneMessage();
		    } catch (Exception ex) {
		        // Handle any other exceptio
		    	System.out.println("not available lane");
		    }
}
	public void v22(ActionEvent e)throws IOException,InsufficientResourcesException,InvalidLaneException{
		try{
			 if(battle.isGameOver())
				 showGameOverMessage(e);
			 else{
		      battle.purchaseWeapon(3, battle.getOriginalLanes().get(1));
		     
		      battle.getOriginalLanes().get(1).addWeapon(new VolleySpreadCannon(5,20,50));
		        weaponimagelane2.add(weaponimagelane2.size());
		        ImageView VolleySpreadCannoniv =new ImageView(volleySpreadCannoni);
		        gpp.add( VolleySpreadCannoniv, weaponimagelane2.size()-1, 1);
		        Titan();
		        setFinalScore(battle.getScore());
		      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
		      uptadelabels();
			}}
			 catch (InsufficientResourcesException ex) {
				 showInsufficientResourcesMessage();
			    } catch (InvalidLaneException ex) {
			    	showInvalidLaneMessage();
			    } catch (Exception ex) {
			        // Handle any other exceptio
			    	System.out.println("not available lane");
			    }

}
	public void v33(ActionEvent e)throws IOException,InsufficientResourcesException,InvalidLaneException{
		try{
			 if(battle.isGameOver())
				 showGameOverMessage(e);
			 else{
		      battle.purchaseWeapon(3, battle.getOriginalLanes().get(2));
		     
		      battle.getOriginalLanes().get(2).addWeapon(new VolleySpreadCannon(5,20,50));
		        weaponimagelane3.add(weaponimagelane3.size());
		        ImageView VolleySpreadCannoniv =new ImageView(volleySpreadCannoni);
		        gpp.add( VolleySpreadCannoniv, weaponimagelane3.size()-1, 2);
		        Titan();
		        setFinalScore(battle.getScore());
		      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
		      uptadelabels();
			}}
			 catch (InsufficientResourcesException ex) {
				 showInsufficientResourcesMessage();
			    } catch (InvalidLaneException ex) {
			    	showInvalidLaneMessage();
			    } catch (Exception ex) {
			        // Handle any other exceptio
			    	System.out.println("not available lane");
			    }
	}
		public void v44(ActionEvent e)throws IOException,InsufficientResourcesException,InvalidLaneException{
			try{
				 if(battle.isGameOver())
					 showGameOverMessage(e);
				 {
			      battle.purchaseWeapon(3, battle.getOriginalLanes().get(3));
			     
			      battle.getOriginalLanes().get(3).addWeapon(new VolleySpreadCannon(5,20,50));
			        weaponimagelane4.add(weaponimagelane4.size());
			        ImageView VolleySpreadCannoniv =new ImageView(volleySpreadCannoni);
			        gpp.add( VolleySpreadCannoniv, weaponimagelane4.size()-1, 3);
			        Titan();
			        setFinalScore(battle.getScore());
			      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
			      uptadelabels();
				}}
				 catch (InsufficientResourcesException ex) {
					 showInsufficientResourcesMessage();
						} catch (InvalidLaneException ex) {
							showInvalidLaneMessage();
				    } catch (Exception ex) {
				        // Handle any other exception
				    	
				    }
			}

			public void v55(ActionEvent e)throws IOException,InsufficientResourcesException,InvalidLaneException{
				try{
					 if(battle.isGameOver())
						 showGameOverMessage(e);
					 else{
				      battle.purchaseWeapon(3, battle.getOriginalLanes().get(4));
				     
				      battle.getOriginalLanes().get(4).addWeapon(new VolleySpreadCannon(5,20,50));
				        weaponimagelane5.add(weaponimagelane5.size());
				        ImageView VolleySpreadCannoniv =new ImageView(volleySpreadCannoni);
				        gpp.add( VolleySpreadCannoniv, weaponimagelane5.size()-1, 4);
				        Titan();
				        setFinalScore(battle.getScore());
				      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
				      uptadelabels();
					}}
					 catch (InsufficientResourcesException ex) {
						 showInsufficientResourcesMessage();
					    } catch (InvalidLaneException ex) {
					    	showInvalidLaneMessage();
					    } catch (Exception ex) {
					        // Handle any other exceptio
					    	
					    }
			}
			public void w11(ActionEvent e)throws IOException,InsufficientResourcesException,InvalidLaneException{
				try{
					 if(battle.isGameOver())
						 showGameOverMessage(e);
					 else{
				      battle.purchaseWeapon(4, battle.getOriginalLanes().get(0));
				     
				      battle.getOriginalLanes().get(0).addWeapon(new WallTrap(100));
				      weaponimagelane1.add(weaponimagelane1.size());  
				      ImageView WallTrapiv =new ImageView(wallTrapi);
				        gpp.add( WallTrapiv, weaponimagelane1.size()-1, 0);
				        Titan();
				        setFinalScore(battle.getScore());
				      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
				      uptadelabels();
					}}
					 catch (InsufficientResourcesException ex) {
						 showInsufficientResourcesMessage();
					    } catch (InvalidLaneException ex) {
					        showInvalidLaneMessage();
					    } catch (Exception ex) {
					        // Handle any other exceptio
					    	
					    }
			}
			public void w22(ActionEvent e)throws IOException,InsufficientResourcesException,InvalidLaneException{
				try{
					 if(battle.isGameOver())
						 showGameOverMessage(e);
					 else{
				      battle.purchaseWeapon(4, battle.getOriginalLanes().get(1));
				     
				      battle.getOriginalLanes().get(1).addWeapon(new WallTrap(100));
				        weaponimagelane2.add(weaponimagelane2.size());
				        ImageView WallTrapiv =new ImageView(wallTrapi);
				        gpp.add( WallTrapiv, weaponimagelane2.size()-1, 1);
				        Titan();
				        setFinalScore(battle.getScore());
				      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
				      uptadelabels();
					}}
					 catch (InsufficientResourcesException ex) {
						 showInsufficientResourcesMessage();
					    } catch (InvalidLaneException ex) {
					    	showInvalidLaneMessage();
					    } catch (Exception ex) {
					        // Handle any other exceptio
					    	
					    }
			}
			public void w33(ActionEvent e)throws IOException,InsufficientResourcesException,InvalidLaneException{
				try{
					 if(battle.isGameOver())
						 showGameOverMessage(e);
					 else{
				      battle.purchaseWeapon(4, battle.getOriginalLanes().get(2));
				     
				      battle.getOriginalLanes().get(2).addWeapon(new WallTrap(100));
				        weaponimagelane3.add(weaponimagelane3.size());
				        ImageView WallTrapiv =new ImageView(wallTrapi);
				        gpp.add( WallTrapiv, weaponimagelane3.size()-1, 2);
				        Titan();
				        setFinalScore(battle.getScore());
				      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
				      uptadelabels();
					}}
					 catch (InsufficientResourcesException ex) {
						 showInsufficientResourcesMessage();
					    } catch (InvalidLaneException ex) {
					    	showInvalidLaneMessage();
					    } catch (Exception ex) {
					        // Handle any other exception
					    	
					    }
			}
			public void w44(ActionEvent e)throws IOException,InsufficientResourcesException,InvalidLaneException{
				try{
					 if(battle.isGameOver())
						 showGameOverMessage(e);
					 else{
				      battle.purchaseWeapon(4, battle.getOriginalLanes().get(3));
				     
				      battle.getOriginalLanes().get(3).addWeapon(new WallTrap(100));
				        weaponimagelane4.add(weaponimagelane4.size());
				        ImageView WallTrapiv =new ImageView(wallTrapi);
				        gpp.add( WallTrapiv, weaponimagelane4.size()-1, 3);
				        Titan();
				        setFinalScore(battle.getScore());
				      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
				      uptadelabels();
					}}
					 catch (InsufficientResourcesException ex) {
						 showInsufficientResourcesMessage();
					    } catch (InvalidLaneException ex) {
					    	showInvalidLaneMessage();
					    } catch (Exception ex) {
					        // Handle any other exceptio
					    	
					    }
			}
			public void w55(ActionEvent e)throws IOException,InsufficientResourcesException,InvalidLaneException{
				try{
					 if(battle.isGameOver())
						 showGameOverMessage(e);
					 else{
				      battle.purchaseWeapon(4, battle.getOriginalLanes().get(4));
				     
				      battle.getOriginalLanes().get(4).addWeapon(new WallTrap(100));
				        weaponimagelane5.add(weaponimagelane5.size());
				        ImageView WallTrapiv =new ImageView(wallTrapi);
				        gpp.add( WallTrapiv, weaponimagelane5.size()-1, 4);
				        Titan();
				        setFinalScore(battle.getScore());
				      topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
				      uptadelabels();
					}}
					 catch (InsufficientResourcesException ex) {
						 showInsufficientResourcesMessage();
					    } catch (InvalidLaneException ex) {
					    	showInvalidLaneMessage();
					    } catch (Exception ex) {

					    	
					    }
			}
			
						
			public ImageView which(Titan t ){
				 ImageView iv =new ImageView(PureTitani);
				 switch(t.getDangerLevel()){
					case 1: iv=new ImageView(PureTitani);break;
					case 2: iv=new ImageView(AbnormalTitani);break;
					case 3: iv=new ImageView(ArmoredTitani);break;
					case 4  : iv=new ImageView(ColasslaTitani);break;
					}
				 return iv;
			}
			 public  void clearAllVBoxes(GridPane gridPane) {
			        gpp.getChildren().removeIf(node -> node instanceof VBox);
			    }
		
			
public void Titan(){
	clearAllVBoxes(gpp);
	 ImageView iv =new ImageView(PureTitani);
	for(Lane lane: battle.getOriginalLanes()){
		for(Titan titan : lane.getTitans()){
			if(lane==battle.getOriginalLanes().get(0)){
			
				  iv =which(titan);
				 VBox vb=new VBox ();
				 Label l= new Label("Health:" +titan.getCurrentHealth());
				 l.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");
				 vb.getChildren().addAll(l,iv); 
				gpp.add(vb, titan.getDistance(), 0);
			}
			else if(lane==battle.getOriginalLanes().get(1)){

				  iv =which(titan);
				 VBox vb=new VBox ();
				 Label l= new Label("Health:" +titan.getCurrentHealth());
				 l.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");				 vb.getChildren().addAll(l,iv); 
				gpp.add(vb, titan.getDistance(), 1);
				
			}
			else	if(lane==battle.getOriginalLanes().get(2)){

				  iv =which(titan);
				 VBox vb=new VBox ();
				 Label l= new Label("Health:" +titan.getCurrentHealth());
				 l.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");				 vb.getChildren().addAll(l,iv); 
				gpp.add(vb, titan.getDistance(), 2);
			}
			else if(lane==battle.getOriginalLanes().get(3)){

				  iv =which(titan);
				 VBox vb=new VBox ();
				 Label l= new Label("Health:" +titan.getCurrentHealth());
				 l.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");				 vb.getChildren().addAll(l,iv); 
				gpp.add(vb, titan.getDistance(), 3);
			}
			else if(lane==battle.getOriginalLanes().get(4)){

				  iv =which(titan);
				 VBox vb=new VBox ();
				 Label l= new Label("Health:" +titan.getCurrentHealth());
				 l.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");
				 vb.getChildren().addAll(l,iv); 
				gpp.add(vb, titan.getDistance(), 4);
			}
		}
	}
	
}

 
public void uptadelabels() {
  
	
	dangerlevel1text.setText("Danger Level:"+ battle.getOriginalLanes().get(0).getDangerLevel());
	dangerlevel2text.setText("Danger Level:"+ battle.getOriginalLanes().get(1).getDangerLevel());
	dangerlevel3text.setText("Danger Level:"+ battle.getOriginalLanes().get(2).getDangerLevel());
	dangerlevel4text.setText("Danger Level:"+ battle.getOriginalLanes().get(3).getDangerLevel());
	dangerlevel5text.setText("Danger Level:"+ battle.getOriginalLanes().get(4).getDangerLevel());

	Health1text.setText("Health:"+ battle.getOriginalLanes().get(0).getLaneWall().getCurrentHealth());
	
	Health2text.setText("Health:"+ battle.getOriginalLanes().get(1).getLaneWall().getCurrentHealth()); 
	Health3text.setText("Health:"+ battle.getOriginalLanes().get(2).getLaneWall().getCurrentHealth()); 
	Health4text.setText("Health:"+ battle.getOriginalLanes().get(3).getLaneWall().getCurrentHealth()); 
	Health5text.setText("Health:"+ battle.getOriginalLanes().get(4).getLaneWall().getCurrentHealth()); 
	if(Health1text.getText().equals("Health:0")) {
		ImageView iv=new ImageView(fire);
		a.getChildren().add(iv);
		iv.setLayoutX(38);
		iv.setLayoutY(96);
		dangerlevel1text.setText("Lane lost");
		clearVBoxesFromRow( gpp, 0);
		
		}
	if(Health2text.getText().equals("Health:0")) {dangerlevel2text.setText("Lane lost");
	ImageView iv=new ImageView(fire);
	a.getChildren().add(iv);
	iv.setLayoutX(38);
	iv.setLayoutY(216);
	clearVBoxesFromRow( gpp, 1);
	}
	if(Health3text.getText().equals("Health:0")){ dangerlevel3text.setText("Lane lost");
	ImageView iv=new ImageView(fire);
	a.getChildren().add(iv);
	iv.setLayoutX(38);
	iv.setLayoutY(338);
	clearVBoxesFromRow( gpp, 2);
	}
	if(Health4text.getText().equals("Health:0")) {dangerlevel4text.setText("Lane lost");
	ImageView iv=new ImageView(fire);
	a.getChildren().add(iv);
	iv.setLayoutX(38);
	iv.setLayoutY(443);	
	clearVBoxesFromRow( gpp, 3);
	}
	if(Health5text.getText().equals("Health:0")) {dangerlevel5text.setText("Lane lost");
	ImageView iv=new ImageView(fire);
	a.getChildren().add(iv);
	iv.setLayoutX(38);
	iv.setLayoutY(567);
	clearVBoxesFromRow( gpp, 4);
	}
	
	
}



 public void changetext(ActionEvent e) throws IOException
 {
	 if(battle.isGameOver()){
		 showGameOverMessage(e);
		 
	 }
	 else{
	 Titan();
	 uptadelabels();
	 battle.passTurn();
	 topTextArea.setText("Score: " +battle.getScore()+"       Current turn:"+battle.getNumberOfTurns()+"       Current Phase:"+battle.getBattlePhase()+"        Current Resources"+battle.getResourcesGathered()+"                   Current Lanes:"+battle.getLanes().size());
	setFinalScore(battle.getScore());
	 }
 }
 
 private void clearVBoxesFromRow(GridPane gridPane, int column) {
     gpp.getChildren().removeIf(node -> {
         Integer rowIndex = GridPane.getRowIndex(node);
         return rowIndex != null && rowIndex == column && node instanceof VBox;
     });
 }

 public static void main(String [] args){}

}

