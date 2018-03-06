package Controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AdminNavigation {
	
	AnchorPane root;
	public void Home(ActionEvent event) throws Exception{
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/AdminFunctions.fxml"));
		/*Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();*/
		
		
		
		Scene scene = new Scene(root);
		Main.stage.setScene(scene);
	}
	
	public void Logout(ActionEvent event) throws Exception{
		System.exit(0);
	}
}
