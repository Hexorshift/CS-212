public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private String studentID;

    public Student() {
        this.firstName = null;
        this.lastName = null;
        this.studentID = "0";
    }

    public Student(String firstName, String lastName, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentId;
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.studentID + "\n";
    }

    public int compareTo(Student other) {
        int val = this.lastName.compareTo(other.lastName);
        if (val == 0) {
            val = this.firstName.compareTo(other.firstName);
        }
        return val;
    }

    public boolean equals(Student other) {
        return this.studentID.equals(other.studentID);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}