/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.cs102.account.management.system;

/**
 *
 * @author xxfoa
 */
public class Faculty extends Employee {

    private String rank;
    private String specialization;

    public Faculty(String rank, String specialization, String department, String officeNuber, String firstName, String surname, String username, String password, String dateOfBirth) {
        super(department, officeNuber, firstName, surname, username, password, dateOfBirth);
        this.rank = rank;
       this.specialization = specialization;
    }

  

  

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        try{
        if (rank != null
                && (rank.equalsIgnoreCase("Lecturer")
                || rank.equalsIgnoreCase("Assistant Professor")
                || rank.equalsIgnoreCase("Associate Professor")
                || rank.equalsIgnoreCase("Professor"))) {
            this.rank = rank;
        } else {
            System.out.println("Invalid rank!");
        }
        }catch(Exception e){
            System.out.println("Error setting Rank: "+e.getMessage());
        }
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        try{
        if (specialization == null || specialization.equals("")) {
            System.out.println("Invalid specialisation!");
        } else {
            this.specialization = specialization;
        }
        }catch(Exception e){
            System.out.println("Error setting specialization: "+e.getMessage());
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Rank: " + rank);
        System.out.println("Specialisation: " + specialization);
    }
}
