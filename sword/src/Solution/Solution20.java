package Solution;

import java.util.Stack;

/**
 *包含min函数的栈
 * 题目描述
 *  定义栈的数据结构，请在该类型中实现
 *  一个能够得到栈中所含最小元素的min函数
 *  （时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，
 * 对栈调用pop()或者min()或者top()方法。
 */
public  class Solution20 {

    Stack<Integer> stack=new Stack<>();
    public void push(int node) {
        if(stack.isEmpty()) {
            stack.push(node);
            stack.push(node);
        }
   else{
       int temp=stack.peek();
       stack.push(node);
       if(temp<node)
       {
           stack.push(temp);
       }
       else
           stack.push(node);
        }
    }
    public void pop() {
        stack.pop();
        stack.pop();
    }
    public int top() {
        return stack.get(stack.size()-2);
    }
    public int min() {

        return stack.peek();
    }
}
