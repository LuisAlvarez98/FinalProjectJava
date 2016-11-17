package application;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;

public class Tables {


	private final SimpleStringProperty name;
	private final SimpleStringProperty price;
	private final SimpleStringProperty clientName;

	public Tables(String fName, String lName, String idNum){
		this.name = new SimpleStringProperty(fName);
		this.price = new SimpleStringProperty(lName);
		this.clientName= new SimpleStringProperty(idNum);
	}

	public String getFirstName(){
		return name.get();
	}
	public void setFirstName(String fName){
		name.set(fName);
	}
	public String getLastName(){
		return price.get();
	}
	public void setLastName(String idNum){
		price.set(idNum);
	}
	public String getIdNumber(){
		return clientName.get();
	}
	public void setIdNumber(String idNum){
		clientName.set(idNum);
	}

}


