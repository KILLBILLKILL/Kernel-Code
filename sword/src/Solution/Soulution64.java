package Solution;

/**
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，
 * 向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 [abcesfcsadee]\begin{bmatrix} a & b & c &e \\ s & f & c & s \\ a & d & e& e\\ \end{bmatrix}\
 * quad⎣⎡​asa​bfd​cce​ese​⎦⎤​  矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */
public class Soulution64 {
    private int[][] visited;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        visited=new int[rows][cols];
        for(int x=0;x<=rows-1;x++)
        {
          for(int y=0;y<=cols-1;y++)
          {
              if(findNext(matrix,rows,cols,x,y,str,0))
              {
                  return true;
              }

          }
        }
        return false;
    }

    public boolean findNext(char[] matrix, int rows, int cols,int x,int y,char[] str,int k)
    {
        if(k==str.length)
            return true;
        if(x<0||y<0||x>=rows||y>=cols||visited[x][y]==1)
            return false;
        if(str[k]!=matrix[x*cols+y])
            return false;
        //下面就是当前相同  朝四面八方按照顺时针顺序走
        visited[x][y]=1;
        if(findNext(matrix,rows,cols,x+1,y,str,k+1))return true;
        if(findNext(matrix,rows,cols,x,y+1,str,k+1))return true;
        if(findNext(matrix,rows,cols,x-1,y,str,k+1))return true;
        if(findNext(matrix,rows,cols,x,y-1,str,k+1))return true;
        visited[x][y]=0;
        return false;

    }


}
