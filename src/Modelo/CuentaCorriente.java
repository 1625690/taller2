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
}
