public class SortedLinkedList {
    private LNode head;

    public SortedLinkedList() {
        this.head = new LNode();
    }

    public boolean isEmpty() {
        return this.head.getNext() == null;
    }

    public void clear() {
        this.head.setNext(null);
    }

    public void insertSorted(StudentRecord x) {
        LNode prevNode = this.head;
        LNode currNode = this.head.getNext();

        while (currNode != null && x.compareTo(currNode.getData()) > 0) {
            prevNode = currNode;
            currNode = currNode.getNext();
        }

        prevNode.setNext(new LNode(x, currNode));
    }

    public void deleteSorted(Student x) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Empty list.");
        }

        LNode prevNode = this.head;
        LNode currNode = this.head.getNext();

        while (currNode != null && x.compareTo(currNode.getData()) != 0) {
            prevNode = currNode;
            currNode = currNode.getNext();
        }

        if (currNode == null) {
            throw new Exception("Student not found.");
        }

        prevNode.setNext(currNode.getNext());
    }

    public StudentRecord searchSorted(StudentRecord x) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("The list is empty.");
        }

        LNode currNode = this.head.getNext();

        while (currNode != null && x.compareTo(currNode.getData()) > 0) {
            currNode = currNode.getNext();
        }

        if (currNode == null || currNode.getData().compareTo(x) != 0) {
            throw new Exception("Student not found.");
        }

        return currNode.getData();
    }

    public StudentRecord searchId(StudentRecord student) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("The list is empty.");
        }

        LNode currNode = this.head.getNext();

        while (currNode != null && !student.equals(currNode.getData())) {
            currNode = currNode.getNext();
        }

        if (currNode == null) {
            throw new Exception("Student not found.");
        }

        return currNode.getData();
    }

    public String toString() {
        String s = "";
        LNode currNode = head.getNext();

        while (currNode != null) {
            s += currNode.getData().toString() + "\n";
            currNode = currNode.getNext();
        }

        return s;
    }
}
