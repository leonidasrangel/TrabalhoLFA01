# Simulador de Autômato Finito Determinístico (AFD) ⚙️

Este projeto é uma implementação em **Java** de um simulador de Autômato Finito Determinístico (AFD). Desenvolvido como trabalho para a disciplina de Linguagens Formais e Autômatos (LFA), o programa é capaz de ler as configurações de um autômato a partir de um arquivo e verificar se determinadas palavras (sequências de caracteres) pertencem ou não à linguagem definida.

## 🎯 Objetivo do Projeto

O objetivo principal é implementar um programa que reconheça linguagens regulares por meio de autômatos finitos. A representação computacional do autômato é feita através de uma **matriz de transição**, que é carregada dinamicamente via leitura de arquivo de texto (`.csv`).

O projeto foi configurado para reconhecer palavras sobre o alfabeto **Σ = {a, b}** e abrange 4 linguagens distintas:
1. $L = \{w \mid w \text{ possua } aa \text{ ou } bb \text{ como subpalavra}\}$
2. $L = \{w \mid \text{entre dois } a\text{'s de } w\text{, há quantidade par de } b\text{'s}\}$
3. $L = \{w \mid w \text{ tenha } aa \text{ ou } aba \text{ como subpalavra}\}$
4. $L = \{w \mid \text{entre dois } b\text{'s de } w\text{, há quantidade ímpar de } a\text{'s}\}$

---

## 🏗️ Estrutura do Código

O projeto foi construído utilizando o paradigma de Orientação a Objetos e está dividido em 3 classes principais:

* **`Automato.java` (O Motor):** Representa a estrutura matemática do AFD. Recebe a matriz de transição e os estados de aceitação. Possui o método `reconhecer(String palavra)`, que percorre a palavra caractere por caractere realizando as transições de estado para determinar se ela é aceita (true) ou rejeitada (false).
* **`Serializador.java` (O Leitor):** Classe utilitária responsável por ler o arquivo `.csv`, tratar os dados (String para Integer) e montar a matriz de transição e a lista de estados finais para instanciar o `Automato`.
* **`TrabalhoLFA01.java` (A Interface):** A classe principal (`Main`). Responsável por solicitar a leitura do arquivo ao Serializador e manter um loop interativo no terminal (console) para que o usuário possa testar múltiplas palavras de forma contínua.

---

## 📂 Formato de Configuração dos Autômatos

Os autômatos são carregados através de arquivos `.csv` localizados na raiz do projeto. O formato padronizado para a leitura é o seguinte:

* **Primeira Linha:** Contém os estados de aceitação (finais), separados por ponto e vírgula (`;`).
* **Linhas Seguintes:** Representam a matriz de transição. Cada linha é um estado (começando do estado inicial `0`). A primeira coluna indica a transição ao ler o símbolo `'a'`, e a segunda coluna ao ler o símbolo `'b'`.

**Exemplo de Arquivo (Automato1.csv):**
```csv
3
1;2
3;2
1;3
3;3


Como Executar
Pré-requisitos
Java Development Kit (JDK) 17 ou superior.

IDE compatível (NetBeans, Eclipse, IntelliJ) ou Maven instalado na máquina.

Passos para rodar
Clone o repositório ou faça o download do projeto.

Certifique-se de que os arquivos .csv (ex: Automato1.csv) estejam localizados na raiz do projeto (fora da pasta src).

Abra a classe TrabalhoLFA01.java e altere o nome do arquivo na variável caminho para o autômato que deseja testar:

Java
String caminho = "Automato1.csv"; // Altere aqui para testar L2, L3 ou L4
Compile e execute o projeto.

No terminal, digite a palavra formada por 'a's e 'b's e pressione Enter para ver o resultado.

Digite sair a qualquer momento para encerrar o programa.
