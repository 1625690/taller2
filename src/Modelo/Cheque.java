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
public class Cheque {
    private String estado, valorGirado, beneficiario, fechaDeGiro, sedeDeCobro, fechaDeCruce;
    private boolean cruzado;
    
    public Cheque(String estado, String valor, String beneficiario, String fechaG, String sede, boolean cruzado, String fechaC){
        this.estado = estado;
        this.valorGirado = valor;
        this.beneficiario = beneficiario;
        this.fechaDeGiro = fechaG;
        this.sedeDeCobro = sede;
        this.cruzado = cruzado;
        this.fechaDeCruce = fechaC;
    }

    public String getEstado() {
        return estado;
    }

    public String getValorGirado() {
        return valorGirado;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public String getFechaDeGiro() {
        return fechaDeGiro;
    }

    public String getSedeDeCobro() {
        return sedeDeCobro;
    }

    public String getFechaDeCruce() {
        return fechaDeCruce;
    }

    public boolean getCruzado() {
        return cruzado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setValorGirado(String valorGirado) {
        this.valorGirado = valorGirado;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public void setFechaDeGiro(String fechaDeGiro) {
        this.fechaDeGiro = fechaDeGiro;
    }

    public void setSedeDeCobro(String sedeDeCobro) {
        this.sedeDeCobro = sedeDeCobro;
    }

    public void setFechaDeCruce(String fechaDeCruce) {
        this.fechaDeCruce = fechaDeCruce;
    }

    public void setCruzado(boolean cruzado) {
        this.cruzado = cruzado;
    }
    
    
}
            
     