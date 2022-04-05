import java.net.*; //utiliza sockets UDP
import java.io.*; 

//parte de servidor
public class ServidorSaludoUDP {

    private static byte[] buffer; 	//almacena los caracteres a pasar
    private static byte[] datos; 	//almacena la información

    public static void main(String args[]) {
        try {
            DatagramSocket socket = new DatagramSocket(9000); //Utiliza el puerto 9000
            buffer = new byte[1024]; 			//Longitud máxima del buffer 1024 bytes	
            while (true) {
                DatagramPacket datagrama = new DatagramPacket(buffer, buffer.length);
                socket.receive(datagrama); 		//Recive lo que está en el buffer
                InetAddress hostDestino = datagrama.getAddress();   //Obtener la dirección de origen
                int puertoDestino = datagrama.getPort(); 	    //Obtener el puerto de 
                datos = datagrama.getData();
                String cadena = new String(datos, 0, datos.length);
                System.out.println("Bienvenido al servidor. Envío por el puerto "
                        + puertoDestino + " el mensaje: " + cadena);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    

