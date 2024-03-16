package neetcode_150.LinkedList;

class Node{
    int val;
    Node next;
    
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    
    }
    public Node(int val) {
        this.val = val;
    }
    public Node() {
    }

    
}

public class ReorderList {

    private static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(3);
        l1.next.next = new Node(4);
        l1.next.next.next = new Node(5);
        l1.next.next.next.next = new Node(6);
        l1.next.next.next.next.next = new Node(7);

        printLinkedList(l1);

        reorderList(l1);
       
        printLinkedList(l1);
    }

    public static void reorderList(Node head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }

        //split the LinkedList in two halfes
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        Node second = slow.next;
        slow.next = null;

        //reverse the second half
        Node prev = null;
        Node curr = second;
        Node nextNode;
        while(curr != null){
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        second = prev;

        //Merge Both linked list
        Node p1 = head;
        Node p2 = second;

        while(p1 != null && p2 != null){
            Node temp1 = p1.next;
            Node temp2 = p2.next;

            p1.next = p2;
            p2.next = temp1;
            p1=temp1;
            p2=temp2;
        }
    }
}
