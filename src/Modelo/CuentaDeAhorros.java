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
    private String numeroCuenta;
    private String Saldo;
    private double TasaRentabilidad;
    public CuentaDeAhorros(String numeroDeCuenta,String Saldo,double tasaDeRentabilidad){
    this.numeroCuenta=numeroDeCuenta;
    this.Saldo=Saldo;
    this.TasaRentabilidad=tasaDeRentabilidad;
    }
}
