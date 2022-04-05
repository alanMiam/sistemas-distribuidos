/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.io.*;

public class CrearDirectorioYArchivo {

    public static void main(String args[]) throws Exception {
        // Si no se le dan argumentos, toma valores por defecto


    private static String DIR = "c:/temporal"; // directorio en formato Windows
    private static String ARCHIVO = "temporal.txt";


    private static boolean crearDirectorio(String dir) {
        boolean dirCreado = false;

        dirCreado = (new File(dir)).mkdir();
        if (dirCreado) {
            System.out.println("Directorio creado.");
            return true;
        } else {
            System.out.println("No pudo crearse el directorio.");
            return false;
        }
    }

    private static void crearArchivo(String dir, String archivo) {
        boolean archCreado = false;

        try {
            archCreado = new File(dir, archivo).createNewFile();
        } catch (IOException e) {
            System.out.println("No pudo crearse el archivo.");
        }
        if (archCreado) {
            System.out.println("Archivo creado.");
        } else {
            System.out.println("No pudo crearse el archivo porque ya existe.");
        }
    }
    private static void crearArchivoYDirectorio(String dir, String archivo) {
        boolean dirCreado = false;
        File temp = new File(dir);

        if ((temp.exists()) && (temp.isDirectory())) {
            crearArchivo(dir, archivo);
        } else {
            dirCreado = crearDirectorio(dir);
            if (dirCreado) {
                crearArchivo(dir, archivo);

    } 
}
}
}
