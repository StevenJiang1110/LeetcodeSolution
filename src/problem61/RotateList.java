package problem61;


public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode p = head;
        ListNode tail = p;
        int len = 0;
        while(p!=null){
            len ++;
            tail = p;
            p = p.next;
        }
        if(len == 0) return head;
        tail.next = head;
        p = head;

        int count = 0;
        while (p != null){
            count ++;
            if(count == len * (k / len + 1)  - k){
                ListNode q  = p.next;
                p.next = null;
                return q;
            }
            p = p.next;
        }
        return head;
    }

    public static void main(String... args){
        System.out.println(-1%4);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
