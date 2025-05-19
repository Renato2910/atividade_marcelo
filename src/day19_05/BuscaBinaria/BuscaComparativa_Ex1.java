package day19_05.BuscaBinaria;

public class BuscaComparativa_Ex1 {
    // Classe para armazenar o resultado de uma busca
    static class ResultadoBusca {
        int indice;       // índice onde a chave foi encontrada (-1 se não encontrada)
        int comparacoes;  // número de comparações realizadas

        ResultadoBusca(int indice, int comparacoes) {
            this.indice = indice;
            this.comparacoes = comparacoes;
        }
    }

    public static ResultadoBusca buscaLinearContando(int[] arr, int chave) {
        int comparacoes = 0;
        for (int i = 0; i < arr.length; i++) {
            comparacoes++;
            if (arr[i] == chave) {
                return new ResultadoBusca(i, comparacoes);
            }
        }
        return new ResultadoBusca(-1, comparacoes);
    }

    public static ResultadoBusca buscaBinariaContando(int[] arr, int chave) {
        int comparacoes = 0;
        int inicio = 0;
        int fim    = arr.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            comparacoes++;
            if (arr[meio] == chave) {
                return new ResultadoBusca(meio, comparacoes);
            } else if (arr[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return new ResultadoBusca(-1, comparacoes);
    }

    public static void main(String[] args) {
        // Tamanhos de vetor sugeridos
        int[] tamanhos = {10, 100, 1000};

        // Para cada tamanho, cria vetor ordenado [1, 2, ... , n],
        // e testa chaves no início, meio, fim e ausentes.
        for (int n : tamanhos) {
            int[] vetor = new int[n];
            for (int i = 0; i < n; i++) {
                vetor[i] = i + 1;
            }

            int meio = n / 2;
            int[] chavesParaTestar = {1, meio, n, -1};

            System.out.println("==== Vetor de tamanho " + n + " ====");
            for (int chave : chavesParaTestar) {
                ResultadoBusca rl = buscaLinearContando(vetor, chave);
                ResultadoBusca rb = buscaBinariaContando(vetor, chave);

                System.out.printf(
                        "Chave %3d -> Linear: índice=%3d, comparações=%3d | " +
                                "Binária: índice=%3d, comparações=%3d%n",
                        chave,
                        rl.indice, rl.comparacoes,
                        rb.indice, rb.comparacoes
                );
            }
            System.out.println();
        }
    }
}
