package Solution;
import java.util.ArrayDeque;
import java.util.Queue;

/*
两个队列实现一个栈
两个队列添加元素，哪个队列为空，由于在输出元素时，要进行相应元素的移动（除去尾部元素），
所以要在对应不为空的队列进行元素的添加；
在输出数据时，要进行两个队列的变相操作，不为空的队列要依次向为空的队列中添加元素
直到尾元素输出即可！
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
        //如果queue1是空的，2有数据 则把2中的数据只留下一个剩下的全部放入1中 然后弹出
        if(queue1.isEmpty())
        {
            while(queue2.size()>1)
            {
                queue1.add(queue2.poll());
            }

            return queue2.poll();
        }
        //反之亦然
        if(queue2.isEmpty())
        {
            while(queue1.size()>1)
            {
                queue2.add(queue1.poll());
            }

            return queue1.poll();
        }
        return (Integer)null;
    }
    public static void main(String[] args) {
        Solution5 solution5=new Solution5();
        solution5.push(1);
        solution5.push(2);
        solution5.push(3);
        solution5.push(4);
        solution5.push(5);
        System.out.println(solution5.pop());
        System.out.println(solution5.pop());
        System.out.println(solution5.pop());
        solution5.push(8);
        System.out.println(solution5.pop());
    }
}
