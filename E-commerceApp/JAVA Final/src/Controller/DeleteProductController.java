package Controller;

import Controller.AdminNavigation;
import dao.AddProductDAO;
import dao.DeleteProductDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Product;

public class DeleteProductController
{

	private static Product product;

	@FXML
	private TextField txtProdID;
	
	public void Submit() {
		
		
		Integer prodID = Integer.parseInt(txtProdID.getText());
		Product prod = new Product();
		prod.setProdID(prodID);
		
		
		try
		{
			//System.out.println("hELLO");
			DeleteProductDAO dao = new DeleteProductDAO();
			dao.createProduct(prod);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//connection.close();
	}
	
	public void BackToHome(ActionEvent event) throws Exception{
		AdminNavigation an = new AdminNavigation();
		an.Home(event);
		
	}
}