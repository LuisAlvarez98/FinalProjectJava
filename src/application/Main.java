package application;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static Parent root;
	public static Parent second;
	//public static Parent third;
	public static Parent fourth;
	public static Parent fifth;
	//public static Parent six;
	//public static Parent seven;
	//public static Parent eight;
	public static Parent nine;
	public static Parent ten;
	public static Parent eleven;

	public static Connection con;
	public static Statement st;
	public static ResultSet rs;

	public static ArrayList<String> inventory =  new ArrayList<String>();
	public static ArrayList<String> clients =  new ArrayList<String>();

	public static Scene scene1;
	public static Scene scene2;
	//public static Scene scene3;
	public static Scene scene4;
	public static Scene scene5;
	//public static Scene scene6;
	//public static Scene scene7;
	//public static Scene scene8;
	public static Scene scene9;
	public static Scene scene10;
	public static Scene scene11;
	public static Stage mainStage;
	public static String user;



	@Override
	public void start(Stage primaryStage) {
		try {
			root = FXMLLoader.load(getClass().getResource("/application/LoginGUI.fxml"));
			second = FXMLLoader.load(getClass().getResource("/application/MainMenuGUI.fxml"));
		//	third = FXMLLoader.load(getClass().getResource("/application/InventoryGUI.fxml"));
			fourth = FXMLLoader.load(getClass().getResource("/application/AddGUI.fxml"));

			//six = FXMLLoader.load(getClass().getResource("/application/SalesGUI.fxml"));
		//	seven = FXMLLoader.load(getClass().getResource("/application/ClientsGUI.fxml"));
		//	eight = FXMLLoader.load(getClass().getResource("/application/SaleDressGUI.fxml"));
			nine = FXMLLoader.load(getClass().getResource("/application/DeleteClient.fxml"));
			ten = FXMLLoader.load(getClass().getResource("/application/AddItem.fxml"));
			eleven = FXMLLoader.load(getClass().getResource("/application/DeleteItem.fxml"));
			scene1 = new Scene(root);
			scene2 = new Scene(second);
			//scene3 = new Scene(third);
			scene4 = new Scene(fourth);

			//scene6 = new Scene(six);
			//scene7 = new Scene(seven);
			//scene8 = new Scene(eight);
			scene9 = new Scene(nine);
			scene10 = new Scene(ten);
			scene11 = new Scene(eleven);
			primaryStage.setResizable(false);

			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);

			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		String pass = "password";
		try {
		System.out.println(hashPassword("1"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		launch(args);
	}
	public static String hashPassword(String password) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] b = md.digest();
		StringBuffer sb = new StringBuffer();
		for(byte b1 : b){
			sb.append(Integer.toHexString(b1 & 0xff).toString());

		}
		return sb.toString();
	}
}
