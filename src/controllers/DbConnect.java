package controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import application.Main;

/**
 * @author Luis Alvarez
 *
 */
public class DbConnect
{
	/**
	 *
	 */
	public DbConnect()
	{
		try
		{
				Class.forName("com.mysql.jdbc.Driver");
				Main.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lg","root","");
				Main.st = Main.con.createStatement();

		}catch(Exception e){
			System.out.print("Error" + e);
		}
	}
	public ArrayList<String> getDataUser()
	{
		ArrayList<String>users= new ArrayList<String>();

		try{

			String query ="select * from users";
			Main.rs = Main.st.executeQuery(query);

			while(Main.rs.next())
			{
				String user = Main.rs.getString("user");

				users.add(user);

			}
		}catch(Exception e)
		{
			System.out.print("Error" + e);
		}
		return users;
	}

	public ArrayList<String> getDataPass()
	{
		ArrayList<String>passwords= new ArrayList<String>();
		try{

			String query ="select * from users";
			Main.rs = Main.st.executeQuery(query);

			while(Main.rs.next())
			{

				String pass =  Main.rs.getString("pass");

				passwords.add(pass);

			}
		}catch(Exception e)
		{
			System.out.print("Error" + e);
		}
		return passwords;
	}
	public ArrayList<String> getDataSales()
	{
		ArrayList<String> tableData = new ArrayList<String>();

		try{

			String query ="select * from sales";
			Main.rs = Main.st.executeQuery(query);

			while(Main.rs.next())
			{

				String name = Main.rs.getString("name");
				int price = Main.rs.getInt("price");
				String client_name = Main.rs.getString("client_name");
				String fPrice = Integer.toString(price);

				tableData.add(name);
				tableData.add (fPrice);
				tableData.add(client_name);
			}
		}catch(Exception e)
		{
			System.out.print("Error" + e);
		}
		return tableData;
	}
	public ArrayList<String> getDataClients()
	{
		ArrayList<String> tableData = new ArrayList<String>();

		try{

			String query ="select * from clients";
			Main.rs = Main.st.executeQuery(query);

			while(Main.rs.next())
			{

				String name = Main.rs.getString("name");
				String email = Main.rs.getString("email");
				String phone= Main.rs.getString("phone");

				tableData.add(name);
				tableData.add (email);
				tableData.add(phone);
			}
		}catch(Exception e)
		{
			System.out.print("Error" + e);
		}
		return tableData;
	}
	public ArrayList<String> getDataInventory()
	{
		ArrayList<String> tableData = new ArrayList<String>();

		try{

			String query ="select * from inventory";
			Main.rs = Main.st.executeQuery(query);

			while(Main.rs.next())
			{

				String name = Main.rs.getString("name");
				int price = Main.rs.getInt("price");
				int quantity = Main.rs.getInt("quantity");
				String fPrice = Integer.toString(price);
				String fQuantity = Integer.toString(quantity);

				tableData.add(name);
				tableData.add (fPrice);
				tableData.add(fQuantity);
			}
		}catch(Exception e)
		{
			System.out.print("Error" + e);
		}
		return tableData;
	}


}
