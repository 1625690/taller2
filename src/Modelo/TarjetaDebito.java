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
public class TarjetaDebito {
    private HashSet asociacion;
    private String fechaDeExpedicion;
    private boolean estado;
    public TarjetaDebito(String expedicion, boolean estado){
        this.asociacion=new HashSet();
        this.fechaDeExpedicion=expedicion;
        this.estado=estado;
    }
}
