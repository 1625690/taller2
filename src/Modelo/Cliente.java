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
    private HashSet referencias;
    
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
        this.referencias = new HashSet();
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

    public HashSet getReferencias() {
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

    public void setReferencias(HashSet referencias) {
        this.referencias = referencias;
    }
    
    
}
