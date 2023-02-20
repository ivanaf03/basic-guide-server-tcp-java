import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args){
        final String host="127.0.0.1";
        final int puerto=5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket socket=new Socket(host, puerto);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hola mundo desde el cliente");
            System.out.println(in.readUTF());
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
