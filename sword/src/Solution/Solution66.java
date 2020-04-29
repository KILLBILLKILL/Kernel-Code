package Solution;

/**
 * 检绳子
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，
 * 我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Solution66 {

    public int cutRope(int target) {
        if(2>target)
            return 0;
        if(target==2)
            return 1;
        if(target==3)
            return 2;
        int max=-1;
        int[] c=new int[target+1];
        c[1]=1;
        c[2]=2;
        c[3]=3;
        for(int i=4;i<=target;i++)
        {
            for(int j=1;j<=target/2;j++)
            {
                int val=c[j]*c[i-j];
                max=max>val?max:val;
                c[i]=max;
            }
        }
        c[target]=max;
        return c[target];


    }

}
