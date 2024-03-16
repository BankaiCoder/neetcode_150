package neetcode_150.LinkedList;

import java.util.PriorityQueue;

class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

public class MergeKSOrtedLists {
    public static void main(String[] args) {
        Node[] list = new Node[3];

        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node list3 = new Node(2);
        list3.next = new Node(6);

        list[0] = list1;
        list[1] = list2;
        list[2] = list3;

        printList(mergeList(list));
    }

public static void printList(Node head){
    Node curr = head;
    while (curr != null) {
        System.out.print(curr.val+" ");
        curr = curr.next;
    }System.out.println();
}


//approach using priorityQueue
    public static Node mergeList(Node[] lists){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{return a.val-b.val;});
        
        for(Node l : lists) if(l != null) pq.add(l);

        Node dummy = new Node(-1);
        Node prev = dummy;

        while(pq.size() != 0){
            Node node = pq.remove();

            prev.next = node;
            prev = prev.next;
            node = node.next;

            if(node != null) pq.add(node);
        }

        return dummy.next;
    }

    //approach using mergeSort i.e devide and conquer
    
}
