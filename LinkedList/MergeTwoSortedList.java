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
public class MergeTwoSortedList {
    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(3);
        l1.next.next = new Node(4);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(7);

        Node res = merge(l1, l2);
        while(res != null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }

    public static Node merge(Node n1, Node n2){
        if(n1 == null){
            return n2;
        }

        if(n2 == null){
            return n1;
        }

        if(n1.val <= n2.val){
            n1.next = merge(n1.next, n2);
            return n1;
        }
        else{
            n2.next = merge(n1, n2.next);
            return n2;
        }
    }
}
