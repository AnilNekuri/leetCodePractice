package org.leetcode.weekly.july.week2;

public class MaximumScoreFromRemovingSubstrings {

    public static void main(String[] args) {
        MaximumScoreFromRemovingSubstrings m = new MaximumScoreFromRemovingSubstrings();
        int res = m.maximumGain("aabbaaxybbaabb",5,4);
        System.out.println(res);

    }
    public int maximumGain(String s, int x, int y) {
        int score = 0;
        StringBuilder sb = new StringBuilder(s);
        if(x > y){
            score += calcScoreAb(sb,x);
            score += calcScoreBa(sb,y);
        }else{
            score += calcScoreBa(sb,y);
            score += calcScoreAb(sb,x);

        }
        return score;
    }

    private int calcScoreAb(StringBuilder sb, int x){
        int index = 0;
        int score = 0;
        while(index < sb.length()-1){
            if(sb.charAt(index) == 'a' && sb.charAt(index+1) == 'b'){
                score += x;
                sb.deleteCharAt(index);
                sb.deleteCharAt(index);
                if(index !=0 && sb.charAt(index-1) == 'a'){
                    index--;
                }

            }else{
                index++;
            }
        }
        return score;
    }

    private int calcScoreBa(StringBuilder sb, int y){
        int index = 0;
        int score = 0;
        while(index < sb.length()-1){
            if(sb.charAt(index) == 'b' && sb.charAt(index+1) == 'a'){
                score += y;
                sb.deleteCharAt(index);
                sb.deleteCharAt(index);
                if(index !=0 && sb.charAt(index-1) == 'b'){
                    index--;
                }
            }else{
                index++;
            }
        }
        return score;
    }

}
