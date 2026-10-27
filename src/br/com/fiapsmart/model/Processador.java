package br.com.fiapsmart.model;

public class Processador implements Notificavel {
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


    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("[ALERTA DE HARDWARE | Chip " + getModelo() + "]: " + mensagem);
    }
}
