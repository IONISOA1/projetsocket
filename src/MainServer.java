
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    ObjectOutputStream output;
    ObjectInputStream input;
    BufferedReader pen;
    String message;
    Socket connection;
    ServerSocket serveur;
    int totalClients = 100;
    int port = 6789;

    public MainServer(){

    }
    public void startRunning(){
        try{
            serveur = new ServerSocket(port, totalClients);
            while(true){

                try{
                    connection = serveur.accept();
                    pen = new BufferedReader(new InputStreamReader(System.in));
                    output = new ObjectOutputStream(connection.getOutputStream());
                    input = new ObjectInputStream(connection.getInputStream());
                    System.out.println("client.....");
                    //whileChatting();
                }catch(EOFException e){

                }
            }
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
}
