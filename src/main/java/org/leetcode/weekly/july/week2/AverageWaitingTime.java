package org.leetcode.weekly.july.week2;

public class AverageWaitingTime {
    public static void main(String[] args) {
        AverageWaitingTime a = new AverageWaitingTime();
        //double res = a.averageWaitingTime(new int[][]{{1,2},{2,5},{4,3}});
        double res = a.averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}});
        //double res = a.averageWaitingTime(input);
        System.out.println(res);

    }
    public double averageWaitingTime(int[][] customers) {
        int startTime = 0;
        long waitTime = 0;
        for (int i = 0; i < customers.length; i++) {
            startTime = Math.max(startTime,customers[i][0]);
            int servingTime = startTime + customers[i][1];
            waitTime += (servingTime - customers[i][0]);
            startTime = servingTime;
        }
        return (1.0 * waitTime)/customers.length;
    }
}
