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
    
    public String adicionarEmpresa(String razonSocial, String nit){
        Empresa empresa = new Empresa(razonSocial, nit);
        return banco.adicionarEmpresa(empresa);
    }
    
    public String agregarEmpresa(String ced, String nit){
        return banco.agregarEmpresa(ced, nit);
    }
    
    public String agregarClientesEnEspera(boolean check, String per, String est, String nom, String ape, String ced, String edad, String genero, String in, String eg, String act){
        Cliente cliente = new Cliente(per, est, nom, ape, ced, edad, genero, in, eg, act);
        Representante representante = new Representante(per, est, nom, ape, ced, edad, genero, in, eg, act);
        return banco.agregarClientesEnEspera(check, representante, cliente);
    }
    
    public String agregarClientesAceptados(String cedula){
        return banco.agregarClientesAceptados(cedula);
    }
    
    public String eliminarClientes(String cedula){
        return banco.eliminarClientes(cedula);
    }
    
    public String modificarClientes(boolean check, String per, String est, String nom, String ape, String ced, String edad, String genero, String in, String eg, String act){
        return banco.modificarClientes(check, per, est, nom, ape, ced, edad, genero, in, eg, act);
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
    
    public String agregarCuentaCorriente(String cedula, String num, String saldo, String DS, String IRM){
        return banco.agregarCuentaCorriente(cedula, num, saldo, DS, IRM);
    }
    
    public String agregarCuentaAhorros(String cedula, String num, String saldo, String IRM){
        return banco.agregarCuentaAhorros(cedula, num, saldo, IRM);
    }
    
    public String agregarTCredito(String cedula, String numTarjeta, String numSeguridad, String cupoT, String gastoT, String cupoA, String expedicion, String vencimiento, String contraseña){
        return banco.agregarTCredito(cedula, numTarjeta, numSeguridad, cupoT, gastoT, cupoA, expedicion, vencimiento, contraseña);
    }
    
    public String agregarTDebito(String cedula, String expedicion, String estado){
        return banco.agregarTDebito(cedula, expedicion, estado);
    }
    
    public String agregarChequera(String cedula, String numChequera){
        return banco.agregarChequera(cedula, numChequera);
    }
    
    public String consultarCuentaCorriente(String ced){
        return banco.consultarCuentaCorriente(ced);
    }
    
    public String consultarCuentaAhorros(String ced){
        return banco.consultarCuentaAhorros(ced);
    }
    
    public String consultarTCredito(String ced){
        return banco.consultarTCredito(ced);
    }
    
    public String consultarTDebito(String ced){
        return banco.consultarTDebito(ced);
    }
    
    public String consultarChequera(String ced){
        return banco.consultarChequera(ced);
    }
    
    public String asociarCCTDevito(String ced){
        return banco.asociarCCTDevito(ced);
    }
    
    public String asociarCATDevito(String ced){
        return banco.asociarCATDevito(ced);
    }
    
    public String asociarCCChequera(String ced){
        return banco.asociarCCChequera(ced);
    }
    
    public String agregarCheque(String ced, String estado, String valor, String beneficiario, String fechaG, String sede, boolean cruzado, String fechaC){
        return banco.agregarCheque(ced, estado, valor, beneficiario, fechaG, sede, cruzado, fechaC);
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
