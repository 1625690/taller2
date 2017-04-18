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
public class CuentaCorriente {
    private String numeroCuenta, saldo, disponibilidadDeSobregiro, interesDeRentabilidadMensual;
    
    
    public CuentaCorriente(String num, String saldo, String DS, String IRM){
        this.numeroCuenta=num;
        this.saldo=saldo;
        this.disponibilidadDeSobregiro=DS;
        this.interesDeRentabilidadMensual=IRM;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getSaldo() {
        return saldo;
    }

    public String getDisponibilidadDeSobregiro() {
        return disponibilidadDeSobregiro;
    }

    public String getInteresDeRentabilidadMensual() {
        return interesDeRentabilidadMensual;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public void setDisponibilidadDeSobregiro(String disponibilidadDeSobregiro) {
        this.disponibilidadDeSobregiro = disponibilidadDeSobregiro;
    }

    public void setInteresDeRentabilidadMensual(String interesDeRentabilidadMensual) {
        this.interesDeRentabilidadMensual = interesDeRentabilidadMensual;
    }
}
