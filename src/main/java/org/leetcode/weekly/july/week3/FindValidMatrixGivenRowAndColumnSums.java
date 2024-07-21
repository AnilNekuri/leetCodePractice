package org.leetcode.weekly.july.week3;

public class FindValidMatrixGivenRowAndColumnSums {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] result = new int[rows][cols];
        int[] currRowSum = new int[rows];
        int[] currColSum = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = Math.min(colSum[j] - currColSum[j],
                        rowSum[i] - currRowSum[i]);
                currRowSum[i] += result[i][j];
                currColSum[j] += result[i][j];
            }
        }
        return result;
    }
}
