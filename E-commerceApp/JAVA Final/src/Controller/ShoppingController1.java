package Controller;

import java.sql.Connection;
import java.sql.ResultSet;

import Connection.DBConnect;
import application.Main;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;


public class ShoppingController1 {

	
	
    //TABLE VIEW AND DATA
    private ObservableList<ObservableList> data;
    
   @FXML
    private TableView tableview;

    //MAIN EXECUTOR
    public void OKPress(){
    	try{
    		AnchorPane root;
    		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/View/CustomerTableView.fxml"));
    		
    		Scene scene = new Scene(root);
    		Main.stage.setScene(scene);
    		Main.stage.setTitle("Admin Functions");
    		buildData();
    		}catch(Exception e) {
    			System.out.println("Error occured while inflating view: " + e);
    		}
    }

    //CONNECTION DATABASE
    public void buildData(){
          Connection c ;
          data = FXCollections.observableArrayList();
          try{
            c = DBConnect.connect();
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
             * Data added to ObservableList *
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

            //FINALLY ADDED TO TableView
           tableview.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }


    /*  @Override
      public void start(Stage stage) throws Exception {
        //TableView
        tableview = new TableView();
        buildData();

        //Main Scene
        Scene scene = new Scene(tableview);        

        stage.setScene(scene);
        stage.show();
      }*/
}
