package controllers;

import java.net.URL;
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
 * DeleteClient Class
 * Deletes an item from the clients data table
 *
 * @author Luis Alvarez
 * @since 09/10/2016
 * @version 1.0
 *
 */
public class DeleteClient implements Initializable {

	@FXML public Button submitButton,cancelButton;
	@FXML public TextField nameField;
	@FXML public Label warningLabel;
	/**
	 * removeClients Method
	 * A query that is in charge of deleting rows from the clients data
	 * @param name
	 */
	public static void removeClients(String name){
		try{
			PreparedStatement statement = (PreparedStatement) Main.con.prepareStatement("DELETE FROM clients WHERE name =?");

			statement.setString(1,name);


			statement.executeUpdate();
			statement.close();

			Main.con.close();


		}catch(Exception e){
			System.out.print("Error" + e);
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	/**
	 * submitButtonPressed Method
	 * Closes the window and removes the Item from the clients table
	 * @param e
	 */
	@FXML
	public void submitButtonPressed(ActionEvent e){
		try{
			
			for(int i = 0; i < Main.clients.size();i+=3){
				if(!Main.clients.get(i).equals(nameField.getText())){
					warningLabel.setText("Please input a valid name");
				}else{
					Stage stage = (Stage) cancelButton.getScene().getWindow();
					removeClients(nameField.getText());
					stage.close();
				}
			}
		
		}catch(Exception ep){

		}

	}
	/**
	 * cancelButtonPressed Method
	 * Closes the current stage
	 * @param e
	 */
	@FXML
	public void cancelButtonPressed(ActionEvent e){
		try{
			Stage stage = (Stage) cancelButton.getScene().getWindow();
			stage.close();
		}catch(Exception ep){

		}

	}

}
