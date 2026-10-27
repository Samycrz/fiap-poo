package br.com.fiapsmart.main;

import br.com.fiapsmart.model.*;

import java.util.ArrayList;
import java.util.List;

public class SistemaPrincipal {
    public static void main(String[] args) {

        //Por ser objeto abstrato, não é possivel instaciar
//        Notebook meuNotebook = new Notebook("Dell", true, 80 );
//        meuNotebook.setEspacoLivreGb(250.5);
//        meuNotebook.setConectadoWifi(false);
//
//        Processador meuProcessador = new Processador("Intel Core i7", 4.2);
//        Notebook novoNotebook = new Notebook("Dell", meuProcessador);

        //Instanciando Objetos
        Processador processadorCorporativo = new Processador("Intel Core i5", 3.2);
        Processador processadorGamer = new Processador("AMD Ryzen 9", 4.8);

        Processador processadorGenerico = new Processador("Intel Core i3", 2.4);

        NotebookCorporativo notebookTrabalho = new NotebookCorporativo("Lenovo", processadorCorporativo, "@dominio.com.br");
        NotebookGamer notebookJogo = new NotebookGamer("Alienware", processadorGamer, true);

        //Tentativa de criar um objeto da classe abstrata
        // Notebook notebookInvalido = new Notebook("HP", processadorGenerico);


        //Por ser objeto abstrato, não é possivel instaciar
//        System.out.println("\n--- Testar Burla no Set ---");
//        meuNotebook.setNivelBateria(150);
//
//        System.out.println("--- Testar Valores Inválidos ---");
//        meuNotebook.ligar();
//        meuNotebook.carregarBateria(-20);
//
//        System.out.println("\n--- Testar Valores Válidos ---");
//        meuNotebook.carregarBateria(40);
//        meuNotebook.ligar();
//
//        System.out.println("\n--- Testar Limites do Estado ---");
//        meuNotebook.carregarBateria(80);
//
//        System.out.println("\n--- Testar Burla no Set ---");
//        meuNotebook.setNivelBateria(500);
//
//
//        System.out.println("O notebook da marca " + novoNotebook.getMarca() +
//                " está equipado com um processador " + novoNotebook.getProcessador().getModelo());

        System.out.println("--- Notebook Corporativo ---");
        System.out.println("Marca: " + notebookTrabalho.getMarca());
        System.out.println("Processador: " + notebookTrabalho.getProcessador().getModelo());
        System.out.println("Domínio: " + notebookTrabalho.getDominioEmpresa());

        notebookTrabalho.carregarBateria(100);

        System.out.println("\n--- Notebook Gamer ---");
        System.out.println("Marca: " + notebookJogo.getMarca());
        System.out.println("Teclado RGB: " + (notebookJogo.isTecladoRgb() ? "Sim" : "Não"));

        notebookJogo.ligar();

        List<Notebook> inventario = new ArrayList<>();
        inventario.add(notebookTrabalho);
        inventario.add(notebookJogo);

        System.out.println("--- O Teste de Fogo: Polimorfismo ---");

        for (Notebook note : inventario) {
            System.out.println("Otimizando portátil da marca: " + note.getMarca());

            note.executarOtimizacao();
            System.out.println("-------------------------------------");

            System.out.println("--- Teste de Abstração ---");
            System.out.println("Notebook Trabalho (" + notebookTrabalho.getMarca() + "): " + notebookTrabalho.obterTipoDeUso());
            System.out.println("Notebook Jogo (" + notebookJogo.getMarca() + "): " + notebookJogo.obterTipoDeUso());
        }

        System.out.println("\n--- Missão: Array de Interfaces (Polimorfismo com Notificavel) ---");
        Notificavel[] centralDeAlertas = new Notificavel[3];
        centralDeAlertas[0] = processadorCorporativo;
        centralDeAlertas[1] = processadorGamer;
        centralDeAlertas[2] = notebookTrabalho;

        for (Notificavel emissor : centralDeAlertas) {
            emissor.enviarNotificacao("Atualização de segurança crítica pendente.");
        }
    }
}