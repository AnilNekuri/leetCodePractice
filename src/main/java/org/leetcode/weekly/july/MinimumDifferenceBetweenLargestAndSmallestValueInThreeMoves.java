package org.leetcode.weekly.july;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    public static void main(String[] args) {
        MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves m = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
        int res = m.minDifference(new int[]{6,6,0,1,1,4,6});
        System.out.println(res);
    }

    public int minDifference(int[] nums) {
        if(nums.length <= 4){
            return 0;
        }
        Arrays.sort(nums);
        int left = 0; int right = nums.length-1;
        int n1 = nums[right]-nums[left+3];
        int n2 = nums[right-3]-nums[left];
        int n3 = nums[right-1]-nums[left+2];
        int n4 = nums[right-2]-nums[left+1];
        return Math.min(n1,Math.min(n2,Math.min(n3,n4)));
    }

    private int rec(int[] nums, int left, int right,int changes) {
        if(left == right){
            return 0;
        }
        if(changes == 0){
            return nums[right] - nums[left];
        }
        int leftMin = rec(nums,left+1,right,changes-1);
        int rightMin = rec(nums,left,right-1,changes-1);
        return Math.min(rightMin,leftMin);
    }
}
