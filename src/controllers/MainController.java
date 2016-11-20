package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 * MainController Class: The controller for the Main menu,
 * in charge of the navigation of the program
 *
 * @author Luis Alvarez
 * @since 09/10/2016
 * @version 1.0
 *
 */
public class MainController implements Initializable {

	@FXML private Button logoutButton,inventoryButton,salesButton,clientsButton,sellDressButton;
	@FXML private Label userText;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	/**
	 * logoutButtonPressed Method
	 * Log outs the user from the program
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void logoutButtonPressed(ActionEvent e) throws IOException
	{
			Scene scene1;
			Parent root;
				 root = FXMLLoader.load(getClass().getResource("/application/LoginGUI.fxml"));
				 scene1 = new Scene(root);
				 application.Main.mainStage.setScene(scene1);
				 Main.mainStage.setResizable(false);
	}
	/**
	 * inventoryButtonPressed
	 * Takes the user to the inventory scene
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void inventoryButtonPressed(ActionEvent e) throws IOException
	{
			Scene scene3;
			Parent three;
				 three = FXMLLoader.load(getClass().getResource("/application/InventoryGUI.fxml"));
				 scene3 = new Scene(three);
				 application.Main.mainStage.setScene(scene3);
				 Main.mainStage.setResizable(false);
	}
	/**
	 * salesButtonPressed
	 * Takes the user to the sales scene
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void salesButtonPressed(ActionEvent e) throws IOException
	{
			Scene scene6;
			Parent six;
				 six = FXMLLoader.load(getClass().getResource("/application/SalesGUI.fxml"));
				 scene6 = new Scene(six);
				 application.Main.mainStage.setScene(scene6);
				 Main.mainStage.setResizable(false);
	}
	/**
	 * clientsButtonPressed
	 * Takes the user to the clients scene
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void clientsButtonPressed(ActionEvent e) throws IOException
	{
			Scene scene7;
			Parent seven;
				 seven = FXMLLoader.load(getClass().getResource("/application/ClientsGUI.fxml"));
				 scene7 = new Scene(seven);
				 application.Main.mainStage.setScene(scene7);
				 Main.mainStage.setResizable(false);
	}
	/**
	 * sellDressButtonPressed
	 * Takes the user to the Sell Dress scene
	 *
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void sellDressButtonPressed(ActionEvent e) throws IOException
	{
		Scene scene8;
		Parent eight;
		 	eight = FXMLLoader.load(getClass().getResource("/application/SaleDressGUI.fxml"));
		 	scene8 = new Scene(eight);
		 	application.Main.mainStage.setScene(scene8);
		 	 Main.mainStage.setResizable(false);
	}
}
