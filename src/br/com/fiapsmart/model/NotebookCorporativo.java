package br.com.fiapsmart.model;

public class NotebookCorporativo extends Notebook {

    private String dominioEmpresa;

    public NotebookCorporativo(String marca, Processador processador, String dominioEmpresa) {
        super(marca, processador);
        this.dominioEmpresa = dominioEmpresa;
    }

    public String getDominioEmpresa() {
        return dominioEmpresa;
    }

    public void setDominioEmpresa(String dominioEmpresa) {
        this.dominioEmpresa = dominioEmpresa;
    }
}