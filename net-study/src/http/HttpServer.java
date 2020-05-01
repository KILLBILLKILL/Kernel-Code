package http;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class HttpServer {
    private static final int PORT=9999;//
    private static final ExecutorService POOL= Executors.newCachedThreadPool();
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(PORT);
        while (true)
        {
            //阻塞等待新的客户端连接
            Socket socket= serverSocket.accept();
            POOL.execute(new HttpTask(socket));
        }
    }
}

