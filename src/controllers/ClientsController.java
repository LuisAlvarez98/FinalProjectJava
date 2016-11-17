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

public class ClientsController implements Initializable {
	@FXML private Button addButton,deleteButton,editButton,backButton,logoutButton,refreshButton;


	@FXML private TableView<Tables> dataTable;
	@FXML private TableColumn<Tables, String> firstNameCol,lastNameCol,numberCol;

	public Stage stage1,stage2 = new Stage();

		private ObservableList<Tables> data = FXCollections.observableArrayList();
		ArrayList<String> clients =  new ArrayList<String>();


	@FXML
	public void backButtonPressed(ActionEvent e)
	{
		application.Main.mainStage.setScene(application.Main.scene2);
	}
	@FXML
	public void logoutButtonPressed(ActionEvent e)
	{
		application.Main.mainStage.setScene(application.Main.scene1);
	}
	@FXML
	public void refreshButtonPressed(ActionEvent e)
	{
		DbConnect connect = new DbConnect();

		Main.clients= connect.getDataClients();
		data.clear();
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("lastName"));
		numberCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("idNumber"));
		dataTable.setEditable(true);
		for(int i = 0; i < Main.clients.size();i+=3){

			data.add(new Tables(Main.clients.get(i),Main.clients.get(i+1),Main.clients.get(i+2)));



		}
		dataTable.setItems(data);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		// TODO Auto-generated method stub
		DbConnect connect = new DbConnect();

		Main.clients= connect.getDataClients();
		data.clear();
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("lastName"));
		numberCol.setCellValueFactory(new PropertyValueFactory<Tables, String>("idNumber"));
		dataTable.setEditable(true);
		for(int i = 0; i < Main.clients.size();i+=3)
		{
			data.add(new Tables(Main.clients.get(i),Main.clients.get(i+1),Main.clients.get(i+2)));
		}
		dataTable.setItems(data);
	}
	@FXML
	public void addButtonPressed(ActionEvent e) throws IOException{
			System.out.println("yay");
			Parent root1 = FXMLLoader.load(getClass().getResource("/application/AddGUI.fxml"));
			Scene scene4 = new Scene(root1);
			stage1.setScene(scene4);
			stage1.show();
	}
	@FXML
	public void deleteButtonPressed(ActionEvent e)throws IOException{
		Parent root2= FXMLLoader.load(getClass().getResource("/application/DeleteClient.fxml"));
		Scene scene9 = new Scene(root2);
		stage1.setScene(scene9);
		stage1.show();
		System.out.println("Holas");
	}


}
