package br.com.fiapsmart.model;

public abstract class Notebook {
   private String marca;
   private boolean ligado;
   private int nivelBateria;
   private  double espacoLivreGb;
   private  boolean conectadoWifi;

   public Notebook(String marca, boolean ligado, int nivelBateria) {
      this.setMarca(marca);
      this.setLigado(ligado);
      this.setNivelBateria(nivelBateria);
      this.setConectadoWifi(false);
   }

   private Processador processador;

   public Notebook(String marca, Processador processador) {
      this.setMarca(marca);
      this.processador = processador;

      this.setLigado(false);
      this.setNivelBateria(0);
      this.setConectadoWifi(false);
   }

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

   public void executarOtimizacao() {
      System.out.println("A executar otimização genérica de energia e processos do sistema...");
   }

   public abstract String obterTipoDeUso();


   //Getters e Setters
   public Processador getProcessador() {
      return processador;
   }

   public String getMarca() {
      return marca;
   }

   public void setMarca(String marca) {
      this.marca = marca;
   }

   public boolean isLigado() {
      return ligado;
   }

   public void setLigado(boolean ligado) {
      this.ligado = ligado;
   }

   public int getNivelBateria() {
      return nivelBateria;
   }

   public void setNivelBateria(int nivelBateria) {
      if (nivelBateria < 0 || nivelBateria > 100) {
         System.out.println("Erro: Nível de bateria inválido. Deve estar entre 0 e 100.");
      } else {
         this.nivelBateria = nivelBateria;
      }
   }

   public double getEspacoLivreGb() {
      return espacoLivreGb;
   }

   public void setEspacoLivreGb(double espacoLivreGb) {
      this.espacoLivreGb = espacoLivreGb;
   }

   public boolean isConectadoWifi() {
      return conectadoWifi;
   }

   public void setConectadoWifi(boolean conectadoWifi) {
      this.conectadoWifi = conectadoWifi;
   }
}