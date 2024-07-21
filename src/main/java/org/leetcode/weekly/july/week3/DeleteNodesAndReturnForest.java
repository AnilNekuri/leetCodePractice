package org.leetcode.weekly.july.week3;

import com.sun.source.tree.Tree;
import org.leetcode.weekly.july.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteNodesAndReturnForest {
    HashMap<Integer,TreeNode> resMap;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        resMap = new HashMap<>();
        if(root == null){
            return new ArrayList<>();
        }
        resMap.put(root.val,root);
        Set<Integer> toDelSet = new HashSet<>();
        for (int val: to_delete ) {
            toDelSet.add(val);
        }
        TreeNode parent = null;
        rec(parent, 'R',root,toDelSet);
        return resMap.values().stream().collect(Collectors.toList());
    }

    private void rec(TreeNode parent, char dir, TreeNode node, Set<Integer> to_del){
        if(node == null){
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        if(to_del.remove(node.val)){
            if(parent!=null){
                if(dir == 'L'){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }
            resMap.remove(node.val);
            if(left != null){
                resMap.put(left.val,left);
            }
            if(right != null){
                resMap.put(right.val,right);
            }
        }
        rec(node,'L',left,to_del);
        rec(node,'R',right,to_del);
    }
}
