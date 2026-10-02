/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.cs102.account.management.system;

/**
 *
 * @author xxfoa
 */
public class Award implements Comparable<Award> {

    private String name;
    private String issuer;
    private String Date;

    public Award(String name, String issuer, String Date) {
        setName(name);
        setIssuer(issuer);
        setDate(Date);
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        try {
            if (Date != null && Date.length() == 10) {
                if (Date.charAt(2) == '/' && Date.charAt(5) == '/') {

                    String dayStr = Date.substring(0, 2);
                    String monthStr = Date.substring(3, 5);
                    String yearStr = Date.substring(6);

                    if (yearStr.length() != 4) {
                        System.out.println("Year must be exactly 4 digits.");
                        return;
                    }

                    int day = Integer.parseInt(dayStr);
                    int month = Integer.parseInt(monthStr);
                    int year = Integer.parseInt(yearStr);

                    if (day >= 1 && day <= 31 && month >= 1 && month <= 12) {

                        if (year >= 1900 && year <= 2025) {
                            this.Date = Date;
                        } else {
                            System.out.println("Year must be between 1900 and 2025");
                        }
                    } else {
                        System.out.println("Day must be 01-31 and Month must be 01-12");
                    }
                } else {
                    System.out.println("Use format dd/mm/yyyy");
                }
            } else {
                System.out.println("Invalid date");
            }
        } catch (Exception e) {
            System.out.println("Error setting date: " + e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.equals("")) {
            System.out.println("Invalid Name!");
        } else {
            this.name = name;
        }

    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        if (issuer == null || issuer.equals("")) {
            System.out.println("Invalid firstName!");
        } else {
            this.issuer = issuer;
        }
    }

    public void showAward() {
        System.out.println("Name: " + name);
        System.out.println("Issuer: " + issuer);
        System.out.println("Date: " + Date);
    }

    @Override
    public int compareTo(Award o) {
        System.out.println("Awards sorted by name (Ascending)");
        return this.name.compareToIgnoreCase(o.getName());
    }
}
