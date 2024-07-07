package org.leetcode.weekly.july;

public class WaterBottles {
    public static void main(String[] args) {
        WaterBottles w = new WaterBottles();
        int r = w.numWaterBottles(9,3);
        System.out.println(r);
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        int remaining = 0;
        int totalBottles = numBottles;
        while (numBottles >= numExchange){
            totalBottles += numBottles/numExchange;
            numBottles = numBottles/numExchange + numBottles%numExchange;
        }
        return totalBottles;
    }
}
