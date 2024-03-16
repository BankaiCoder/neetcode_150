//package neetcode_150.LinkedList;


class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

public class RemoveNthNodeFormEndOfLL {
    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(3);
        l1.next.next = new Node(4);
        l1.next.next.next = new Node(5);
        l1.next.next.next.next = new Node(6);
        l1.next.next.next.next.next = new Node(7);

        int n = 2;

        Node res = removeNthNode(l1, n);
        while(res!=null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }

    public static Node removeNthNode(Node head, int n){
        Node dummy = new Node(-1);//-->you can give zero as well
        dummy.next = head;

        Node firstNode = dummy;
        Node secondNode = dummy;

        //Move second Node n space ahead
        for(int i=0;i<n;i++){
            secondNode = secondNode.next;
        }

        while(secondNode.next != null){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        firstNode.next = firstNode.next.next;
        return dummy.next;
    }
}
