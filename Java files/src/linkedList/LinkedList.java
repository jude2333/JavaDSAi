package linkedList;

class Node{
    int data;
    Node next;

    public Node(){}

    public Node(int data) {
        this.data = data;
        this.next = null;// initially
    }
}

public class LinkedList {
    Node head;

    public void add(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null){
//            System.out.println("Currently at node: " + temp.data);
            temp = temp.next;
        }
        temp.next = newNode;

    }

    public void deleteNode(int data){
        if(head.data == data){
            head = head.next;
            return;
        }
//        head = null;
        Node temp = head;
        while(temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

        if(temp.next == null){
            System.out.println("element not found");
        }else{
            temp.next = temp.next.next;
        }


    }
    public void display(){
        if(head == null){
            System.out.println("there are no elements present");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }

        System.out.println("null");


    }


    public void reverseList(){
        Node prev = null;
        Node curr = head;

        while(curr.next != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);

        linkedList.display();

        linkedList.deleteNode(30);

        linkedList.display();
    }

}
