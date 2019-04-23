package com.zhousx.leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * 104 二叉树最大深度
 * 给定一个二叉树,找出其最大深度(根节点到最远叶子节点的最长路径上的节点数)
 * 叶子节点是指没有子节点的节点
 */
public class leetcode104 {

    public static int maxDepthFast(TreeNode root){
        return root == null ? 0 : Math.max(maxDepthFast(root.left),maxDepthFast(root.right)) +1;
    }

    /**
     * 迭代  通过DFS策略访问每个结点,同事在每次访问时更新最大深度
     * @param root
     * @return
     */
    public static int maxDepthByQueue(TreeNode root){
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        if (root != null){
            q.add(new Pair<>(root,1));
        }
        int depth = 0;
        while (!q.isEmpty()){
            Pair<TreeNode,Integer> current = q.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null){
                depth = Math.max(depth,current_depth);
                q.add(new Pair<>(root.left,current_depth+1));
                q.add(new Pair<>(root.right,current_depth+1));
            }
        }
        return depth;
    }

    public static int maxDepth(TreeNode root){
        if (root == null) return 0;
        int max = 1;
        Map<TreeNode,Integer> map = new HashMap<>();
        map = putMap(root,map,max);
        for (TreeNode key : map.keySet()){
            if (map.get(key)>=max){
                max = map.get(key);
            }
        }
        return max;

    }

    public static Map<TreeNode,Integer> putMap(TreeNode t,Map<TreeNode,Integer> map,int max){
        map.put(t,max);
        if (t.left != null){
            int temp = max;
            temp++;
            putMap(t.left,map,temp);
        }
        if (t.right != null){
            int temp1 = max;
            temp1++;
            putMap(t.right,map,temp1);
        }
        return map;
    }
}
