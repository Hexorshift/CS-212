public class LNode {
    Student data;
    LNode next;

    public LNode() {
        this.data = null;
        this.next = null;
    }

    public LNode(Student data) {
        this.data = data;
        this.next = null;
    }

    public LNode(Student data, LNode next) {
        this.data = data;
        this.next = next;
    }

    public void setData(Student data) {
        this.data = data;
    }

    public void setNext(LNode next) {
        this.next = next;
    }

    public Student getData() {
        return this.data;
    }

    public LNode getNext() {
        return this.next;
    }
}
