package Sprint5_0;

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

    public static void main(String[] args) {
        new Record();
    }
}
