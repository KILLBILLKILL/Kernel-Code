package Solution;
/**
 *树的子结构
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag=false;
        if(root1!=null&&root2!=null)
        {
            if (root1.val == root2.val) {
                flag = cc(root1, root2);
            }
            if (!flag) {
                flag = HasSubtree(root1.right, root2);
            }
            if (!flag) {
                flag = HasSubtree(root1.left, root2);
            }
        }
        return flag;
    }
    public boolean cc(TreeNode root1,TreeNode root2)
    {
            if(root2==null)
                return true;
            if(root1==null)
                return false;
            if(root1.val!=root2.val)
            {
                return false;
            }
            return cc(root1.left,root2.left)&&cc(root1.right,root2.right);
    }


}
