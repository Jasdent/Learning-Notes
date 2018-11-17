package socket_comm;
import java.net.*;
import java.io.*;
import javax.activation.*;


public class Server {

    private ServerSocket server = null;
    private Socket socket = null;
    private DataInputStream input = null;
    // private DataOutputStream output = null; No output stream needed

    public Server(int port){
        try {

            server = new ServerSocket(port);
            // 服务器实例化一个 ServerSocket 对象，打开一个端口
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            // 监听这个端口
            socket = server.accept(); // equivalent to s.listen and s.accept in python
            System.out.println("Client accepted");

            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            // take input from client socket, buffer it, then form the data
            String line = "";

            while(!line.equals("Over")){
                try {
                    line = input.readUTF();
                    System.out.println(line);
                }
                catch (IOException i){
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            input.close();
            socket.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args){
        Server server = new Server(5000);
    }

}

/* Multi-threading lifecycle */