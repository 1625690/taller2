/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Clase de la referencia de un cliente del banco
 * @author invitado
 */
public class Referencia {
    //-------------------------------------------------------------------------
    // ATRIBUTOS
    //-------------------------------------------------------------------------
    private String tipo, nombre, apellido, cedula, numeroContacto;
    
    //-------------------------------------------------------------------------
    // CONSTRUCTOR
    //-------------------------------------------------------------------------

    public Referencia(String tipo, String nombre, String apellido, String cedula, String numeroContacto) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.numeroContacto = numeroContacto;
    }
    //-------------------------------------------------------------------------
    // ATRIBUTOS
    //-------------------------------------------------------------------------

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }
    
    
}
