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
    private String numeroTarjeta,numeroSeguridad,cupoTotal, fechaExpedicion, fechaDeVencimiento, contraseñaAvances;
    private int gastoTotal,cupoAvances;
    public TarjetaDeCredito(String numTarjeta, String numSeguridad, String cupoTotal, String expedicion, String vencimiento, String contraseña, int gastoTotal, int cupoAvances){
        this.numeroTarjeta=numTarjeta;
        this.numeroSeguridad=numSeguridad;
        this.cupoTotal= cupoTotal;
        this.fechaExpedicion=expedicion;
        this.fechaDeVencimiento=vencimiento;
        this.contraseñaAvances=contraseña;
        this.gastoTotal=gastoTotal;
        this.cupoAvances=cupoAvances;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNumeroSeguridad() {
        return numeroSeguridad;
    }

    public void setNumeroSeguridad(String numeroSeguridad) {
        this.numeroSeguridad = numeroSeguridad;
    }

    public String getCupoTotal() {
        return cupoTotal;
    }

    public void setCupoTotal(String cupoTotal) {
        this.cupoTotal = cupoTotal;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(String fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public String getContraseñaAvances() {
        return contraseñaAvances;
    }

    public void setContraseñaAvances(String contraseñaAvances) {
        this.contraseñaAvances = contraseñaAvances;
    }

    public int getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(int gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public int getCupoAvances() {
        return cupoAvances;
    }

    public void setCupoAvances(int cupoAvances) {
        this.cupoAvances = cupoAvances;
    }
    
}
