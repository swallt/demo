package com.zhousx.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class leetcode257 {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        func(root,"",list);
        return list;
    }

    private void func(TreeNode root,String cur,List<String> list){
        if (root == null) return;
        cur += root.val;
        if (root.left == null && root.right==null){
            list.add(cur);
        }else {
            func(root.left,cur+"->",list);
            func(root.right,cur+"->",list);
        }
    }
}
