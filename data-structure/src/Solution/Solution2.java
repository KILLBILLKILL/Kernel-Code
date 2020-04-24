package Solution;

import java.util.Stack;

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    push(x) —— 将元素 x 推入栈中。
    pop() —— 删除栈顶的元素。
    top() —— 获取栈顶元素。
    getMin() —— 检索栈中的最小元素。
 */
public class Solution2 {
//        private Stack<Integer> stack;
//        public void MinStack() {
//
//            stack = new Stack<Integer>();
//
//        }
//        public void push(int x) {
//
//            if(stack.isEmpty()){
//                stack.push(x);
//                stack.push(x);
//            }else{
//                int tmp = stack.peek();
//                stack.push(x);
//                if(tmp<x){
//                    stack.push(tmp);
//                }else{
//                    stack.push(x);
//                }
//            }
//
//        }
//        public void pop() {
//            stack.pop();
//            stack.pop();
//
//        }
//        public int top() {
//            return stack.get(stack.size()-2);
//
//        }
//        public int getMin() {
//            return stack.peek();
//
//        }
//    }
    private Stack<Integer> stack;
    public Solution2() {
        stack =new Stack<>();
    }
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }
        else{
            int temp=stack.peek();
            stack.push(x);
            if(x>temp)
            {
                stack.push(temp);
            }
            else{

                stack.push(x);
            }
        }
    }
    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {

        return stack.get(stack.size()-2);

    }
    public int getMin() {

        return stack.peek();

    }
}


