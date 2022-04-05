
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

class Conexion extends Thread {

        private Socket socketCliente;
        private PrintWriter salida;

        public Conexion(Socket socketCliente) {
            this.socketCliente = socketCliente;
        }

        public void run() {
            try {
                salida = new PrintWriter(socketCliente.getOutputStream(), true);
                salida.println("FUGA LA ORUGA");
                socketCliente.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    socketCliente.close();
                } catch (IOException e2) {
                }
            }
        }

    }