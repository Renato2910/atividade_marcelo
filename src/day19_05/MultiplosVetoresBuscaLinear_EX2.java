package day19_05;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class MultiplosVetoresBuscaLinear_EX2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // 1) Criação e preenchimento de 3 vetores de 20 elementos (1–100)
        int[][] vetores = new int[3][20];
        for (int v = 0; v < 3; v++) {
            for (int i = 0; i < 20; i++) {
                vetores[v][i] = rand.nextInt(100) + 1;
            }
        }

        // 2) Leitura do valor a buscar
        System.out.print("Digite o valor a buscar (1–100): ");
        int chave = sc.nextInt();

        // 3) Para cada vetor, faz busca linear contando comparações e armazenando posições
        int[] comparacoes = new int[3];
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] posicoes = new ArrayList[3];

        for (int v = 0; v < 3; v++) {
            posicoes[v] = new ArrayList<>();
            for (int i = 0; i < vetores[v].length; i++) {
                comparacoes[v]++;
                if (vetores[v][i] == chave) {
                    posicoes[v].add(i);
                }
            }
        }

        // 4) Exibição dos resultados para cada vetor
        for (int v = 0; v < 3; v++) {
            System.out.println("\nVetor " + (v+1) + ": " + Arrays.toString(vetores[v]));
            System.out.println("  Existe? " + (posicoes[v].isEmpty() ? "Não" : "Sim"));
            System.out.print  ("  Posições: ");
            if (posicoes[v].isEmpty()) {
                System.out.println("-");
            } else {
                System.out.println(posicoes[v]);
            }
            System.out.println("  Comparações feitas: " + comparacoes[v]);
        }

        sc.close();
    }
}

/*
→ Em qual vetor a busca foi mais eficiente?
   No vetor que teve o menor número de comparações (ou seja, aquele cuja
   variável comparacoes[v] é a mais baixa).

→ Por quê?
   Porque na busca linear cada elemento verificado gera uma comparação.
   Quanto mais cedo (índice menor) o valor buscado aparece no vetor,
   menos comparações serão necessárias para encontrá-lo.
*/
