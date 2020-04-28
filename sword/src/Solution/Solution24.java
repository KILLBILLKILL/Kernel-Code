package Solution;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *二叉树中和为某一路径的值
 *题目描述
 * 输入一颗二叉树的根节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 */
public class Solution24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> s1=new ArrayList<ArrayList<Integer>>();

        if(root==null)
            return s1;
        help(s1,new ArrayList<>(),root ,target);
        return s1;
    }
    public void help(ArrayList<ArrayList<Integer>> s1, ArrayList<Integer> s2,TreeNode root ,int taget)
    {
        s2.add(root.val);
        if (root.left == null && root.right == null ){
            if(taget == root.val) {
                s1.add(s2);
            }
        return;
    }
        ArrayList<Integer> s3=new ArrayList<>();
        s3.addAll(s2);
        if(root.left!=null)
        help(s1,s2,root.left,taget-root.val);
        if(root.right!=null)
        help(s1,s3,root.right,taget-root.val);
    }
}
