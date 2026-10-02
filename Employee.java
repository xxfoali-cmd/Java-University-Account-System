/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.cs102.account.management.system;

/**
 *
 * @author xxfoa
 */
public class Employee extends Person {

    private String department;
    private String officeNuber;

    public Employee(String department, String officeNuber, String firstName, String surname, String username, String password, String dateOfBirth) {
        super(firstName, surname, username, password, dateOfBirth);
        this.department = department;
        this.officeNuber = officeNuber;
    }

   
     
    

   

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        try {
            if (department == null || department.equals("")) {
                System.out.println("Invalid department!");
            } else {
                this.department = department;
            }
        } catch (Exception e) {
            System.out.println("Error setting department: " + e.getMessage());
        }

    }

    public String getOfficeNuber() {
        return officeNuber;
    }

    public void setOfficeNuber(String officeNuber) {
        try{
        if (officeNuber == null || officeNuber.equals("")) {
            System.out.println("Invalid office number!");
        } else {
            this.officeNuber = officeNuber;
        }
        }catch(Exception e){
            System.out.println("Error setting office number: "+e.getMessage());
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Department: " + department);
        System.out.println("Office Number: " + officeNuber);
    }
}
