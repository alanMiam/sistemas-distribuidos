
package newpackage;
import java.io.*; 
import java.util.*; 
/**
 *
 * @author Miam
 */
public class InformacionArchivo {

    public static void main(String args[]) throws IOException {
        File archivo = new File("\"C:\\\\Users\\\\Miam\\\\Documents\"");
        if ((archivo.exists()) && (archivo.isFile())) {
            System.out.println("Nombre: " + archivo.getName());
            System.out.println("Ruta absoluta " + archivo.getAbsolutePath());
            System.out.println("Ruta: " + archivo.getPath());
            System.out.println("Padre: " + archivo.getParent());
            System.out.println("¿Admite lectura? " + archivo.canRead());
            System.out.println("¿Admite escritura? " + archivo.canWrite());
            System.out.println("Tamaño en bytes: " + archivo.length());
            System.out.println("Fecha de la última modificación: "
                    + new Date(archivo.lastModified()));
        } else {
            System.out.println("No existe ningún archivo con esa ruta");
        }
    }

}
