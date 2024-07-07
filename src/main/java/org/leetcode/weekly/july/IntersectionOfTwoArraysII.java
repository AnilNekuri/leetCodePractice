package org.leetcode.weekly.july;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] memory = new int[1001];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            memory[nums1[i]] += 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            if(memory[nums2[i]] > 0){
                res.add(nums2[i]);
                memory[nums2[i]] -= 1;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
