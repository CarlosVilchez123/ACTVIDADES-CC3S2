package org.example;

import java.util.ArrayList;
import java.util.List;

public class Reserv {

    private List<String[]> lista=new ArrayList<>();


    /**
     * el metodo agrega la hora y objeto a la lista de reserva
     *
     * @param hora es un string que representa la hora de reserva, no se permite repeticiones de hora en la lista de reserva
     *             no se permite agregar un horario vacio, no se admiten horario.
     * @param objeto es un string que agrega el objeto de reserva, no debe ser vacio.
     */
    public void reservar(String hora, String objeto){

        if(hora==""||objeto=="") return;

        for(String[] aux: lista){
            if(aux[0]==hora) return;
        }
        String[] array = new String[2];
        array[0]=hora;
        array[1]=objeto;
        lista.add(array);
    }

    public void retornaListaReserva(){
        for (String[] cadena : lista){
            System.out.println(cadena[0]+" "+ cadena[1]);
        }
    }

    public static void main(String[] args) {
        Reserv r = new Reserv();

        r.reservar("4:30","mesa");
        r.reservar("5:00","cama");
        r.retornaListaReserva();
    }
}
