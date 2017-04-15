/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;
/**
 * Representa un cliente dentro de la entidad bancaria
 * @author invitado
 */
public class Cliente {
    
    //-------------------------------------------------------------------------
    // ATRIBUTOS
    //-------------------------------------------------------------------------
    
    /**
     * Atributos 
     */
    private String nombre, apellido, cedula, edad, genero, ingresos, egresos, actEconomica;
    
    /**
     * Coleccion con las referencias del cliente
     */
    private HashMap referencias;
    
    //-------------------------------------------------------------------------
    // CONSTRUCTOR
    //-------------------------------------------------------------------------
    
    /**
     * Constructor de Cliente
     * @param nom - Nombre del cliente
     * @param ape - Apellido del cliente
     * @param ced - Cedula del cliente
     * @param edad -  Edad del cliente
     * @param genero - Genero del cliente
     * @param in - Ingresos del cliente
     * @param eg - Egresos del cliente
     * @param act - Actividad económica
     */
    public Cliente(String nom, String ape, String ced, String edad, String genero, String in, String eg, String act){
        this.nombre = nom;
        this.apellido = ape;
        this.cedula = ced;  
        this.edad = edad;
        this.genero = genero;
        this.ingresos = in;
        this.egresos = eg;
        this.actEconomica = act;
        this.referencias = new HashMap();
    }
    
    //-------------------------------------------------------------------------
    // GETS & SETS
    //-------------------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getIngresos() {
        return ingresos;
    }

    public String getEgresos() {
        return egresos;
    }

    public String getActEconomica() {
        return actEconomica;
    }

    public HashMap getReferencias() {
        return referencias;
    }  

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIngresos(String ingresos) {
        this.ingresos = ingresos;
    }

    public void setEgresos(String egresos) {
        this.egresos = egresos;
    }

    public void setActEconomica(String actEconomica) {
        this.actEconomica = actEconomica;
    }

    public void setReferencias(HashMap referencias) {
        this.referencias = referencias;
    }
    
    public String agregarReferencias(Referencia referencia){
        if (!referencias.containsKey(referencia.getCedula())){
                referencias.put(referencia.getCedula(), referencia);
            return "La referencia se agregó con exito";
        }else{
            return "No se pudó agregar la referencia";
        }
    }
    public String eliminarReferencias(String cedula){
        if(referencias.containsKey(cedula)){
                referencias.remove(cedula);
            return "La referencia se ha eliminado exitosamente";
        }else{
            return "La referencia no se pudó eliminar";
        }
    }
    
    public String modificarReferencias(Referencia referencia){
        if(referencias.containsKey(referencia.getCedula())){
            referencias.put(referencia.getCedula(), referencia);
            return "Referencia modificada correctamente";
        }else{
            return "No exite la referencia a modificar";
        }
    }
    
    public String consultarReferencias(String cedula){
        if(referencias.containsKey(cedula)){
            Referencia ref = (Referencia) referencias.get(cedula);
            return  "Tipo: "+ ref.getTipo() +
                    "\n" + "Nombre: " + ref.getNombre() +
                    "\n" + "Apellido: " + ref.getApellido() +
                    "\n" + "Cedula: " + ref.getCedula() +
                    "\n" + "# de Contacto: " + ref.getNumeroContacto();
        }else{
            return "No se encontro la referencia";
        }
    }
    
    public String cedulasReferencias(){
        String salida = "Referencias: ";
        Set cedulas = referencias.keySet();
        Iterator i = cedulas.iterator();
        while(i.hasNext()){
            String ced = (String) i.next();
            Referencia ref = (Referencia) referencias.get(ced);
            salida += ref.getCedula() + "\n";
        }
        return salida;
    }
    
    public boolean revisarReferencias(){
        boolean hayRefFam = false;
        boolean hayRefCom = false;
        boolean estanAmbas = false;
        
        Set cedulas = referencias.keySet();
        Iterator i = cedulas.iterator();
        while(i.hasNext()){
            String ced = (String) i.next();
            Referencia ref = (Referencia) referencias.get(ced);
            if(ref.getTipo() == "Referencia Familiar"){
                hayRefFam =true;
                break;
            }
        }
        while(i.hasNext()){
            String ced = (String) i.next();
            Referencia ref = (Referencia) referencias.get(ced);
            if(ref.getTipo() == "Referencia Comercial"){
                hayRefCom =true;
                break;
            }
        }
        
        if((hayRefFam == true) && (hayRefCom == true)){
            estanAmbas = true;
        }else{
            estanAmbas = false;
        }
        
        return estanAmbas;
    }
}

        
    
        
    