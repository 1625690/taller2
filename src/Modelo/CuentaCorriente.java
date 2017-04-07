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
    private String numeroCuenta, disponibilidadDeSobregiro;
    private int Saldo,interesDeRentabilidadMensual;
    
    public CuentaCorriente(String numCuenta, String dispDeSobregiro, int sald, int intDeRentMensual){
        this.numeroCuenta=numCuenta;
        this.disponibilidadDeSobregiro=dispDeSobregiro;
        this.interesDeRentabilidadMensual=intDeRentMensual;
        this.Saldo=sald;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getDisponibilidadDeSobregiro() {
        return disponibilidadDeSobregiro;
    }

    public void setDisponibilidadDeSobregiro(String disponibilidadDeSobregiro) {
        this.disponibilidadDeSobregiro = disponibilidadDeSobregiro;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public int getInteresDeRentabilidadMensual() {
        return interesDeRentabilidadMensual;
    }

    public void setInteresDeRentabilidadMensual(int interesDeRentabilidadMensual) {
        this.interesDeRentabilidadMensual = interesDeRentabilidadMensual;
    }
    
}
