package Controller;

import dao.AddProductDAO;
import dao.UpdateProductDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Product;

public class UpdateProductController {
	
	public static Product product;
	
	@FXML
	private TextField txtProdID;
	
	@FXML
	private TextField txtUnitPrice;
	
	@FXML
	private TextField txtQuantity;
	
	@FXML
	private Label lblStatus;
	
	public void Submit() {
		
		
		Integer prodID = Integer.parseInt(txtProdID.getText());
		Double unitPrice = Double.parseDouble(txtUnitPrice.getText());
		Integer quantity= Integer.parseInt(txtQuantity.getText());
		
		
		Product prod = new Product();
		prod.setProdID(prodID);
		prod.setUnitPrice(unitPrice);
		prod.setQuantity(quantity);
		
		try
		{
			//System.out.println("hELLO");
			UpdateProductDAO dao = new UpdateProductDAO();
			dao.UpdateProduct(prod);
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
