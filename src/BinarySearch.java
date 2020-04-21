public class BinarySearch {
    public static int  binarysearch(int a[],int target)
    {
        int left=0;
        int right=a.length-1;
        int mid=(left+right)/2;
        while(left<=right) {
            int midtarget = a[mid];
            if (target < midtarget) {
                right = mid - 1;
            } else if (target > midtarget) {
                left = mid + 1;
            } else {

                return mid;
            }
            mid = mid = (left + right) / 2;
        }
        return -1;
    }
    public static void main(String[] args) {

        int a[]={1,4,8,12,34,56,78,100};
        int target=12;
        int c=binarysearch(a,12);
        System.out.println("我们可以知道C存在的位置是"+c);
    }
}
