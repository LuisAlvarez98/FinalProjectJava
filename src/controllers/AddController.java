package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * AddController Class, In charge of adding 
 * clients to the database => Tables
 * 
 * @author Luis Alvarez
 * @since 09/10/2016
 * @version 1.0
 */
public class AddController implements Initializable {


	@FXML private Button submitButton,cancelButton;
	@FXML private TextField nameField,emailField,phoneField;
	@FXML private Label warningLabel;

	/**
	 * addClients Method
	 * A query in charge of creating a connection and adding elements to the clients table
	 * 
	 * 
	 * @param name
	 * @param email
	 * @param phone
	 */
	public static void addClients(String name, String email, String phone)
	{
		try{
			PreparedStatement statement = (PreparedStatement) Main.con.prepareStatement("INSERT INTO clients(name,email,phone) VALUES(?,?,?)");

			statement.setString(1, name);
			statement.setString(2,email);
			statement.setString(3,phone);
			statement.executeUpdate();
			statement.close();

			//Main.con.close();

		}catch(Exception e){
			System.out.print("Error" + e);
		}
	}
	/**
	 * integerChecker Method
	 * 
	 * Checks if the string is an integer or a string
	 * if it is an integer it will return true,
	 * if it is an string it will return false.
	 * @param s
	 * @return boolean
	 */
	public static boolean integerChecker(String s){
		try{
			Long.parseLong(s);
			return true;
		}catch(NumberFormatException nfe){
			return false;
		}
	}
	/**
	 * submitButtonPressed Method
	 * When you hit the submit button, you add the desired client element to the table,
	 * checks if client already exists.
	 * @param e
	 */
	@FXML
	public void submitButtonPressed(ActionEvent e)
	{
		try{

			Stage stage = (Stage) cancelButton.getScene().getWindow();

			for(int i = 0 ; i < Main.clients.size();i+=3)
			{
				if(nameField.getText().equals(Main.clients.get(i))){
					warningLabel.setText("Please input a valid name");
					return;
				}else if(nameField.getText().equals("")){
					warningLabel.setText("Please input a name");
					return;
				}else if(emailField.getText().equals("")){
					warningLabel.setText("Please input a email");
					return;
				}else if(integerChecker(phoneField.getText()) == false){
					warningLabel.setText("Please input a phone");
					return;
				}
			}
			addClients(nameField.getText(),emailField.getText(),phoneField.getText());
			warningLabel.setText("");
				stage.close();	

		}catch(Exception ep){

		}

	}
	/**
	 * cancelButtonPressed Method
	 * In charge of closing the current stage.
	 * @param e
	 */
	public void cancelButtonPressed(ActionEvent e)
	{
		try{
			Stage stage = (Stage) cancelButton.getScene().getWindow();

			stage.close();
		}catch(Exception ep){

		}

	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {


	}

}
