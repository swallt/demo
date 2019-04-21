package com.zhousx.leetcode;

/**
 * 83 删除排序链表中的重复元素
 */
public class leetcode83 {

    public ListNode deleteDuplicates(ListNode head){
        ListNode current = head;
        while (current != null && current.next != null){
            if (current.val == current.next.val){
                current.next = current.next.next;
//                current = current.next;   不需要移动链表
            }else {
                current = current.next;
            }
        }
        return head;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}