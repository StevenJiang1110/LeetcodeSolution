package problem23;

import java.awt.*;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        boolean hasNonEmptyNode = false;
        for(ListNode node : lists){
            if(node != null){
                hasNonEmptyNode = true;
                break;
            }
        }
        if(!hasNonEmptyNode) return null;
        ListNode header = new ListNode(0);
        header.next = null;
        ListNode tail = header;

        boolean hasNonEmptyList = true;
        int listSize = lists.length;
        while(true){
            hasNonEmptyList = false;
            int listIndex = -1;
            for(int i = 0; i < listSize; i++){
                if(lists[i] == null) continue;
                hasNonEmptyList = true;
                if(listIndex == -1) listIndex = i;
                else{
                    if(lists[i].val < lists[listIndex].val){
                        listIndex = i;
                    }
                }
            }
            if(!hasNonEmptyList) break;
            ListNode p = new ListNode(lists[listIndex].val);
            lists[listIndex] = lists[listIndex].next;
            tail.next = p;
            tail = p;
        }
        return header.next;
    }

    public static void main(String... agrs){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
