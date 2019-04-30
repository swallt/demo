package com.zhousx.leetcode;

import java.util.Stack;

/**
 * 设计一个支持push,pop,top操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 将元素和当前最小元素同时放入栈中
 */
public class leetcode155 {
}

class MinStack{
    private Stack<Integer> stack;

    public MinStack(){
        this.stack = new Stack<>();
    }

    public void push(int x){
        if (stack.empty()){
            stack.push(x);
            stack.push(x);
        }else {
            int temp = stack.get(stack.size() - 2);
            if (temp < x){
                stack.push(temp);
                stack.push(x);
            }else {
                stack.push(x);
                stack.push(x);
            }
        }
    }

    public void pop(){
        stack.pop();
        stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return stack.get(stack.size()-2);
    }
}