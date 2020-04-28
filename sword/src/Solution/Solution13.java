package Solution;

/**
 * 调整数组顺序，
 * 使得基数位于偶数前面
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution13 {
    public static  void reOrderArray(int [] array) {
        int b=0;
        int array2[]=new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            if(array[i]%2==1)
            {
                array2[b]=array[i];
                b++;
            }
        }
        for(int j=0;j<array.length;j++)
        {
            if(array[j]%2==0)
            {
                array2[b]=array[j];
                b++;
            }
        }
        for(int c=0;c<array.length;c++)
        {
            array[c]=array2[c];
        }

    }

    public static void main(String[] args) {
        int array[]={1,5,6,7,89,616,15,11515,1515,116,54,58,4641,456,258,214,656};
        reOrderArray(array);
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }
    }
}
