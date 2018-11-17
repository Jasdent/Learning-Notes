package socket_comm;


import java.net.*;
import java.io.*;
import java.util.Scanner;

/* Client side */
// step 1: make a socket
public class Client {
    private Socket socket = null; // init compile time type
    private DataInputStream input = null;
    private DataOutputStream output = null;
    private Scanner scanner = new Scanner(System.in);

    // All are done in the constructor
    public Client(String addr,int port){
        // establish a connection: open a socket

        try {
            // establish a connection, but not yet communicating
            this.socket = new Socket(addr, port);
            // Creates a stream socket and connects it to
            // the specified port number on the named host (请求目的地).
            System.out.println("Connected");
            // this.input = new DataInputStream(System.in); // It defines that the input source is from the console
            this.output = new DataOutputStream(socket.getOutputStream());

        }
        catch (UnknownHostException u){
            System.out.println(u);
        }
        catch (IOException i){
            System.out.println(i);
        }

        String line = "";

        while(!line.equals("Over")){
            try{
                line = scanner.nextLine();
                this.output.writeUTF(line);
            }
            catch (IOException i){
                System.out.println(i);
            }
            catch (NullPointerException n){
                System.out.println(n);
            }
        }

        try{
            // input.close();
            output.close();
            socket.close();
        }
        catch (IOException i){
            System.out.println(i);
        }

    }

    public static void main(String[] args){
        Client client = new Client("127.0.0.1",5000);
        // addr is the localhost server addr, it does not matter what addr the client has

    }

}
