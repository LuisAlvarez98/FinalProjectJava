package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class EditController implements Initializable {


	@FXML private Button submitButton,cancelButton;

	public static void editClients(String name, String email, String phone){
		try{
			PreparedStatement statement = (PreparedStatement) Main.con.prepareStatement("UPDATE FROM clients WHERE name =?");

			statement.setString(1,name);
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

	}
	public void cancelButtonPressed(ActionEvent e)
	{

	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
