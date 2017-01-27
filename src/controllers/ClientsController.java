package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

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
 * ClientsController Class
 * In charge of showing the Clients information in a table,
 * you can add, edit and delete elements.
 *
 * @author Luis Alvarez
 * @since 09/10/2016
 * @version 1.0
 *
 */
public class ClientsController implements Initializable {
	@FXML private Button addButton;
	@FXML private Button deleteButton;
	@FXML private Button editButton;
	@FXML private Button backButton;
	@FXML private Button logoutButton;
	@FXML private TextField nameField,emailField,phoneField,newNameField;
	@FXML private Label editLabel;

	@FXML private Button refreshButton;
	@FXML private TableView<Tables> dataTable;
	@FXML private TableColumn<Tables, String> firstNameCol;
	@FXML private TableColumn<Tables, String> lastNameCol;
	@FXML private TableColumn<Tables, String> numberCol;


	public Stage stage1 = new Stage();
	public Stage stage2 = new Stage();
		private ObservableList<Tables> data = FXCollections.observableArrayList();
		ArrayList<String> clients =  new ArrayList<String>();


	/**
	 * backButtonPressed Method
	 * Takes you to the Main Menu
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
	 * Takes you to the login screen
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
	 * In charge of refreshing the table with the new data
	 * @param e
	 */
	@FXML
	public void refreshButtonPressed(ActionEvent e)
	{
		try{
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
		}catch(Exception ep){

		}


	}
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		try{
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
		}catch(Exception ep){

		}

	}
	/**
	 * addButtonPressed Method
	 * In charge of opening the pop up of AddController
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void addButtonPressed(ActionEvent e) throws IOException{
		try{
			System.out.println("yay");
			Parent root1 = FXMLLoader.load(getClass().getResource("/application/AddGUI.fxml"));
			Scene scene4 = new Scene(root1);
			stage1.setScene(scene4);
			stage1.setResizable(false);
			stage1.show();

		}catch(Exception ep){

		}

	}
	/**
	 * deleteButtonPressed Method
	 * In charge of opening the pop up of DeleteClient
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void deleteButtonPressed(ActionEvent e)throws IOException{
		try{
			Parent root2= FXMLLoader.load(getClass().getResource("/application/DeleteClient.fxml"));
			Scene scene9 = new Scene(root2);
			stage1.setScene(scene9);
			stage1.setResizable(false);
			stage1.show();

		}catch(Exception ep){

		}


	}
<<<<<<< HEAD
	public static boolean integerChecker(String s){
		try{
			Long.parseLong(s);
			return true;
		}catch(NumberFormatException nfe){
			return false;
		}
	}
=======
>>>>>>> 2ffc0bc3625ccaf9526849742f546de3e0f73bc0
	/**
	 * editButtonPressed Method
	 * In charge of editing the values of the clients table
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void editButtonPressed(ActionEvent e) throws IOException{
		try
		{
			String value0 = nameField.getText();
			String value1 = newNameField.getText();
			String value2 = emailField.getText();
			String value3 = phoneField.getText();
			for(int i = 0; i < Main.clients.size();i+=3){
<<<<<<< HEAD
				if(!Main.clients.get(i).equals(value0)){
				editLabel.setText("Please input a valid name.");
=======
				if(!value0.equals(Main.clients.get(i))){
					editLabel.setText("Please input a valid name.");
>>>>>>> 2ffc0bc3625ccaf9526849742f546de3e0f73bc0
				}else if(value1.equals("")){
					editLabel.setText("Please input a new name.");
			}else if(value2.equals("")){
				editLabel.setText("Please input a new email.");
<<<<<<< HEAD
			}else if(integerChecker(value3) == false){
=======
			}else if(value3.equals("")){
>>>>>>> 2ffc0bc3625ccaf9526849742f546de3e0f73bc0
				editLabel.setText("Please input a new phone.");
			}else{
				String sql="update clients set name='"+value1+"',email='"+value2+"',phone='"+value3+"'where  name='"+value0+"' ";
				java.sql.PreparedStatement st = Main.con.prepareStatement(sql);
				st.execute();
				editLabel.setText(" ");
				nameField.setText("");
				newNameField.setText("");
				emailField.setText("");
				phoneField.setText("");
			}
		}
		
		}catch(Exception ep){

		}


	}


}
