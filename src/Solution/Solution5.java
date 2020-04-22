package Solution;
import java.util.ArrayDeque;
import java.util.Queue;
/*
两个队列实现一个栈
 */
public class Solution5 {
    Queue<Integer> queue1=new ArrayDeque<>();
    Queue<Integer> queue2=new ArrayDeque<>();
    public void push(Integer in)
    {
        //两个队列都为空的时候优先考虑queue1
        if(queue1.isEmpty()&&queue2.isEmpty())
        {
            queue1.add(in);
            return ;
        }
        //queue1有数据queue2没有数据我们就直接插入queue1
        if(queue2.isEmpty())
        {
            queue1.add(in);
            return ;
        }
        //queue2有数据queue1没有数据我们就直接插入queue2
        if(queue1.isEmpty())
        {
            queue2.add(in);
            return ;
        }
    }
    public Integer pop()
    {
        if(queue2.isEmpty()&&queue1.isEmpty())
        {
            try{

                throw  new Exception("stack is  Empty");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        //如果
        if()



    }




}
