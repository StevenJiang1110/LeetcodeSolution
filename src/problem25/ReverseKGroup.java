package problem25;

import java.util.List;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1) return head;
        ListNode helperNode = new ListNode(0);
        helperNode.next = head;
        swapKNodes(helperNode, k);
        return helperNode.next;
    }

    public void swapKNodes(ListNode node, int k){
        if(node == null || node.next == null) return;
        ListNode[] nodes = new ListNode[k];
        int i = 0;
        ListNode currentNode = node;
        while (i < k){
            if(currentNode.next == null) break;
            nodes[i] = currentNode.next;
            currentNode = nodes[i];
            i++;
        }
        int NodeSize = i - 1;
        if(NodeSize < k - 1) return;
        ListNode nextNode = nodes[NodeSize].next;
        node.next = nodes[NodeSize];
        nodes[0].next = nextNode;
        for(int j = NodeSize; j > 0 ; j--){
            nodes[j].next = nodes[j-1];
        }
        swapKNodes(nodes[0],k);
    }

    public void printList(ListNode node){
        if(node == null){
            System.out.print("\n");
            return;
        }
        System.out.print(node.val + "\t");
        printList(node.next);
    }

    public static void main(String... args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new ReverseKGroup().printList(node1);
        ListNode node = new ReverseKGroup().reverseKGroup(node1, 3);
        new ReverseKGroup().printList(node);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
