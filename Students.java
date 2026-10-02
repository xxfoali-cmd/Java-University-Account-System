/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.cs102.account.management.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author xxfoa
 */
public class Students extends Person {

    private String major;
    private String status;
    private ArrayList<Award> awards = new ArrayList<>();

    public Students(String major, String status, String firstName, String surname, String username, String password, String dateOfBirth) {
        super(firstName, surname, username, password, dateOfBirth);
        this.major =  major;
        this.status = status;
    }

   

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status != null
                && (status.equalsIgnoreCase("Freshman")
                || status.equalsIgnoreCase("Sophomore")
                || status.equalsIgnoreCase("Junior")
                || status.equalsIgnoreCase("Senior"))) {
            this.status = status;
        } else {
            System.out.println("Invalid status! Must be Freshman, Sophomore, Junior, or Senior.");
        }
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if (major != null && !major.equals("")) {
            this.major = major;
        } else {
            System.out.println("Invalid major!");
        }
    }

    public ArrayList<Award> getAwards() {
        return awards;
    }

    public void setAwards(ArrayList<Award> award) {
        this.awards = award;
    }

    public void addAwards(String name, String issuer, String date) {
        Award award = new Award(name, issuer, date);
        awards.add(award);
        System.out.println("Award added successfully");

    }

    public void showAllAwards() {
        if (awards.isEmpty()) {
            System.out.println("No awards found");
        } else {
            System.out.println("Awards: ");
            for (Award award : awards) {
                award.showAward();
            }
        }
    }

    public void sortAwardsByNameDescending() {
        Collections.sort(awards, new Comparator<Award>() {
            @Override
            public int compare(Award o1, Award o2) {
                return o2.getName().compareToIgnoreCase(o1.getName());
            }
        });
        System.out.println("Awards sorted by name (Descending)");
    }

    public void sortAwardsByDateAscending() {
        Collections.sort(awards, new Comparator<Award>() {
            @Override
            public int compare(Award o1, Award o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        System.out.println("Awards sorted by date (Ascending)");
    }

    public void sortAwardsByDateDescending() {
        Collections.sort(awards, new Comparator<Award>() {
            @Override
            public int compare(Award o1, Award o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });
        System.out.println("Awards sorted by date (Descending)");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Major: " + major);
        System.out.println("status: " + status);

    }

}
