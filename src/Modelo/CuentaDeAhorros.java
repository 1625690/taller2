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
public class CuentaDeAhorros {
    private String numeroCuenta, Saldo, interesDeRentabilidadMensual;
    
    public CuentaDeAhorros(String num,String Saldo,String IRM){
    this.numeroCuenta = num;
    this.Saldo = Saldo;
    this.interesDeRentabilidadMensual = IRM;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getSaldo() {
        return Saldo;
    }

    public String getInteresDeRentabilidadMensual() {
        return interesDeRentabilidadMensual;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(String Saldo) {
        this.Saldo = Saldo;
    }

    public void setInteresDeRentabilidadMensual(String interesDeRentabilidadMensual) {
        this.interesDeRentabilidadMensual = interesDeRentabilidadMensual;
    }

    
    
}
