package Controller;


import application.Main;
import dao.AdminLoginDAO;
import dao.CustomerLoginDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Admin;
import model.Customer;

public class CustomerLoginController {
	
	public static Customer customer;
	@FXML
	private TextField txtUserName;
	
	@FXML
	private TextField txtPassword;
	
	@FXML
	private Label lblStatus;
	
	
	
	@FXML
public void Login(){
		
		Customer c;
		String username = txtUserName.getText();
		String password = txtPassword.getText();
		
		//Validations
		if(username == null || username.trim().equals("")) {
					lblStatus.setText("Username Cannot be empty or spaces");
					return;
		}
		if(password == null || password.trim().equals("")) {
					lblStatus.setText("Password Cannot be empty or spaces");
					return;
		}
		
		//Get user
		CustomerLoginDAO cdao = new CustomerLoginDAO();
		 c = cdao.findCustomerByName(username);
		cdao.close();
		//If user not found
		if(c == null) {
			lblStatus.setText("Username cannot be found");
			return;
		}
		//If passwords dont match
		if(!(c.getPassword().equals(password.trim()))) {
			lblStatus.setText("Username and Password dont match");
			return;
		}
		
		//Set user as Logged in user
		customer = c;
		
		
		try{
		AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/Shopping.fxml"));
		
		Scene scene = new Scene(root);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Shopping");
		
		/*Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Admin Functions");*/
		
		
		}catch(Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
	
	@FXML
	public void Register(ActionEvent event) throws Exception{
		AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/CustomerRegistration.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Customer Login");
			
	}
	
	
	
}
