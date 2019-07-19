package com.mx;

import java.util.Stack;

/**
 * @ClassName QueueByStack
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/3/20 17:03
 * @Version 1.0
 **/
public class QueueByStack {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
//        stack1.push(node);

        //让Stack2中保存正确的顺序
        while (!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
        while (!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }
}
