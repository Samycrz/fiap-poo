package br.com.fiapsmart.main;

import br.com.fiapsmart.model.Notebook;
import br.com.fiapsmart.model.NotebookCorporativo;
import br.com.fiapsmart.model.NotebookGamer;
import br.com.fiapsmart.model.Processador;

public class SistemaPrincipal {
    public static void main(String[] args) {

        //Instanciando Objetos
        Notebook meuNotebook = new Notebook("Dell", true, 80 );
        meuNotebook.setEspacoLivreGb(250.5);
        meuNotebook.setConectadoWifi(false);

        Processador meuProcessador = new Processador("Intel Core i7", 4.2);
        Notebook novoNotebook = new Notebook("Dell", meuProcessador);

        Processador processadorCorporativo = new Processador("Intel Core i5", 3.2);
        Processador processadorGamer = new Processador("AMD Ryzen 9", 4.8);

        NotebookCorporativo notebookTrabalho = new NotebookCorporativo("Lenovo", processadorCorporativo, "@dominio.com.br");
        NotebookGamer notebookJogo = new NotebookGamer("Alienware", processadorGamer, true);

        System.out.println("\n--- Testar Burla no Set ---");
        meuNotebook.setNivelBateria(150);

        System.out.println("--- Testar Valores Inválidos ---");
        meuNotebook.ligar();
        meuNotebook.carregarBateria(-20);

        System.out.println("\n--- Testar Valores Válidos ---");
        meuNotebook.carregarBateria(40);
        meuNotebook.ligar();

        System.out.println("\n--- Testar Limites do Estado ---");
        meuNotebook.carregarBateria(80);

        System.out.println("\n--- Testar Burla no Set ---");
        meuNotebook.setNivelBateria(500);


        System.out.println("O notebook da marca " + novoNotebook.getMarca() +
                " está equipado com um processador " + novoNotebook.getProcessador().getModelo());

        System.out.println("--- Notebook Corporativo ---");
        System.out.println("Marca: " + notebookTrabalho.getMarca());
        System.out.println("Processador: " + notebookTrabalho.getProcessador().getModelo());
        System.out.println("Domínio: " + notebookTrabalho.getDominioEmpresa());

        notebookTrabalho.carregarBateria(100);

        System.out.println("\n--- Notebook Gamer ---");
        System.out.println("Marca: " + notebookJogo.getMarca());
        System.out.println("Teclado RGB: " + (notebookJogo.isTecladoRgb() ? "Sim" : "Não"));

        notebookJogo.ligar();
    }
}