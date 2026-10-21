package br.com.fiapsmart.main;

import br.com.fiapsmart.model.Notebook;

public class SistemaPrincipal {
    public static void main(String[] args) {

        Notebook meuNotebook = new Notebook();

        meuNotebook.marca = "Dell";
        meuNotebook.ligado = true;
        meuNotebook.nivelBateria = 0;
        meuNotebook.espacoLivreGb = 250.5;
        meuNotebook.conectadoWifi = false;

        System.out.println("--- Testar Valores Inválidos ---");
        meuNotebook.ligar();
        meuNotebook.carregarBateria(-20);

        System.out.println("\n--- Testar Valores Válidos ---");
        meuNotebook.carregarBateria(40);
        meuNotebook.ligar();

        System.out.println("\n--- Testar Limites do Estado ---");
        meuNotebook.carregarBateria(80);
    }
}