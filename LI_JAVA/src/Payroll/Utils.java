package Payroll;

import java.io.*;
import java.util.*;

public class Utils {
    private static final String FILENAME = "src\\Payroll\\employeesInfo.csv";
    private static final String DELIMITER = ",";

    public static ArrayList<Employee> getEmployees() throws FileNotFoundException {
        ArrayList<Employee> employees = new ArrayList<>();
        File info = new File(FILENAME);
        if(!info.exists()) {
            System.out.println("File Not Found");
            System.exit(0);
        }

        Scanner inputFile = new Scanner(info);
        while(inputFile.hasNextLine()) {
            String[] splitLine = inputFile.nextLine().split(DELIMITER);
            Employee employee = new Employee(Integer.parseInt(splitLine[0]), Double.parseDouble(splitLine[1]));
            employees.add(employee);
        }
        inputFile.close();
        return employees;
    }

    public static void changeEmployeeWage(ArrayList<Employee> employees, int employeeNum) throws IOException {
        File info = new File(FILENAME);
        if(!info.exists()) {
            System.out.println("File Not Found");
            System.exit(0);
        }

        String tempFileName = "src\\Payroll\\tempFile.csv";
        File tempFile = new File(tempFileName);
        FileWriter fileWriter = new FileWriter(tempFileName, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        Scanner inputFile = new Scanner(info);
        Employee employee = employees.get(employeeNum);
        while(inputFile.hasNextLine()) {
            String[] splitLine = inputFile.nextLine().split(DELIMITER);
            if(Integer.parseInt(splitLine[0]) == employee.getEmployeeID()) {
                Scanner input = new Scanner(System.in);
                double originalPay = employee.getPayRate();
                double wage;
                do {
                    System.out.println("What would you like to change employee: " + employee.getEmployeeID() + "'s wage to?");
                    wage = input.nextDouble();
                    if(wage < 15 || wage <= employee.getPayRate())
                        System.out.println("Wage must be at least minimum wage (15) and more than their current wage");
                    else {
                        System.out.println("Running");
                        printWriter.println(splitLine[0] + DELIMITER + wage);
                        for(int i = 0; i < employees.size() - 1; i++) {
                            Employee e = employees.get(i);
                            e.setPayRate(wage);
                            e.setGrossPay(e.getHours() * wage);
                            e.setTaxWithheld(e.getGrossPay() * .05);
                            e.setNetPay(e.getGrossPay() - e.getTaxWithheld());
                        }
                    }
                } while(wage < 15 || wage <= originalPay);
            } else
                printWriter.println(splitLine[0] + DELIMITER + splitLine[1]);
        }
        inputFile.close();

        printWriter.flush();
        printWriter.close();
        printWriter.close();

        info.delete();
        File dump = new File(FILENAME);
        tempFile.renameTo(dump);
    }
}