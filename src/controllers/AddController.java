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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController implements Initializable {


	@FXML private Button submitButton,cancelButton;

	@FXML private TextField nameField,emailField,phoneField;

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

			System.out.println("works");
		}catch(Exception e){
			System.out.print("Error" + e);
		}
	}

	@FXML
	public void submitButtonPressed(ActionEvent e)
	{
		try{
			Stage stage = (Stage) cancelButton.getScene().getWindow();

			addClients(nameField.getText(),emailField.getText(),phoneField.getText());
			stage.close();
		}catch(Exception ep){

		}

	}
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
		// TODO Auto-generated method stub

	}

}
