package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Application {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		List<Employee> employees = new ArrayList<>();
		
		System.out.print("How many employees will be registered?: ");
		int n = input.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Employee #" + (i+1) + ":");
			System.out.print("ID: ");
			int id = input.nextInt();
			System.out.print("Name: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Salary: ");
			double salary = input.nextDouble();
			Employee employee = new Employee(id, name, salary);
			employees.add(employee);
		}
		System.out.println(" ");
		System.out.print("Enter the employee id that will have salary increased: ");
		int id = input.nextInt();
		Employee emp = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = input.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		for (Employee empView : employees) {
			System.out.println(empView);
		}

	}

}
