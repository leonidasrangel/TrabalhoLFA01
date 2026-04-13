/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalholfa01;

import automato.Automato;
import java.io.IOException;
import java.util.Scanner;
import serializador.Serializador;

/**
 *
 * @author Rangel
 */
public class TrabalhoLFA01 {

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            String caminho = "Automato1.csv";

            Automato automato = Serializador.lerAutomatoDeArquivo(caminho);
        
            
            System.out.println("\nDigite palavras para testar (ou 'sair' para encerrar):");
            while (true) {
                String palavra = scanner.nextLine();
                if (palavra.equalsIgnoreCase("sair")) {
                    break;
                }
                boolean resultado = automato.reconhecer(palavra);
                System.out.println("Resultado: " + resultado);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
