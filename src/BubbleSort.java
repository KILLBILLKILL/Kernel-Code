import java.lang.reflect.Array;
import java.util.Arrays;
public class BubbleSort {
    //冒泡排序就是 每一次 将这个序列中最大的放在后面
    //序列-1
    //就像是水里的泡泡冒起来一样
    // 原始数组 3  9 -1 10 20
    //第一次排序
    //  3 9 -1 10 20
    // 3 -1 9 10 20
    // 3 -1 9 10 20
    // 3 -1 9 10 20
    // 如果相邻的两个逆序就交换
    //第二趟排序
    /*
     -1 3 9 10 20
     -1 3 9 10 20
     -1 3 9 10 20
     第三趟排序
     -1 3 9 10 20
     1 3 9 10 20-
     第四趟排序
     1 3 9 10 20
     这其中每次都是从左到右两辆比较 每次都找到一个最大的放在最后面 根据上一次 所以每次比较的次数都在变小
     小结冒泡排序规则
     1.一共要进行数组的大小-1次的循环
     2.每一次排序的次数在逐渐的减少
     3.如果我们发现某一次排序中没有发现一次交换，我们就直接结束冒泡排序（这个就是优化）
          */
    public static void main(String[] args) {
        int array[]={3,9,-1,10,-2};
        int temp=0;
        boolean flag=false;
        for(int i=0;i<array.length-1;i++)
        {
            for(int j=0;j<array.length-1-i;j++)
            {
                if(array[j]>array[j+1])
                {
                    flag=true;
                    temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
            System.out.println("第"+(i+1)+"次排序的结果为");
            System.out.println(Arrays.toString(array));
            if(!flag)
            {
                break;
            }else{
                flag=false; //进行下一次 判断的基础
            }
        }
    }
}
