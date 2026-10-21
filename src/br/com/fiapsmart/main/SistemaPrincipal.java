package br.com.fiapsmart.main;

import br.com.fiapsmart.model.Notebook;

public class SistemaPrincipal {
    public static void main(String[] args) {

        Notebook meuNotebook = new Notebook("Dell", true, 80 );
        meuNotebook.setEspacoLivreGb(250.5);
        meuNotebook.setConectadoWifi(false);

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
    }
}