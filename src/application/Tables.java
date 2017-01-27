package application;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;

/**
 * Tables Class
 * In charge of the getters & setters of the tables used in the program
 * 
 * @author Luis Alvarez
 * @since 1/27/2017
 * @version 1.0
 *
 */
public class Tables {


	private final SimpleStringProperty name;
	private final SimpleStringProperty price;
	private final SimpleStringProperty clientName;

	/**
	 * Tables Constructor
	 * Defines the variables in the constructor
	 * @param fName
	 * @param lName
	 * @param idNum
	 */
	public Tables(String fName, String lName, String idNum){
		this.name = new SimpleStringProperty(fName);
		this.price = new SimpleStringProperty(lName);
		this.clientName= new SimpleStringProperty(idNum);
	}

	/**
	 * getFirstName Method
	 * @return name.get();
	 */
	public String getFirstName(){
		return name.get();
	}
	/**
	 * setFirstName Method
	 * @param fName
	 */
	public void setFirstName(String fName){
		name.set(fName);
	}
	/**
	 * getLastName Method
	 * @return price.get();
	 */
	public String getLastName(){
		return price.get();
	}
	/**
	 * setLastName Method
	 * @param idNum
	 */
	public void setLastName(String idNum){
		price.set(idNum);
	}
	/**
	 * getIdNumber Method
	 * @return clientName.get();
	 */
	public String getIdNumber(){
		return clientName.get();
	}
	/**
	 * setIdNumber Method
	 * @param idNum
	 */
	public void setIdNumber(String idNum){
		clientName.set(idNum);
	}

}


