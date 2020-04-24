package Tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        //创建一个ArrBinaryTree
        ArrayBinaryTree arrayBinaryTree=new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();//  1 2 4 5 3 6 7
    }
}

//编写一个ArrayBinaryTree，实现顺序存储二叉树的遍历
class ArrayBinaryTree{
    private int[] arr;
    public ArrayBinaryTree(int[] arr)
    {
        this.arr=arr;
    }
    //重载preOrder//这样更干净一点
    public void preOrder()
    {
        this.preOrder(0);
    }
    //编写一个方法完成顺序存储二叉树的前序遍历
    //表示数组的标记

    /**
     *
     * @param indext  数组的下标
     */
    public void preOrder(int indext)
    {
        //如果数组为空 或者是arr.length为0
        if(arr==null || arr.length==0)
        {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.println(arr[indext]);
        //向左递归遍历
        if((indext*2+1)<arr.length)
        {
            preOrder(2*indext+1);
        }
        //向右递归遍历
        if((indext*2+2)<arr.length)
        {
            preOrder(2*indext+2);
        }
    }
}