package Payroll;

public class Employee {
    private final int employeeID;
    private int hours;
    private double payRate;
    private double grossPay;
    private double netPay;
    private double taxWithheld;

    public Employee(int employeeID, double payRate) {
        this.employeeID = employeeID;
        this.payRate = payRate;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }
    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }
    public void setTaxWithheld(double taxWithheld) {
        this.taxWithheld = taxWithheld;
    }

    public int getEmployeeID() {
        return employeeID;
    }
    public int getHours() {
        return hours;
    }
    public double getGrossPay() {
        return grossPay;
    }
    public double getPayRate() {
        return payRate;
    }
    public double getNetPay() {
        return netPay;
    }
    public double getTaxWithheld() {
        return taxWithheld;
    }
}