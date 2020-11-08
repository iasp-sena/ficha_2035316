/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsandstreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ismael
 */
public class Main2 {

    public static void main(String[] args) {
        File file = new File(Main2.class.getResource("resources/usuarios.txt").getPath());

        try (Reader fileReader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(fileReader);) {
            String linea = null;
            while (Objects.nonNull(linea = buffer.readLine())) {
                System.out.println(linea);
            }
            
        } catch (IOException ex) {
            System.out.println("Se ejecuta porque se presentó una Excepción...");
        } finally {
            System.out.println("Siempre se ejecuta...");
        }
        
        try(Writer fileWriter = new FileWriter(file, true);
            BufferedWriter buffer = new BufferedWriter(fileWriter);) {
            
            buffer.write("Escribitmos en el archivo");
        } catch (IOException ex) {
            System.out.println("Se ejecuta porque se presentó una Excepción...");
        } finally {
            System.out.println("Siempre se ejecuta...");
        }

    }
}
