# SPRINT 5
- video explicativo: https://drive.google.com/file/d/1qzlwV30FwhZabzCXymig2XktRB-Gn5dl/view?usp=sharing

En este sprint se estan trabajando los siguientes items:

- Refactorizacion del metodo Gana de la clase tablero.
- Implementacion de la letra "S" en la GUI en la clase GUI_SOS.
- Aleatoriedad de las letras "S" u "O" en la clase Semi_IA.
- Implementacion de una clase record y creacion de un fichero que grabara una partida.
- En el documento se creo una historia de usuario numero 15.

# Refactorización del metodo gana
En el sprint numero 3 se menciono que toda la lógica de juego se trabajo dentro de un solo metodo; es decir, que el metodo gana me determinaba el fin
de una partida, la decision de la victoria y la formacion de un SOS pora parte de un jugador.

Esto incumple con el principio de responsabilidad única, entonces debe ser refactorizado.

Por ello se separó en dos metodos a parte, el metodo Gana() se sigue manteniendo, pero este solo me determina si hay ganador o si hay un empate, el metodo
FinDelJuego() determina (dependiendo el modo de juego elegido) si se ha terminado una partida; y por último, el metodo FormacionDelSOS() contabiliza
los SOS formados por los jugadores.
<pre>
´´´java
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

´´´
</pre>

Con respecto al metodo al metodo FormacionDelSOS() se debe refactorizar si o si, debido al evidente smell code que se observa.

# Implementación de la letra "S" en la GUI de la clase GUI_SOS

En el sprint 4 se menciono que se cambiara la letra "C" que se uso para ese sprint por la letra "S" la cual es la correcta, en este sprint ya esa corregido.

# Aleatoriedad de las letras "S" u "O" de la clase Semi_IA

En el sprint 4 no se implemento una aleatoriedad para la colocacion de las letras "S" u "O", puesto que la maquina colocaba la misma letra que el
jugador humano seleccionaba. Ahora ya se imeplemento dicha aleatoriedad.

<pre>
´´´java
 @Override
    public void RealizarMovimiento(int filas, int columnas)
    {
        if(super.CeldaValida(filas,columnas))
        {
            super.RealizarMovimiento(filas,columnas);
            if(turno == autoPlayer && EstadoActual== Tablero.EstadoDeJuego.PLAYING)
            {
                Random rand = new Random();

		/*
		En estas dos lineas de codigo se muestra que la letra S u O pueden
		ser seleccionadas de forma aleatoria
		*/
                if(rand.nextInt(2)==0) super.seleccion='S';
                else super.seleccion='O';
                autoMoverse();
            }
        }
    }

´´´
<\pre>

# Implementacion de la clase Record y la creacion de un archivo de texto

Dentro de la clase Tablero se creo un metodo llamado CrearRecord() el cual crea un archivo de texto con las posiciones logicas del tablero lógico
del tablero creado al momento de jugar.

<pre>
´´´java
  GNU nano 7.1                                                              README.md                                                               Modified

# Aleatoriedad de las letras "S" u "O" de la clase Semi_IA

En el sprint 4 no se implemento una aleatoriedad para la colocacion de las letras "S" u "O", puesto que la maquina colocaba la misma letra que el
jugador humano seleccionaba. Ahora ya se imeplemento dicha aleatoriedad.

<pre>
´´´java
 @Override
    public void RealizarMovimiento(int filas, int columnas)
    {
        if(super.CeldaValida(filas,columnas))
        {
            super.RealizarMovimiento(filas,columnas);
            if(turno == autoPlayer && EstadoActual== Tablero.EstadoDeJuego.PLAYING)
            {
                Random rand = new Random();

                /*
                En estas dos lineas de codigo se muestra que la letra S u O pueden
                ser seleccionadas de forma aleatoria
                */
                if(rand.nextInt(2)==0) super.seleccion='S';
                else super.seleccion='O';
                autoMoverse();
            }
        }
    }

´´´
<\pre>

# Implementacion de la clase Record y la creacion de un archivo de texto

Dentro de la clase Tablero se creo un metodo llamado CrearRecord() el cual crea un archivo de texto con las posiciones logicas del tablero lógico
del tablero creado al momento de jugar.

<pre>
´´´java
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

´´´
<\pre>

Luego, para poder visualizar el record como se indica en la GUI de referencia del documento, se implemento un boton en la clase GUI_SOS el cual 
va a mostrar un JFrame con el contenido del archivo de texto creado. Para ello se creo una nueva clase Record.

<pre>
´´´java
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Record extends JFrame {

    private JPanel panel1;
    private JPanel BackGround;
    private JTextPane txp_record;

    public Record()
    {
        initComponent();
        leerArchivo();
    }

    private void leerArchivo() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        //19 20 21
        try
        {
            archivo = new File("record.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            int i=0;
            while((linea = br.readLine())!=null)
            {
                System.out.println(i+": "+linea);
                txp_record.setText(txp_record.getText()+"\n"+linea);
            }
            txp_record.setForeground(Color.MAGENTA);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void initComponent() {
        setTitle("RECORD");

        setPreferredSize(new Dimension(300,250));
        BackGround.setPreferredSize(new Dimension(300,250));
        add(BackGround,BorderLayout.CENTER);

        setVisible(true);
        pack();
    }
}
´´´
<\pre>

