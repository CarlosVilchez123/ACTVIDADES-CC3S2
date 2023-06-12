package Sprint5_0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_SOS extends JFrame{
    private JPanel panel1;
    private int TAM_CELDA=100;
    private int ANCHO;
    private int LARGO;
    private Tablero tableroLogico;
    private PanelBoard panelTablero;
    private JPanel paneTablero;
    private JPanel BackGround;
    private JButton btn_JuegoNuevo;
    private JRadioButton rbtn_azulS;
    private JRadioButton rbtn_rojoS;
    private JRadioButton rbtn_azulO;
    private JRadioButton rbtn_rojoO;
    private JLabel lbl_turno;
    private JLabel lbl_JugadorAzul;
    private JLabel lbl_JugadorRojo;
    private JLabel lbl_scoreRojo;
    private JLabel lbl_scoreAzul;

    public GUI_SOS(Tablero tableroLogico)
    {
        this.tableroLogico=tableroLogico;

        initComponent();
        BotonesJugadorAzul();
        BotonesJugadorRojo();
        ActionListener();
        repaint();
    }

    private void ActionListener()
    {
        rbtn_azulS.setSelected(false);

        btn_JuegoNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableroLogico.ResetGame();
                tableroLogico.setEstadoActual(Tablero.EstadoDeJuego.PLAYING);
                repaint();
            }
        });
    }

    private void BotonesJugadorRojo()
    {
        ButtonGroup GroupJugadorAzul=new ButtonGroup();
        GroupJugadorAzul.add(rbtn_rojoO);
        GroupJugadorAzul.add(rbtn_rojoS);
    }

    private void BotonesJugadorAzul()
    {
        ButtonGroup GroupJugadorAzul=new ButtonGroup();
        GroupJugadorAzul.add(rbtn_azulS);
        GroupJugadorAzul.add(rbtn_azulO);
    }

    private void initComponent() {
        ANCHO=TAM_CELDA*tableroLogico.getNumFilas();
        LARGO = TAM_CELDA*tableroLogico.getNumColumnas();
        paneTablero = new PanelBoard(ANCHO,LARGO);

        setTitle("SOS GAMER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(ANCHO,600));
        add(BackGround,BorderLayout.CENTER);


        add(paneTablero,BorderLayout.SOUTH);
        setVisible(true);
        pack();
    }

    public class PanelBoard extends JPanel
    {
        private int largo;
        private int ancho;

        PanelBoard(int ancho, int largo)
        {
            this.largo = largo;
            this.ancho = ancho;

            setPreferredSize(new Dimension(ancho, largo));
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if( tableroLogico.getEstadoActual() == Tablero.EstadoDeJuego.PLAYING)
                    {
                        if(rbtn_azulO.isSelected() == true) tableroLogico.setSeleccion('O');
                        if (rbtn_azulS.isSelected() == true) tableroLogico.setSeleccion('S');
                        if(tableroLogico.getTurno()=='R') {
                            if (rbtn_rojoS.isSelected() == true) tableroLogico.setSeleccion('S');
                            if (rbtn_rojoO.isSelected() == true) tableroLogico.setSeleccion('O');
                        }
                        int filas = e.getY() / TAM_CELDA;
                        int columnas = e.getX() / TAM_CELDA;
                        tableroLogico.RealizarMovimiento(filas,columnas);

                    }
                    repaint();
                }
            });
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);

            DibujarTablero(g);
            Dibujar(g);

            MostrarTurno();
            MostrarScore();
        }
        public void MostrarScore()
        {
            if (tableroLogico.getEstadoActual() == Tablero.EstadoDeJuego.PLAYING) {
                if (tableroLogico.getModo()== Tablero.ModoDeJuego.GENERAL)
                {
                    lbl_scoreRojo.setText("SCORE JUGADOR ROJO: "+Integer.toString(tableroLogico.puntosRojo));
                    lbl_scoreAzul.setText("SCORE JUGADOR ROJO: "+Integer.toString(tableroLogico.puntosAzul));
                }else {
                    lbl_scoreAzul.setVisible(false);
                    lbl_scoreRojo.setVisible(false);
                }
            }

        }


        public void DibujarTablero(Graphics g)
        {
            for( int filas=1; filas<tableroLogico.getNumFilas(); filas++)
            {
                g.fillRoundRect(0,filas*(largo)/tableroLogico.getNumFilas(),ANCHO,6, 6,6);
            }

            for( int colum=1; colum<tableroLogico.getNumColumnas(); colum++)
            {
                g.fillRoundRect(colum*ANCHO/tableroLogico.getNumColumnas(),0,6,ANCHO, 6,6);
            }
        }
        public void Dibujar(Graphics g)
        {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            for (int row = 0; row < tableroLogico.getNumFilas(); ++row) {
                for (int col = 0; col < tableroLogico.getNumColumnas(); ++col) {
                    int x1 = col * TAM_CELDA +(TAM_CELDA/5);
                    int y1 = row * TAM_CELDA +(TAM_CELDA/5);
                    if (tableroLogico.getContenidoCeldas(row,col) == Tablero.ContenidoCeldas.AZUL_S) {
                        g2d.setColor(Color.BLUE);
                        g2d.drawArc(x1,y1,35,35,45,220);
                        g2d.drawArc(x1-5,y1+32,35,35,90,-220);
                    }
                    if (tableroLogico.getContenidoCeldas(row,col) == Tablero.ContenidoCeldas.AZUL_O) {
                        g2d.setColor(Color.BLUE);
                        g2d.drawOval(x1, y1, 60, 60);
                    }
                    if (tableroLogico.getContenidoCeldas(row,col) == Tablero.ContenidoCeldas.ROJO_O) {
                        g2d.setColor(Color.RED);
                        g2d.drawOval(x1, y1, 60, 60);
                    }
                    if (tableroLogico.getContenidoCeldas(row,col) == Tablero.ContenidoCeldas.ROJO_S) {
                        g2d.setColor(Color.RED);
                        g2d.drawArc(x1,y1,35,35,45,220);      
                        g2d.drawArc(x1-5,y1+32,35,35,90,-220);

                    }
                }
            }
        }
        public void MostrarTurno() {
            if (tableroLogico.getEstadoActual() == Tablero.EstadoDeJuego.PLAYING) {
                if (tableroLogico.getTurno() == 'A')
                {
                    lbl_turno.setText("ES TURNO DEL AZUL");
                    lbl_turno.setForeground(Color.BLUE);
                    lbl_JugadorAzul.setForeground(Color.BLUE);
                    lbl_JugadorRojo.setForeground(Color.BLACK);
                }else {
                    lbl_turno.setText("ES TURNO DEL ROJO");
                    lbl_turno.setForeground(Color.RED);
                    lbl_JugadorAzul.setForeground(Color.BLACK);
                    lbl_JugadorRojo.setForeground(Color.RED);
                }
            }else {
                if(tableroLogico.getEstadoActual()== Tablero.EstadoDeJuego.AZUL_GANA)
                {
                    lbl_turno.setText("GANO AZUL");
                    lbl_turno.setForeground(Color.BLUE);
                }
                else
                {
                    lbl_turno.setText("GANO ROJO");
                    lbl_turno.setForeground(Color.RED);
                }

                if(tableroLogico.getEstadoActual()== Tablero.EstadoDeJuego.EMPATE) lbl_turno.setText("EMPATE");

            }
        }
    }
    public static void main(String[] args) {

    }
}
