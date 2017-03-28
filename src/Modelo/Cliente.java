/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;
/**
 *
 * @author invitado
 */
public class Cliente {
    
    private String nombre, apellido, cedula, edad, genero, ingresos, egresos, actEconomica;
    private HashSet referencias;
    
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
