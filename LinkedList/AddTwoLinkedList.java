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
public class AddTwoLinkedList {
    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        Node res = sum(l1, l2);
        while(res != null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }

    public static Node sum(Node l1,Node l2){
        Node result = new Node(0);
        Node ptr = result;
        int carry = 0;

        while(l1 != null || l2 != null){
            int sum = +carry;

            if(l1 != null){
                sum+=l1.val;
                l1=l1.next;
            }

            if(l2 != null){
                sum+=l2.val;
                l2=l2.next;
            }

            carry = sum/10;
            sum = sum%10;
            ptr.next = new Node(sum);
            ptr = ptr.next;
        }

        if(carry == 1){
            ptr.next = new Node(1);
        }
        return result.next;
    }
}
