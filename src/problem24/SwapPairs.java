package problem24;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode helperNode = new ListNode(0);
        helperNode.next = head;
        swapNodes(helperNode);
        return helperNode.next;
    }

    public void swapNodes(ListNode node){
        if(node == null) return;
        ListNode p = node.next;
        if(p == null) return;
        ListNode q = p.next;
        if(q == null) return;
        ListNode r = q.next;

        node.next = q;
        q.next = p;
        p.next = r;
        swapNodes(p);
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
