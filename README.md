# Sistema de Gestão de Inventário de TI (Portáteis)

## Descrição do Projeto
Este projeto simula um sistema de gestão de hardware empresarial em Java. A aplicação foi desenvolvida aplicando princípios avançados de Programação Orientada a Objetos (POO) e a manipulação eficiente de dados em memória através do Java Collections Framework.

## Arquitetura e Padrões de Projeto (POO)
- **Abstração e Herança:** A classe central `Notebook` é **abstrata**. Isto impede a criação de portáteis genéricos no sistema. Foram implementadas duas especializações concretas:
    - `NotebookCorporativo`: Inclui regras de negócio para integração em domínios empresariais.
    - `NotebookGamer`: Focado em alto desempenho e periféricos específicos (ex: teclado RGB).
- **Composição:** Cada portátil exige, no momento da sua instanciação, um objeto `Processador` fortemente associado.
- **Polimorfismo:** O método genérico `executarOtimizacao()` está subscrito em cada classe filha (`@Override`), permitindo que cada tipo de máquina reaja à sua própria maneira quando solicitada pelo sistema principal.

