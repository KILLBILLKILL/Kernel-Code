package Sort;

import java.util.Arrays;

public class MergetSort {
    public static void main(String[] args) {
        int arr[]={8,4,5,7,1,3,6,2};
        int temp[]=new int[arr.length];//归并排序需要额外的空间开销
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("归并排序之后"+ Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr,int left,int right,int []temp)
    {
        if(left<right)
        {
            int mid=(left+right)/2; //中间索引
            mergeSort(arr,left,mid,temp);//向左递归索引
            mergeSort(arr,mid+1,right,temp);//向右递归索引
            //合并
            merge(arr,left,mid,right,temp);
        }
    }
    //合并的方法
    /*  arr 排序的原始数组
       left 左边有序序列的原始索引
       Mid  中间索引
       right 右边索引
       temp 做中转的数组
     */
    public static void merge(int []arr,int left,int mid,int right,int temp[]){
        int i=left;//初始化i 左边有序序列的初始索引
        int j=mid+1;//初始化j,右边有序序列的初始索引
        int t=0;//t  指向temp数组的当前索引
        //------
        //先把左右两边（有序）的数据 按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕
        while(i<=mid&&j<=right)//继续
        {
            //如果我们发现左边的有序序列的当前元素小于等于 右边有序序列的当前元素
            //即将左边的当前元素。拷贝到temp数组
            //t++ i++
            if(arr[i]<=arr[j])
            {
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }
            else{//反之  将右边有序序列的当前元素，填充到temp数组
                temp[t]=arr[j];
                t+=1;
                j+=1;
            }
        }
        //二
        //将temp数组的元素拷贝到arr
        while(i<=mid)
        {//左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while(j<=right)
        {
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }
        //三
        // 将temp数组拷贝过去 并不是每次都拷贝所有的           0  1     2   3     0   3
        //最后一次才是0和7
        t=0;
        int templeft=left;
        System.out.println("templeft="+templeft+"right="+right);
        while(templeft<=right)
        {
            arr[templeft]=temp[t];
            t+=1;
            templeft+=1;
        }
    }
}
