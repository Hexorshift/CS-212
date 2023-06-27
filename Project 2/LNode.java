public class LNode {
    private StudentRecord data;
    private LNode next;

    public LNode() {
        this.data = null;
        this.next = null;
    }

    public LNode(StudentRecord data) {
        this.data = data;
        this.next = null;
    }

    public LNode(StudentRecord data, LNode next) {
        this.data = data;
        this.next = next;
    }

    public void setData(StudentRecord data) {
        this.data = data;
    }

    public void setNext(LNode next) {
        this.next = next;
    }

    public StudentRecord getData() {
        return this.data;
    }

    public LNode getNext() {
        return this.next;
    }
}
