package serverconnect;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Server listens, repeat text sent from client before close

public class ServerConnect1b {
    public static void main(String[] args) throws IOException{
        //create server socket, create accept method
        System.out.println("Listening at port 3001");
        ServerSocket serverSocket = new ServerSocket(3001);
        Socket socket = serverSocket.accept();

        //InputStream is;

        try (InputStream is = socket.getInputStream()) {
            //Next line below same meaning as above bracket lines ^
            //is = socket.getInputStream()
            /* BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis); */
            //Next line below same meaning as above 2 lines ^
            DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
            String msg = "";

            while (!msg.equals("exit")){
                msg = dis.readUTF();
                System.out.println("Message: " + msg);
            }

        } //catch (Exception e){
          //}
            socket.close();
      serverSocket.close();
    
    }
}
