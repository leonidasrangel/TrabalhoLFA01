/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automato;

import java.util.List;

/**
 *
 * @author Rangel
 */
public class Automato {
    private final int[][] matrizTransicao; // A matriz que representa a tabela de transição (linhas = estados, colunas = alfabeto)
    private final List<Integer> estadosFinais; // Lista que guarda quais são os estados de aceitação (estados finais)
    private final String alfabeto = "ab"; // definição do alfabeto

    // Construtor: Inicializa o autômato recebendo as regras lidas do arquivo
    public Automato(int[][] matrizTransicao, List<Integer> estadoFinal) {
        this.matrizTransicao = matrizTransicao; // Salva a matriz de transição
        this.estadosFinais = estadoFinal;       // Salva a lista de estados finais
    }

    // Método principal da classe: verifica se a palavra fornecida é aceita pelo autômato
    public boolean reconhecer(String palavra) {
        int estadoAtual = 0; // começa a leitura a partir do estado inicial zero
        
        // Laço de repetição que quebra a palavra recebida em um vetor de caracteres e analisa letra por letra
        for (char c : palavra.toCharArray()) {
            
            // Descobre o índice da letra no alfabeto. 'a' vira 0 (coluna 0) e 'b' vira 1 (coluna 1)
            int indiceSimbolo = alfabeto.indexOf(c);
            
            // Trava de segurança: se a letra não estiver no alfabeto (ex: 'c' ou 'x'), a palavra é rejeitada na hora
            if (indiceSimbolo == -1) {
                return false;
            }
            
            // Aqui ocorre a transição de estado! O autômato "anda" para o próximo estado
            // Ele consulta a matriz na linha do seu estado atual e na coluna da letra que acabou de ler
            estadoAtual = matrizTransicao[estadoAtual][indiceSimbolo];
        }
        
        // Após ler todas as letras da palavra, verificamos onde o autômato parou.
        // Se o estado onde ele parou está dentro da lista de estados finais, a palavra é aceita (true).
        if(estadosFinais.contains(estadoAtual))
            return true;
        return false;
    }
}
