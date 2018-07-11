package myTest.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServerDemo {
    private ServerSocket serverSocket;
    private DataInputStream dataInputStream;

    public void startServer(){
        Socket socket =null;
        try {
            serverSocket = new ServerSocket(10003);
            socket = serverSocket.accept();
            dataInputStream = new DataInputStream(socket.getInputStream());
            GetMessageFromClient();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(socket!=null){
                try{
                    socket.close();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void GetMessageFromClient(){
        try {
            //获取消息的长度
            int length = dataInputStream.read();

            //获取消息
            byte[] body = new byte[length];
            dataInputStream.read(body);

            String message = new String(body);
            System.out.println("客户端说："+message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TCPServerDemo server = new TCPServerDemo();
        server.startServer();
    }

}

