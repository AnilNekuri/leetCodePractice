package org.leetcode.weekly.july.week3;
import com.sun.source.tree.Tree;
import org.leetcode.weekly.july.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class NumberOfGoodLeafNodesPairs {
    public int countPairs(TreeNode root, int distance) {
        int result = 0;
        Map<TreeNode,List<Integer>> memory= new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        bfs(root, stack);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null){
                List<Integer> distanceList = new ArrayList<>();
                distanceList.add(0);
                memory.put(node,distanceList);
                continue;
            }
            List<Integer> nodeList = new ArrayList<>();
            List<Integer> leftList = null;
            if(node.left != null){
                leftList = getCollect(memory, node.left, distance);
                nodeList.addAll(leftList);
            }
            List<Integer> rightList = null;
            if(node.right != null){
                rightList = getCollect(memory, node.right, distance);
                nodeList.addAll(rightList);
            }
            memory.put(node,nodeList);
            if(leftList != null && rightList != null){
                for (int i = 0; i < leftList.size(); i++) {
                    for (int j = 0; j < rightList.size(); j++) {
                        if(leftList.get(i)+ rightList.get(j) <= distance){
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    private static List<Integer> getCollect(Map<TreeNode, List<Integer>> memory, TreeNode node, int distance) {
        return memory.get(node).stream().
                filter(v -> v < distance).
                map(v -> v + 1).
                collect(Collectors.toList());
    }

    private static void bfs(TreeNode root, Stack<TreeNode> stack) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode curr = queue.poll();
                stack.add(curr);
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
                size--;
            }
        }
    }
}
