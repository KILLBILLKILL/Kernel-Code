package Solution;
import java.util.Stack;

/*
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2}
 就不可能是该压栈序列的弹出序列。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {
    // 比较压入序列、弹出序列是否相等，如果相等则while环节
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int indext=0;
        for(int i=0,len=pushed.length;i<len;i++)
        {
            while(!stack.isEmpty()&&indext<len&&stack.peek()==popped[indext])
            {
                stack.pop();
                indext++;
            }
        }
        return stack.isEmpty();
    }
//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        Stack<Integer> stack =new Stack<>();
//        int indext=0;
//        for(int i=0,len=pushed.length;i<len;i++)
//        {
//            stack.push(pushed[i]);
//            while(!stack.isEmpty()&& indext<len&&popped[indext]==stack.peek())
//            {
//                stack.pop();
//                indext++;
//            }
//        }
//        return stack.isEmpty();
//    }
    }

