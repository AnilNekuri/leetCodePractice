package org.leetcode.weekly.july.week3;

import org.leetcode.weekly.july.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;
        pair = new ArrayList<>();
        pair.add(startValue);
        pair.add(destValue);
        fromSource = new StringBuilder();
        toTarget = new StringBuilder();
        findNodes(root);
        return res;
    }

    int startValue, destValue;
    ArrayList<Integer> pair;

    StringBuilder fromSource;
    StringBuilder toTarget;

    String res;

    public int findNodes(TreeNode node){
        if(node == null || res != null){
            return 0;
        }
        int m = 0;
        if(pair.contains(node.val)){
            m = node.val;
        }
        int r = findNodes(node.right);
        if(r == startValue){
            fromSource.append('U');
        }else if(r == destValue){
            toTarget.insert(0,'R');
        }
        int l = findNodes(node.left);
        if(l == startValue){
            fromSource.append('U');
        }else if(l == destValue){
            toTarget.insert(0,'L');
        }
        if((l != 0 && r != 0) || (m != 0 && l != 0) || (m != 0 && r != 0)){
            res = fromSource.toString() + toTarget.toString();
        }else if(l > 0){
            return l;
        }else if(r > 0){
            return r;
        }else if(m > 0){
            return m;
        }
        return 0;
    }
}
