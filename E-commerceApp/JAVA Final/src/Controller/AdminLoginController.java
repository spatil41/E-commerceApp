package Controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import application.Main;
import dao.AdminLoginDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Admin;

public class AdminLoginController 
{
	private static Admin admin;
	
	@FXML
	private TextField txtAdminUserName;
	
	@FXML
	private TextField txtAdminPassword;
	
	@FXML
	private Label lblAdminStatus;
	
	
	
	@FXML
	public void Login(){
		
		Admin a;
		String username = txtAdminUserName.getText();
		String password = txtAdminPassword.getText();
		
		//Validations
		if(username == null || username.trim().equals("")) {
					lblAdminStatus.setText("Username Cannot be empty or spaces");
					return;
		}
		if(password == null || password.trim().equals("")) {
					lblAdminStatus.setText("Password Cannot be empty or spaces");
					return;
		}
		
		//Get user
		AdminLoginDAO adao = new AdminLoginDAO();
		a = adao.findAdminByUserName(username);
		adao.close();
		//If user not found
		if(a == null) {
			lblAdminStatus.setText("Username cannot be found");
			return;
		}
		//If passwords dont match
		if(!(a.getPassword().equals(password.trim()))) {
			lblAdminStatus.setText("Username and Password dont match");
			return;
		}
		
		//Set user as Logged in user
		admin = a;
		
		
		try{
		AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/AdminFunctions.fxml"));
		
		Scene scene = new Scene(root);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Admin Functions");
		
		/*Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Admin Functions");*/
		
		
		}catch(Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}

}


