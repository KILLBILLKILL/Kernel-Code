package Solution;

public class Solution1 {
    /**二维数组中的查找
     * 题目描述
     在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     判断数组中是否含有该整数。
     */
    public boolean Find(int target, int [][] array) {
        int rows=array.length;
        int clos=array[0].length;
        int j=clos-1;
        int i=0;
        while(j>=0&&i<rows)
        {
            if(array[i][j]==target)
                return true;
            if(array[i][j]>target)
                j--;
            else
                i++;
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
