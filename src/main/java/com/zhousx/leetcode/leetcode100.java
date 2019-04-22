package com.zhousx.leetcode;

/**
 * 100 相同的树
 * 给定两个二叉树，编写一个函数来判断是否相同
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为这两个二叉树相等
 */
public class leetcode100 {

    public static boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}