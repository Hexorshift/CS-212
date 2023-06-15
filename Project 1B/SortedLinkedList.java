public class SortedLinkedList {
    private LNode head;

    public SortedLinkedList() {
        this.head = new LNode();
    }

    public boolean isEmpty() {
        return this.head.getNext() == null;
    }

    public void insertSorted(Student x) {
        LNode prevNode = this.head;
        LNode currNode = this.head.next;

        while (currNode != null && x.compareTo(currNode.data) > 0) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        prevNode.next = new LNode(x, currNode);
    }

    public void deleteSorted(Student x) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Empty list.");
        } else {
            LNode prevNode = this.head;
            LNode currNode = this.head.next;

            while (currNode != null && x.compareTo(currNode.data) > 0) {
                prevNode = currNode;
                currNode = currNode.next;
            }

            if (currNode == null) {
                throw new Exception("Student not found.");
            } else {
                prevNode.next = currNode.next;
            }
        }
    }

    public Student searchSorted(Student x) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Empty list.");
        }

        LNode currNode = this.head.next;

        while (currNode != null && (x.compareTo(currNode.data) > 0)) {
            currNode = currNode.next;
        }

        if (currNode == null) {
            throw new Exception("Student not found.");
        }

        return currNode.data;
    }

    public Student searchId(Student student) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Empty list.");
        }

        LNode currNode = this.head.next;

        while (currNode != null && !student.equals(currNode.data)) {
            currNode = currNode.next;
        }

        if (currNode == null) {
            throw new Exception("Student not found.");
        }

        return currNode.data;
    }

    public String toString() {
        String s = "";
        LNode currNode = head.next;

        while (currNode != null) {
            s += currNode.data.toString() + "\n";
            currNode = currNode.next;
        }

        return s;
    }
}
