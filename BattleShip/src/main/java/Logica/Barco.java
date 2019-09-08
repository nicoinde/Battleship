/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Nico
 */
public class Barco {
    private Celda[] barco;
    private int tamaño;
    private boolean hundido;
    private boolean horizontal;
    private int[] pos;
    
    public Barco() {
        pos=new int[2];
        tamaño=2;
        barco= new Celda[tamaño];
        hundido=false;
        horizontal=true;
    }

    public Barco(int tamaño, boolean direccion) {
        pos=new int[2];
        this.tamaño = tamaño;
        this.barco = new Celda[tamaño];
        hundido=false;
        horizontal= direccion;
    }
    public Barco(int tamaño, boolean direccion, int[] posicion) {
        pos=posicion;
        this.tamaño = tamaño;
        this.barco = new Celda[tamaño];
        hundido=false;
        horizontal= direccion;
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public Celda[] getBarco() {
        return barco;
    }

    public void setBarco(Celda[] barco) {
        this.barco = barco;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isHundido() {
        return hundido;
    }

    public void setHundido(boolean hundido) {
        this.hundido = hundido;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
    
    
}
