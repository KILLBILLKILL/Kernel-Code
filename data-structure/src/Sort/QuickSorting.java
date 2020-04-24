package Sort;
import java.util.Arrays;

public class QuickSorting {
    /*
    快速排序的思路分析
    -9 78 0 23 -567 70
    中间值取  0
    -9 -567 0 23 78 70
    向左向右递归
    不可以同时进行
    -567 -9          0              23 70 78
     */
    public static void main(String[] args) {
        int arr[]={-9,78,0,23,-567,70,-1,900,4561 };
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static  void quickSort(int[] arr,int left,int right)
    {
        int l=left;//坐下标
        int r=right;//右下标
        //pivot中轴值
        int pivot =arr[(left+right)/2];
        int temp=0;//临时变量，作为交换时使用
        //while循环的目的是让 比 pivot小的放到左边
        //比pivot大的值放到右边
        while(l<r)
        {
            //在pivot的左边一直找 ，直到找到大于等于pivot的值 才退出
            while(arr[l]<pivot)
            {
                l+=1;
            }
            while(arr[r]>pivot)
            {
                r-=1;
            }
            //如果l>=r,说明pivot的左右两边的值，已经按照左边全部小于等于pivot  右边全部大于pivot的值
            if(l>=r)
            {
                break;
            }
            //交换
           temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            //如果交换完之后 发现这个arr[l]==pivot值  相等 --，前移一下
            if(arr[l]==pivot)
            {
                r-=1;
            }
            if(arr[r]==pivot)
            {
                l+=1;
            }
        }
        //如果 l==r 必须l++ r-- 否则会栈溢出
        if(l==r)
        {
            l+=1;
            r-=1;
        }
        //向左递归
        if(left<r)
        {

            quickSort(arr,left,r);
        }
        //向右递归
        if(right>l)
        {

            quickSort(arr,l,right);
        }
    }
}
