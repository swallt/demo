package com.zhousx.leetcode;

/**
 * 404 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * 示例：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class leetcode404 {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null){
            getsum(root);
            return sum;
        }
        return 0;
    }

    private void getsum(TreeNode root){
        if (root != null){
            if (root.left != null){
                if (root.left.left == null && root.left.right == null){
                    sum += root.left.val;
                }
            }
            getsum(root.left);
            getsum(root.right);
        }
    }
}
