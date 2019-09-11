/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Estrategias.*;
import java.util.Random;

/**
 *
 * @author Nico
 */
public class Partida {

    Estrategia player1, player2;
    Tablero tabPlayer1, tabPlayer2;
    int[] ultPlayer1, ultPlayer2;
    int disparos1, disparos2, impactos1, impactos2, errados1, errados2;
    Barco[] barcosPlayer1, barcosPlayer2;
    boolean finished = false;
    //0 lineal - 1 DumbRandom - 2 SmartRandom - 3 Impares

    int ganador;

    public Partida() {

        //hay que acomodar despues para que tome distintas opciones de estrategia
        this.player1 = new SmartRandom();
        this.player2 = new Impares();
        this.tabPlayer1 = new Tablero();
        this.tabPlayer2 = new Tablero();
        disparos1 = 0;
        disparos2 = 0;
        impactos1 = 0;
        impactos2 = 0;
        errados1 = 0;
        errados2 = 0;
        ponerBarcos(tabPlayer1, tabPlayer2);
        ultPlayer1 = player1.siguientePunto(finished);
        ultPlayer2 = player2.siguientePunto(finished);
        finished = false;

    }

    public Partida(int estrategiaA, int estrategiaB) {

        //hay que acomodar despues para que tome distintas opciones de estrategia
        this.player1 = generarEstrategia(estrategiaA);
        this.player2 = generarEstrategia(estrategiaB);
        this.tabPlayer1 = new Tablero();
        this.tabPlayer2 = new Tablero();
        disparos1 = 0;
        disparos2 = 0;
        impactos1 = 0;
        impactos2 = 0;
        errados1 = 0;
        errados2 = 0;
        ponerBarcos(tabPlayer1, tabPlayer2);
        ultPlayer1 = player1.siguientePunto(finished);
        ultPlayer2 = player2.siguientePunto(finished);
        finished = false;

    }

    public Estrategia generarEstrategia(int est) {
        Estrategia estra;
        switch (est) {
            case 0:
                estra = new Lineal();
                break;
            case 1:
                estra = new DumbRandom();
                break;
            case 2:
                estra = new SmartRandom();
                break;
            case 3:
                estra = new Impares();
                break;
            default:
                estra = new Lineal();
                break;
        }
        return estra;
    }

    public void ponerBarcos(Tablero tabPlayer1, Tablero tabPlayer2) {
        Random rnd = new Random();
        int cont = 0;
        for (int i = 2; i <= 6; i++) {
            for (int j = 1; j <= 2; j++) {
                boolean dir = rnd.nextBoolean();
                barcosPlayer1[cont] = new Barco(i, dir);
                barcosPlayer1[cont].setPos(tabPlayer1.ubicarBarco(barcosPlayer1[cont]));

                barcosPlayer2[cont] = new Barco(i, rnd.nextBoolean());
                dir = rnd.nextBoolean();
                barcosPlayer1[cont].setPos(tabPlayer2.ubicarBarco(barcosPlayer2[cont]));
                cont++;

            }
        }
    }

    public void disparar() {
        if (!finished) {
            boolean imp1, imp2;
            imp1 = tabPlayer2.impacto(ultPlayer1[0], ultPlayer1[1]);
            if (imp1) {
                impactos1++;
            } else {
                errados1++;
            }
            disparos1++;
            if(impactos1==40){
                finished=true;
                ganador=0;
            }
            player1.siguientePunto(imp1);
            imp2 = tabPlayer1.impacto(ultPlayer2[0], ultPlayer2[1]);
            player2.siguientePunto(imp2);

            if (imp2) {
                impactos2++;
            } else {
                errados2++;
            }
            disparos2++;
            
            if(!finished&&impactos2==40){
                finished=true;
                ganador=1;
            }
        }
    }
    
    public boolean ganoPlayer1(){
        return (ganador==0);
    }
    
    public int[] ultimoAtaqueA(){
        return ultPlayer1;
    }
    public int[] ultimoAtaqueB(){
        return ultPlayer2;
    }


    public void dispararPegaSigue() { //falta TERMINAR
        if (!finished) {
            boolean imp1, imp2;
            imp1 = tabPlayer2.impacto(ultPlayer1[0], ultPlayer1[1]);
            if (imp1) {
                impactos1++;
            } else {
                errados1++;
            }
            disparos1++;
            player1.siguientePunto(imp1);
            imp2 = tabPlayer1.impacto(ultPlayer2[0], ultPlayer2[1]);
            player2.siguientePunto(imp2);
        } else {

        }
    }

    /*
    este metodo devuelve un arreglo de doubles con los porcentajes de impactos de ambos jugadores
    porcentajes[PAR] para Jugador 1
    porcentajes[IMPAR] para Jugador 2
     */
    public double[] porcentajesAciertos() {

        double porcentajes[] = new double[4];
        porcentajes[0] = (double) (impactos1 * 100 / disparos1);
        porcentajes[1] = (double) (impactos2 * 100 / disparos1);
        porcentajes[2] = (double) (errados1 * 100 / disparos1);
        porcentajes[3] = (double) (errados2 * 100 / disparos1);
        return porcentajes;
    }

    public int[] totales() {
        int[] totales = new int[4];
        totales[0] = disparos1;
        totales[1] = disparos1;
        totales[2] = impactos1;
        totales[3] = impactos2;
        return totales;
    }

    public void dispararAll() {

        do {
            disparar();
        } while (!finished);

    }
    
    public boolean isFinished(){
        return finished;
    }
}
