/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listadodirectorio;

import java.io.*;

public class ListadoDirectorio {

    public static void main(String args[]) throws IOException {
        File directorio = new File("C:\Users\Miam\Documents");
        if ((directorio.exists()) && (directorio.isDirectory())) {
            String[] lista = directorio.list();
            for (int i = 0; i < lista.length; i++) {
                System.out.println(lista[i]);
            }
        } else {
            System.out.println("El directorio no existe");
        }
    }
}
