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


/**
 * Main Class
 * In charge of initialize the Parents and Scenes. Also, Main
 * is in charge of loading some of the fxmls, and launching the application.
 * 
 * @author Luis Alvarez
 * @since 1/27/2017
 * @version 1.0
 *
 */
public class Main extends Application {
	public static Parent root;
	public static Parent second;
	public static Parent fourth;
	public static Parent fifth;
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
	public static Scene scene4;
	public static Scene scene5;
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
			fourth = FXMLLoader.load(getClass().getResource("/application/AddGUI.fxml"));
			nine = FXMLLoader.load(getClass().getResource("/application/DeleteClient.fxml"));
			ten = FXMLLoader.load(getClass().getResource("/application/AddItem.fxml"));
			eleven = FXMLLoader.load(getClass().getResource("/application/DeleteItem.fxml"));

			scene1 = new Scene(root);
			scene2 = new Scene(second);
			scene4 = new Scene(fourth);
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

	/**
	 * main Method
	 *  In charge of launching the application
	 * @param args
	 */
	public static void main(String[] args)
	{
		launch(args);
	}

}
