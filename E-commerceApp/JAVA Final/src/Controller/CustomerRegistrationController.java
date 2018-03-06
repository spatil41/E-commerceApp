package Controller;


import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import dao.CustomerRegistrationDAO;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;

public class CustomerRegistrationController extends CustomerRegistrationDAO
{
	private static Customer customer;
	@FXML
	private TextField txtFirstName;
	
	@FXML
	private TextField txtLastName;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private TextField txtPassword;
	
	@FXML
	private TextField txtConfirmPass;
	
	@FXML
	private DatePicker txtDOB= new DatePicker();
	
	@FXML
	private TextField txtUserName;
	
	
	@FXML
	private Label lblStatus;
	

	
	
	public void Submit(){
		boolean user1 = false;
		
		
		
		String firstname = txtFirstName.getText();
		String lastname = txtLastName.getText();
		String email = txtEmail.getText();
		String password = txtPassword.getText();
		String confirmpass = txtConfirmPass.getText();
		TextField date= txtDOB.getEditor();
		String username= txtUserName.getText();
	   
//		user = CheckUsernameExists(username);
		java.sql.Date dob = java.sql.Date.valueOf(txtDOB.getValue());	 
		
		
		//String query = "SELECT FirstName FROM customerRegistration_nm1 WHERE FirstName= '"+customer.firstname+"';";
		if(firstname == null || firstname.trim().equals("")) {
			lblStatus.setText("First Name Cannot be empty or spaces");
			return;
			
			}
		if(lastname == null || lastname.trim().equals("")) {
			lblStatus.setText("Last Name Cannot be empty or spaces");
			return;
		}
		
		if(password == null || password.trim().equals("")) {
			lblStatus.setText("Password Cannot be empty or spaces");
			return;
		}
		
		if(confirmpass!= null && !confirmpass.equals(password)) {
			lblStatus.setText("Password & confirm password must be same");
			return;
		}
		user1 = CheckUsernameExists(username);
		if(user1 == true){
			lblStatus.setText("UserName alrteady exists");
			//return;
		}
		//Create customer in database
		Customer cust = new Customer();
		cust.setFirstName(firstname);
		cust.setLastName(lastname);
		cust.setEmail(email);
		cust.setPassword(password);
		cust.setConfirmPass(confirmpass);
		cust.setDOB(dob);
		cust.setUserName(username);

		try(CustomerRegistrationDAO dao = new CustomerRegistrationDAO()) {
			dao.create(cust);
		
		AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/CustomerLogin.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Customer Login");
		}
		catch(Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
	
}
