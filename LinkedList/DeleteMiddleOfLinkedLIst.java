package neetcode_150.LinkedList;


 class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
 }
public class DeleteMiddleOfLinkedLIst {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(6);

        Node res = delete(head);
        while(res != null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }

    public static Node delete(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node prev = null;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev != null){
            prev.next = slow.next;
        }
        else{
            head = slow.next;
        }
        return head;
    }
}
