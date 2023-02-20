import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;
        try {
            ServerSocket servidor = new ServerSocket(5000); //creamos el servidor
            //Servidor iniciado
            while (true) {
                socket = servidor.accept(); //Espera la petición
                System.out.println("Cliente conectado");
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                String message = in.readUTF(); //Se queda esperando a que se le pase el mensaje
                System.out.println(message);
                out.writeUTF("Hola mundo desde el server"); //Respuesta del server
                socket.close();
                System.out.println("Cliente desconectado");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
