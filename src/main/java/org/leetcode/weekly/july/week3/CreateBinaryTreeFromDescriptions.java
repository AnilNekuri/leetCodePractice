package org.leetcode.weekly.july.week3;

import org.leetcode.weekly.july.TreeNode;

import java.util.*;

public class CreateBinaryTreeFromDescriptions {
    public static void main(String[] args) {
        int[][] descriptions = new int[][]{{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        CreateBinaryTreeFromDescriptions c = new CreateBinaryTreeFromDescriptions();
        TreeNode t = c.createBinaryTree(descriptions);
        System.out.println(t.val);
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        //Map to store nodes
        Set<Integer> parents = new HashSet<>();
        Set<Integer> children = new HashSet<>();
        Map<Integer,TreeNode> memory = new HashMap<>();
        for (int i = 0; i < descriptions.length; i++) {
            int parentKey = descriptions[i][0];
            parents.add(parentKey);
            int childKey = descriptions[i][1];
            children.add(childKey);
            int isLeft = descriptions[i][2];
            TreeNode parent = memory.getOrDefault(parentKey,new TreeNode(parentKey));
            TreeNode child = memory.getOrDefault(childKey,new TreeNode(childKey));
            memory.put(parentKey,parent);
            memory.put(childKey,child);
            if(isLeft == 1){
                parent.left = child;
            }else {
                parent.right = child;
            }
        }
        for (int child: children) {
            parents.remove(child);
        }
        return memory.get(parents.iterator().next());
    }
}
