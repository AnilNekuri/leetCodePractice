package org.leetcode.weekly.july.week1;

import org.leetcode.weekly.july.ListNode;

public class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummyHead = new ListNode();
        ListNode pointer = dummyHead;
        ListNode curr = head;
        while(curr.next != null){
            ListNode node = new ListNode(0);
            do{
                curr = curr.next;
                node.val = node.val+ curr.val;
            }while(curr.val!=0);
            pointer.next = node;
            pointer = pointer.next;
        }
        return dummyHead.next;
    }
}
