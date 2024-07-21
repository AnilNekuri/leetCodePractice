package org.leetcode.weekly.july.week2;

import javax.sound.sampled.AudioFormat;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class RobotCollisionsTimeout {

    public static void main(String[] args) throws IOException {
        RobotCollisionsTimeout r = new RobotCollisionsTimeout();
        String positionPath = "C:\\Users\\user\\IdeaProjects\\LeetCodePractice\\src\\main\\java\\org\\leetcode\\weekly\\july\\week2\\positions.txt";
        String healthPath = "C:\\Users\\user\\IdeaProjects\\LeetCodePractice\\src\\main\\java\\org\\leetcode\\weekly\\july\\week2\\healths.txt";
        String directionPath = "C:\\Users\\user\\IdeaProjects\\LeetCodePractice\\src\\main\\java\\org\\leetcode\\weekly\\july\\week2\\directions.txt";

        String[] positionsStr = readFile(positionPath, StandardCharsets.UTF_8).split(",");
        int[] positions = new int[positionsStr.length];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = Integer.valueOf(positionsStr[i]).intValue();
        }
        String[] healthStr = readFile(healthPath, StandardCharsets.UTF_8).split(",");
        int[] healths = new int[healthStr.length];
        for (int i = 0; i < healths.length; i++) {
            healths[i] = Integer.valueOf(healthStr[i]).intValue();
        }
        String directions = readFile(directionPath, StandardCharsets.UTF_8);
        List<Integer> integerList = r.survivedRobotsHealths(positions, healths, directions);
        System.out.println(integerList);
    }
    public static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new LinkedList<>();
        for (int i = 0; i < positions.length; i++) {
            robots.add(new Robot(positions[i],i,directions.charAt(i),healths[i]));
        }
        Comparator<Robot> positionComparable = new Comparator<Robot>() {
            @Override
            public int compare(Robot o1, Robot o2) {
                return o1.position-o2.position;
            }
        };
        Comparator<Robot> indexComparable = new Comparator<Robot>() {
            @Override
            public int compare(Robot o1, Robot o2) {
                return o1.index-o2.index;
            }
        };

        Collections.sort(robots,positionComparable);
        int i = 0;
        while(i < robots.size()-1){
            if(robots.get(i).direction == 'R' && robots.get(i+1).direction == 'L'){
                Robot right = robots.get(i);
                Robot left = robots.get(i+1);
                if(right.health > left.health){
                    robots.remove(i+1);
                    right.health = right.health-1;

                }else if(right.health == left.health) {
                    robots.remove(i);
                    robots.remove(i);

                }else{
                    robots.remove(i);
                    left.health = left.health-1;
                }
                if(i > 0){
                    i--;
                }
            }else{
                i++;
            }
        }
        if(robots.size() > 0){
            Collections.sort(robots,indexComparable);
            return robots.stream().map(robot -> robot.health).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
