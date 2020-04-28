package Solution;
/**
 *二叉树的后序遍历序列
 *题目描述
 * 输入一个非空整数数组，
 * 判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class Solution23 {
    public boolean  help(int []sequence,int left,int right)
    {
        if(left>=right)
            return true;
        int root=sequence[right];
        int i;
        for(i=left;i<right;i++)
        {
            if(sequence[i]>root)
                break;
        }
        for(int j=i;j<right;j++)
        {
            if(sequence[j]<root)
                return false;
        }
        return help(sequence,left,i-1)&&help(sequence,i ,right-1);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0)
            return false;
       return help(sequence,0,sequence.length-1);
    }

}
