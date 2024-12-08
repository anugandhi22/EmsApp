package com.cjc.emsapp.app.client;

import java.util.List;
import java.util.Scanner;

import com.cjc.emsapp.app.model.Employee;
import com.cjc.emsapp.app.servicei.EmployeeServiceI;
import com.cjc.emsapp.app.serviceimpl.EmployeeServiceImp;

public class TestUI {
public static void main(String[] args) {
	

		Scanner sc = new Scanner(System.in);
		EmployeeServiceI emp = new EmployeeServiceImp();

		System.out.println("********* EMS App *********");
		System.out.println("///// //// ///// //// /////\n");

		while (true) {

			System.out.println("Select your Choice..!\n");
			System.out.println("1. Add Employee \n2. View Employee List\n" + "3. Update Employee\n4. Delete Employee\n"
					+ "5. Create Table\n6. Drop Table\n" + "7. Create coloum\n8. Drop Coloum");

			System.out.println("\nEnter Your choice...");
			int no = sc.nextInt();
			System.out.println("\n");

			if (no == 1) {

				Employee e = new Employee();

				System.out.println("#### Enter Employee Detils ####\n");
				System.out.println(" ID :");
				e.setEid(sc.nextInt());
				System.out.println(" name :");
				e.setEname(sc.next());
				System.out.println(" Salary :");
				e.setSalary(sc.nextDouble());
				System.out.println(" Gmail :");
				e.setEmailId(sc.next());

				emp.AddEmployeeData(e);

			} else if (no == 2) {

				List<Employee> out = emp.viewEmployee();

				System.out.println(" ID   |  Name           |  Salary    |  Gmail            ");
				System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				System.out.println("---- -|- ------------- -|- -------- -|- ------------------");

				for (Employee ee : out) {
					System.out.printf("%-5s | %-15s | %-10s | %-20s%n", ee.getEid(), ee.getEname(), ee.getSalary(),
							ee.getEmailId());
					System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				}
				System.out.println("\n");

			} else if (no == 3) {
				Employee e1 = new Employee();

				System.out.println("#### Update Employee Details ####\n");
				System.out.println("Which Id Data Update :");

				int eid = sc.nextInt();
				e1.setEid(eid);

				//////////////

				List<Employee> data = emp.getDataByEid(eid);

				System.out.println(" ID   |  Name           |  Salary    |  Gmail            ");
				System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				for (Employee ee : data) {
					System.out.printf("%-5s | %-15s | %-10s | %-20s%n", ee.getEid(), ee.getEname(), ee.getSalary(),
							ee.getEmailId());
					System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				}
				System.out.println("\n");

				//////
				////////
				System.out.println("Update Employee Details :\n");
				System.out.println("Name :");
				e1.setEname(sc.next());
				System.out.println("Salary :");
				e1.setSalary(sc.nextDouble());
				System.out.println("Gmail :");
				e1.setEmailId(sc.next());

				emp.updatedata(e1);

				List<Employee> data1 = emp.getDataByEid(eid);

				System.out.println(" ID   |  Name           |  Salary    |  Gmail            ");
				System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				for (Employee ee : data1) {
					System.out.printf("%-5s | %-15s | %-10s | %-20s%n", ee.getEid(), ee.getEname(), ee.getSalary(),
							ee.getEmailId());
					System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				}
				System.out.println("\n");

			} else if (no == 4) {

				System.out.println("Enter Delete Employee Id :");
				int eid = sc.nextInt();
				List<Employee> data2 = emp.getDataByEid(eid);

				//////////////////////

				System.out.println(" ID   |  Name           |  Salary    |  Gmail            ");
				System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				for (Employee ee1 : data2) {
					System.out.printf("%-5s | %-15s | %-10s | %-20s%n", ee1.getEid(), ee1.getEname(), ee1.getSalary(),
							ee1.getEmailId());
					System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				}
				System.out.println("\n");

				//////////////////////

				System.out.println("Your are the Sure This Employee Was Deleted..?");
				System.out.println("1. Yes\n2. No\nEnter Your Choice..:");
				int val = sc.nextInt();
				if (val == 1) {
					emp.deleteEmployee(eid);
					System.out.println("Employee Was Deleted..!\n");
				} else if (val == 2) {
					System.out.println("Employee Not Deleted..!\n");
				}

				List<Employee> out = emp.viewEmployee();

				System.out.println(" ID   |  Name           |  Salary    |  Gmail            ");
				System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				System.out.println("---- -|- ------------- -|- -------- -|- ------------------");

				for (Employee ee : out) {
					System.out.printf("%-5s | %-15s | %-10s | %-20s%n", ee.getEid(), ee.getEname(), ee.getSalary(),
							ee.getEmailId());
					System.out.println("---- -|- ------------- -|- -------- -|- ------------------");
				}
				System.out.println("\n");

			} else if (no == 5) {

				System.out.println("#### Create DB Table ####\n\nEnter Table Name :");
				emp.createDBTable(sc.next());

			} else if (no == 6) {

				System.out.println("#### Drop DB Table ####\n\nEnter Table Name :");
				emp.DropDBTable(sc.next());

			} else if (no == 7) {

				System.out.println(" #### ADD the Table column ####\n");

				System.out.println("** Here the all DataBase Table Name **\n");

				List<String> tnames = emp.getDBtableName();

				for (String st : tnames) {
					System.out.print(st + ", ");
				}
				System.out.println("\n");

				System.out.println("Added column in which table :");
				String t_n = sc.next();

				while (true) {

					System.out.println("\nIf you want to Add Column..?\nEnter Your Choice :\n1. Yes\n2. No\n");
					if (sc.nextInt() == 2) {
						break;
					}

					System.out.println("\n** Here Is all column name **\n");
					emp.getcolumnName(t_n);
					System.out.println("\n");

					System.out.println("Enter The New Column Name :");
					String c_n = sc.next();
					System.out.println("Enter The Data Type & length :");
					String dType = sc.next();
					int len = sc.nextInt();

					emp.addTableColumn(t_n, c_n, dType, len);

					System.out.println("** Here Is all column name **");
					emp.getcolumnName(t_n);
					System.out.println("\n");

				}

			} else if (no == 8) {

				System.out.println(" #### Drop the Table column ####\n");

				System.out.println("** Here the all DataBase Table Name **\n");

				List<String> tnames = emp.getDBtableName();

				for (String st : tnames) {
					System.out.print(st + ", ");
				}
				System.out.println("\n");

				System.out.println("Drop column in which table :");
				String t_n = sc.next();

				while (true) {

					System.out.println("\nIf you want to Drop Column..?\nEnter Your Choice :\n1. Yes\n2. No\n");
					if (sc.nextInt() == 2) {
						break;
					}

					System.out.println("\n** Here Is all column name **\n");
					emp.getcolumnName(t_n);
					System.out.println("\n");

					System.out.println("Which column you want to Drop..?");
					String c_n = sc.next();
					emp.dropColumn(t_n, c_n);

					System.out.println("\n** Here Is all column name **\n");
					emp.getcolumnName(t_n);
					System.out.println("\n");

				}

			} else {
				System.out.println("Invalid choice...\n");
				System.out.println("Enter Again ..:\n");
			}

		}

	}

}
