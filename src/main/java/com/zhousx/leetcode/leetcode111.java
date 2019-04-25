package com.zhousx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 111 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度，即从根节点到叶子节点最短路径的节点数
 *
 * 解法： 递归： 1、 节点为空时返回0
 *             2、 返回根节点到当前节点的深度
 *             3、 左右节点不为空时取小，有一个为空则取大。
 *
 *    找出所有的叶子节点极其对应的深度
 */
public class leetcode111 {

    public int minDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (l>0 && r>0){
            return 1+(Math.min(l,r));
        }
        return 1+l+r;
    }

/*    public int minDepth(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int depth = 1;
        findLeafNodeDepth(root,depth,list);
        //java 8 新特性，List<Integer>直接转int[] 数组
        int[] depths = list.stream().mapToInt(Integer::intValue).toArray();
        int min = depths[0];
        for (int i = 0;i<depths.length;i++){
            if (min>depths[i]){
                min = depths[i];
            }
        }
        return min;
    }

    private void findLeafNodeDepth(TreeNode root,int depth,List<Integer> list){
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
