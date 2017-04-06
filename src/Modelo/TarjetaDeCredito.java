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
}
