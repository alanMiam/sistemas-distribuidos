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

    private String host;
    private int puerto;
    private String mensaje;

    public Cliente(String host, int puerto, String mensaje){
        this.host=host;
        this.puerto=puerto;
        this.mensaje=mensaje;
    }

    public void run(){
        final String host = "192.168.0.17"; // VERIFICAR LA DIRECCIÓN ANTES DE EJECUTAR
        //DataInputStream in;
        DataOutputStream out;

        try {
            Socket sc = new Socket(host, puerto);
            //in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(mensaje);
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    


}
