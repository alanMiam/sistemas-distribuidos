
package paquete;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miam
 */
public class Cliente implements Runnable{
    private int puerto;
    private String mensaje;

    public Cliente(int puerto, String mensaje){
        this.puerto=puerto;
        this.mensaje=mensaje;
    }


    public void run(){
        final String HOST = "192.168.0.13";
        //DataInputStream in;
        DataOutputStream out;

        try {
            Socket sc = new Socket(HOST, puerto);
            //in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(mensaje);
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    


}
