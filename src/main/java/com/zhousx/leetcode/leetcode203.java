package com.zhousx.leetcode;

/**
 * 203 移除链表元素
 * 删除链表中等于给定值val的所有节点
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class leetcode203 {
    public ListNode removeElements(ListNode head, int val) {

        //新建一个链表，有一个头节点，后指向目标节点
        ListNode headers = new ListNode(-1);
        headers.next = head;
        ListNode cur = headers;
        //从cui.next开始遍历链表
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return headers.next;
    }
}
