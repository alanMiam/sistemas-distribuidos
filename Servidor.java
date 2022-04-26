package paquete;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Observable;


/**
 *
 * @author Miam
 */
public class Servidor extends Observable implements Runnable{
    private int puerto;
    public Servidor(int puerto){
        this.puerto = puerto;
    }    


    public void run(){

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        try{
            servidor = new ServerSocket (puerto);
            System.out.println("INICIADO");

            while(true){
                sc = servidor.accept();
                in = new DataInputStream(sc.getInputStream());

                String mensaje = in.readUTF();
                System.out.println(mensaje);

                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();

                sc.close();
                System.out.println("Cliente desconectado");
            }
        }catch(IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
