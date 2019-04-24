package com.zhousx.leetcode;

/**
 * 108 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一颗高度平衡二叉搜索树（指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1）
 * 例如：给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *  二叉树中序遍历逆过程
 */
public class leetcode108 {

    public static TreeNode sorteArrayToBST(int[] nums){
        //左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        return nums == null ? null : buildTree(nums,0,nums.length-1);
    }

    private static TreeNode buildTree(int[] nums,int low,int high){
        if (low > high){
            return null;
        }
        int mid = low + (high -low) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums,low,mid-1);
        root.right = buildTree(nums,mid+1,high);
        return root;
    }
}
