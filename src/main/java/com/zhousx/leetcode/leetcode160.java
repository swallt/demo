package com.zhousx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 160 相交链表
 * 编写一个程序，找到两个链表相交的起始节点
 */
public class leetcode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1!=null&&p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        while (p1!=null){
            headA=headA.next;
            p1=p1.next;
        }
        while (p2!=null){
            headB=headB.next;
            p2=p2.next;
        }
        while (headA!=null&&headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;

    }

    //bad
  /*  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>();
        while (headA != null){
            listNodes.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            for (ListNode listNode:listNodes){
                if (listNode == headB){
                    return headB;
                }
            }
            headB = headB.next;
        }
        return null;
    }*/
}
