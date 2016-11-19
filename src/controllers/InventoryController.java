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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

	@FXML private TableView<Tables> dataTable;
	@FXML private TableColumn<Tables, String> firstNameCol,lastNameCol,numberCol;

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
			stage1.show();

		}catch(Exception ep){

		}

	}
}
