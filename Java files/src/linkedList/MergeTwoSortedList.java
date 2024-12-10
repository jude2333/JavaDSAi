package linkedList;

public class MergeTwoSortedList {
    static Node head;
    static Node head2;

    public Node merge(Node l1, Node l2) {
        Node dummy = new Node(0); // Dummy node to simplify merging
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append the remaining nodes
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next; // Return the merged list starting after dummy
    }

    public Node add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public Node add2(int data) {
        Node newNode = new Node(data);
        if (head2 == null) {
            head2 = newNode;
            return head2;
        }
        Node temp = head2;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head2;
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        mergeTwoSortedList.add(1);
        mergeTwoSortedList.add(4);
        mergeTwoSortedList.add2(2);
        mergeTwoSortedList.add2(3);

        Node mergedHead = mergeTwoSortedList.merge(head, head2);
        mergeTwoSortedList.printList(mergedHead); // Print the merged list
    }
}


