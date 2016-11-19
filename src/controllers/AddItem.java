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

/**
 * @author Luis Avarez
 *
 */
public class AddItem implements Initializable {


	@FXML private Button submitButton,cancelButton;
	@FXML private TextField nameField,priceField,quantityField;
	/**
	 * @param name
	 * @param price
	 * @param quantity
	 */
	public static void addItems(String name, int price, int quantity){
		try{
			PreparedStatement statement = (PreparedStatement) Main.con.prepareStatement("INSERT INTO inventory(name,price,quantity) VALUES(?,?,?)");

			statement.setString(1, name);
			statement.setInt(2,price);
			statement.setInt(3,quantity);
			statement.executeUpdate();
			statement.close();

			Main.con.close();

			System.out.println("works");
		}catch(Exception e){
			System.out.print("Error" + e);
		}
	}

	/**
	 * @param e
	 */
	@FXML
	public void submitButtonPressed(ActionEvent e)
	{
		try{
			Stage stage = (Stage) cancelButton.getScene().getWindow();

			addItems(nameField.getText(),Integer.parseInt(priceField.getText()),Integer.parseInt(quantityField.getText()));
			stage.close();
		}catch(Exception ep){

		}

	}
	/**
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
		// TODO Auto-generated method stub

	}

}
