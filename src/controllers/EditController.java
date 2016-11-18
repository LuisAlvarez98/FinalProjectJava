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

public class EditController implements Initializable {


	@FXML private Button submitButton;
	@FXML private Button cancelButton;
	@FXML private Button searchButton;

	@FXML private TextField searchField;
	@FXML
	private TextField nameField;
	@FXML
	private  TextField phoneField;
	@FXML
	private  TextField emailField;




	@FXML
	public void submitButtonPressed(ActionEvent e)
	{


	}
	@FXML
	public void cancelButtonPressed(ActionEvent e)
	{
		System.out.println("cancel work");
	}
	@FXML
	public void searchButtonPressed(ActionEvent e){
		System.out.println("search working");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
