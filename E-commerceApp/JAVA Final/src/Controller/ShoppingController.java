package Controller;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import Connection.DBConnect;
import application.Main;
import dao.Connector;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ShoppingController implements Initializable
{

	
	@FXML
	private CheckBox PC1;
	
	@FXML
	private CheckBox PC2;
	
	@FXML
	private CheckBox PC3;
	
	@FXML
	private CheckBox PC4;
	
	@FXML
	private CheckBox BN1;
	
	@FXML
	private CheckBox BN2;
	
	@FXML
	private CheckBox BN3;
	
	@FXML
	private CheckBox BN4;
	
	@FXML
	private CheckBox S1;
	
	@FXML
	private CheckBox S2;
	
	@FXML
	private CheckBox S3;
	
	@FXML
	private CheckBox S4;
	
	@FXML
	private TableView productview = new TableView() ;
	
	//private ComboBox ProductCategory;
	
	ObservableList<String> options = (ObservableList<String>) FXCollections.observableArrayList(
			"Jeans",
			"Trouser",
			"Accessories",
			"T-shirt"
			
			);
	@FXML
	public ComboBox<String> ProductCategory;
	
	//ProductCategory.setItem(options);
	 ObservableList<String> row = FXCollections.observableArrayList();
	String	message4="";
	String	message5="";
	String	message6="";
	String	message7="";
	String	message8="";
	String message="";
	String message9="";
	String message10="";
	String message11="";
public void checkEvent (ActionEvent event)
{
	int count=0;
	message= ProductCategory.getValue();
	
	
	//brand name
	if(BN1.isSelected())
	{
		
		message4= BN1.getText();
	}
	
	if(BN2.isSelected())
	{
		
		message5= BN2.getText();
	}
	
	if(BN3.isSelected())
	{
		
		message6= BN3.getText();
	}
	
	if(BN4.isSelected())
	{
		
		message7= BN4.getText();
	}
	
	if(S1.isSelected())
	{
		
		message8 = S1.getText();
	}
	if(S2.isSelected())
	{
		
		message9 = S2.getText();
	}
	if(S3.isSelected())
	{
		
		message10 = S3.getText();
	}
	if(S4.isSelected())
	{
		
		message11 = S4.getText();
	}
	
}



@SuppressWarnings("rawtypes")
private ObservableList<ObservableList> data;


@SuppressWarnings({ "rawtypes", "unchecked", "unused", "static-access" })
public void loadTable(ActionEvent event) throws Exception{


    @SuppressWarnings({ "rawtypes" })
	
    //TABLE VIEW AND DATA

	ObservableList<ObservableList> data;

	//CONNECTION DATABASE
	  Connection c ;
     data = FXCollections.observableArrayList();
     try{
       c = DBConnect.connect();
       
       //ResultSet
       ResultSet rs = OK();

       /**********************************
        * TABLE COLUMN ADDED DYNAMICALLY *
        **********************************/
       for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
           //We are using non property style for making dynamic table
           final int j = i;                
           TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
           col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
               public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                   return new SimpleStringProperty(param.getValue().get(j).toString());                        
               }                    
           });
          
           productview.getColumns().addAll(col); 
           System.out.println("Column ["+i+"] ");
       }

       /********************************
        * DATA ADDED TO OBSERVABLELIST*
        ********************************/
       while(rs.next()){
           //Iterate Row
           ObservableList<String> row = FXCollections.observableArrayList();
           for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
               //Iterate Column
               row.add(rs.getString(i));
           }
           System.out.println("Row [1] added "+row );
           data.add(row);
       }

       //FINALLY ADD TO TableView
       productview.setItems(data);
     }catch(Exception e){
         e.printStackTrace();
         System.out.println("Error on Building Data");             
     }
  
   //Create Main Scene (pop up)
  /* productReview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
   Scene scene = new Scene(productReview);        
   Stage stage = new Stage();
   stage.setWidth(500);
   stage.setScene(scene);
   stage.show();*/
}




public ResultSet OK()
{	
@SuppressWarnings({ "rawtypes" })

	//CONNECTION DATABASE
	  Connection c ;
      ResultSet rs = null;
     
     try{
       c = Connector.connect();
       //SQL FOR SELECTING ALL OF PRODUCTS
       String SQLFinal = "";
       String SQL3="SELECT * from product_NM WHERE productCatagory='"+message+"';";
       String SQL  = "SELECT * from product_NM WHERE productCatagory='"+message+"' AND ";
       String SQL2="";
       String SQL4="  ";
       SQL2+= "productBrand IN ('"+message4+"','"+message5+"','"+message6+"','"+message7+"')";
       
    
    if (message4=="" && message5== "" && message6== "" && message7=="")
      {
    	   
    	   rs = c.createStatement().executeQuery(SQL3);
    	   
    }
      
      
       else if (message8=="" && message9=="" && message10=="" && message11=="")
    	   
    	   {	    
    	   		SQLFinal =SQL+ SQL2;
    	   		System.out.println(SQLFinal);   
    	   		rs = c.createStatement().executeQuery(SQLFinal);
    	   }
       
    	   else
    	   {
    		   SQL4+=" AND size IN ('"+message8+"','"+message9+"','"+message10+"','"+message11+"')";
    		   SQLFinal= SQL+SQL2+SQL4;
    		   System.out.println(SQLFinal);   
    		   rs = c.createStatement().executeQuery(SQLFinal);
    	   }
       System.out.println(SQL3);
       System.out.println(SQLFinal);   
     }  
     catch(Exception e)
     {
    	 e.printStackTrace();
     }
     return rs;
}
 

	public void LogoutApp(ActionEvent event) throws Exception{
		AdminNavigation an = new AdminNavigation();
		an.Logout(event);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// TODO Auto-generated method stub
		ProductCategory.setItems(options);
		
	}

}
