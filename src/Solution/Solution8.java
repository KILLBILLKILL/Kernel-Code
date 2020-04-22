package Solution;
/*
括号的匹配问题，如{()},{[()]},({[]})都匹配的
 */

import java.util.Scanner;
import java.util.Stack;

public class Solution8 {
        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();   //创建一个栈
            for (int i = 0; i < s.length(); i++) {
                if ((s.charAt(i) == '(') || (s.charAt(i) == '[') || (s.charAt(i) == '{')) {    // 如果是左括号，则将其放入栈内
                    stack.push(s.charAt(i));
                }
                if ((s.charAt(i) == ')') || (s.charAt(i) == ']') || (s.charAt(i) == '}')) {   // 如果是右括号
                    if (stack.empty()) {     //  如果栈为空，则证明括号不匹配，返回false
                        return false;
                    }
                    if ((stack.peek() == '(' && s.charAt(i) == ')') || (stack.peek() == '[' && s.charAt(i) == ']') || (stack.peek() == '{' && s.charAt(i) == '}') ) {     // 如果栈顶元素和下一个右括号相匹配，则将其栈顶元素出栈
                        stack.pop();
                    }
                }
            }
            if (stack.empty()) {   // 遍历循环结束后，如果发现栈里为空，则证明括号匹配完毕；否则括号不匹配
                return true;
            }
            return false;
        }
    public static void main(String[] args) {
        System.out.println("Please enter a sentence include '('，')'，'{'，'}'，'['，']' ：");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println("The result is：" + isValid(string));
    }

}
