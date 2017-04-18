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
public class TarjetaDebito {
    private CuentaCorriente cuentaCorriente;
    private CuentaDeAhorros cuentaDeAhorros;
    private String fechaDeExpedicion, estado;
    
    public TarjetaDebito(String expedicion, String estado){
        CuentaCorriente cc = this.cuentaCorriente;
        CuentaDeAhorros ca = this.cuentaDeAhorros;
        this.fechaDeExpedicion = expedicion;
        this.estado = estado;
    }

    public String getFechaDeExpedicion() {
        return fechaDeExpedicion;
    }

    public String getEstado() {
        return estado;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public CuentaDeAhorros getCuentaDeAhorros() {
        return cuentaDeAhorros;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public void setCuentaDeAhorros(CuentaDeAhorros cuentaDeAhorros) {
        this.cuentaDeAhorros = cuentaDeAhorros;
    }

    public void setFechaDeExpedicion(String fechaDeExpedicion) {
        this.fechaDeExpedicion = fechaDeExpedicion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void asociarCCorriente(CuentaCorriente cc){
        cuentaCorriente = cc;
    }
    
    public void asociarCAhorros(CuentaDeAhorros ca){
        cuentaDeAhorros = ca;
    }
    
   public String numeroCA(){
       return cuentaDeAhorros.getNumeroCuenta();
   }
   
   public String numeroCC(){
       return cuentaCorriente.getNumeroCuenta();
   }
    
    
}
