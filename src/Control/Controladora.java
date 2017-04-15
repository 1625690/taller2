/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;

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
    
    public String agregarEmpresa(String ced, String razonSocial, String nit){
        Empresa empresa = new Empresa(razonSocial, nit);
        return banco.agregarEmpresa(ced, empresa);
    }
    
    public String agregarClientesEnEspera(boolean check, String nom, String ape, String ced, String edad, String genero, String in, String eg, String act){
        Cliente cliente = new Cliente(nom, ape, ced, edad, genero, in, eg, act);
        Representante representante = new Representante(nom, ape, ced, edad, genero, in, eg, act);
        return banco.agregarClientesEnEspera(check, representante, cliente);
    }
    
    public String agregarClientesAceptados(String cedula){
        return banco.agregarClientesAceptados(cedula);
    }
    
    public String eliminarClientes(String cedula){
        return banco.eliminarClientes(cedula);
    }
    
    public String modificarClientes(boolean check, String nom, String ape, String ced, String edad, String genero, String in, String eg, String act){
        return banco.modificarClientes(check, nom, ape, ced, edad, genero, in, eg, act);
    }
    
    public String consultarClientes(String cedula){
        return banco.consultarClientes(cedula);
    }
    
    public String adicionarReferencias(String ced, String tipo, String nombre, String apellido, String cedula, String numeroContacto){
        Referencia ref = new Referencia(tipo, nombre, apellido, cedula, numeroContacto);
        return banco.adicionarReferencias(ced, ref);
    }
    
    public String modificarReferencias(String ced, String tipo, String nombre, String apellido, String cedula, String numeroContacto){
        Referencia ref = new Referencia(tipo, nombre, apellido, cedula, numeroContacto);
        return banco.modificarReferencias(ced, ref);
    }
    
    public String eliminarReferencias(String ced, String cedula){
        return banco.eliminarReferencias(ced, cedula);
    }
    
    public String consultarReferencias(String ced, String cedula){
        return banco.consultarReferencias(ced, cedula);
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
