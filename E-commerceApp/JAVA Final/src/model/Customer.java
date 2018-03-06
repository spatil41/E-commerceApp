
package model;



	import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;


	public class Customer {

		private Integer id;
		

		private String FirstName;
		private String LastName;
		private String password;
		private String confirmPass;
		private Date DOB;
		private String UserName;
		
		

		public String getUserName() {
			return UserName;
		}


		public void setUserName(String userName) {
			UserName = userName;
		}


		public Date getDOB() {
			return DOB;
		}
		

		public void setDOB(Date dOB) {
			DOB = dOB;
		}

		private String email;
		//private ArrayList<Account> accounts;
		
		public Customer() {
			//Empty Default constructor
		}
		
		public Customer(Integer id, String FirstName, String LastName, String email , String password, String confirmPass, Date DOB, String UserName) {
			//super( username, password);
			this.id= id;
			this.FirstName = FirstName;
			this.LastName = LastName;
			this.email= email;
			this.password= password;
			this.confirmPass= confirmPass;
			this.DOB= DOB;
			this.UserName= UserName;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		public String getFirstName() {
			return FirstName;
		}

		public void setFirstName(String firstName) {
			FirstName = firstName;
		}

		public String getLastName() {
			return LastName;
		}

		public void setLastName(String lastName) {
			LastName = lastName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmPass() {
			return confirmPass;
		}

		public void setConfirmPass(String confirmPass) {
			this.confirmPass = confirmPass;
		}

		

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		
		
		
	}
