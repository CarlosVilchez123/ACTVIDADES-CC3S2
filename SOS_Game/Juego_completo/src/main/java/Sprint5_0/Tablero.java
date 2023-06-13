package Sprint5_0;

import java.io.File;
import java.io.PrintWriter;

public class Tablero {
    public enum ContenidoCeldas {VACIO, AZUL_O,AZUL_S,ROJO_O,ROJO_S};
    public enum EstadoDeJuego {PLAYING, DRAW, AZUL_GANA, ROJO_GANA, EMPATE}
    public enum ModoDeJuego {SIMPLE,GENERAL}
    protected ContenidoCeldas celdas[][];
    protected EstadoDeJuego EstadoActual;
    protected ModoDeJuego modo;

    protected int NumFilas;
    protected int NumColumnas;
    protected char turno;
    protected char seleccion;
    protected int puntosAzul=0;
    protected int puntosRojo=0;

    public Tablero(int NumFilas, int NumColumnas)
    {
        this.NumFilas=NumFilas;
        this.NumColumnas=NumColumnas;

        celdas = new Tablero.ContenidoCeldas[NumFilas][NumColumnas];
        initTablero();
    }

    private void initTablero() {
        for(int filas = 0; filas< NumFilas; filas++)
            for(int columnas = 0; columnas< NumColumnas; columnas++)
                celdas[filas][columnas]= Tablero.ContenidoCeldas.VACIO;

        EstadoActual= Tablero.EstadoDeJuego.PLAYING;
        turno='A';
        puntosAzul=0;
        puntosRojo=0;
    }

    public void ResetGame(){ initTablero();}
    public void RealizarMovimiento(int filas, int columnas)
    {
        if(CeldaValida(filas,columnas))
        {
            if(turno=='A')
            {
                celdas[filas][columnas] = (seleccion=='S')? Tablero.ContenidoCeldas.AZUL_S: Tablero.ContenidoCeldas.AZUL_O;
            }else {
                celdas[filas][columnas]= (seleccion=='S')? Tablero.ContenidoCeldas.ROJO_S: Tablero.ContenidoCeldas.ROJO_O;
            }

            ActualizarEstadoDeJuego(filas, columnas);
            CrearRecord();
            turno = (turno=='A')? 'R':'A';
        }
    }

    private void CrearRecord()
    {
        File record = new File("record.txt");

        try{
            PrintWriter salida = new PrintWriter(record);
            for(int i=0; i<NumFilas; i++)
            {
                salida.println("--------------------------------------");
                for(int j=0;j<NumColumnas;j++)
                {
                    salida.print("| "+celdas[i][j].toString());
                    salida.print("| ");
                }
                salida.println();
            }
            salida.print("--------------------------------------");
            salida.close();
        }catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

    public void ActualizarEstadoDeJuego(int filas, int columnas)
    {
        if(FinDelJuego(filas, columnas))
        {
            if(modo== Tablero.ModoDeJuego.SIMPLE) Gana();
            else Gana();

        }else if(isDraw())
        {
            EstadoActual = Tablero.EstadoDeJuego.DRAW;
        }
    }

    public void Gana()
    {
        if (puntosAzul > puntosRojo) {
            EstadoActual = Tablero.EstadoDeJuego.AZUL_GANA;
        } else {
            if (puntosAzul == puntosRojo)
                EstadoActual = Tablero.EstadoDeJuego.EMPATE;
            else EstadoActual = Tablero.EstadoDeJuego.ROJO_GANA;
        }
    }
    public boolean FinDelJuego(int filas, int columnas)
    {
        FormacionDelSOS(filas,columnas);
        if(modo==ModoDeJuego.SIMPLE) return (puntosAzul>puntosRojo || puntosRojo>puntosAzul);
        if(modo==ModoDeJuego.GENERAL) return tableroLleno();
        return false;
    }
    public void FormacionDelSOS(int filas, int columnas)
    {

            if (turno == 'A') {
                if (seleccion == 'S') {

                    if (filas - 1 >= 0 && filas - 1 < NumFilas && columnas + 1 >= 0 && columnas + 1 < NumColumnas && filas - 2 >= 0 && filas - 2 < NumFilas && columnas + 2 >= 0 && columnas + 2 < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.AZUL_S && celdas[filas - 1][columnas + 1] == Tablero.ContenidoCeldas.AZUL_O && celdas[filas - 2][columnas + 2] == Tablero.ContenidoCeldas.AZUL_S)
                        {
                            puntosAzul++;
                        }

                    if (filas >= 0 && filas < NumFilas && columnas + 1 >= 0 && columnas + 1 < NumColumnas && filas >= 0 && filas < NumFilas && columnas + 2 >= 0 && columnas + 2 < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.AZUL_S && celdas[filas][columnas + 1] == Tablero.ContenidoCeldas.AZUL_O && celdas[filas][columnas + 2] == Tablero.ContenidoCeldas.AZUL_S)
                        {

                            puntosAzul++;
                        }

                    if (filas + 1 >= 0 && filas + 1 < NumFilas && columnas + 1 >= 0 && columnas + 1 < NumColumnas && filas + 2 >= 0 && filas + 2 < NumFilas && columnas + 2 >= 0 && columnas + 2 < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.AZUL_S && celdas[filas + 1][columnas + 1] == Tablero.ContenidoCeldas.AZUL_O && celdas[filas + 2][columnas + 2] == Tablero.ContenidoCeldas.AZUL_S)
                        {

                            puntosAzul++;
                        }

                    if (filas + 1 >= 0 && filas + 1 < NumFilas && columnas >= 0 && columnas < NumColumnas && filas + 2 >= 0 && filas + 2 < NumFilas && columnas >= 0 && columnas < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.AZUL_S && celdas[filas + 1][columnas] == Tablero.ContenidoCeldas.AZUL_O && celdas[filas + 2][columnas] == Tablero.ContenidoCeldas.AZUL_S)
                        {

                            puntosAzul++;
                        }

                    if (filas + 1 >= 0 && filas + 1 < NumFilas && columnas - 1 >= 0 && columnas - 1 < NumColumnas && filas + 2 >= 0 && filas + 2 < NumFilas && columnas - 2 >= 0 && columnas - 2 < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.AZUL_S && celdas[filas + 1][columnas - 1] == Tablero.ContenidoCeldas.AZUL_O && celdas[filas + 2][columnas - 2] == Tablero.ContenidoCeldas.AZUL_S)
                        {

                            puntosAzul++;
                        }

                    if (filas - 1 >= 0 && filas - 1 < NumFilas && columnas - 1 >= 0 && columnas - 1 < NumColumnas && filas - 2 >= 0 && filas - 2 < NumFilas && columnas - 2 >= 0 && columnas - 2 < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.AZUL_S && celdas[filas - 1][columnas - 1] == Tablero.ContenidoCeldas.AZUL_O && celdas[filas - 2][columnas - 2] == Tablero.ContenidoCeldas.AZUL_S)
                        {

                            puntosAzul++;
                        }

                    if (filas >= 0 && filas < NumFilas && columnas - 1 >= 0 && columnas - 1 < NumColumnas && filas >= 0 && filas < NumFilas && columnas - 2 >= 0 && columnas - 2 < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.AZUL_S && celdas[filas][columnas - 1] == Tablero.ContenidoCeldas.AZUL_O && celdas[filas][columnas - 2] == Tablero.ContenidoCeldas.AZUL_S)
                        {

                            puntosAzul++;
                        }

                    if ((filas - 1 >= 0 && filas - 1 < NumFilas && columnas >= 0 && columnas < NumColumnas) && (filas - 2 >= 0 && filas - 2 < NumFilas && columnas >= 0 && columnas < NumColumnas))
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.AZUL_S && celdas[filas - 1][columnas] == Tablero.ContenidoCeldas.AZUL_O && celdas[filas - 2][columnas] == Tablero.ContenidoCeldas.AZUL_S)
                        {

                            puntosAzul++;
                        }

                }
            }else {
                if (seleccion=='S') {
                    if (filas - 1 >= 0 && filas - 1 < NumFilas && columnas + 1 >= 0 && columnas + 1 < NumColumnas && filas - 2 >= 0 && filas - 2 < NumFilas && columnas + 2 >= 0 && columnas + 2 < NumColumnas)
                        if (celdas[filas][columnas] == ContenidoCeldas.ROJO_S && celdas[filas - 1][columnas + 1] == ContenidoCeldas.ROJO_O && celdas[filas - 2][columnas + 2] == Tablero.ContenidoCeldas.ROJO_S)
                            puntosRojo++;

                    if (filas >= 0 && filas < NumFilas && columnas + 1 >= 0 && columnas + 1 < NumColumnas && filas >= 0 && filas < NumFilas && columnas + 2 >= 0 && columnas + 2 < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.ROJO_S && celdas[filas][columnas + 1] == Tablero.ContenidoCeldas.ROJO_O && celdas[filas][columnas + 2] == Tablero.ContenidoCeldas.ROJO_S)
                            puntosRojo++;

                    if (filas + 1 >= 0 && filas + 1 < NumFilas && columnas + 1 >= 0 && columnas + 1 < NumColumnas && filas + 2 >= 0 && filas + 2 < NumFilas && columnas + 2 >= 0 && columnas + 2 < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.ROJO_S && celdas[filas + 1][columnas + 1] == Tablero.ContenidoCeldas.ROJO_O && celdas[filas + 2][columnas + 2] == Tablero.ContenidoCeldas.ROJO_S)
                            puntosRojo++;

                    if (filas + 1 >= 0 && filas + 1 < NumFilas && columnas >= 0 && columnas < NumColumnas && filas + 2 >= 0 && filas + 2 < NumFilas && columnas >= 0 && columnas < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.ROJO_S && celdas[filas + 1][columnas] == Tablero.ContenidoCeldas.ROJO_O && celdas[filas + 2][columnas] == Tablero.ContenidoCeldas.ROJO_S)
                            puntosRojo++;

                    if (filas + 1 >= 0 && filas + 1 < NumFilas && columnas - 1 >= 0 && columnas - 1 < NumColumnas && filas + 2 >= 0 && filas + 2 < NumFilas && columnas - 2 >= 0 && columnas - 2 < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.ROJO_S && celdas[filas + 1][columnas - 1] == Tablero.ContenidoCeldas.ROJO_O && celdas[filas + 2][columnas - 2] == Tablero.ContenidoCeldas.ROJO_S)
                            puntosRojo++;

                    if (filas - 1 >= 0 && filas - 1 < NumFilas && columnas - 1 >= 0 && columnas - 1 < NumColumnas && filas - 2 >= 0 && filas - 2 < NumFilas && columnas - 2 >= 0 && columnas - 2 < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.ROJO_S && celdas[filas - 1][columnas - 1] == Tablero.ContenidoCeldas.ROJO_O && celdas[filas - 2][columnas - 2] == Tablero.ContenidoCeldas.ROJO_S)
                            puntosRojo++;

                    if (filas >= 0 && filas < NumFilas && columnas - 1 >= 0 && columnas - 1 < NumColumnas && filas >= 0 && filas < NumFilas && columnas - 2 >= 0 && columnas - 2 < NumColumnas)
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.ROJO_S && celdas[filas][columnas - 1] == Tablero.ContenidoCeldas.ROJO_O && celdas[filas][columnas - 2] == Tablero.ContenidoCeldas.ROJO_S)
                            puntosRojo++;

                    if ((filas - 1 >= 0 && filas - 1 < NumFilas && columnas >= 0 && columnas < NumColumnas) && (filas - 2 >= 0 && filas - 2 < NumFilas && columnas >= 0 && columnas < NumColumnas))
                        if (celdas[filas][columnas] == Tablero.ContenidoCeldas.ROJO_S && celdas[filas - 1][columnas] == Tablero.ContenidoCeldas.ROJO_O && celdas[filas - 2][columnas] == Tablero.ContenidoCeldas.ROJO_S)
                            puntosRojo++;
                }
            }
    }

    public boolean tableroLleno()
    {
        for(int filas = 0; filas< NumFilas; filas++)
        for(int columnas = 0; columnas< NumColumnas; columnas++)
            if(celdas[filas][columnas]==ContenidoCeldas.VACIO) return false;
        return true;
    }

    public boolean isDraw()
    {
        for (int filas = 0; filas < NumFilas; ++filas) {
            for (int columnas = 0; columnas < NumColumnas; ++columnas) {
                if (celdas[filas][columnas] == Tablero.ContenidoCeldas.VACIO) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean CeldaValida(int filas, int columnas){
        if(filas >= 0 && filas < NumFilas && columnas >= 0 && columnas < NumColumnas && celdas[filas][columnas]== Tablero.ContenidoCeldas.VACIO)
            return true;
        else return false;
    }

    public Tablero.ContenidoCeldas getContenidoCeldas(int filas, int columnas)
    {
        if(filas >= 0 && filas < NumFilas && columnas >= 0 && columnas < NumColumnas)
            return celdas[filas][columnas];
        else return null;
    }

    public char getTurno(){return turno;}
    public void setSeleccion(char seleccion){this.seleccion = seleccion;}
    public int getNumFilas(){return NumFilas;}
    public int getNumColumnas(){return NumColumnas;}
    public void setModo(Tablero.ModoDeJuego modo){this.modo=modo;}
    public ModoDeJuego getModo(){return modo;}

    public EstadoDeJuego getEstadoActual(){return EstadoActual;}
    public void setEstadoActual( EstadoDeJuego estadoActual){ this.EstadoActual=estadoActual;}
}
