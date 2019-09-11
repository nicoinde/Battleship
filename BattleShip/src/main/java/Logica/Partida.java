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
            player1.siguientePunto(imp1);
            imp2 = tabPlayer1.impacto(ultPlayer2[0], ultPlayer2[1]);
            player2.siguientePunto(imp2);

            if (imp2) {
                impactos2++;
            } else {
                errados2++;
            }
            disparos2++;
        }
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

    public void dispararAll() {

        do {
            disparar();
        } while (!finished);

    }
}
