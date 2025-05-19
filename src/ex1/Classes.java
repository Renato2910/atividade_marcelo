package ex1;

public class Classes {

    /**
     * Busca linear em vetor não ordenado.
     * Percorre todos os elementos até encontrar k ou chegar ao fim.
     * @param A vetor de inteiros (não ordenado)
     * @param n tamanho do vetor
     * @param k valor a buscar
     * @return índice de k em A, ou -1 se não encontrado
     */
    public static int buscaLinearNaoOrdenado(int[] A, int n, int k) {
        for (int i = 0; i < n; i++) {             // para cada posição i
            if (A[i] == k) {                      // verifica igualdade
                return i;                         // retorna índice imediatamente
            }
        }
        return -1;                                // não achou: retorna -1
    }

    /**
     * Busca linear em vetor ordenado.
     * Para assim que supera k, pois não há mais chance de encontrá-lo.
     * @param A vetor de inteiros (ordenado em ordem crescente)
     * @param n tamanho do vetor
     * @param k valor a buscar
     * @return índice de k em A, ou -1 se não encontrado
     */
    public static int buscaLinearOrdenado(int[] A, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (A[i] == k) {
                return i;
            } else if (A[i] > k) {                // ultrapassou k
                return -1;                        // k não estará adiante
            }
        }
        return -1;
    }

    /**
     * Busca binária em vetor ordenado.
     * Divide repetidamente o intervalo de busca ao meio.
     * @param A vetor de inteiros (ordenado)
     * @param n tamanho do vetor
     * @param k valor a buscar
     * @return índice de k em A, ou -1 se não encontrado
     */
    public static int buscaBinaria(int[] A, int n, int k) {
        int esq = 0;
        int dir = n - 1;
        while (esq <= dir) {                              // enquanto houver intervalo válido
            int meio = esq + (dir - esq) / 2;             // evita overflow
            if (A[meio] == k) {
                return meio;
            } else if (A[meio] < k) {
                esq = meio + 1;                          // busca na metade direita
            } else {
                dir = meio - 1;                          // busca na metade esquerda
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] vetorNaoOrdenado = {5, 3, 8, 1, 9, 2};
        int[] vetorOrdenado    = {1, 2, 3, 5, 8, 9};
        int[] chavesParaTestar = {5, 1, 9, 7, 2, 3};

        System.out.println("=== Busca Linear Não Ordenado ===");
        for (int k : chavesParaTestar) {
            int idx = buscaLinearNaoOrdenado(vetorNaoOrdenado, vetorNaoOrdenado.length, k);
            if (idx == -1) {
                System.out.printf("busca(%d): elemento NÃO encontrado\n", k);
            } else {
                System.out.printf("busca(%d): índice %d\n", k, idx);
            }
        }

        System.out.println("\n=== Busca Linear Ordenado ===");
        for (int k : chavesParaTestar) {
            int idx = buscaLinearOrdenado(vetorOrdenado, vetorOrdenado.length, k);
            if (idx == -1) {
                System.out.printf("busca(%d): elemento NÃO encontrado\n", k);
            } else {
                System.out.printf("busca(%d): índice %d\n", k, idx);
            }
        }

        System.out.println("\n=== Busca Binária ===");
        for (int k : chavesParaTestar) {
            int idx = buscaBinaria(vetorOrdenado, vetorOrdenado.length, k);
            if (idx == -1) {
                System.out.printf("busca(%d): elemento NÃO encontrado\n", k);
            } else {
                System.out.printf("busca(%d): índice %d\n", k, idx);
            }
        }
    }
}
