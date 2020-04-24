package ThreadBinaryTree;
public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        //测试线索化二叉树的实现
        Node root=new Node(1);
        Node node2=new Node(3);
        Node node3=new Node(6);
        Node node4=new Node(8);
        Node node5=new Node(10);
        Node node6=new Node(14);
        root.setLeft(node2);
        root.setRight(node3);
    }
}

class BinaryTree{
    private Node root;
    //为了实现线索化 需要创建前驱节点的指针
    private  Node pre=null;

    public void setRoot(Node root) {
        this.root = root;
    }
    //中序线索化
    public void threadedNodes(Node node)
    {
        //node == null 不能线索化
        if(node==null)
        {
            return ;
        }
        //线索化左子树
        threadedNodes(node.getLeft());
        //线索化当前节点
        //处理当前节点的前驱节点
        if(node.getLeft()==null)
        {
            //当前节点的左指针 指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型，指向前驱节点
            node.setLeftType(1);

        }
        //处理后继结点
        if(pre!=null&&node.getRight()==null)
        {
            //前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改类型
            pre.setRightTupe(1);
        }
        //!!!!每处理一个结点之后，当前节点是下一个节点的前驱节点
        pre=node;
        //线索化右子树
        threadedNodes(node.getRight());
    }
    //删除节点
    public void delNode(int value)
    {
        if(root!=null)
        {
            if(root.getValue()==value)
            {
                root=null;
            }else {
                root.delNode(value);
            }

        }
        else{
            System.out.println("root为空不能删除");
        }
    }
    //前序遍历
    public void preOrder()
    {
        if(this.root!=null)
        {
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空无法遍历");
        }
    }
    //中序遍历
    public void infixOrder()
    {
        if(this.root!=null)
        {
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空无法遍历");
        }
    }
    //后序遍历
    public void postOrder()
    {
        if(this.root!=null)
        {
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空无法遍历");
        }
    }
    public Node preOrderSearch(int value)
    {
        if(root!=null)
        {
            return root.preOrderSearch(value);
        }
        else{
            return null;
        }
    }
    public Node infixOrderSearch(int value)
    {
        if(root!=null)
        {
            return root.infixOrderSearch(value);
        }
        else{
            return null;
        }
    }
    public Node postOrderSearch(int value)
    {
        if(root!=null)
        {
            return root.postOrderSearch(value);
        }
        else{
            return null;
        }
    }
}

//先创建Node结点
class Node {
    private int value;
    private Node left;//默认null
    private Node right;//默认null
    //0 指向左子树 1 指向前驱结点
    private int leftType;
    private int rightTupe;
    public void setRightTupe(int rightTupe) {
        this.rightTupe = rightTupe;
    }
    public int getRightTupe() {
        return rightTupe;
    }
    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }
    public int getLeftType() {
        return leftType;
    }
    public Node(int value) {
        this.value = value;
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
    public int getValue() {
        return value;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public void setValue(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    //递归删除结点
    //1.如果删除的是叶子结点，就删除该节点
    //如果删除的是非叶子结点，就删除该子树
    public  void delNode(int value)
    {
        if(this.left!=null&&this.left.value==value)
        {
            this.left=null;
            return ;
        }
        if(this.right!=null&&this.right.value==value)
        {
            this.right=null;
            return ;
        }
        if(this.left!=null)
        {
            this.left.delNode(value);
        }
        if(this.right!=null)
        {
            this.right.delNode(value);
        }
    }
    //前序遍历
    public void preOrder()
    {
        System.out.println(this.value);//先输出父节点
        //递归向左子树
        if(this.left!=null)
        {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right!=null)
        {
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder()
    {
        //递归向左子树
        if(this.left!=null)
        {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this.value);
        if(this.right!=null)
        {
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder()
    {
        if(this.left!=null)
        {
            this.left.preOrder();

        }
        if(this.right!=null)
        {
            this.right.postOrder();
        }
        System.out.println(this.value);
    }
    //前序遍历查找
    /**
     *
     * @param value  查找no
     * @return   找到就返回Node 没找到的话就返回Null
     */
    public Node preOrderSearch(int value)
    {

        System.out.println("进入前序遍历查找");
        //比较当前节点是不是
        if(this.value==value)
        {
            return this;
        }
        //判断当前节点的左子节点是否为空，如果不为空 继续递归查找
        //如果找到就返回 运用临时变量
        Node resnode=null;
        if(this.left!=null)
        {
            resnode=this.left.preOrderSearch(value);
        }
        if(resnode!=null)//说明我们在左子树找到了
        {
            return resnode;
        }
        if(this.right!=null)
        {
            resnode=this.right.preOrderSearch(value);
        }
        return resnode;
    }
    public Node infixOrderSearch(int value)
    {
        Node resnode=null;
        if(this.left!=null)
        {
            resnode=this.left.infixOrderSearch(value);
        }
        if(resnode!=null)
        {
            return resnode;
        }
        if(this.value==value)
        {
            return this;
        }
        if(this.right!=null)
        {
            resnode=this.right.infixOrderSearch(value);
        }
        return resnode;
    }
    public Node postOrderSearch(int value)
    {
        Node resnode=null;
        if(this.left!=null)
        {
            resnode=this.left.postOrderSearch(value);
        }
        if(resnode!=null)
        {
            return resnode;
        }
        if(this.right!=null)
        {
            resnode=this.right.postOrderSearch(value);

        }
        if(resnode!=null)
        {
            return resnode;
        }
        if(this.value==value)
        {
            return this;
        }
        return resnode;
    }
}


