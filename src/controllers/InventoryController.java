package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.Tables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * InventoryController Class
 * In charge of displaying the inventory information in a table,
 * you can add, edit and delete elements.
 *
 * @author Luis Alvarez
 * @since 09/10/2016
 * @version 1.0
 *
 */
public class InventoryController implements Initializable {
	@FXML private Button addButton,editButton,deleteButton,backButton,logoutButton,refreshButton;

	@FXML public TableView<Tables> dataTable;
	@FXML public TableColumn<Tables, String> firstNameCol,lastNameCol,numberCol;
	@FXML private TextField nameField,newNameField, priceField,quantityField;
	@FXML private Label editLabel;

	public Stage stage1 = new Stage();
	private ObservableList<Tables> data = FXCollections.observableArrayList();



	/**
	 * backButtonPressed Method
	 * Takes you back to the main menu
	 * @param e
	 */
	@FXML
	public void backButtonPressed(ActionEvent e)
	{
		try{
			application.Main.mainStage.setScene(application.Main.scene2);
		}catch(Exception ep){

		}

	}
	/**
	 * logoutButtonPressed Method
	 * Takes you back to the login screen
	 * @param e
	 */
	@FXML
	public void logoutButtonPressed(ActionEvent e)
	{
		try{
			application.Main.mainStage.setScene(application.Main.scene1);
		}catch(Exception ep){

		}

	}
	/**
	 * refreshButtonPressed Method
	 * In charge of refreshing the inventoryTable
	 * @param e
	 */
	@FXML
	public void refreshButtonPressed(ActionEvent e)
	{
		try{
			DbConnect connect = new DbConnect();

			Main.inventory= connect.getDataInventory();
			data.clear();
			firstNameCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("firstName"));
			lastNameCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("lastName"));
			numberCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("idNumber"));
			dataTable.setEditable(true);
			for(int i = 0; i < Main.inventory.size();i+=3){

				data.add(new Tables(Main.inventory.get(i),Main.inventory.get(i+1),Main.inventory.get(i+2)));
			}
			dataTable.setItems(data);
		}catch(Exception ep){

		}

	}
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// TODO Auto-generated method stub
		try{
			DbConnect connect = new DbConnect();

			Main.inventory= connect.getDataInventory();
			data.clear();
			firstNameCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("firstName"));
			lastNameCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("lastName"));
			numberCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("idNumber"));
			dataTable.setEditable(true);
			for(int i = 0; i < Main.inventory.size();i+=3)
			{
				data.add(new Tables(Main.inventory.get(i),Main.inventory.get(i+1),Main.inventory.get(i+2)));
			}
			dataTable.setItems(data);
		}catch(Exception ep){

		}

	}
	/**
	 * addButtonPressed Method
	 *
	 * A pop out appears, so you can add elements
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void addButtonPressed(ActionEvent e) throws IOException{

		try{
			Parent root1 = FXMLLoader.load(getClass().getResource("/application/AddItem.fxml"));
			Scene scene10 = new Scene(root1);
			stage1.setScene(scene10);
			stage1.setResizable(false);
			stage1.show();
		}catch(Exception ep){

		}

	}
	/**
	 * editButtonPressed Method
	 *
	 * A pop out appears, so you can edit elements
	 * @param e
	 */
	@FXML
	public void editButtonPressed(ActionEvent e){
		try
		{
			String value0 = nameField.getText();
			String value1 = newNameField.getText();
			String value2 = priceField.getText();
			String value3 = quantityField.getText();
			if(value0.equals("")){
				editLabel.setText("Please input the name you desire to edit.");
			}else if(value1.equals("")){
				editLabel.setText("Please input a new name.");
			}else if(value2.equals("")){
				editLabel.setText("Please input a new price.");
			}else if(value3.equals("")){
				editLabel.setText("Please input a new quantity.");
			}else{
				String sql="update inventory set name='"+value1+"',price='"+value2+"',quantity='"+value3+"'where  name='"+value0+"' ";
				java.sql.PreparedStatement st = Main.con.prepareStatement(sql);
				st.execute();
				editLabel.setText(" ");
				nameField.setText("");
				newNameField.setText("");
				priceField.setText("");
				quantityField.setText("");
			}

			System.out.println("working");
		}catch(Exception ep){

		}
	}
	/**
	 * deleteButtonPressed Method
	 *
	 * A pop out appears, so you can delete elements
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void deleteButtonPressed(ActionEvent e) throws IOException{
		try{
			Parent root2 = FXMLLoader.load(getClass().getResource("/application/DeleteItem.fxml"));
			Scene scene11= new Scene(root2);
			stage1.setScene(scene11);
			stage1.setResizable(false);
			stage1.show();

		}catch(Exception ep){

		}

	}
}
