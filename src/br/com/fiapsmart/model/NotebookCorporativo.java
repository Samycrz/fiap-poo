package br.com.fiapsmart.model;

public class NotebookCorporativo extends Notebook {

    private String dominioEmpresa;

    @Override
    public void executarOtimizacao() {
        System.out.println("A ligar à VPN corporativa do domínio " + getDominioEmpresa() + " e a atualizar regras de firewall.");
    }

    @Override
    public String obterTipoDeUso() {
        return "Uso estritamente profissional e tarefas de escritório.";
    }

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