# Projeto Portátil (Notebook)

## Descrição
A classe `Notebook` representa um computador portátil do mundo real. O objetivo é gerir o estado físico e lógico do dispositivo, como a sua marca, o nível de energia e se está em funcionamento.

## Métodos Disponíveis
- `ligar()`: Altera o estado do portátil para ligado. **Regra de negócio:** O equipamento só liga se estiver atualmente desligado e possuir um nível de bateria superior a 0%.
- `carregarBateria(int quantidade)`: Incrementa o nível de energia do portátil. **Regra de negócio:** Não aceita valores negativos de carga e impede que a bateria ultrapasse o limite físico de 100%.