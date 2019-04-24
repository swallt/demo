package com.zhousx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 107 二叉树的层次遍历
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。（即按从叶子节点所在层到跟节点所在的层，逐层从左向右遍历）
 * 解法：利用递归的思想，在递归中先处理左节点，再处理有节点，根据深度来找对应层次的list
 */
public class leetcode107 {
    public static void main(String[] args){

    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root){
        //获取结果list<list<Integer>>
        List<List<Integer>> lists = new ArrayList<>();
        getResultList(lists,0,root);
        //逆序
        for (int i = 0,j = lists.size() -1;i <= j; i++,j--){
            List<Integer> temp = lists.get(i);
            lists.set(i,lists.get(j));
            lists.set(j,temp);
        }
        return lists;
    }

    private static void getResultList(List<List<Integer>> lists,int level,TreeNode root){
        if (root == null){
            return;
        }
        if (lists.size() == level){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
        }else {
            lists.get(level).add(root.val);
        }
        getResultList(lists,level+1,root.left);
        getResultList(lists,level+1,root.right);
    }

    //逆序
    private static void levelOrderBottom(List<List<Integer>> lists,int level,TreeNode root){
        if (root == null){
            return;
        }
        if (lists.size()<= level){
            lists.add(0,new ArrayList<>());
        }
        lists.get(lists.size() - level -1).add(root.val);
        levelOrderBottom(lists,level+1,root.left);
        levelOrderBottom(lists,level+1,root.right);
    }

}
