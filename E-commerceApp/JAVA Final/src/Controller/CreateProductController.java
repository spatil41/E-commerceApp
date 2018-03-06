
package Controller;
import dao.Connector;

import java.net.URL;
import java.util.ResourceBundle;

import dao.AddProductDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Product;




public class CreateProductController implements Initializable
{
	private static Product product;

	@FXML
	private TextField txtProdID;
	
	@FXML
	private TextField txtProdCategory;
	
	@FXML
	private TextField txtProdBrand;
	
	@FXML
	private TextField txtUnitPrice;
	
	@FXML
	private TextField txtQuantity;
	
	@FXML
	private Label lblStatus;
	
	@FXML
	public ComboBox<String> comboSite; 	
	
	@FXML
	public ComboBox<String> comboProductCategory; 	
	
	@FXML
	public ComboBox<String> comboProductBrand ; 	
	
	@FXML
	public ComboBox<String> comboSize; 	
	
	
	ObservableList<String> siteoptions = (ObservableList<String>) FXCollections.observableArrayList(
			"Amazon",
			"Flipkart"
			);
	ObservableList<String> ProductCategoryOptions = (ObservableList<String>) FXCollections.observableArrayList(
			"Jeans",
			"Trouser",
			"T-Shirt",
			"Accessories"
			);

	ObservableList<String> ProductBrandOptions = (ObservableList<String>) FXCollections.observableArrayList(
			"Nike",
			"GAP",
			"Levis",
			"ALDO"
			);

	ObservableList<String>SizeOptions = (ObservableList<String>) FXCollections.observableArrayList(
			"S",
			"M",
			"L",
			"XL"
			);

	
public void Submit() {
		
		
	Integer prodID = Integer.parseInt(txtProdID.getText());
		String prodCategory = comboProductCategory.getValue();
		String prodBrand = comboProductBrand.getValue();
		String site = comboSite.getValue();
		String size = comboSize.getValue();
		Double unitPrice = Double.parseDouble(txtUnitPrice.getText());
		Integer quantity= Integer.parseInt(txtQuantity.getText());
		
	   
		
	    if (prodID== null)
	    {
	    	lblStatus.setText("Product ID Cannot be empty.");
			return;
	    }
	      
		if(prodCategory == null)
		{
			lblStatus.setText("Product category Cannot be empty");
			return;
			
			}
		if(prodBrand == null) {
			lblStatus.setText("Product Brand cannot be empty.");
			return;
		}
		
		if(site == null) {
			lblStatus.setText("Product site cannot be empty or spaces");
			return;
		}
		
		if(unitPrice == null || unitPrice==0) {
			lblStatus.setText("Unit price can not be null or zero.");
			return;
		}
		if(quantity == null || quantity==0) {
			lblStatus.setText("Unit price can not be null or zero.");
			return;
		}
		//Create Product in database
		Product prod = new Product();
		prod.setProdID(prodID);
		prod.setProdCategory(prodCategory);
		prod.setProdBrand(prodBrand);
		//prod.setSite(site);
		prod.setSite(site);
		prod.setUnitPrice(unitPrice);
		prod.setQuantity(quantity);
		prod.setSize(size);
		
		try
		{
			//System.out.println("hELLO");
			AddProductDAO dao = new AddProductDAO();
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		comboSite.setItems(siteoptions);
		comboProductCategory.setItems(ProductCategoryOptions);
		comboProductBrand.setItems(ProductBrandOptions);
		comboSize.setItems(SizeOptions);
	}
	
	
}
