package com.cbalt.miindicadorexample.models;

public class Indicator {

    String fecha;
    double valor;

    public Indicator() {
    }

    public Indicator(String fecha, double valor) {
        this.fecha = fecha;
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
