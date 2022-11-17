package application;

import java.util.UUID;

public class Employee {


	public String firstName;
	public String lastName;
	public final int ID;
	public Department dept;

	public Employee(Department dept, String firstName, String lastName) {
		this.dept = dept;
		this.firstName = firstName;
		this.lastName = lastName;
		ID = App.generateID();
	}

	public void print() {
		System.out.println("Der Mitarbeiter "+ ID +
				" " +firstName + " " + lastName +
				" arbeitet in der Abteilung " +
				dept.name + " in " + dept.city);
	}

	public boolean isEquals(Employee other) {
		return other.ID == ID;
	}
}
