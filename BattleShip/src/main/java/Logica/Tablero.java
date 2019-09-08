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
public class Tablero {

    static int TAMAÑO_TABLERO;
    private Celda[][] tablero;
    private boolean derrota;

    public Tablero(Celda[][] tablero) {
        this.tablero = tablero;
        derrota = false;
    }

    public Tablero() {
        tablero = new Celda[TAMAÑO_TABLERO][TAMAÑO_TABLERO];
        for (Celda[] fila : tablero) {
            for (Celda celda : fila) {
                celda = new Celda();
            }
        }
        derrota = false;
    }

    public boolean hayEspacio(int[] pos, int tamaño, boolean horizontal) {
        boolean ok = true;
        int x = pos[0];
        int y = pos[1];
        
        //CONTROL PARA BARCOS HORIZONTALES
        if (horizontal && (y + tamaño < TAMAÑO_TABLERO)) {
            int opt = 0;
            if (x != 0 && x < TAMAÑO_TABLERO - 1) {
                opt = 1;
            }
            if (x == TAMAÑO_TABLERO - 1) {
                opt = 2;
            }
            switch (opt) {
                case 0:
                    for (int i = y; i < y + tamaño; i++) {
                        String aux1 = tablero[x][i].getActual().toString();
                        String aux2 = tablero[x + 1][i].getActual().toString();
                        if (aux1 == "Barco" || aux2 == "Barco" || aux1 == "AguaForzosa") {
                            return false;
                        }
                    }
                    if (y + tamaño < TAMAÑO_TABLERO - 1) {
                        String aux1 = tablero[x][y+tamaño].getActual().toString();
                        String aux2 = tablero[x + 1][y+tamaño].getActual().toString();
                        if (aux1 == "Barco" || aux2 == "Barco" || aux1 == "AguaForzosa" || aux2 == "AguaForzosa") {
                            return false;
                        }
                    }
                    if (y > 0) {
                        String aux1 = tablero[x][y-1].getActual().toString();
                        String aux2 = tablero[x + 1][y-1].getActual().toString();
                        if (aux1 == "Barco" || aux2 == "Barco" || aux1 == "AguaForzosa" || aux2 == "AguaForzosa") {
                            return false;
                        }
                    }
                    break;
                case 1:
                    for (int i = y; i < y + tamaño; i++) {
                        String aux0 = tablero[x - 1][i].getActual().toString();
                        String aux1 = tablero[x][i].getActual().toString();
                        String aux2 = tablero[x + 1][i].getActual().toString();
                        if (aux1 == "Barco" || aux2 == "Barco" || aux1 == "AguaForzosa" || aux0 == "Barco") {
                            return false;
                        }
                    }
                    if (y + tamaño < TAMAÑO_TABLERO - 1) {
                        String aux0 = tablero[x - 1][y+tamaño].getActual().toString();
                        String aux1 = tablero[x][y+tamaño].getActual().toString();
                        String aux2 = tablero[x + 1][y+tamaño].getActual().toString();
                        if (aux1 == "Barco" || aux2 == "Barco" || aux1 == "AguaForzosa" || aux0 == "AguaForzosa" || aux2 == "AguaForzosa" || aux0 == "Barco" ) {
                            return false;
                        }
                    }
                    if (y > 0) {
                        String aux0 = tablero[x - 1][y-1].getActual().toString();
                        String aux1 = tablero[x][y-1].getActual().toString();
                        String aux2 = tablero[x + 1][y-1].getActual().toString();
                        if (aux1 == "Barco" || aux2 == "Barco" || aux1 == "AguaForzosa" || aux0 == "AguaForzosa" || aux2 == "AguaForzosa" || aux0 == "Barco" ) {
                            return false;
                        }
                    }
                    break;
                case 2:
                    for (int i = y; i < y + tamaño; i++) {
                        String aux0 = tablero[x - 1][i].getActual().toString();
                        String aux1 = tablero[x][i].getActual().toString();
                        if (aux1 == "Barco" || aux1 == "AguaForzosa" || aux0 == "Barco") {
                            return false;
                        }
                    }
                    if (y + tamaño < TAMAÑO_TABLERO - 1) {
                        String aux0 = tablero[x - 1][y+tamaño].getActual().toString();
                        String aux1 = tablero[x][y+tamaño].getActual().toString();
                        if (aux1 == "Barco" || aux0 == "Barco" || aux1 == "AguaForzosa" || aux0 == "AguaForzosa") {
                            return false;
                        }
                    }
                    if (y > 0) {
                        String aux0 = tablero[x - 1][y-1].getActual().toString();
                        String aux1 = tablero[x][y-1].getActual().toString();
                        if (aux1 == "Barco" || aux0 == "Barco" || aux1 == "AguaForzosa" || aux0 == "AguaForzosa") {
                            return false;
                        }
                    }
                    break;
            }
            
        }
        
        //CONTROL PARA BARCOS VERTICALES
        
        if (!horizontal && (x + tamaño < TAMAÑO_TABLERO)) {
            int opt = 0;
            if (y != 0 && y < TAMAÑO_TABLERO - 1) {
                opt = 1;
            }
            if (y == TAMAÑO_TABLERO - 1) {
                opt = 2;
            }
            switch (opt) {
                case 0:
                    for (int i = x; i < x + tamaño; i++) {
                        String aux1 = tablero[i][y].getActual().toString();
                        String aux2 = tablero[i][y+1].getActual().toString();
                        if (aux1 == "Barco" || aux2 == "Barco" || aux1 == "AguaForzosa") {
                            return false;
                        }
                    }
                    if (x + tamaño < TAMAÑO_TABLERO - 1) {
                        String aux1 = tablero[x+tamaño][y].getActual().toString();
                        String aux2 = tablero[x+tamaño][y+1].getActual().toString();
                        if (aux1 == "Barco" || aux2 == "Barco" || aux1 == "AguaForzosa" || aux2 == "AguaForzosa") {
                            return false;
                        }
                    }
                    if (x > 0) {
                        String aux1 = tablero[x-1][y].getActual().toString();
                        String aux2 = tablero[x - 1][y+1].getActual().toString();
                        if (aux1 == "Barco" || aux2 == "Barco" || aux1 == "AguaForzosa" || aux2 == "AguaForzosa") {
                            return false;
                        }
                    }
                    break;
                case 1:
                    for (int i = x; i < x + tamaño; i++) {
                        String aux0 = tablero[i][y - 1].getActual().toString();
                        String aux1 = tablero[i][y].getActual().toString();
                        String aux2 = tablero[i][y+1].getActual().toString();
                        if (aux1 == "Barco" || aux2 == "Barco" || aux1 == "AguaForzosa" || aux0 == "Barco") {
                            return false;
                        }
                    }
                    if (x + tamaño < TAMAÑO_TABLERO - 1) {
                        String aux0 = tablero[x+tamaño][y-1].getActual().toString();
                        String aux1 = tablero[x+tamaño][y].getActual().toString();
                        String aux2 = tablero[x+tamaño][y+1].getActual().toString();
                        if (aux1 == "Barco" || aux2 == "Barco" || aux1 == "AguaForzosa" || aux0 == "AguaForzosa" || aux2 == "AguaForzosa" || aux0 == "Barco" ) {
                            return false;
                        }
                    }
                    if (x > 0) {
                        String aux0 = tablero[x - 1][y-1].getActual().toString();
                        String aux1 = tablero[x-1][y].getActual().toString();
                        String aux2 = tablero[x - 1][y+1].getActual().toString();
                        if (aux1 == "Barco" || aux2 == "Barco" || aux1 == "AguaForzosa" || aux0 == "AguaForzosa" || aux2 == "AguaForzosa" || aux0 == "Barco" ) {
                            return false;
                        }
                    }
                    break;
                case 2:
                    for (int i = x; i < x + tamaño; i++) {
                        String aux0 = tablero[i][y-1].getActual().toString();
                        String aux1 = tablero[i][y].getActual().toString();
                        if (aux1 == "Barco" || aux1 == "AguaForzosa" || aux0 == "Barco") {
                            return false;
                        }
                    }
                    if (x + tamaño < TAMAÑO_TABLERO - 1) {
                        String aux0 = tablero[x+tamaño][y-1].getActual().toString();
                        String aux1 = tablero[x+tamaño][y].getActual().toString();
                        if (aux1 == "Barco" || aux0 == "Barco" || aux1 == "AguaForzosa" || aux0 == "AguaForzosa") {
                            return false;
                        }
                    }
                    if (x > 0) {
                        String aux0 = tablero[x - 1][y-1].getActual().toString();
                        String aux1 = tablero[x-1][y].getActual().toString();
                        if (aux1 == "Barco" || aux0 == "Barco" || aux1 == "AguaForzosa" || aux0 == "AguaForzosa") {
                            return false;
                        }
                    }
                    break;
            }
            
        }
        return ok;
    }

    public boolean ubicarBarco(Barco bote, int[] pos) {
        boolean ok = true;
        if (bote.isHorizontal()) {

        }
        return ok;
    }

}
