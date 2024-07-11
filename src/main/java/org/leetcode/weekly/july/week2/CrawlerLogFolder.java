package org.leetcode.weekly.july.week2;

public class CrawlerLogFolder {
    public static void main(String[] args) {
        CrawlerLogFolder c = new CrawlerLogFolder();
        int res = c.minOperations(new String[]{"d1/","d2/","../","d21/","./"});
        System.out.println(res);
    }
    public int minOperations(String[] logs) {
        int op = 0;
        for (int i = 0; i < logs.length; i++) {
            if(logs[i].equals("../")) {
                if(op > 0){
                    op--;
                }
            }else if(!logs[i].equals("./")){
                op++;
            }
        }
        return op;
    }
}
