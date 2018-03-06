package Controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InformationController 
{
	
	AnchorPane root;
	
	
	public void LoginAdmin(ActionEvent event) throws Exception{		
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/AdminLogin.fxml"));
			
			/*Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Admin Login");*/
			
			
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Admin Login");
			
			
			
		}
	
		
	public void LoginCustomer(ActionEvent event) throws Exception{
		
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/CustomerLogin.fxml"));
		/*Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Customer Login");*/
		
		Scene scene = new Scene(root);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Customer Login");
		
	}
	


}
