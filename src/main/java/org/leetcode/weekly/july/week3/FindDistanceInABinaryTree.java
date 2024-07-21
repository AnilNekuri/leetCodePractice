package org.leetcode.weekly.july.week3;

import org.leetcode.weekly.july.TreeNode;

public class FindDistanceInABinaryTree {
    int res;
    public int findDistance(TreeNode root, int p, int q) {
        res = 0;
        dfs(root,p,q);
        return res;
    }

    private int dfs(TreeNode node, int p, int q){
        if(node == null || res > 0){
            return 0;
        }
        int m = 0;
        if(node.val == p || node.val == q){
            m = 1;
        }
        int l = dfs(node.left,p,q);
        int r = dfs(node.right,p,q);
        if((l > 0 || r > 0) && m > 0){
            res = Math.max(l,r);
        } else if ( l > 0 && r > 0) {
            res = l + r;
        } else if ( l > 0) {
            return l+1;
        } else if( r > 0){
            return r+1;
        }
        return m;
    }
}
