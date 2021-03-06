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
				for(int i = 0 ; i < Main.inventory.size();i+=3)
				{
					if(nameField.getText().equals(Main.inventory.get(i))){
						warningLabel.setText("Please input a valid name");
						return;
					}else if(nameField.getText().equals("")){
						warningLabel.setText("Please input a name");
						return;
					}else if(integerChecker(priceField.getText()) == false){
						warningLabel.setText("Please input a price");
						return;
					}else if(integerChecker(quantityField.getText()) == false){
						warningLabel.setText("Please input a quantity");
						return;
					}
					
				}
				
				addItems(nameField.getText(),Integer.parseInt(priceField.getText()),Integer.parseInt(quantityField.getText()));
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
