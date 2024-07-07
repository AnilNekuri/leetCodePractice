package org.leetcode.weekly.july;

import java.util.*;

public class TheEarliestMomentWhenEveryoneBecomeFriends {

    public static void main(String[] args) {
        TheEarliestMomentWhenEveryoneBecomeFriends t = new TheEarliestMomentWhenEveryoneBecomeFriends();
        int[][] input = new int[][] {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        int res = t.earliestAcq(input,6);
        System.out.println(res);
    }
    public int earliestAcq(int[][] logs, int n) {

        Arrays.sort(logs,(o1, o2) -> o1[0] - o2[0]);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] parent = new int[n];
        //init Map
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(i,list);
        }
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < logs.length; i++) {
            int left = parent[logs[i][1]];
            int right = parent[logs[i][2]];
            int num = 0;
            if(left < right){
                num = moveChildren(map, parent, left, right);
            }else if(left > right){
                num = moveChildren(map, parent, right, left);
            }
            if(num == n){
                return logs[i][0];
            }
        }
        return -1;
    }

    private int moveChildren(Map<Integer, List<Integer>> map, int[] parent, int left, int right) {
        List<Integer> list = map.get(left);
        for (int index: map.get(right)) {
            parent[index] = left;
        }
        list.addAll(map.get(right));
        map.remove(right);
        return list.size();
    }

}
