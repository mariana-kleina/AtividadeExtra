# Atividade Extra - Sistema de Gerenciamento de Obras de Arte

Este repositório contém um sistema de gerenciamento de obras de arte, desenvolvido em Java. O projeto foca na aplicação de conceitos de **Programação Orientada a Objetos (POO)**, incluindo herança, polimorfismo e manipulação de coleções, além de persistência de dados em arquivos.

### Sobre o Projeto

O sistema permite o cadastro e gerenciamento de diferentes tipos de obras de arte, como **Pinturas** e **Esculturas**, que herdam de uma classe base `ObraDeArte`. Ele oferece um menu interativo via console para realizar operações CRUD (Criar, Ler, Atualizar, Deletar) e funcionalidades de busca por critérios. A persistência de dados garante que as informações das obras sejam salvas e carregadas de um arquivo de texto, mesmo após o encerramento do programa.

### Funcionalidades Principais

* **Adicionar Obra:** Cadastra novas pinturas, esculturas ou obras de arte genéricas, solicitando detalhes específicos para cada tipo.
* **Listar Obras:** Exibe todas as obras de arte cadastradas na coleção.
* **Buscar Obra:** Permite buscar uma obra específica pelo título.
* **Atualizar Obra:** Edita os detalhes de uma obra existente com base no seu título.
* **Excluir Obra:** Remove uma obra da coleção pelo seu título.
* **Salvar/Carregar Obras:** Persiste os dados da coleção em um arquivo de texto e os carrega de volta para o sistema.
* **Procurar por Critérios:** Busca obras por artista, ano de criação ou tipo.

### Estrutura do Projeto (Classes Principais)

* `ObraDeArte.java`: Classe base que define as propriedades comuns de uma obra de arte (título, artista, ano, tipo, localização).
* `Pintura.java`: Estende `ObraDeArte`, adicionando a propriedade `meio` (ex: óleo, acrílico).
* `Escultura.java`: Estende `ObraDeArte`, adicionando a propriedade `material` (ex: mármore, bronze).
* `GerenciadorDeObras.java`: Contém a lógica de negócios para gerenciar a coleção de obras (adição, busca, atualização, exclusão, listagem, e persistência em arquivo).
* `SistemaObras.java`: Implementa a interface de usuário baseada em console, interagindo com o `GerenciadorDeObras`.
* `Principal.java`: Contém o método `main` para iniciar a aplicação.

### Tecnologias Utilizadas

* **Linguagem:** Java
* **Estruturas de Dados:** `ArrayList` para gerenciar a coleção de obras.
* **Entrada/Saída:** `Scanner` para leitura de dados do console e `PrintWriter`/`FileReader`/`FileWriter` para manipulação de arquivos.

### Como Executar o Projeto

Para rodar este projeto em sua máquina local, siga os passos abaixo:

1.  **Pré-requisitos:** Certifique-se de ter o Java Development Kit (JDK) instalado (versão 8 ou superior recomendada).
2.  **Clonar o Repositório:**
    ```bash
    git clone [https://github.com/mariana-kleina/AtividadeExtra.git](https://github.com/mariana-kleina/AtividadeExtra.git)
    cd AtividadeExtra
    ```
3.  **Compilar o Projeto:** Navegue até o diretório onde os arquivos `.java` estão localizados (geralmente na raiz do projeto ou em uma pasta `src`) e compile-os:
    ```bash
    javac *.java
    ```
    *Se estiver usando um IDE (Eclipse, IntelliJ):* Abra o projeto diretamente no IDE e ele cuidará da compilação.
4.  **Executar o Projeto:** A partir do diretório onde os arquivos `.class` foram gerados:
    ```bash
    java Principal
    ```
    *Se estiver usando um IDE:* Execute a classe `Principal.java`.

### O que este projeto demonstra:

* Minha capacidade de aplicar **Programação Orientada a Objetos** com herança e polimorfismo.
* Habilidade em desenvolver sistemas de **gerenciamento de dados (CRUD)** em Java.
* Conhecimento em **persistência de dados** utilizando arquivos de texto.
* Competência em criar interfaces de usuário baseadas em console.
* Organização de código em classes distintas com responsabilidades claras.
