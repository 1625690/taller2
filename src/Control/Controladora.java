/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Banco;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author invitado
 */
public class Controladora {
    
    //-------------------------------------------------------------------------
    // ATRIBUTOS
    //-------------------------------------------------------------------------
    
    /**
     * Instancia del banco en la controladora
     */
    private Banco banco;
    
    //-------------------------------------------------------------------------
    // CONSTRUCTOR
    //-------------------------------------------------------------------------


    public Controladora() {
        banco = new Banco();
    }
    
    //-------------------------------------------------------------------------
    // LECTURA Y ESCRITURA
    //------------------------------------------------------------------------- 
    
    /**
     * metodo que escribe 
     */
    public void escribirOFAC(){
                

           try {
               BufferedWriter br = new BufferedWriter(new FileWriter("archivo.txt"));
               br.write("hola");
               br.newLine();
               br.write("Univalle");
               br.newLine();
               br.newLine();
               br.write("Escribir Archivos es importante.");
               br.flush();      
               br.close();
           } 
           catch(Exception e){
               System.out.println("Excepción Generada");
           }
    }
    
    public void leerOFAC(){
        
    }
    
}
