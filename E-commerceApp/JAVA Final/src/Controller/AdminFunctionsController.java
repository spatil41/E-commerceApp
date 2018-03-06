package Controller;

import java.sql.Connection;
import java.sql.ResultSet;

import application.Main;
import dao.Connector;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AdminFunctionsController 
{
AnchorPane root;
	
	public void Add(ActionEvent event) throws Exception{
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/CreateProduct.fxml"));
			/*Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Add Products");*/
			
			
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Add Products");
		}
	
	public void Delete(ActionEvent event) throws Exception{
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/DeleteProduct.fxml"));
		/*Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Delete Products");*/
		
		
		Scene scene = new Scene(root);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Delete Products");
	}
	
	public void Update(ActionEvent event) throws Exception{
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/UpdateProduct.fxml"));
		/*Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Update Products");*/
		
		Scene scene = new Scene(root);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Update Products");
	}
		
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void ViewProduct(ActionEvent event) throws Exception {  
	    
	         @SuppressWarnings({ "rawtypes" })
	    	
	         //TABLE VIEW AND DATA

	    	TableView tableview = new TableView();
	    	ObservableList<ObservableList> data;
	
	    	//CONNECTION DATABASE
	    	  Connection c ;
	          data = FXCollections.observableArrayList();
	          try{
	            c = Connector.connect();
	            //SQL FOR SELECTING ALL OF CUSTOMER
	            String SQL = "SELECT * from product_NM";
	            //ResultSet
	            ResultSet rs = c.createStatement().executeQuery(SQL);

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
	               
	                tableview.getColumns().addAll(col); 
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
	            tableview.setItems(data);
	          }catch(Exception e){
	              e.printStackTrace();
	              System.out.println("Error on Building Data");             
	          }
	       
	        //Create Main Scene (pop up)
	        tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	        Scene scene = new Scene(tableview);        
	        Stage stage = new Stage();
	        stage.setWidth(600);
	        stage.setScene(scene);
	        stage.setTitle("Product List");
	        stage.show();
  }
	
	public void LogoutApp(ActionEvent event) throws Exception{
		AdminNavigation an = new AdminNavigation();
		an.Logout(event);
	}
	

}
