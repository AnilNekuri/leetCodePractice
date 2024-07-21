package org.leetcode.weekly.july.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbersInAMatrix {

    public static void main(String[] args) {
        LuckyNumbersInAMatrix l = new LuckyNumbersInAMatrix();
        List<Integer> res = l.luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}});
        for (int lucky: res) {
            System.out.println(lucky);
        }
        System.out.println();
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[] minIndex = new int[matrix.length];
        Arrays.fill(minIndex,0);

        int[] maxIndex = new int[matrix[0].length];
        Arrays.fill(maxIndex,0);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][minIndex[i]] > matrix[i][j]){
                    minIndex[i] = j;
                }
                if(matrix[maxIndex[j]][j] < matrix[i][j]){
                    maxIndex[j] = i;
                }
            }
        }
        for (int i = 0; i < minIndex.length; i++) {
            if(maxIndex[minIndex[i]] == i){
                res.add(matrix[i][minIndex[i]]);
            }
        }
        return res;
    }
}
