package one;
import java.util.Scanner;
public class ScannerTest {
    /*
    题目要求10组测试用例 每个测试用路完成某一块逻辑/业务
    每个测试用例
          先输入一行数字（整形）4
          在输入一行数字（一组数字）4个数字：5 6 2 1
          再做 业务
     */
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        //10组测试用例
        for(int i=0;i<10;i++)
        {
            //每组测试例要干的事
            //1.都是阻塞的方法 造成当前线程阻塞
            //2.满足一定的条件才返回：
            // hasNext满足换行符字符才返回
            //hasNextLine 满足换行符
            //hasNextInt读取到不满足int数值的字符

            //io流中的数据 读写只执行一次
//            sc.hasNext();
//            while(sc.hasNext())//非读取的操作
//            {
////                sc.next();
//                System.out.println(sc.next());//读取的操作
//            }
            int count=sc.nextInt();//读取第一行数字 4
            for(int j=0;j<count;j++)
            {
                int current=sc.nextInt();
                System.out.println(current);
            }
        }
    }
}
