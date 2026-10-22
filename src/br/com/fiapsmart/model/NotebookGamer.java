package br.com.fiapsmart.model;

public class NotebookGamer extends Notebook {

    private boolean tecladoRgb;

    @Override
    public void executarOtimizacao() {
        System.out.println("A ativar o modo de desempenho máximo, a ligar o teclado RGB e a acelerar as ventoinhas.");
    }

    @Override
    public String obterTipoDeUso() {
        return "Alto desempenho para jogos e renderização gráfica.";
    }

    public NotebookGamer(String marca, Processador processador, boolean tecladoRgb) {
        super(marca, processador);
        this.tecladoRgb = tecladoRgb;
    }

    public boolean isTecladoRgb() {
        return tecladoRgb;
    }

    public void setTecladoRgb(boolean tecladoRgb) {
        this.tecladoRgb = tecladoRgb;
    }
}
