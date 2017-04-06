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
public class Chequera {
    private CuentaCorriente cuentaCorriente;
    private String numeroChequera;
    private int canidadDeCheques;
    private HashSet cheques;
    
    public Chequera(CuentaCorriente cuenta, String numChequera, int cantCheques){
        this.cuentaCorriente= cuenta;
    }
}
