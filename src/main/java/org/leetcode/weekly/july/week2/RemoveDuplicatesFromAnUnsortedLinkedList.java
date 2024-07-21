package org.leetcode.weekly.july.week2;

import org.leetcode.weekly.july.ListNode;

import java.util.*;

public class RemoveDuplicatesFromAnUnsortedLinkedList {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        Map<Integer, Integer> map = new HashMap<>();
        ListNode curr = dummyHead.next;
        while(curr!=null){
            int count = map.getOrDefault(curr.val,0);
            map.put(curr.val, count+1);
            curr = curr.next;
        }
        ListNode prev = dummyHead;
        curr = dummyHead.next;
        while(curr!=null){
            int count = map.get(curr.val);
            if(count > 1){
                curr = curr.next;
                prev.next = curr;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }
}
