package http;

import java.io.IOException;
import java.net.Socket;

public class HttpTsak implements Runnable {
    private  Request request;
    public HttpTsak(Socket socket)
    {
        try {
            //通过客户端发送报文的输入流（请求数据）创建http请求对象
            request=Request.buildRequest(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("客户端连接的IO流出错",e);
        }
    }
    @Override
    public void run() {



    }
}
