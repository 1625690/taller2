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
public class Empresa {
    //-------------------------------------------------------------------------
    // ATRIBUTOS
    //-------------------------------------------------------------------------
    private String razonSocial, nit;
    private Cliente clienteasociado;
    //-------------------------------------------------------------------------
    // CONSTRUCTOR
    //-------------------------------------------------------------------------
    /**
     * Constructor de una empresa
     * @param razonSocial - Nombre de la empresa
     * @param nit - Identificacion de la empresa
     */
    public Empresa(String razonSocial, String nit){
        this.razonSocial = razonSocial;
        this.nit = nit;
    }
    //-------------------------------------------------------------------------
    // GETS & SETS
    //-------------------------------------------------------------------------

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    public Cliente getClienteAsociado(){    
        return clienteasociado;
    }
    public void setClienteAsociao(Cliente cliente){
        this.clienteasociado = cliente;
    }
    
}
