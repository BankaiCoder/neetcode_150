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

public class ReverseLLInKGroups {

private static Node th = null;
private static Node tt = null;


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;

        Node res = reverseKGroups(head, k);
        while(res != null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }

    public static Node reverseKGroups(Node head, int k){
        if(head == null || head.next == null || k == 0) return head;

        Node oh = null,ot = null;
        Node curr = head;
        int len = length(head);
        while(len >= k){
            int tempk = k;
            while(tempk-- > 0){
                Node forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
            }

            if(oh == null){
                oh = th;
                ot = tt;
            }else{
                ot.next = th;
                ot = tt;
            }
            th=null;
            tt=null;
            len -= k;
        }
        ot.next = curr;
        return oh;
    }

    public static void addFirst(Node head){
        if(th == null){
            th = head;
            tt = head;
        }else{
            head.next = th;
            th = head;
        }
        
    }

    public static int length(Node head)
    {
        Node curr = head;
        int len=0;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        return len;
    }
}
