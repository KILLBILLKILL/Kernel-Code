package tcp;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class TCPServer {
    private  static final int PORT=9999;
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
             */
            new Thread(new Runnable() {
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
                            System.out.printf("服务端接收到数据:"+line);
                            //write操作指的是将数据写入缓冲区
                            pw.println("我已经接收到了"+line+"消息");
                            //需要刷新一下缓冲区,这个时候才会将数据发送到对端
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

    }


}
