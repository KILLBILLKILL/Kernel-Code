package Solution;

/**
 * 斐波那契数列
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 */
public class Solution7 {
    public int Fibonacci(int n) {
        int pre=1;
        int prepre=0;
        int result=0;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        for(int i=2;i<n+1;i++)
        {
             result=pre+prepre;
             prepre=pre;
             pre=result;
        }

        return result;
    }

}
