package com.zhousx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 160 相交链表
 * 编写一个程序，找到两个链表相交的起始节点
 *
 *   /
 *         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
 *         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
 *
 *  if(headA==null||headB==null)return null;
 *  ListNode pA=headA,pB=headB;
 *         // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
 *  while(pA!=pB){
 *   pA=pA==null?headB:pA.next;
 *   pB=pB==null?headA:pB.next;
 * }
 * return pA;
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
