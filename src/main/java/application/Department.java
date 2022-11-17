package application;

import java.util.UUID;

public class Department {

	public String name;
	public final int ID;
	public String country;
	public String city;


	public Department(){
		name = "Test";
		ID = 123;
		country = "Neverland";
		city = "Gotham";
	}

	public Department(String name, String country, String city) {
		this.name = name;
		ID = App.generateID();
		this.country = country;
		this.city = city;
	}

	public boolean isEquals(Department other) {
		return false;
	}
}
