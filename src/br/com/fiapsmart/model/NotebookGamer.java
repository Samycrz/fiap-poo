package br.com.fiapsmart.model;

public class NotebookGamer extends Notebook {

    private boolean tecladoRgb;

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
