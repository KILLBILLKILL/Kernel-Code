package http;

import java.net.Socket;

public class HttpTsak implements Runnable {

    private Socket socket;

    public HttpTsak(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {

    }
}
