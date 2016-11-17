package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import application.Main;
import application.Tables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SellDressController implements Initializable {


	public static ObservableList<String> dressList = FXCollections.observableArrayList();
	@FXML private Button payButton,cancelButton,backButton,logoutButton;
	@FXML private ChoiceBox<String> dressSelector,clientSelector;

	@FXML private Label total;


	@FXML
	public void backButtonPressed(ActionEvent e)
	{
		application.Main.mainStage.setScene(application.Main.scene2);
	}
	@FXML
	public void logoutButtonPressed(ActionEvent e)
	{
		application.Main.mainStage.setScene(application.Main.scene1);
	}
	@FXML
	public void payButtonPressed(ActionEvent e){
		DbConnect connect = new DbConnect();
		Main.inventory= connect.getDataInventory();
		boolean found = false;

		for(int i = 0; i < Main.inventory.size();i+=3)
		{
			if(dressSelector.getValue().equals(Main.inventory.get(i))){
				total.setText(Main.inventory.get(i+1));
				found = true;
			}

			if(!found)
				total.setText("");
		}

		addSales(dressSelector.getValue(),Integer.parseInt(total.getText()),clientSelector.getValue());


	}
	public static void addSales(String name, int price, String clientName)
	{
		try{
			PreparedStatement statement = (PreparedStatement) Main.con.prepareStatement("INSERT INTO sales(name,price,client_name) VALUES(?,?,?)");

			statement.setString(1, name);
			statement.setInt(2,price);
			statement.setString(3,clientName);
			statement.executeUpdate();
			statement.close();

			Main.con.close();

			System.out.println("works");
		}catch(Exception e){
			System.out.print("Error" + e);
		}
	}
//JAJAJ
	@FXML
	public void cancelButtonPressed(ActionEvent e){
		application.Main.mainStage.setScene(application.Main.scene2);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub


		DbConnect connect = new DbConnect();
		Main.inventory= connect.getDataInventory();

		ObservableList<String> dressList = FXCollections.observableArrayList();

		for(int i = 0; i < Main.inventory.size();i+=3)
		{
			dressList.add(Main.inventory.get(i));
		}

		dressSelector.setItems(dressList);

		DbConnect connect2= new DbConnect();
		Main.clients= connect2.getDataClients();

		ObservableList<String> clientList = FXCollections.observableArrayList();

		for(int i = 0; i < Main.clients.size();i+=3)
		{
			clientList.add(Main.clients.get(i));
		}

		clientSelector.setItems(clientList);
	}


}
