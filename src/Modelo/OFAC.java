/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author invitado
 */
public class OFAC {
    private String nombre, ident;
    private int criticidad;
    public OFAC(String id, int critic){
        nombre = "";
        this.ident = id;
        this.criticidad = critic;
    }
    public OFAC (String id , String nom, int critic){
    this.nombre=nom;
    this.ident=id;
    this.criticidad=critic;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public int getCriticidad() {
        return criticidad;
    }

    public void setCriticidad(int criticidad) {
        this.criticidad = criticidad;
    }
    
}
