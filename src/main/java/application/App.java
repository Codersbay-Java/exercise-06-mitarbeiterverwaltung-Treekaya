package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

	public static int idIndex = 0;
	public static Employee[] employees;
	public static List<Department> departments = new ArrayList<>();
	private int employeesMax;
	private int employeesCurrent;

	public static void main(String[] args) {

		Department dept = new Department("Name", "Country", "City");
		Employee employee = new Employee(dept, "FirstName", "LastName");

		employee.print();

		application();
	}


	 public static int generateID() {
		return idIndex++;
	 }


	 private static void application() {

		 Scanner scan = new Scanner(System.in);

		 mainloop:
		 for(;;){

			 System.out.println("Bitte legen Sie eine Abteilung an:\n\nName");
			 String name = scan.nextLine();
			 System.out.println("Land");
			 String country = scan.nextLine();
			 System.out.println("Berlin");
			 String city= scan.nextLine();
			 Department newDept = new Department(name, country, city);
			 departments.add(newDept);

			 System.out.println("Bitte legen Sie einen Mitarbeiter an:\n\nVorname");
			 String firstName = scan.nextLine();
			 System.out.println("Nachname");
			 String lastName = scan.nextLine();
			 Employee employee = new Employee(newDept, firstName, lastName);

			 System.out.println("Sie haben folgenden Mitarbeiter angelegt:\n");
			 employee.print();



				 System.out.println("Welches Apartment?");
				 String wantedDepart = scan.nextLine();

				 for (Department dept: departments) {
					 if(dept.name.equalsIgnoreCase(wantedDepart)) {
						 employee.dept = dept;
						 break;
					 }
				 }
				 System.out.println("Department does not exist. Setting "+ newDept.name + " as default");


			 checkloop:
			 for(;;){
				 System.out.println("Möchten Sie noch einen Mitarbeiter anlegen?\nj für ja und n für beenden");
				 String answer = scan.nextLine();

				 switch (answer){
					 case "j": break checkloop;
					 case "n": break mainloop;
					 default:
						 System.out.println(answer + " ist ungültig.");
				 }
			 }
		 }

	 }

	 private void AddEmployee(Employee employee){

		if(employees == null) {
			employees = new Employee[1];
			employeesMax = 1;
			employeesCurrent = 0;
		}

		if(employeesCurrent == employeesMax){
			employees = Arrays.copyOf(employees, employeesMax * 2);
		}

		employees[employeesCurrent] = employee;
		employeesCurrent++;
		employee.print();

		 for (Employee emp: employees) {
			 emp.print();
		 }
	 }

}
