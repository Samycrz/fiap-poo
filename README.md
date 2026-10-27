# Projeto FiapRide - Samy Tamires de Sousa Cruz

## Informações do Aluno
- **Nome:** Samy Tamires de Sousa Cruz 
- **RM:** 566674 
- **Turma:** 2CCPS 
- **Curso:** Ciência da Computação 
- **GitHub:** @Samycrz

---

## Descrição do Projeto
Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, onde desenvolvemos o sistema ........

---

## Checklist de Implementação
- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos
**Pergunta:** "Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil apenas criar variáveis soltas no main, como `String nomeAna = "Ana"` e `double saldoAna = 50.0`?
**Pense:** E se o FiapRide tiver 1 milhão de usuários? Como a Classe ajuda a resolver isso?"

**Sua Resposta:**
A criação de uma classe `Passageiro` é fundamental para a organização, coesão e escalabilidade do sistema. Se usássemos variáveis soltas no `main` para 1 milhão de usuários, teríamos que gerenciar 2 milhões de variáveis independentes (`nome1`, `saldo1`, `nome2`, `saldo2`), o que é humanamente impossível e insustentável. A classe atua como um molde ou "planta baixa". Com ela, escrevemos a estrutura apenas uma vez e podemos instanciar 1 milhão de objetos na memória. Cada objeto agrupa o seu próprio estado (nome, saldo) e comportamentos de forma independente, permitindo que o sistema gerencie dados massivos de forma limpa, estruturada e sem misturar as informações de Ana com as de outro usuário.

---

### Aula 2 - Métodos
**Pergunta:** "Se nós podemos simplesmente fazer `passageiro.saldo = passageiro.saldo + 100` diretamente no código principal, por que dá tanto trabalho criar um método específico chamado `adicionarSaldo(valor)` para fazer isso? Quais seriam os riscos para a nossa startup de mobilidade se deixássemos qualquer programador alterar o saldo diretamente?"

**Sua Resposta:**
Criar um método como `adicionarSaldo(valor)` serve para centralizar as regras de negócio e proteger os dados. Se permitirmos a manipulação direta (`passageiro.saldo += 100`), qualquer programador poderia, por erro ou má-fé, injetar valores negativos (`passageiro.saldo -= 5000`) ou ignorar limites máximos estipulados pela startup. O método atua como um "porteiro": dentro dele, podemos colocar validações (ex: `if (valor > 0)`), acionar registros de auditoria (logs) ou disparar notificações automáticas antes de efetivamente alterar o saldo. Isso garante que o estado do objeto permaneça sempre consistente e seguro.

---

### Aula 3 - Encapsulamento
**Pergunta:** "No nosso código, os atributos são `private`, mas os métodos `getSaldo()` e `getNome()` são `public`. Por que é seguro deixar o `get` público, mas perigoso deixar o atributo original público?
Pense bem: Qual a diferença entre dar a alguém uma CÓPIA de um documento seu, e entregar o documento ORIGINAL para a pessoa rasurar? "

**Sua Resposta:**
A segurança está na diferença entre acesso de leitura e permissão de escrita. O método `get` apenas retorna o valor atual, ou seja, entrega uma "cópia" da informação para quem pediu. A pessoa pode ler, mas não pode alterar o dado original dentro do objeto. Deixar o atributo `public` seria o equivalente a entregar o documento original nas mãos de terceiros, permitindo que rasuras e alterações inválidas fossem feitas sem nenhum controle. O encapsulamento com `private` garante que a única forma de modificar aquele dado seja através das vias oficiais do objeto (os métodos), mantendo a integridade da informação.

---

### Aula 4 - Construtores
**Pergunta:** "Na nossa classe `Veiculo`, nós tomamos duas decisões arquitetônicas muito importantes:
1. Nós **não** criamos o método `setModelo()`.
2. O `setPlaca()` foi criado como **privado**, e criamos um método público chamado `atualizarPlaca()` para acessá-lo.
Pensando no mundo real e no Clean Code: Por que é um erro gravíssimo clicar em 'Gerar Getters e Setters para tudo' automaticamente na sua IDE? Como as nossas duas decisões acima protegem o sistema de fraudes e falhas de lógica?
_Dica: Pense sobre o que pode ou não mudar fisicamente em um carro, e a diferença entre "alterar um dado no banco" e "executar um processo real no Detran"_"

**Sua Resposta:**
Gerar *Getters* e *Setters* cegamente quebra o encapsulamento, pois expõe todo o estado interno do objeto para alterações externas arbitrárias. No mundo real, um carro não troca de modelo após sair da fábrica; logo, a decisão de não ter `setModelo()` reflete essa imutabilidade física (o modelo nasce com o carro no construtor e nunca muda). Já a placa pode mudar, mas exige um processo burocrático no Detran. Ao usar um `setPlaca()` privado e um `atualizarPlaca()` público, blindamos a classe: a troca de placa só ocorre se a regra de negócio completa (validação de formato, registro de impostos, logs) for executada dentro de `atualizarPlaca()`, prevenindo fraudes sistêmicas.

---

### Aula 5 - Associação
**Pergunta:** "No construtor da `Viagem`, nós exigimos o objeto inteiro (`Passageiro solicitante`). Se o nosso resumo só precisa imprimir o nome da pessoa, não seria mais fácil e mais leve pedir apenas a String do nome no construtor da Viagem (`String nomeDoPassageiro`) em vez do objeto todo?
_Pense nas regras de negócio: O que acontece na hora que a Viagem acaba e o sistema precisa descontar o saldo? Se a Viagem tiver apenas a String "Ana Silva", ela consegue mexer no dinheiro dela? _"

**Sua Resposta:**
Passar apenas a `String` com o nome tornaria o sistema superficial e quebrado. Uma viagem não é feita por um texto, mas por uma entidade real de negócio que possui comportamentos e estado financeiro. Se a `Viagem` tiver apenas "Ana Silva", ao final do trajeto ela não conseguirá acionar o desconto do valor, pois uma `String` não possui o método `descontarSaldo()`. Ao exigirmos o objeto inteiro `Passageiro solicitante` no construtor, estabelecemos uma associação real: a viagem agora "conhece" a Ana e pode interagir com os métodos dela, atualizando seu saldo no banco de dados e mantendo a coesão do fluxo da aplicação.

---

### Aula 6 - Herança
**Pergunta:** "No nosso código, a mãe `Veiculo` possui os atributos `placa` e `modelo` como `private`. Quando o `Carro` herda de `Veiculo`, ele recebe esses atributos, mas o código dentro de `Carro` NÃO consegue fazer `this.placa = "ABC"`. Ele é obrigado a usar o `super()` ou o `setPlaca()`.
Por que o Java não deixa a filha alterar as variáveis privadas da mãe diretamente? Qual o princípio das aulas passadas que isso está protegendo?"

**Sua Resposta:**
O Java bloqueia o acesso direto de classes filhas aos atributos privados da classe mãe para manter estrito o princípio do Encapsulamento e a proteção do estado. A herança reaproveita código, mas não anula a segurança. Se a classe `Carro` pudesse alterar `placa` diretamente (`this.placa = "ABC"`), ela estaria contornando todas as regras de validação que o autor da classe `Veiculo` programou no `setPlaca()`. Obrigando o uso de métodos públicos, protegidos (`protected`) ou do `super()`, a linguagem garante que as regras de negócio definidas na superclasse sejam sempre respeitadas, não importa quantas gerações de subclasses existam.

---

### Aula 7 - Polimorfismo
**Pergunta:** "No nosso loop `for (Veiculo veiculo : frota)`, a variável `veiculo` é do tipo genérico `Veiculo`. Se esquecêssemos de criar o método `calcularAutonomia()` lá na classe mãe `Veiculo`, nós conseguiríamos chamá-lo dentro do loop, mesmo sabendo que ele existe dentro do `Carro` e da `Moto`? Por que o contrato precisa existir na base da hierarquia?"

**Sua Resposta:**
Não conseguiríamos chamá-lo. O Java possui tipagem estática e forte. Quando declaramos `Veiculo veiculo`, o compilador só "enxerga" os métodos que foram assinados na classe genérica `Veiculo`. Esse é o contrato. Mesmo que, em tempo de execução, o objeto específico seja um `Carro` que saiba calcular sua autonomia, o compilador barra a compilação, pois não há garantia de que *todos* os veículos saibam fazer isso. O contrato precisa existir na base da hierarquia (mesmo que vazio ou abstrato) para garantir ao compilador que é seguro chamar aquele comportamento para qualquer objeto que pertença àquela família.

---

### Aula 8 - Classes Abstratas
**Pergunta:** "Pense no mundo real: Faz sentido existir um objeto que é APENAS 'Veículo' sem ser um tipo específico? Você já entrou em uma concessionária e comprou "um veículo" genérico, sem ser carro, moto, caminhão ou nada disso?
Por que, então, no código, precisamos EXPLICITAMENTE dizer ao Java que `Veiculo` é `abstract`? Por que ele não deduz isso sozinho?
Pense: Se esquecermos de colocar `abstract`, qual o risco que corremos? Alguém pode criar `new Veiculo()` e quebrar a lógica do nosso sistema?"

**Sua Resposta:**
A palavra `abstract` é a tradução em código da impossibilidade de instanciar um conceito genérico. Assim como no mundo real não existe a entidade física "veículo genérico", no sistema instanciar `new Veiculo()` geraria um objeto oco, sem especificidades de aceleração, número de rodas ou autonomia. O Java não deduz isso sozinho porque ele não interpreta regras semânticas de negócio; ele precisa do comando explícito. Se esquecermos o `abstract`, corremos o risco de desenvolvedores criarem objetos inválidos e incompletos que causarão exceções e falhas na lógica de negócio na hora de executar ações que dependiam da implementação concreta das filhas.

---

### Aula 9 - Interfaces
**Pergunta:** "Por que Java permite herança simples (apenas uma mãe), mas múltipla implementação de interfaces (vários contratos)?
Pense: Se `CarroEletrico` pudesse herdar de `Veiculo` E de `Bateria` ao mesmo tempo (herança múltipla), o que aconteceria se AMBAS as mães tivessem um método chamado `ligar()`?
Como as interfaces resolvem esse problema? "

**Sua Resposta:**
A herança múltipla de classes gera o temido "Problema do Diamante". Se `CarroEletrico` herdasse de `Veiculo` e `Bateria`, e ambas as mães possuíssem um método implementado `ligar()`, a linguagem não saberia qual das duas lógicas executar, causando ambiguidade fatal. As Interfaces resolvem isso genialmente porque elas fornecem apenas o *contrato* (a assinatura do método), sem a implementação. Mesmo que um objeto assine 10 interfaces diferentes que exijam o método `ligar()`, não há conflito de herança, pois a responsabilidade de escrever o bloco de código lógico recai exclusivamente sobre a classe concreta filha, de forma única e inequívoca.

---

## Desafios Técnicos Implementados

### Desafio Pessoal (Seu Projeto)

**Qual foi o domínio que você escolheu para seu projeto pessoal?**
Sistema de Gestão e Especificação de Portáteis Corporativos e Gamers (FiapSmart).

**Quais classes você criou?**
A classe executável `SistemaPrincipal`, a classe abstrata `Notebook`, as subclasses concretas `NotebookCorporativo` e `NotebookGamer`, a classe de composição `Processador`, e a interface `Notificavel`.

**Qual foi o maior desafio técnico que você enfrentou?**
O maior desafio foi orquestrar adequadamente o polimorfismo misturando herança, classes abstratas e interfaces. Precisei garantir que objetos da superclasse `Notebook` não pudessem ser instanciados de forma pura (impedido pela abstração). Para aplicar a interface, criei um array polimórfico `Notificavel[] centralDeAlertas` que armazenava instâncias completamente distintas entre si, como `Processador` e `NotebookCorporativo`. Foi complexo alinhar os construtores via `super()` e garantir que a proteção de estado no método `carregarBateria()`, que impede valores maiores que 100%, funcionasse em conjunto com o polimorfismo da sobreposição (`@Override`) das rotinas de otimização exclusivas de cada tipo de notebook.

---

## Conclusão

**O que você aprendeu nestas 9 aulas?**
Aprendi a projetar arquiteturas de software seguras e escaláveis. Saí de uma visão simplista (variáveis soltas e métodos procedurais) para compreender como a Orientação a Objetos mapeia o mundo real. Entendi o valor inegociável de blindar o estado (Encapsulamento), a eficiência de reutilizar contratos lógicos (Herança) e a versatilidade de tratar objetos distintos de forma padronizada em tempo de execução (Polimorfismo e Interfaces).

**Qual conceito foi mais difícil de entender?**
A combinação de Polimorfismo e Interfaces. Inicialmente, era contraintuitivo entender como uma lista de uma "Interface" podia armazenar objetos tão diferentes. Superei isso percebendo que a interface não é "o que o objeto é", mas sim "uma habilidade que o objeto assinou o contrato dizendo que sabe fazer", permitindo agrupar classes não relacionadas baseando-se apenas em um comportamento em comum.

**O que você melhoraria no seu projeto se pudesse refazer?**
Eu refatoraria a classe `Notebook` para remover o `setNivelBateria(int nivelBateria)`. Embora ele possua uma validação impedindo valores abaixo de 0 ou acima de 100, a simples existência desse *setter* burla a lógica física do sistema, permitindo que a bateria mude "magicamente" de 10% para 90%. O correto seria manter apenas os métodos comportamentais de negócio reais (`carregarBateria(int quantidade)` e um potencial `descarregarBateria()`), além de substituir os alertas de terminal (`System.out.println("Erro...")`) pelo lançamento formal de exceções (`throw new IllegalArgumentException`).