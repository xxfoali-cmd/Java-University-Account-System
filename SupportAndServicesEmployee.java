/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.cs102.account.management.system;

/**
 *
 * @author xxfoa
 */
public class SupportAndServicesEmployee extends Employee {

    private String jobDescription;

    public SupportAndServicesEmployee(String jobDescription, String department, String officeNuber, String firstName, String surname, String username, String password, String dateOfBirth) {
        super(department, officeNuber, firstName, surname, username, password, dateOfBirth);
        this.jobDescription = jobDescription;
    }

   

    

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        try{
        if (jobDescription == null || jobDescription.equals("")) {
            System.out.println("Invalid job description!");
        } else {
            this.jobDescription = jobDescription;
        }
        }catch(Exception e){
            System.out.println("Error setting job Description: "+e.getMessage());
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Job Description: " + jobDescription);
    }

}
