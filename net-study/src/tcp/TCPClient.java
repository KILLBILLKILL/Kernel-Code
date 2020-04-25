package tcp;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    //本机默认的域名，默认IP就是127.0.0.1
    private static final String Host="localhost";
    //losthost会通过本机：C://windows/system32/drivers/etc/host 文件（本机DNS）转换为本机的IP地址
    //127.0.0.1
    //本机默认的ip
//    private static final String Host="127.0.0.1";
    private static final int PORT=9999;
    public static void main(String[] args) throws IOException {
        //建立了一个客户端到服务端的tcp连接
        Socket socket = new Socket(Host, PORT);
        //循环获取新的客户端连接
        InputStream is = socket.getInputStream();//获取到的是socket帮我们包装的一个输入字节流
        //缓冲字符流BufferedReader/BufferedWriter:字节流要转换为字符流，需要通过
        //InputStreamReader/OutputStreamWriter字节字符转换流来进行转换
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        OutputStream os = socket.getOutputStream();//获取到的是socket帮我们包装的一个输出字节流
        PrintWriter pw=new PrintWriter(os,true);
//        pw.println("Hello,我来了");
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine())
        {
            String line=scanner.nextLine();//已经去除了换行符
            //发送数据报到服务端
            pw.println(line);//发送的数据包会加上换行符
            //接收服务端的响应信息
            String response=br.readLine();
            System.out.println("接收到服务端响应："+response+"\n");

        }

        }
    }


