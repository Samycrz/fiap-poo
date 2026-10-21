package br.com.fiapsmart.model;

public class Processador {
    private String modelo;
    private double frequenciaGHz;

    public Processador(String modelo, double frequenciaGHz) {
        this.modelo = modelo;
        this.frequenciaGHz = frequenciaGHz;
    }

    public String getModelo() {
        return modelo;
    }

    public double getFrequenciaGHz() {
        return frequenciaGHz;
    }
}
