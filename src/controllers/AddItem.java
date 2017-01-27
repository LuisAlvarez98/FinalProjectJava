package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;
import controllers.InventoryController;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * AddItem Class, In charge of adding 
 * items to the database => Tables
 * 
 * @author Luis Alvarez
 * @since 09/10/2016
 * @version 1.0
 */
public class AddItem implements Initializable {


	@FXML private Button submitButton,cancelButton;
	@FXML private TextField nameField,priceField,quantityField;
	@FXML private Label warningLabel;
	/**
	 * addItems Method
	 * 
	 * A query in charge of creating a connection and adding elements to the inventory table
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
		}catch(Exception e){
			System.out.print("Error" + e);
		}
	}
	/**
	 * submitButtonPressed Method
	 * When you hit the submit button, you add the desired item element to the table,
	 * checks if item already exists.
	 * @param e
	 */
	@FXML
	public void submitButtonPressed(ActionEvent e)
	{
		try
		{
			Stage stage = (Stage) submitButton.getScene().getWindow();

			boolean flag = false;
				for(int i = 0 ; i < Main.inventory.size();i++)
				{
					warningLabel.setText("Please input another name");
					if(Main.inventory.get(i).equals(nameField.getText()))
					{
						addItems(nameField.getText(),Integer.parseInt(Main.inventory.get(i+=2)),Integer.parseInt(Main.inventory.get(i+=3)));
						flag = true;
					}
				}
			if(!flag)
			{
				addItems(nameField.getText(),Integer.parseInt(priceField.getText()),Integer.parseInt(quantityField.getText()));
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
