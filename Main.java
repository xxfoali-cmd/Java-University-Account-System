/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.cs102.account.management.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author xxfoa
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Person> users = loadUsersFrom();

        while (true) {
            System.out.println("\n==== PSU SYSTEM MENU ====");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                sginUp(users, input);
            } else if (choice == 2) {
                SignIn(users, input);
            } else if (choice == 3) {
                saveUsersToFile(users);
                System.out.println("Exiting the program...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    public static void sginUp(ArrayList<Person> users, Scanner input) {
        System.out.println("\n-- Sign Up --");
        System.out.println("Choose account type:");
        System.out.println("1. Student");
        System.out.println("2. Faculty");
        System.out.println("3. Support and Services");
        int type = input.nextInt();
        input.nextLine();

        String fname;
        while (true) {
            System.out.print("First Name: ");
            fname = input.nextLine().trim();
            if (!fname.isEmpty()) {
                break;
            }
            System.out.println("First name cannot be empty.");
        }

        String sname;
        while (true) {
            System.out.print("Surname: ");
            sname = input.nextLine().trim();
            if (!sname.isEmpty()) {
                break;
            }
            System.out.println("Surname cannot be empty.");
        }

        String username;
        while (true) {
            System.out.print("Username: ");
            username = input.nextLine().trim();

            if (username.isEmpty()) {
                System.out.println("Username cannot be empty.");
                continue;
            }

            if (!Character.isLetter(username.charAt(0))) {
                System.out.println("Username must start with a letter.");
                continue;
            }

            boolean isValid = true;
            for (char c : username.toCharArray()) {
                if (!Character.isLetterOrDigit(c)) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) {
                System.out.println("Username must contain only letters or digits.");
                continue;
            }

            boolean exists = false;
            for (Person p : users) {
                if (p.getUsername().equalsIgnoreCase(username)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                System.out.println("Username already exists. Try another.");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            System.out.print("Password: ");
            password = input.nextLine();

            if (password.length() < 6) {
                System.out.println("Password must be at least 6 characters.");
                continue;
            }

            boolean upper = false, lower = false, digit = false, special = false;
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    upper = true;
                } else if (Character.isLowerCase(c)) {
                    lower = true;
                } else if (Character.isDigit(c)) {
                    digit = true;
                } else {
                    special = true;
                }
            }

            if (upper && lower && digit && special) {
                break;
            } else {
                System.out.println("Password must contain uppercase, lowercase, digit, and special character.");
            }
        }

        String dob;
        while (true) {
            System.out.print("Date of Birth (dd/mm/yyyy): ");
            dob = input.nextLine();
            if (isValidDate(dob)) {
                break;
            } else {
                System.out.println("Invalid date. Format must be dd/mm/yyyy and realistic values.");
            }
        }

        if (type == 1) {
            String major;
            while (true) {
                System.out.print("Major: ");
                major = input.nextLine().trim();
                if (!major.isEmpty()) {
                    break;
                }
                System.out.println("Major cannot be empty.");
            }

            String status;
            while (true) {
                System.out.println("Status: (Freshman/Sophomore/Junior/Senior)");
                status = input.nextLine();
                if (status.equalsIgnoreCase("Freshman")
                        || status.equalsIgnoreCase("Sophomore")
                        || status.equalsIgnoreCase("Junior")
                        || status.equalsIgnoreCase("Senior")) {
                    break;
                } else {
                    System.out.println("Invalid input Please enter a valid status.");
                }
            }
            users.add(new Students(fname, sname, username, password, dob, major, status));
            System.out.println("Student registered");
        } else if (type == 2) {
            String dept;
            while (true) {
                System.out.print("Department: ");
                dept = input.nextLine().trim();
                if (!dept.isEmpty()) {
                    break;
                }
                System.out.println("Department cannot be empty.");
            }

            String office;
            while (true) {
                System.out.print("Office Number: ");
                office = input.nextLine().trim();
                if (!office.isEmpty()) {
                    break;
                }
                System.out.println("Office number cannot be empty.");
            }
            String rank;
            while (true) {
                System.out.println("Rank: (Lecturer/Assistant Professor/Associate Professor/Professor)");
                rank = input.nextLine();
                if (rank.equalsIgnoreCase("Lecturer")
                        || rank.equalsIgnoreCase("Assistant Professor")
                        || rank.equalsIgnoreCase("Associate Professor")
                        || rank.equalsIgnoreCase("Professor")) {
                    break;
                } else {
                    System.out.println("Invalid rank. Please try again.");
                }
            }

            String spec;
            while (true) {
                System.out.print("Specialization: ");
                spec = input.nextLine().trim();
                if (!spec.isEmpty()) {
                    break;
                }
                System.out.println("Specialization cannot be empty.");
            }

            users.add(new Faculty(rank, spec, dept, office, fname, sname, username, password, dob));
            System.out.println("Faculty registered");
        } else if (type == 3) {
            String dept;
            while (true) {
                System.out.print("Department: ");
                dept = input.nextLine().trim();
                if (!dept.isEmpty()) {
                    break;
                }
                System.out.println("Department cannot be empty.");
            }
            String office;
            while (true) {
                System.out.print("Office Number: ");
                office = input.nextLine().trim();
                if (!office.isEmpty()) {
                    break;
                }
                System.out.println("Office number cannot be empty.");
            }

            String job;
            while (true) {
                System.out.print("Job Description: ");
                job = input.nextLine().trim();
                if (!job.isEmpty()) {
                    break;
                }
                System.out.println("Job description cannot be empty.");
            }

            users.add(new SupportAndServicesEmployee(job, dept, office, fname, sname, username, password, dob));
            System.out.println("Support staff registered");
        } else {
            System.out.println("Invalid type!");
        }

    }

    public static void SignIn(ArrayList<Person> users, Scanner input) {

        System.out.println("\n-- Sign In --");
        int attempts = 0;

        while (attempts < 3) {
            System.out.println("Username: ");
            String username = input.nextLine();
            System.out.println("Password: ");
            String password = input.nextLine();

            for (Person p : users) {

                if (p.getUsername().equals(username) && p.getPassword().equals(password)) {
                    System.out.println("Welcome " + p.getFirstName());

                    if (p instanceof Students) {
                        studentMenu((Students) p, input);
                    } else {
                        userMenu(p, input);
                    }
                    return;
                }
            }

            System.out.println("Incorrect. please try again");
            attempts++;
        }

        System.out.println("Too many attempts. Returning to main menu");
    }

    public static void userMenu(Person user, Scanner input) {
        while (true) {
            System.out.println("\n==== User Menu ====");
            System.out.println("1. Show Info");
            System.out.println("2. change Name");
            System.out.println("3. change password");
            System.out.println("Logout");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                user.showInfo();
            } else if (choice == 2) {
                System.out.println("Enter new first name: ");
                String newfname = input.nextLine();
                System.out.println("Enter new surname: ");
                String newsname = input.nextLine();
                user.setFirstName(newfname);
                user.setSurname(newsname);
            } else if (choice == 3) {
                System.out.println("Enter new password: ");
                String pass1 = input.nextLine();
                System.out.println("Re-enter new password: ");
                String pass2 = input.nextLine();

                if (pass1.equals(pass2)) {
                    user.setPassword(pass1);
                } else {
                    System.out.println("Passwords do not match don't match try again");
                }
            } else if (choice == 4) {
                System.out.println("Logging out...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    public static void awardsMenu(Students student, Scanner input) {
        while (true) {
            System.out.println("\n==== Awards Menu ====");
            System.out.println("1. Add Award");
            System.out.println("2. show All Awards");
            System.out.println("3. Back to Student Menu");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.println("Award name: ");
                String AwardName = input.nextLine();
                System.out.println("Issuer: ");
                String issuer = input.nextLine();
                System.out.println("Date (dd/mm/yyyy)");
                String date = input.nextLine();
                student.addAwards(AwardName, issuer, date);

            } else if (choice == 2) {
                System.out.println("do you want the awards to be sorted? (yes/no)");
                String answer = input.nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    System.out.println("1. By Name Ascending");
                    System.out.println("2. By Name Descending");
                    System.out.println("3. By Date Ascending");
                    System.out.println("4. By Date Descending");
                    int sortChoice = input.nextInt();
                    input.nextLine();

                    if (sortChoice == 1) {
                        student.showAllAwards();
                    } else if (sortChoice == 2) {
                        student.sortAwardsByNameDescending();
                        student.showAllAwards();
                    } else if (sortChoice == 3) {
                        student.sortAwardsByDateAscending();
                        student.showAllAwards();
                    } else if (sortChoice == 4) {
                        student.sortAwardsByDateDescending();
                        student.showAllAwards();
                    } else if (answer.equalsIgnoreCase("no")) {
                        student.showAllAwards();
                    } else {
                        System.out.println("Invalid sort choice.");
                    }
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    public static void studentMenu(Students student, Scanner input) {

        while (true) {
            System.out.println("\n===== Student Menu =====");
            System.out.println("1. Show Info");
            System.out.println("2. Change First Name");
            System.out.println("3. Change Password");
            System.out.println("4. Awards Menu");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                student.showInfo();
            } else if (choice == 2) {
                System.out.print("Enter new first name: ");
                String NewFname = input.nextLine();
                System.out.print("Enter new surname: ");
                String NewSname = input.nextLine();
                student.setFirstName(NewFname);
                student.setSurname(NewSname);
            } else if (choice == 3) {
                System.out.print("Enter new password: ");
                String pass1 = input.nextLine();
                System.out.print("Re-enter new password: ");
                String pass2 = input.nextLine();

                if (pass1.equals(pass2)) {
                    student.setPassword(pass1);
                } else {
                    System.out.println("Passwords do not match. please Try again.");
                }

            } else if (choice == 4) {
                awardsMenu(student, input);

            } else if (choice == 5) {
                System.out.println("Logging out...");
                break;

            } else {
                System.out.println("Invalid choice");
            }

        }
    }

    public static void saveUsersToFile(ArrayList<Person> users) {
        try {
            PrintWriter pw = new PrintWriter("users.txt");
            for (Person user : users) {
                if (user instanceof Students) {
                    Students s = (Students) user;
                    pw.println("Student|" + s.getFirstName() + "|" + s.getSurname() + "|" + s.getUsername() + "|" + s.getPassword() + "|"
                            + s.getDateOfBirth() + "|" + s.getMajor() + "|" + s.getStatus());
                } else if (user instanceof Faculty) {
                    Faculty f = (Faculty) user;
                    pw.println("Faculty|" + f.getFirstName() + "|" + f.getSurname() + "|" + f.getUsername() + "|" + f.getPassword() + "|"
                            + f.getDateOfBirth() + "|" + f.getDepartment() + "|" + f.getOfficeNuber() + "|" + f.getRank() + "|" + f.getSpecialization());
                } else if (user instanceof SupportAndServicesEmployee) {
                    SupportAndServicesEmployee e = (SupportAndServicesEmployee) user;
                    pw.println("Support|" + e.getFirstName() + "|" + e.getSurname() + "|" + e.getUsername() + "|" + e.getPassword() + "|"
                            + e.getDateOfBirth() + "|" + e.getDepartment() + "|" + e.getOfficeNuber() + "|" + e.getJobDescription());
                }
            }
            pw.close();
            System.out.println("Users saved to file");
        } catch (FileNotFoundException ex) {
            System.out.println("Error saving users " + ex.getMessage());
        }
    }

    public static ArrayList<Person> loadUsersFrom() {
        ArrayList<Person> users = new ArrayList<>();
        File file = new File("users.txt");

        if (!file.exists()) {
            return users;
        }

        try {
            Scanner inFile = new Scanner(file);
            while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
                String[] parts = line.split("\\|");
                String type = parts[0];

                if (type.equalsIgnoreCase("Student")) {
                    users.add(new Students(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]));
                } else if (type.equalsIgnoreCase("Faculty")) {
                    users.add(new Faculty(parts[8], parts[9], parts[6], parts[7], parts[1], parts[2], parts[3], parts[4], parts[5]));
                } else if (type.equalsIgnoreCase("Support")) {
                    users.add(new SupportAndServicesEmployee(parts[8], parts[6], parts[7], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
            inFile.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error loading users " + ex.getMessage());
        }
        return users;
    }

    public static boolean isValidDate(String dateStr) {
        if (dateStr == null || dateStr.length() != 10) {
            return false;
        }
        if (dateStr.charAt(2) != '/' || dateStr.charAt(5) != '/') {
            return false;
        }

        try {
            int day = Integer.parseInt(dateStr.substring(0, 2));
            int month = Integer.parseInt(dateStr.substring(3, 5));
            int year = Integer.parseInt(dateStr.substring(6));

            return (day >= 1 && day <= 31)
                    && (month >= 1 && month <= 12)
                    && (year >= 1900 && year <= 2025);
        } catch (Exception e) {
            return false;
        }
    }

}
