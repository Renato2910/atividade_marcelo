package day19_05;
import java.util.Scanner;
import java.util.ArrayList;

public class BuscaLinear_EX0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leitura do tamanho do vetor
        System.out.print("Digite o número de elementos do vetor: ");
        int n = sc.nextInt();
        int[] vetor = new int[n];

        // Leitura dos elementos do vetor
        System.out.println("Digite os " + n + " valores inteiros:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento [" + i + "]: ");
            vetor[i] = sc.nextInt();
        }

        // Leitura do valor a ser buscado
        System.out.print("Digite o valor a buscar: ");
        int chave = sc.nextInt();

        // Busca linear, contando comparações
        int comparacoes = 0;
        int posicaoEncontrada = -1;
        for (int i = 0; i < n; i++) {
            comparacoes++;
            if (vetor[i] == chave) {
                posicaoEncontrada = i;
                break;  // interrompe ao encontrar a primeira ocorrência
            }
        }

        // Exibição dos resultados da busca
        System.out.println("\n=== RESULTADO DA BUSCA ===");
        System.out.println("Comparações realizadas: " + comparacoes);
        if (posicaoEncontrada != -1) {
            System.out.println("Valor " + chave + " encontrado na posição: " + posicaoEncontrada);
        } else {
            System.out.println("Valor " + chave + " não encontrado no vetor.");
        }

        // Exibe quantidade total de elementos do vetor
        System.out.println("Total de elementos no vetor: " + n);

        // Coleta elementos menores e maiores
        ArrayList<Integer> menores = new ArrayList<>();
        ArrayList<Integer> maiores = new ArrayList<>();
        for (int valor : vetor) {
            if (valor < chave) {
                menores.add(valor);
            } else if (valor > chave) {
                maiores.add(valor);
            }
        }

        // Imprime elementos menores
        System.out.print("Elementos menores que " + chave + ": ");
        if (menores.isEmpty()) {
            System.out.println("Nenhum");
        } else {
            for (int v : menores) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        // Imprime elementos maiores
        System.out.print("Elementos maiores que " + chave + ": ");
        if (maiores.isEmpty()) {
            System.out.println("Nenhum");
        } else {
            for (int v : maiores) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
