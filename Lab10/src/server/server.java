package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server implements Runnable {
    int port;
    private ServerSocket serverSocket;
    public server(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
    }
    public void run() {
        System.out.println("SimpleBBS Server Listening on: " + port);

        while(true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            RequestHandler handler = new RequestHandler(socket);
            Thread handlerThread = new Thread(handler);
            handlerThread.start();
        }
    }

}