package minichat2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import javax.swing.DefaultListModel;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 * @since 2022/04/19
 * @author Miam
 * @version 1.0.0
 */
public class HiloServidor extends Thread{
    private DataInputStream entrada;
    private DataOutputStream salida;
    private Servidor server;
    private Socket Cliente;
    private static Vector<HiloServidor> usuarioActivo = new Vector();
    private String nombre;
    private ObjectOutputStream salidaObjeto;

    public HiloServidor(Socket socketcliente, String nombre, Servidor serv) throws Exception{
        this.Cliente=socketcliente;
        this.server=serv;
        this.nombre=nombre;
        usuarioActivo.add(this);

        for (int i = 0; i < usuarioActivo.size(); i++) {
            usuarioActivo.get(i).enviosMensajes(nombre+": Se ha conectado");
        }
    }
    public void run(){
        String mensaje=" ";
        while(true){
            try{
                entrada = new DataInputStream(Cliente.getInputStream());
                mensaje =entrada.readUTF();
                for (int i = 0; i < usuarioActivo.size(); i++) {
                    usuarioActivo.get(i).enviosMensajes(mensaje);
                    server.mensajeria("Mensaje enviado.");
                }
            }catch(Exception e){
                break;
            }
        }   
        usuarioActivo.removeElement(this);
        server.mensajeria(nombre +" El usuario se ha desconectado"); //ELIMINAR nombre SI DA PROBLEMAS
        
        try{
            Cliente.close();
        }catch(Exception e){

        }
    }
    private void enviosMensajes(String msg) throws Exception{
        salida = new DataOutputStream(Cliente.getOutputStream());
        salida.writeUTF(msg);
        DefaultListModel modelo = new DefaultListModel();

        for (int i = 0; i < usuarioActivo.size(); i++) {
            modelo.addElement(usuarioActivo.get(i).nombre);
        }
        salidaObjeto=new ObjectOutputStream(Cliente.getOutputStream());
        salidaObjeto.writeObject(modelo);
    }
}

