package Sprint5_0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel BackGround;
    private JRadioButton rbtn_juegoSimple;
    private JRadioButton rbtn_JuegoGeneral;
    private JRadioButton rbtn_1v1;
    private JRadioButton rbtn_1vcpu;
    private JTextField txt_size;
    private JButton btn_NewGame;

    public Menu()
    {
        setTitle("Menu SOS GAME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(450,400));

        BotonesModoDeJuego();
        BotonesModoContricante();
        IniciarJuego();

        add(BackGround, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }

    private void IniciarJuego() {
        btn_NewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tam = Integer.parseInt(txt_size.getText());
                Tablero.ModoDeJuego modo;
                if(rbtn_juegoSimple.isSelected()==true) modo= Tablero.ModoDeJuego.SIMPLE;
                else modo= Tablero.ModoDeJuego.GENERAL;


                Tablero tablero = new Tablero(tam, tam);
                tablero.setModo(modo);

                if(rbtn_1v1.isSelected()==true)
                {
                    GUI_SOS g = new GUI_SOS(tablero);
                    setVisible(false);
                    g.setVisible(true);

                }else {
                    Semi_IA cpu = new Semi_IA(tam,tam,'R');
                    new GUI_SOS(cpu);
                    cpu.setModo(modo);
                    setVisible(false);
                }
            }
        });
    }

    private void BotonesModoContricante() {
        ButtonGroup contricante=new ButtonGroup();
        contricante.add(rbtn_1v1);
        contricante.add(rbtn_1vcpu);
    }

    private void BotonesModoDeJuego() {
        ButtonGroup modo = new ButtonGroup();
        modo.add(rbtn_JuegoGeneral);
        modo.add(rbtn_juegoSimple);
    }

    public static void main(String[] args) {
        new Menu();
    }
}
