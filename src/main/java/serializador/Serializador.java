/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializador;

import automato.Automato;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class Serializador {
    
    // Método auxiliar: recebe um vetor de textos (ex: ["1", "3"]) e converte para uma lista de números inteiros
    public static List<Integer> converterParaInteiros(String[] array){
        List<Integer> inteiros = new ArrayList<>(); // Cria uma lista vazia de números
        // Percorre cada texto do vetor
        for(String c : array){
            // Transforma o texto em número (Integer.parseInt) e guarda na lista
            inteiros.add(Integer.parseInt(c)); 
        }
        return inteiros; // Devolve a lista de números pronta
    }
    
    // Método que abre o arquivo, lê linha por linha e monta o objeto Automato
    public static Automato lerAutomatoDeArquivo(String caminhoArquivo) throws IOException {
        // BufferedReader é usado para ler o arquivo de forma rápida e eficiente
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            
            // --- PASSO 1: LER OS ESTADOS FINAIS ---
            List<Integer> estadosFinais;
            
            // Lê a primeira linha do arquivo, remove espaços vazios (trim) e corta no ponto e vírgula (split)
            String[] Finais = leitor.readLine().trim().split(";");
            
            // Usa o método auxiliar lá de cima para converter o texto lido em números inteiros
            estadosFinais = converterParaInteiros(Finais);
            
            // --- PASSO 2: LER A MATRIZ DE TRANSIÇÃO ---
            // Cria uma lista flexível, pois ainda não sabemos quantos estados (linhas) o autômato tem
            List<int[]> linhas = new ArrayList<>(); 
            String linha;
            
            // Laço de repetição que vai ler o arquivo linha por linha até encontrar o fim (null)
            while ((linha = leitor.readLine()) != null) {
                // Pega a linha atual e corta no ponto e vírgula
                String[] estados = linha.trim().split(";");
                
                // Se a linha tem exatamente 2 colunas (uma transição para 'a' e outra para 'b')
                if (estados.length == 2) {
                    // Converte os dois valores para número e adiciona como uma nova linha na nossa lista flexível
                    linhas.add(new int[] {
                        Integer.parseInt(estados[0]), // Destino lendo 'a'
                        Integer.parseInt(estados[1])  // Destino lendo 'b'
                    });
                }
            }
            
            // --- PASSO 3: CONVERTER PARA MATRIZ FIXA ---
            // Cria uma matriz fixa com o tamanho exato de linhas que acabamos de ler
            int[][] matrizTransicao = new int[linhas.size()][2];
            
            // Copia os dados da lista flexível para a matriz definitiva
            for (int i = 0; i < linhas.size(); i++) {
                matrizTransicao[i] = linhas.get(i);
            }
            
            // --- PASSO 4: CRIAR O AUTÔMATO ---
            // Devolve um novo objeto Automato já configurado com a matriz e os estados finais lidos do arquivo
            return new Automato(matrizTransicao, estadosFinais);
        }
    }
}