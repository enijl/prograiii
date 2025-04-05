package umg.edu.gt.test.EjercicioTree;

import java.io.*;
import java.util.*;

public class FrecuenciaPalabras {

    public static void analizarFrecuencia(String archivo) {
        InputStream inputStream = FrecuenciaPalabras.class.getClassLoader().getResourceAsStream(archivo);
        
        if (inputStream == null) {
            System.out.println("Archivo no encontrado: " + archivo);
            return;
        }
        
        TreeMap<String, Integer> frecuencias = new TreeMap<>();
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.toLowerCase().replaceAll("[^a-záéíóúñ]+", " ").split("\\s+");

                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("Frecuencia de las palabras:");
        for (Map.Entry<String, Integer> entry : frecuencias.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        analizarFrecuencia("Recursos/datos.txt");
    }
}
