package br.com.fiapsmart.main;

import br.com.fiapsmart.model.Notebook;

public class SistemaPrincipal {
    public static void main(String[] args) {

        Notebook meuNotebook = new Notebook();

        meuNotebook.marca = "Dell";
        meuNotebook.ligado = true;
        meuNotebook.nivelBateria = 80;
        meuNotebook.espacoLivreGb = 250.5;
        meuNotebook.conectadoWifi = false;

        System.out.println("Marca: " + meuNotebook.marca);
        System.out.println("Bateria: " + meuNotebook.nivelBateria + "%");
    }
}