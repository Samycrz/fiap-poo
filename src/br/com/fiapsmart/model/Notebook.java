package br.com.fiapsmart.model;

public class Notebook {
   public String marca;
   public boolean ligado;
   public int nivelBateria;
   public  double espacoLivreGb;
   public  boolean conectadoWifi;

   public void ligar() {
      if (this.ligado) {
         System.out.println("Aviso: O notebook já está ligado.");
      } else if (this.nivelBateria <= 0) {
         System.out.println("Erro: Bateria esgotada. Não é possível ligar.");
      } else {
         this.ligado = true;
         System.out.println("Notebook ligado com sucesso.");
      }
   }

   public void carregarBateria(int quantidade) {
      if (quantidade <= 0) {
         System.out.println("Erro: A quantidade de carga deve ser superior a zero.");
      } else if (this.nivelBateria + quantidade > 100) {
         this.nivelBateria = 100;
         System.out.println("Bateria totalmente carregada (100%).");
      } else {
         this.nivelBateria += quantidade;
         System.out.println("Bateria carregada. Nível atual: " + this.nivelBateria + "%");
      }
   }
}