import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    private static Scanner scnr;
    private static boolean exit;
    private static SortedLinkedList students;

    public static void main(String[] args) {
        scnr = new Scanner(System.in);
        exit = false;
        students = new SortedLinkedList();

        clearConsole();
        System.out.println("Welcome to the student management system!\n");

        while (!exit) {
            printMenu();
            getChoice();
        }

        scnr.close();
        System.out.print("Thank you for using the student management system.");
    }

    public static void printMenu() {
        System.out.println("1. Load student records from file");
        System.out.println("2. Add a new student");
        System.out.println("3. Remove an existing student");
        System.out.println("4. Look up student information (search by name or id)");
        System.out.println("5. Add a course to a student");
        System.out.println("6. Display student information");
        System.out.println("7. Save student records to file");
        System.out.println("8. Exit the program\n");
    }

    public static void getChoice() {
        System.out.print("Enter your choice: ");
        String choice = scnr.next();

        clearConsole();
        switch (choice) {
            case "1":
                loadFile();
                break;
            case "2":
                addStudent();
                break;
            case "3":
                removeStudent();
                break;
            case "4":
                searchStudent();
                break;
            case "5":
                addCourseToStudent();
                break;
            case "6":
                displayStudents();
                break;
            case "7":
                saveRecords();
                break;
            case "8":
                exit = true;
                break;
            default:
                printMenu();
                getChoice();
                break;
        }
    }

    public static void clearConsole() {
        System.out.print("\033\143");
    }

    public static void loadFile() {
        System.out.print("Please enter the path of the student records file: ");
        String filePath = scnr.next();

        try {
            students.clear();
            File studentsFile = new File(filePath);
            Scanner inFile = new Scanner(studentsFile);
            int i = 0;

            while (inFile.hasNext()) {
                String firstName = inFile.next();
                String lastName = inFile.next();
                String id = inFile.next();
                double GPA = inFile.nextDouble();
                int credits = inFile.nextInt();

                students.insertSorted(new StudentRecord(firstName, lastName, id, GPA, credits));
                i++;
            }

            clearConsole();
            System.out.println("Loaded " + i + " students into memory.\n");
            inFile.close();
        } catch (Exception e) {
            System.out.println("The file could not be opened, please try again.\n");
            loadFile();
        }
    }

    public static void addStudent() {
        String firstName, lastName, id;

        System.out.println("Please enter the student's first name: ");
        firstName = scnr.next();

        System.out.println("Please enter the student's last name: ");
        lastName = scnr.next();

        System.out.println("Please enter the student's id: ");
        id = scnr.next();

        students.insertSorted(new StudentRecord(firstName, lastName, id));
        clearConsole();
        System.out.println("Added " + firstName + " " + lastName + " to the students list.\n");
    }

    public static void removeStudent() {
        try {
            String firstName, lastName;

            System.out.println("Please enter the student's first name: ");
            firstName = scnr.next();

            System.out.println("Please enter the student's last name: ");
            lastName = scnr.next();

            students.deleteSorted(new StudentRecord(firstName, lastName, ""));
            clearConsole();
            System.out.println("Deleted " + firstName + " " + lastName + " from memory.\n");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
            removeStudent();
        }
    }

    public static StudentRecord searchStudent() {
        try {
            System.out.println("1. Search student by name");
            System.out.println("2. Search student by id" + "\n");
            System.out.print("Enter choice: ");

            String choice = scnr.next();

            clearConsole();
            StudentRecord foundStudent = null;

            switch (choice) {
                case "1":
                    System.out.print("Please enter student name: ");
                    String firstName = scnr.next();
                    String lastName = scnr.next();

                    foundStudent = students.searchSorted(new StudentRecord(firstName, lastName, ""));
                    clearConsole();
                    System.out.println(foundStudent.toString() + "\n");
                    break;
                case "2":
                    System.out.print("Please enter student id: ");
                    String id = scnr.next();

                    foundStudent = students.searchId(new StudentRecord(id));
                    clearConsole();
                    System.out.println(foundStudent.toString() + "\n");
                    break;
                default:
                    searchStudent();
                    break;
            }

            return foundStudent;
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
            searchStudent();
        }

        return null;
    }

    public static void displayStudents() {
        System.out.println(students.toString());
    }

    public static void addCourseToStudent() {
        StudentRecord foundStudent = searchStudent();
        double courseGrade;
        int credits;

        clearConsole();
        System.out.print("Please enter the course grade: ");
        courseGrade = scnr.nextDouble();

        System.out.print("Please enter the course credit: ");
        credits = scnr.nextInt();

        foundStudent.addCourse(courseGrade, credits);
        clearConsole();
        System.out.println(
                "A new course grade was added to " + foundStudent.getFirstName() + " " + foundStudent.getLastName() +
                        ".\n");
    }

    public static void saveRecords() {
        try {
            System.out.print("Please enter the path of the student records file: ");
            String filePath = scnr.next();
            PrintWriter outFile = new PrintWriter(new File(filePath));

            try {
                outFile.print(students.toString());
                clearConsole();
                System.out.println("The student records were saved to " + filePath + "\n");
            } finally {
                outFile.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            saveRecords();
        }
    }
}
