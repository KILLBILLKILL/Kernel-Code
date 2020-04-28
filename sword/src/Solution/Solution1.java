package Solution;

public class Solution1 {
    /**二维数组中的查找
     * 题目描述
     在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     判断数组中是否含有该整数。
     */
    public boolean Find(int target, int [][] array) {
        int row=array.length;
        int col=array[0].length;
        int c=col-1;
        int r=0;
        while(c>=0&&r<row)
        {
            if(target==array[r][c])
                return true;
            if(target<array[r][c])
                c--;
            else
                r++;
            }
        return false;
    }
    public static void main(String[] args){
        int [][]array={{1,23,4,5,6},{1,5,6,1,61},{1,5,6,1,6},{1,5,6,1,6}};
        int row=array.length;//行和列row and column
        System.out.println(row);
        int col=array[0].length;
        System.out.println(col);
    }
}
