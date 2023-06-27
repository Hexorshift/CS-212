import java.util.Scanner;

public class Tester {
    public static Scanner kybd = new Scanner(System.in);

    public static void main(String args[]) {
        Student student;
        String f, l, id;
        SortedLinkedList students = new SortedLinkedList();

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter first name");
            f = kybd.next();
            System.out.println("Enter last name");
            l = kybd.next();
            System.out.println("Enter ID number");
            id = kybd.next();
            student = new Student(f, l, id);
            students.insertSorted(student);
        }

        System.out.println("");
        System.out.println(students.toString());

        try {
            System.out.println("Search for a student by ID");
            id = kybd.next();
            student = new Student(id);
            System.out.println(students.searchId(student).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        kybd.close();
    }
}
