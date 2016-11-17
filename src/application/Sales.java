package application;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;

public class Sales {



	private final SimpleStringProperty firstName;


	/**
	 * @param array
	 * @param fName
	 * @param lName
	 * @param idNum
	 */
	public Sales(ArrayList<String> array){
		this.firstName = new SimpleStringProperty();

	}

	/**
	 * @return firstName.get();
	 */
	public String getFirstName(){
		return firstName.get();
	}
	/**
	 * @param fName
	 */
	public void setFirstName(String fName){
		firstName.set(fName);
	}


}
