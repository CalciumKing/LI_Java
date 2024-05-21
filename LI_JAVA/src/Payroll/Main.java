package Payroll;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Employee> employees = Utils.getEmployees();

        Scanner input = new Scanner(System.in);
        for(int i = 0; i < employees.size(); i++) {
            System.out.println("Enter Employee " + (i + 1) + "'s hours");
            int hours = input.nextInt();
            while(hours <= 0) {
                System.out.println("That is not a valid response, please enter a number above 0");
                hours = input.nextInt();
            }

            Employee e = employees.get(i);
            e.setHours(hours);
            e.setGrossPay(hours * e.getPayRate());
            e.setTaxWithheld(e.getGrossPay() * .05);
            e.setNetPay(e.getGrossPay() - e.getTaxWithheld());
        }
        input.nextLine();

        printEmployees(employees);

        String response;
        do {
            System.out.println("Would you like to change an employees hourly wage? [Yes/Exit]");
            response = input.nextLine();
            if(response.equalsIgnoreCase("YES")) {
                System.out.println("Which employee would you like to change? (1-Employee List Length)");
                int employeeNum = input.nextInt() - 1;
                while (employeeNum < 0 || employeeNum > employees.size() - 1) {
                    System.out.println("That is not a valid employee number, please enter a correct one:");
                    employeeNum = input.nextInt() - 1;
                }
                input.nextLine();
                Utils.changeEmployeeWage(employees, employeeNum);
                printEmployees(employees);
            }
        } while(!response.equalsIgnoreCase("EXIT"));
    }

    private static void printEmployees(ArrayList<Employee> employees) {
        for(int i = 0; i < employees.size(); i++) {
            Employee em = employees.get(i);
            System.out.println("Employee " + (i + 1) + "'s stuff");
            System.out.println("ID: " + em.getEmployeeID());
            System.out.println("Gross Wage: " + em.getGrossPay());
            System.out.println("Taxes Withheld: " + em.getTaxWithheld());
            System.out.println("Net Pay: " + em.getNetPay());
            System.out.println();
        }
    }
}