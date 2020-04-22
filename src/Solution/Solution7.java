package Solution;
/*
1、判断两个升序数组其中一个是另外一个数组的子集，需要满足以下两个条件：
    数组N的所有元素都能在数组M中找到；
    数组N项中元素重复项的个数不能大于数组M中元素重复项的个数。
 */
public class Solution7 {
    public static boolean isIn(int arrM[],int arrN[])
    {
        int m=arrM.length;
        int n= arrN.length;
        int i=0,j=0;
        while(m>n&&i<m&&j<n)
        {
            if(arrM[i]<arrN[j])
            {
                i++;
            }
            else if(arrN[j]>arrM[i])
            {
                return false;
            }
            else{
                i++;
                j++;
            }

        }
        if(j<n)
        {
            return false;
        }
        else{

            return true;
        }
    }


    public static void main(String[] args) {

        int arrM[]={1,2,2,3,3,4,4,5,5};
        int arrN[]={1,2,3,4,5};
        Boolean m=isIn(arrM,arrN);
        System.out.println(m);

    }

}
