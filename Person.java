/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.cs102.account.management.system;

/**
 *
 * @author xxfoa
 */
public abstract class Person {

    private String firstName;
    private String surname;
    private String username;
    private String password;
    private String dateOfBirth;

    public Person(String firstName, String surname, String username, String password, String dateOfBirth) {

        this.firstName = firstName;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;

    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

        if (dateOfBirth != null && dateOfBirth.length() == 10) {
            if (dateOfBirth.charAt(2) == '/' && dateOfBirth.charAt(5) == '/') {

                String dayStr = dateOfBirth.substring(0, 2);
                String monthStr = dateOfBirth.substring(3, 5);
                String yearStr = dateOfBirth.substring(6);

                if (yearStr.length() != 4) {
                    System.out.println("Year must be exactly 4 digits.");
                    return;
                }

                int day = Integer.parseInt(dayStr);
                int month = Integer.parseInt(monthStr);
                int year = Integer.parseInt(yearStr);

                if (day >= 1 && day <= 31 && month >= 1 && month <= 12) {

                    if (year >= 1900 && year <= 2025) {
                        this.dateOfBirth = dateOfBirth;
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
            System.out.println("Invalid date of birth");
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (firstName == null || firstName.equals("")) {
            System.out.println("Invalid firstName!");
        } else {
            this.firstName = firstName;
        }

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {

        if (surname == null || surname.equals("")) {
            System.out.println("Invalid surName!");
        } else {
            this.surname = surname;
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        if (username != null && Character.isLetter(username.charAt(0)) && username.length() > 0) {
            boolean isVaild = true;
            for (int i = 0; i < username.length(); i++) {
                char ch = username.charAt(i);
                if (!Character.isLetterOrDigit(ch)) {
                    isVaild = false;
                    break;
                }
            }
            if (isVaild) {
                this.username = username;
            } else {
                System.out.println("Username must not contain special characters!");
            }
        } else {
            System.out.println("Invalid username!");
        }

    }

    public String getPassword() {
        return decrypt(password);
    }

    public void setPassword(String password) {

        if (password != null && password.length() >= 6) {
            boolean upper = false;
            boolean lower = false;
            boolean digit = false;
            boolean special = false;
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (Character.isUpperCase(ch)) {
                    upper = true;
                } else if (Character.isLowerCase(ch)) {
                    lower = true;
                } else if (Character.isDigit(ch)) {
                    digit = true;
                } else {
                    special = true;
                }
            }

            if (upper && lower && digit && special) {
                this.password = encrypt(password);
            } else {
                System.out.println("Invalid password!");
            }

        } else {
            System.out.println("Invalid password!");
        }

    }

    public void showInfo() {
        System.out.println("Full Name: " + firstName + " " + surname);
        System.out.println("Username: " + username);
        System.out.println("Date of Birth: " + dateOfBirth);
    }

    private String encrypt(String text) {
        int key = 3;
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            ch = (char) (ch + key);
            result += ch;
        }
        return result;
    }

    private String decrypt(String text) {
        int key = 3;
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            ch = (char) (ch - key);
            result += ch;
        }
        return result;
    }

}
