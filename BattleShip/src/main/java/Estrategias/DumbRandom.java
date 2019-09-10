/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estrategias;

/**
 *
 * @author Nico
 */
public class DumbRandom extends Estrategia {

    @Override
    public int[] siguientePunto(boolean impactoAnterior) {
        int[] coord = new int[2];
        int auxX = 0, auxY = 0;
        do {
            auxX = (int) Math.random() * sizeX;
            auxY = (int) Math.random() * sizeY;
        } while (oponente[auxX][auxY] == 1);

        coord[0] = auxX;
        coord[1] = auxY;
        oponente[coord[0]][coord[1]] = 1;
        return coord;
    }

}
