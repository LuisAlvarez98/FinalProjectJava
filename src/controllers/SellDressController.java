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
import javafx.stage.Stage;

/**
 * SellDressController Class
 * In charge of selling dresses, you select a dress and a client. When you hit pay it automatically
 * updates the sales table.
 *
 * @author Luis Alvarez
 * @since 09/10/2016
 * @version 1.0
 *
 */
public class SellDressController implements Initializable {


	public static ObservableList<String> dressList = FXCollections.observableArrayList();
	@FXML private Button payButton,cancelButton,backButton,logoutButton;
	@FXML private ChoiceBox<String> dressSelector,clientSelector;

	@FXML private Label total;
	@FXML private Label warningLabel;
	boolean flag = true;

	/**
	 * backButtonPressed Method
	 * Takes you back to the main menu
	 * @param e
	 */
	@FXML
	public void backButtonPressed(ActionEvent e)
	{
		application.Main.mainStage.setScene(application.Main.scene2);
	}
	/**
	 * logoutButtonPressed Method
	 * Takes you back to the login screen
	 * @param e
	 */
	@FXML
	public void logoutButtonPressed(ActionEvent e)
	{
		application.Main.mainStage.setScene(application.Main.scene1);
	}

	/**
	 * payButtonPressed Method
	 * Calculates the total and send the information to the sales table
	 * @param e
	 */
	@FXML
	public void payButtonPressed(ActionEvent e){

		try{
			DbConnect connect = new DbConnect();
			Main.inventory= connect.getDataInventory();
			boolean found = false;
			for(int i = 0; i < Main.inventory.size();i+=3)
			{
				//Checks if the selectors are empty.
				boolean checkDress = dressSelector.getSelectionModel().isEmpty();
				boolean checkClient = clientSelector.getSelectionModel().isEmpty();
				
				if((checkDress == true) && (checkClient == true)){
					warningLabel.setText("*Please select a client and a dress.*");
				}else if(checkClient == true){
					warningLabel.setText("*Please select a client.*");
				}else if(checkDress == true){
					warningLabel.setText("*Please select a dress.*");
				}else{
					warningLabel.setText("");
					if(dressSelector.getValue().equals(Main.inventory.get(i))){
						total.setText(Main.inventory.get(i+1));
						found = true;
						addSales(dressSelector.getValue(),Integer.parseInt(total.getText()),clientSelector.getValue());
						updateInventory((Integer.parseInt(Main.inventory.get(i+2))-1),dressSelector.getValue());
						if(Integer.parseInt(Main.inventory.get(i+2)) <= 1){
							deleteDress(dressSelector.getValue());
						}
					}
					if(!found)
						total.setText("");
				}
			
				
			}
		}catch(Exception ep){

		}
	}
	/**
	 * addSales Method
	 * A query that is in charge of sending all the info inputed by the user to the sales table
	 * @param name
	 * @param price
	 * @param clientName
	 */
	public static void addSales(String name, int price, String clientName)
	{
		try{
			PreparedStatement statement = (PreparedStatement) Main.con.prepareStatement("INSERT INTO sales(name,price,client_name) VALUES(?,?,?)");

			statement.setString(1, name);
			statement.setInt(2,price);
			statement.setString(3,clientName);
			statement.executeUpdate();


			System.out.println("works");
		}catch(Exception e){
			System.out.print("Error" + e);
		}
	}
	/**
	 * updateInventory Method
	 * In charge of updating the quantity of the item
	 * @param quantity
	 * @param dressName
	 */
	public static void updateInventory(int quantity, String dressName){
		try{

			String sql="update inventory set quantity='"+quantity+"' where  name='"+dressName+"' ";

			java.sql.PreparedStatement st = Main.con.prepareStatement(sql);
			st.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * deleteDress Method
	 * In charge of deleting rows from inventory table if quantity <=0, depending on the dressName.
	 * @param dressName
	 */
	public static void deleteDress(String dressName){
		try{
			String sql="DELETE FROM inventory WHERE name ='"+dressName+"'";

			java.sql.PreparedStatement st = Main.con.prepareStatement(sql);
			st.execute();
		}catch(Exception e){

		}

	}
	/**
	 * cancelButtonPressed Method
	 * Cancels the transaction and sends you back to the main menu
	 * @param e
	 */
	@FXML
	public void cancelButtonPressed(ActionEvent e){
		application.Main.mainStage.setScene(application.Main.scene2);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		DbConnect connect = new DbConnect();
		Main.inventory= connect.getDataInventory();
		//Fills the Choice Box of Dresses
		ObservableList<String> dressList = FXCollections.observableArrayList();

		for(int i = 0; i < Main.inventory.size();i+=3)
		{
			dressList.add(Main.inventory.get(i));
		}

		dressSelector.setItems(dressList);




		DbConnect connect2= new DbConnect();
		Main.clients= connect2.getDataClients();
		//Fills the Choice Box of Clients
		ObservableList<String> clientList = FXCollections.observableArrayList();

		for(int i = 0; i < Main.clients.size();i+=3)
		{
			clientList.add(Main.clients.get(i));
		}

		clientSelector.setItems(clientList);
	}



}
