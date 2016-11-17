package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteClient implements Initializable {

	@FXML public Button submitButton,cancelButton;
	@FXML public TextField nameField;

	public static void removeClients(String name){
		try{
			PreparedStatement statement = (PreparedStatement) Main.con.prepareStatement("DELETE FROM clients WHERE name =?");

			statement.setString(1,name);


			statement.executeUpdate();
			statement.close();

			Main.con.close();

			System.out.println("works");
		}catch(Exception e){
			System.out.print("Error" + e);
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	@FXML
	public void submitButtonPressed(ActionEvent e){
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		removeClients(nameField.getText());
		stage.close();
	}
	@FXML
	public void cancelButtonPressed(ActionEvent e){
		Stage stage = (Stage) cancelButton.getScene().getWindow();

		stage.close();
	}

}
