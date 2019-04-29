package com.zhousx.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 141 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数pos来表示链表尾连接到链表中的位置（索引从0开始）。如果pos是-1，则在该链表中没有环。
 */
public class leetcode141 {

    public boolean hasCycle(ListNode head){
        //利用hashSet的唯一性
      /*  Set<ListNode> nodes = new HashSet<>();
        while (head != null){
            if (nodes.contains(head)){
                return true;
            }else {
                nodes.add(head);
            }
            head = head.next;
        }
        return false;*/


      //双指针  通过使用不同速度的指针，慢指针每次移动1，快指针每次移动2.如果不存在环，快指针将最先到达队尾；如果存在环，他们最终相遇。
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
