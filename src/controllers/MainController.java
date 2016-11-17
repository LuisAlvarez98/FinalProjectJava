package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class MainController implements Initializable {

	@FXML private Button logoutButton,inventoryButton,salesButton,clientsButton,sellDressButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	@FXML
	public void logoutButtonPressed(ActionEvent e) throws IOException{
		Scene scene1;
		 Parent root;
		 root = FXMLLoader.load(getClass().getResource("/application/LoginGUI.fxml"));
		 scene1 = new Scene(root);
		application.Main.mainStage.setScene(scene1);

	}
	@FXML
	public void inventoryButtonPressed(ActionEvent e) throws IOException{
		Scene scene3;
		 Parent three;
		 three = FXMLLoader.load(getClass().getResource("/application/InventoryGUI.fxml"));
		 scene3 = new Scene(three);
		application.Main.mainStage.setScene(scene3);
	}
	@FXML
	public void salesButtonPressed(ActionEvent e) throws IOException{
		Scene scene6;
		 Parent six;
		 six = FXMLLoader.load(getClass().getResource("/application/SalesGUI.fxml"));
		 scene6 = new Scene(six);
		application.Main.mainStage.setScene(scene6);

	}
	@FXML
	public void clientsButtonPressed(ActionEvent e) throws IOException{
		Scene scene7;
		 Parent seven;
		 seven = FXMLLoader.load(getClass().getResource("/application/ClientsGUI.fxml"));
		 scene7 = new Scene(seven);
		application.Main.mainStage.setScene(scene7);
	}
	@FXML
	public void sellDressButtonPressed(ActionEvent e) throws IOException{
		Scene scene8;
		 Parent eight;
		 eight = FXMLLoader.load(getClass().getResource("/application/SaleDressGUI.fxml"));
		 scene8 = new Scene(eight);
		application.Main.mainStage.setScene(scene8);
	}
}
