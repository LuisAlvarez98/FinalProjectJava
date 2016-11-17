package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML TextField userField,passField,showPassField;
	@FXML Button submitButton;
	@FXML Label accessDenied;
	@FXML CheckBox showPassword;


	ArrayList<String> users =  new ArrayList<String>();
	ArrayList<String> passwords =  new ArrayList<String>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		showPassField.setVisible(false);
		// TODO Auto-generated method stub
		accessDenied.setText("");
	}
	@FXML
	public void onEnter(ActionEvent ae){
	  submitButtonPressed(ae);
	}
	@FXML
	public void submitButtonPressed(ActionEvent event)
	{

		DbConnect connect = new DbConnect();
		users = connect.getDataUser();
		passwords = connect.getDataPass();
		if(showPassword.isSelected()){
			passField.setText(showPassField.getText());
		}else{
			showPassField.setText(passField.getText());
		}


		for(int i = 0; i  < users.size();i++){
			accessDenied.setText("");
			if(userField.getText().equals(users.get(i)) && passField.getText().equals(passwords.get(i)))
			{

				application.Main.mainStage = (Stage) submitButton.getScene().getWindow();
				application.Main.mainStage.setScene(application.Main.scene2);
				accessDenied.setText("");
			}else if(!userField.getText().equals(users.get(i))){
				accessDenied.setText("Wrong Credentials");
			}else{
				accessDenied.setText("Wrong Credentials");
			}
		}



	}
	@FXML
	public void showPasswordPressed(ActionEvent e){
		if(showPassword.isSelected()){
			passField.setVisible(false);
			showPassField.setVisible(true);
			showPassField.setText(passField.getText());
		}else{
			passField.setVisible(true);
			showPassField.setVisible(false);
			passField.setText(showPassField.getText());
		}
	}

}
