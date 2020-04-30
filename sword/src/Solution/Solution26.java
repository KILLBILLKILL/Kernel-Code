package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 *二叉搜索树与双向链表
 *
 *题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 * 。要求不能创建任何新的结点，只能调整树中结点指针的指向
 *
 *
 *
 */
public class Solution26 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        List<TreeNode>c=new ArrayList<>();
        InOrder(pRootOfTree,c);
        TreeNode head=c.get(0);
        TreeNode ptr=head;
        ptr.left=null;
        for(int i=1;i<c.size();i++)
        {
            ptr.right=c.get(i);
            c.get(i).left=ptr;
            ptr=ptr.right;
        }

        return head;
    }
    public void InOrder(TreeNode node,List<TreeNode> c)
    {
        if(node==null)
            return ;
        InOrder(node.left,c);
        c.add(node);
        InOrder(node.right,c);

    }
}
