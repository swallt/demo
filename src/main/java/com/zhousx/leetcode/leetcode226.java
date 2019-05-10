package com.zhousx.leetcode;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 226 翻转二叉树
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null ){
            return null;
        }
//        if (root.left==null || root.right == null)
//            return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
