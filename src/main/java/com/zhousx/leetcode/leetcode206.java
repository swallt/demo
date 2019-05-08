package com.zhousx.leetcode;

import java.util.Stack;

/**
 * 206 反转链表
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class leetcode206 {

    public ListNode funcTwo(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public ListNode func(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode prev = func(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode res = stack.peek();
        ListNode cur = stack.pop();
        while (!stack.empty()){
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return res;
    }
}
