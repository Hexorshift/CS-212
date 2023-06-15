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
        } else {
            LNode prevNode = this.head;
            LNode currNode = this.head.getNext();

            while (currNode != null && x.compareTo(currNode.getData()) > 0) {
                prevNode = currNode;
                currNode = currNode.getNext();
            }

            if (currNode == null) {
                throw new Exception("Student not found.");
            } else {
                prevNode.setNext(currNode.getNext());
            }
        }
    }

    public Student searchSorted(Student x) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Empty list.");
        }

        LNode currNode = this.head.getNext();

        while (currNode != null && (x.compareTo(currNode.getData()) > 0)) {
            currNode = currNode.getNext();
        }

        if (currNode == null) {
            throw new Exception("Student not found.");
        }

        return currNode.getData();
    }

    public Student searchId(Student student) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Empty list.");
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
