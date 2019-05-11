package com.zhousx.leetcode;

import java.util.Stack;
import java.util.Timer;

/**
 * 232 用栈实现队列
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
public class leetcode232 {
    private Stack<Integer> put;
    private Stack<Integer> out;

    /** Initialize your data structure here. */
    public leetcode232() {
        this.put = new Stack<>();
        this.out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
       put.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        transfer();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        transfer();
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return put.isEmpty()&&out.isEmpty();
    }

    private void transfer() {
        if (out.isEmpty()) {
            while (!put.isEmpty()) {
                out.push(put.pop());
            }
        }
    }

    public static void main(String[] args) {
        leetcode232 leetcode232 = new leetcode232();
        leetcode232.push(1);
        leetcode232.push(2);
        leetcode232.push(3);
        leetcode232.peek();
    }
}
