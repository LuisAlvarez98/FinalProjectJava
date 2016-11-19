package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


import application.Tables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * SalesController Class
 * This class shows the sales information in a Table
 *
 * @author Luis Alvarez
 * @since 09/10/2016
 * @version 1.0
 *
 */
public class SalesController implements Initializable {
	@FXML private Button addButton,editButton,backButton,logoutButton,refreshButton;

	@FXML private TableView<Tables> dataTable;
	@FXML private TableColumn<Tables, String> firstNameCol,lastNameCol,numberCol;

	private ObservableList<Tables> data = FXCollections.observableArrayList();
	ArrayList<String> array =  new ArrayList<String>();


	/**
	 * backButtonPressed Method
	 * Takes you back to the main menu
	 *
	 * @param e
	 */
	@FXML
	public void backButtonPressed(ActionEvent e)
	{
		application.Main.mainStage.setScene(application.Main.scene2);
	}
	/**
	 * logoutButtonPressed Method
	 * Takes you back to the log in screen
	 * @param e
	 */
	@FXML
	public void logoutButtonPressed(ActionEvent e)
	{
		application.Main.mainStage.setScene(application.Main.scene1);
	}
	/**
	 * refreshButtonPressed Method
	 * is in charge of filling up the table again, kinds of refresh it
	 * @param e
	 */
	@FXML
	public void refreshButtonPressed(ActionEvent e)
	{
		DbConnect connect = new DbConnect();

		array= connect.getDataSales();
		data.clear();
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("lastName"));
		numberCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("idNumber"));

		dataTable.setEditable(true);
		for(int i = 0; i < array.size();i+=3)
		{
			data.add(new Tables(array.get(i),array.get(i+1),array.get(i+2)));
		}
		dataTable.setItems(data);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// TODO Auto-generated method stub
		DbConnect connect = new DbConnect();

		array= connect.getDataSales();
		data.clear();
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("lastName"));
		numberCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("idNumber"));
		dataTable.setEditable(true);
		for(int i = 0; i < array.size();i+=3)
		{
			data.add(new Tables(array.get(i),array.get(i+1),array.get(i+2)));
		}
		dataTable.setItems(data);
	}

}
