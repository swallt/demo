package com.zhousx.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101 对称二叉树
 * 给定一个二叉树,检查它是否是镜像对称的.
 */
public class leetcode101 {

    /**
     * 递归法
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root){
        return isEquals(root,root);
    }

    public static boolean isEquals(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)&&isEquals(t1.right,t2.left)&&isEquals(t1.left,t2.right);
    }

    /**
     * 迭代
     * 利用队列进行迭代,队列中连续的两点应该是相等的,而且他们的子树互为镜像.最初,队列中包含的是root以及root.每次提取两个节点并比较他们的值,
     * 然后,将两个节点的左右子节点按相反的顺序插入队列中.当队列为空或者检测到树不对称时,算法结束.
     */
    public static boolean isSymmetricByQueue(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null ) continue;
            if (t1 == null || t2 == null ) return false;
            if (t1.val == t2.val){
                q.add(t1.left);
                q.add(t2.right);
                q.add(t1.right);
                q.add(t2.left);
            } else {
                return false;
            }
        }
        return true;
    }
}
