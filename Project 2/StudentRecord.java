public class StudentRecord extends Student {
    private double GPA;
    private int credits;

    public StudentRecord() {
        super();
        this.GPA = 0.0;
        this.credits = 0;
    }

    public StudentRecord(String id) {
        super(id);
        this.GPA = 0.0;
        this.credits = 0;
    }

    public StudentRecord(String firstName, String lastName, String studentId) {
        super(firstName, lastName, studentId);
        this.GPA = 0.0;
        this.credits = 0;
    }

    public StudentRecord(String firstName, String lastName, String studentId, double GPA, int credits) {
        super(firstName, lastName, studentId);
        this.GPA = GPA;
        this.credits = credits;
    }

    public String toString() {
        return super.toString() + " " + this.GPA + " " + this.credits;
    }

    public double getGPA() {
        return this.GPA;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void addCourse(double courseGrade, int courseCredit) {
        this.GPA = (this.credits * this.GPA + courseCredit * courseGrade) / (this.credits + courseCredit);
        this.credits += courseCredit;
    }
}
