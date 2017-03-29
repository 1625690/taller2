/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Clase del representante legal de una empresa
 * Hereda los atributos y metodos de cliente
 * @author invitado
 */
public class Representante extends Cliente{

    //-------------------------------------------------------------------------
    // ATR
    //-------------------------------------------------------------------------
    //-------------------------------------------------------------------------
    // CONSTRUCTOR
    //-------------------------------------------------------------------------
    
    /**
     * Constructor de Representante
     * @param nom - Nombre del cliente
     * @param ape - Apellido del cliente
     * @param ced - Cedula del cliente
     * @param edad -  Edad del cliente
     * @param genero - Genero del cliente
     * @param in - Ingresos del cliente
     * @param eg - Egresos del cliente
     * @param act - Actividad económica
     */
    public Representante(String nom, String ape, String ced, String edad, String genero, String in, String eg, String act) {
        super(nom, ape, ced, edad, genero, in, eg, act);
    }
 
}
