package org.leetcode.weekly.july.week2;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerOfTheCircularGame {
    public static void main(String[] args) {
        FindTheWinnerOfTheCircularGame f = new FindTheWinnerOfTheCircularGame();
        f.findTheWinner(6,5);
    }
    public int findTheWinner(int n, int k) {
        List<Integer> friends = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            friends.add(i+1);
        }
        int sp = 0;
        while(friends.size() > 1){
            int i = (sp + k)%friends.size() -1;
            if(i < 0){
                i = friends.size()+i;
            }
            friends.remove(i);
            sp = i;
            if(i > friends.size()-1){
                sp = 0;
            }
        }
        return friends.get(0);
    }
}
