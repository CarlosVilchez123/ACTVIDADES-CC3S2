package Sprint5_0;

import java.util.Random;

public class Semi_IA extends Tablero{
    private char autoPlayer;

    public Semi_IA(int filas, int columnas, char Player)
    {
        super(filas,columnas);
        this.autoPlayer=Player;
        if(autoPlayer=='A')
        {
            hacerPrimerMovimiento();
        }
    }

    private void hacerPrimerMovimiento() {
        Random rand = new Random();
        int position = rand.nextInt(getNumFilas()*getNumColumnas());
        super.RealizarMovimiento(position/ getNumFilas(),position%getNumColumnas());
    }

    @Override
    public void RealizarMovimiento(int filas, int columnas)
    {
        if(super.CeldaValida(filas,columnas))
        {
            super.RealizarMovimiento(filas,columnas);
            if(turno == autoPlayer && EstadoActual== Tablero.EstadoDeJuego.PLAYING)
            {
                Random rand = new Random();

                if(rand.nextInt(2)==0) super.seleccion='S';
                else super.seleccion='O';
                autoMoverse();
            }
        }
    }

    private void autoMoverse()
    {
        if(!movimientoGanador())
        {
            if(!oponenteNoGana())
            {
                movimientoRandom();
            }
        }
    }

    private void movimientoRandom()
    {
        int numeroDeCeldasVacias = getNumeroDeCeldasVacias();
        Random random = new Random();
        int casilla= random.nextInt(numeroDeCeldasVacias);
        int i=0;
        for (int filas = 0; filas < NumFilas; filas++) {
            for (int columnas = 0; columnas < NumColumnas; columnas++) {
                if(celdas[filas][columnas]== Tablero.ContenidoCeldas.VACIO)
                {
                    if(casilla==i){
                        super.RealizarMovimiento(filas,columnas);
                        return;
                    }else i++;
                }
            }
        }
    }
    private boolean movimientoGanador(){return false;}
    private boolean oponenteNoGana(){return false;}

    private int getNumeroDeCeldasVacias() {
        int numeroDeCeldasVacias = 0;
        for (int filas = 0; filas < NumFilas; filas++) {
            for (int columnas = 0; columnas < NumColumnas; columnas++) {
                if (celdas[filas][columnas] == Tablero.ContenidoCeldas.VACIO) {
                    numeroDeCeldasVacias++;
                }
            }
        }
        return numeroDeCeldasVacias;
    }
}
