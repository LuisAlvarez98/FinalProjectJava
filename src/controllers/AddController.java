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

			Main.con.close();

		}catch(Exception e){
			System.out.print("Error" + e);
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

			boolean flag = false;
			for(int i = 0 ; i < Main.clients.size();i++)
			{
				warningLabel.setText("Please input another name");
				if(Main.clients.get(i).equals(nameField.getText()))
				{
					addClients(nameField.getText(),Main.clients.get(i+=2),Main.clients.get(i+=3));
					flag = true;
				}
			}
		if(!flag)
		{
			addClients(nameField.getText(),emailField.getText(),phoneField.getText());
			warningLabel.setText("");
			stage.close();
		}
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
