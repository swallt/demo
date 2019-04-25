package com.zhousx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 110 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树
 *
 * 解法： 遍历二叉树，获得每个叶子节点的深度，如果它们直接的绝对值差不超过1，即使平衡二叉树(错误)
 * 递归：1、空树，为平衡
 *      2、返回结果需要包含是否平衡及节点高度
 *      3、单步需要判断左右子节点是否同时平衡，左右子节点的高度差小于1
 */
public class leetcode110 {

    private static class result{
        boolean balance;
        int depth;
        public result(boolean balance,int depth){
            this.balance = balance;
            this.depth = depth;
        }
    }

    public static boolean isBalanced(TreeNode root){
        return isB(root).balance;
    }

    private static result isB(TreeNode root){
        if (root == null){
            return new result(true,0);
        }
        result resultleft = isB(root.left);
        result resultright = isB(root.right);

        if (resultleft.balance == false || resultright.balance == false){
            return new result(false,0);
        }
        if (Math.abs(resultleft.depth - resultright.depth) > 1){
            return new result(false,0);
        }
        return new result(true,Math.max(resultleft.depth,resultright.depth)+1);
    }
    /*//理解错误，高度平衡二叉树在本题中指任意节点的左右两子树的高度差的绝对值不超过1.
    public static boolean isBalanced(TreeNode root){
        List<Integer> list = new ArrayList<>();
        int depth = 0;
        if (root == null || (root.right==null&&root.left == null))
            return true;
        findLeafNodeDepth(root,0,list);
        //java 8 新特性，List<Integer>直接转int[] 数组
        int[] depths = list.stream().mapToInt(Integer::intValue).toArray();
        if (depths.length == 1){
            return false;
        }
        int min = depths[0],max=depths[0];
        for (int i = 1;i<depths.length;i++){
            if (depths[i]<min){
                min = depths[i];
            }
            if (depths[i]>max){
                max = depths[i];
            }
        }
        if (max - min > 1){
            return false;
        }
        return true;
    }

    private static void findLeafNodeDepth(TreeNode root,int depth,List<Integer> list){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            list.add(depth);
            return;
        }
        findLeafNodeDepth(root.left,depth+1,list);
        findLeafNodeDepth(root.right,depth+1,list);
    }*/
}
