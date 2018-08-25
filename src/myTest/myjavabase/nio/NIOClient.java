package myTest.myjavabase.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class NIOClient {
    public static void main(String[] args) throws IOException {
        for(int i = 0;i < 10;i ++){
            new Thread(()->{
                Socket socket = null;
                try {
                    socket = new Socket("127.0.0.1", 8888);
                    OutputStream out = socket.getOutputStream();
                    String s = "hello world " + Thread.currentThread().getName();
                    out.write(s.getBytes());
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();
        }

    }
}
