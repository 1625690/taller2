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
public class TarjetaDeCredito {
    private String numeroTarjeta, numeroSeguridad, cupoTotal, gastoTotal, cupoAvances, fechaExpedicion, fechaDeVencimiento, contraseñaAvances;
    
    public TarjetaDeCredito(String numTarjeta, String numSeguridad, String cupoT, String gastoT, String cupoA, String expedicion, String vencimiento, String contraseña){
        this.numeroTarjeta=numTarjeta;
        this.numeroSeguridad=numSeguridad;
        this.cupoTotal= cupoT;
        this.gastoTotal=gastoT;
        this.cupoAvances=cupoA;
        this.fechaExpedicion=expedicion;
        this.fechaDeVencimiento=vencimiento;
        this.contraseñaAvances=contraseña;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getNumeroSeguridad() {
        return numeroSeguridad;
    }

    public String getCupoTotal() {
        return cupoTotal;
    }

    public String getGastoTotal() {
        return gastoTotal;
    }

    public String getCupoAvances() {
        return cupoAvances;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public String getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public String getContraseñaAvances() {
        return contraseñaAvances;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setNumeroSeguridad(String numeroSeguridad) {
        this.numeroSeguridad = numeroSeguridad;
    }

    public void setCupoTotal(String cupoTotal) {
        this.cupoTotal = cupoTotal;
    }

    public void setGastoTotal(String gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public void setCupoAvances(String cupoAvances) {
        this.cupoAvances = cupoAvances;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public void setFechaDeVencimiento(String fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public void setContraseñaAvances(String contraseñaAvances) {
        this.contraseñaAvances = contraseñaAvances;
    }

    
}
