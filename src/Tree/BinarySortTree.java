package Tree;
public class BinarySortTree {
    public static void main(String[] args) {
    }
}
class Node{
    int value;
    Node left;
    Node right;
    public Node(int value)
    {
        this.value=value;
    }
    //添加节点的方式
    //递归的方式添加节点，需要满足二叉排序树的要求
    public void add(Node node)
    {
        if(node==null)
        {
            return ;
        }
        if(node.value<this.value)
        {
            if(this.left==null)
            {
                this.left=node;
            }
            else{
                //递归的向左子树添加
                this.left.add(node);
            }
        }else{//添加的结点的值大于当前结点的值
            if(this.right==null)
            {
                this.right=node;
            }
            else{
                //递归的向右子树添加
                this.right.add(node);
            }
        }
    }
}
