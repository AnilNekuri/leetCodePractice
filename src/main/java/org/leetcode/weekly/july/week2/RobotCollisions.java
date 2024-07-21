package org.leetcode.weekly.july.week2;

import java.util.*;
import java.util.stream.Collectors;

public class RobotCollisions {

    public static void main(String[] args) {
        RobotCollisions r = new RobotCollisions();
        int[] positions = new int[]{32,4};
        int[] healths = new int[]{630,234};
        String directions = "RLRL";
        List<Integer> integerList = r.survivedRobotsHealths(positions, healths, directions);
        //System.out.println(integerList);
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>();
        List<Robot> result = new LinkedList<>();
        Stack<Robot> stack = new Stack<>();
        for (int i = 0; i < positions.length; i++) {
            robots.add(new Robot(positions[i],i,directions.charAt(i),healths[i]));
        }
        Comparator<Robot> indexComparable = new Comparator<Robot>() {
            @Override
            public int compare(Robot o1, Robot o2) {
                return o1.index-o2.index;
            }
        };
        Comparator<Robot> positionComparable = new Comparator<Robot>() {
            @Override
            public int compare(Robot o1, Robot o2) {
                return o1.position-o2.position;
            }
        };
        Collections.sort(robots,positionComparable);
        for (int i = 0; i < robots.size(); ) {
            //System.out.println(robots.get(i));
            Robot left = robots.get(i);
            if(left.direction == 'L'){
                if(stack.isEmpty()){
                    result.add(left);
                }else{
                    Robot right = stack.pop();
                    if(right.health > left.health){
                        right.health = right.health-1;
                        stack.add(right);
                    }else if(right.health < left.health){
                        left.health = left.health -1;
                        continue;
                    }
                }
            }else{
                stack.add(left);
            }
            i++;
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result.stream().sorted(indexComparable).map(r -> r.health).collect(Collectors.toList());
    }
}
