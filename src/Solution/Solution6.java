package Solution;

/*
两个栈实现一个队列
 */

import java.util.Stack;

public class Solution6 {
    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();
    //队列的压入过程
    public void push(Integer in )
    {
        stack1.push(in);
    }
    //队列的弹出过程
    public Integer pop()
    {
        if(stack2.size()==0)
        {
            while(stack1.size()>0)
            {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty())
        {
            try{
                throw new Exception("queue is Empty");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        Integer head=stack2.pop();
        return head;
    }

    public static void main(String[] args) {
        Solution6 solution6 =new Solution6();
        solution6.push(1);
        solution6.push(2);
        solution6.push(3);
        solution6.push(4);
        solution6.push(5);
        System.out.println(solution6.pop());
        System.out.println(solution6.pop());
        solution6.push(5);
        System.out.println(solution6.pop());
    }




}
