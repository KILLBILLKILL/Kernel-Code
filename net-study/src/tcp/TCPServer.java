package tcp;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
public class TCPServer {
    private  static final int PORT=9999;
    /**
     * 参数1： 核心线程数（正式工，启动线程池就运行这个数量的线程）
     * 参数2： 最大线程数（正式工+临时工）
     * 参数3+4：一定数量的时间+时间单位，临时工的线程没有任务处理，把临时工解雇掉（关闭线程）
     * 参数5：   无边界的工作队列
     * 参数6：  任务数量超出最大值，线程池应该怎么做（4中策略，简单了解）
     */
    // 有新任务进来需要处理 ，此时正式线程空闲，就让正式工处理，
    // 如果正式工都没有空闲，让临时工处理（以来哪一种线程池实现）
    //如果都没有空闲的，就创建新的先线程处理（依赖具体哪一种线程池的实现）（新的线程加入正式工或者临时工）
//    private  static ThreadPoolExecutor POOL=new ThreadPoolExecutor(0,Integer.MAX_VALUE,
//            30, TimeUnit.SECONDS,new
//            LinkedBlockingDeque<>(),new ThreadPoolExecutor.CallerRunsPolicy());
    //线程池中使用的线程，在参数3+4的时间范围内，是可以重用
    //单个线程的线程池 只有一个正式工
//    private static final ExecutorService EXE=Executors.newSingleThreadExecutor();
//    可缓存的线程池 ：正式工编制为0，所有线程都是临时工
    private static final ExecutorService EXE=Executors.newCachedThreadPool();
    //定时任务的线程池
//    private static final ExecutorService EXE=Executors.newScheduledThreadPool(1);
    //固定大小的线程池 只有固定数量编制的正式工
//    private static final ExecutorService EXE=Executors.newFixedThreadPool(1);
    public static void main(String[] args) throws IOException {
        //启动TCP服务器
        ServerSocket serverSocket=new ServerSocket(PORT);
        //循环获取新的客户端连接
        while(true)
        {
            //阻塞 等待新的客户端连接
            Socket socket = serverSocket.accept();
            /**
             * 多线程解决多个客户端连接的问题
             * 需要使用CatchThreadPool这种类型，
             * 如果使用固定大小的线程池在达到线程数量的客户端连接之后
             * 新的客户端就会阻塞
             */
            EXE.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //处理这个客户端连接的业务，这个业务可能会发生阻塞
                        //先不考虑阻塞的实现
                        InputStream is=socket.getInputStream();//获取到的是socket帮我们包装的一个输入字节流
                        //缓冲字符流BufferedReader/BufferedWriter:字节流要转换为字符流，需要通过
                        //InputStreamReader/OutputStreamWriter字节字符转换流来进行转换
                        BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
                        OutputStream os=socket.getOutputStream();//获取到的是socket帮我们包装的一个输出字节流
                        PrintWriter pw=new PrintWriter(new OutputStreamWriter(os,"UTF-8"),true);
                        //1.先接受客户端传过来的数据，并打印出来
                        //2.响应给客户端一个数据：我已经接收到了XXXX消息
                        String line;
                        //阻塞等待客户端传过来的新的一行数据 :readline读取到换行符之前的部分
                        //接收到（Line+\n)通过readline返回字符串就是Line
                        while((line=br.readLine())!=null)//需要IO流关闭，或者客户端方法返回 (IO流关闭）
                        {
                            System.out.println("服务端接收到数据:"+line);
                            //write操作指的是将数据写入缓冲区
                            pw.println("我已经接收到了"+line+"消息");
                            //需要刷新一下缓冲区,这个时候才会将数据发送到对端
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
