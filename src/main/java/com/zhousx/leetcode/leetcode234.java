package com.zhousx.leetcode;

/**
 * 234 回文链表
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 */
public class leetcode234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        //定义快慢指针，找到中点
        ListNode slow = head,fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转
        slow = reserve(slow.next);
        while (slow != null){
            if (slow.val != head.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;

    }

    private ListNode reserve(ListNode head){
        if (head.next == null)
            return head;
        ListNode newhead = reserve(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }


}
