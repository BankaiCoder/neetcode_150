package neetcode_150.LinkedList;


class Node{
    int val;
    Node next;
    Node random;
    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
    public Node(int val) {
        this.val = val;
    }
    public Node() {
    }

    
}

public class CreateNewListWithRandomPointer {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.next.random = head.next;

        Node res = copy(head);

        while (res != null) {
            System.out.print(res.val+" ");
            res = res.next;
        }

    }

    public static Node copy(Node head){
        if(head == null){
            return null;
        }

        Node curr = head;

        while(curr != null){
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }

        curr = head;
        while(curr != null){
            curr.next.random = (curr.random != null && curr.random.next !=  null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        Node orig=head,copy=head.next;
        Node temp = copy;

        while(orig != null){
            orig.next = orig.next.next;
            orig = orig.next;

            if(copy != null && copy.next != null){
                copy.next = copy.next.next;

            }
            copy=copy.next;
        }
        return temp;
    }
}
