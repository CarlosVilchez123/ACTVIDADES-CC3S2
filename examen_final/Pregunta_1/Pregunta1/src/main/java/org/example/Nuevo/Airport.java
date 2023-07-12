package org.example.Nuevo;

public class Airport{

    public static void main(String[] args) {
        Fligth vueloEcnomico = new Fligth("ecnomico");
        Fligth vueloNegocio = new Fligth("negocio");

        Passenger carlos = new Passenger("carlos",true);
        Passenger arturo = new Passenger("arturo",false);

        vueloEcnomico.addPassenger(arturo);
        vueloNegocio.addPassenger(carlos);
        System.out.println("LIsta de pasajeros de negocios");
        for(Passenger passenger: vueloNegocio.getPassengersList()){
            System.out.println(passenger.getName());
        }

        System.out.println("LIsta de pasajeros ecnomicos");
        for(Passenger passenger: vueloEcnomico.getPassengersList()){
            System.out.println(passenger.getName());
        }
    }
}
