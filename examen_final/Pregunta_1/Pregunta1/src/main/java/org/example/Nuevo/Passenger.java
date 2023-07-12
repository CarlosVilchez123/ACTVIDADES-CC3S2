package org.example.Nuevo;

public class Passenger {
    private String name;
    private boolean vip;

    public Passenger(String name, boolean vip){
        this.name=name;
        this.vip=vip;
    }

    public boolean isVip(){
        return vip;
    }

    protected String getName() {
        return name;
    }
}
