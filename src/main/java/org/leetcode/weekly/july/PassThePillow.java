package org.leetcode.weekly.july;

public class PassThePillow {

    public static void main(String[] args) {
        PassThePillow p = new PassThePillow();
        int res = p.passThePillow(4,5);
        System.out.println(res);
    }
    public int passThePillow(int n, int time) {
        int e = n-1;
        if((time/e)%2==0){
            return 1+(time%e);
        }else{
            return n-(time%e);
        }
    }
}
