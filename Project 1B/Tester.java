import java.util.Scanner;

public class Tester {
    public static void main(String args[]) {
        Student student;
        SortedLinkedList students = new SortedLinkedList();

        String f, l, id;
        Scanner kybd = new Scanner(System.in);

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

        System.out.println(students.toString());
        kybd.close();
    }

    public static void addEmployee(SortedLinkedList students) {
    }
}
