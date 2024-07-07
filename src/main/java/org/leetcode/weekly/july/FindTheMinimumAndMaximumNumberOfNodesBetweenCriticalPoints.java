package org.leetcode.weekly.july;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public static void main(String[] args) {
        FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints f = new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints();
        ListNode dummyHead = new ListNode();
        ListNode pointer = dummyHead;
        int[] n = new int[]{5,3,1,2,5,1,2};
        for (int i = 0; i < n.length; i++) {
            pointer.next = new ListNode(n[i]);
            pointer = pointer.next;
        }
        int[] res = f.nodesBetweenCriticalPoints(dummyHead.next);
        System.out.println(res);
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int fcp = -1;
        int pcp = -1;
        int ccp = -1;
        int min = Integer.MAX_VALUE;
        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode next = curr.next;
        int i = 1;
        while (next!= null){
            if((prev.val < curr.val && curr.val > next.val) ||
                    (prev.val > curr.val && curr.val < next.val)){
                if(fcp == -1){
                    fcp = i;
                }
                if(ccp!=-1){
                    pcp = ccp;
                }
                ccp = i;
                if(pcp != -1){
                    min = Math.min(ccp-pcp,min);
                }
            }
            prev = curr;
            curr = next;
            next = next.next;
            i++;
        }
        if(fcp == -1 || pcp == -1){
            return new int[]{-1,-1};
        }
        return new int[]{min,ccp-fcp};
    }
}
