package serverconnect;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1b {
    public static void main(String[] args) throws UnknownHostException, IOException{
        Socket socket = new Socket("localhost",3001);
        
        try (OutputStream os = socket.getOutputStream()) {
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);
            //below line will read from console
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String msg = "";

            while (!msg.equals("exit")){
                msg = br.readLine();
                dos.writeUTF(msg);
                dos.flush();
            }

        }

       socket.close();

    }



}

