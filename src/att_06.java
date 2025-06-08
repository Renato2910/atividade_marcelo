import java.util.Arrays;
import java.util.Random;

public class att_06 {

    // Classe para armazenar estatísticas
    static class SortStats {
        long comparisons = 0;
        long swaps = 0;

        void reset() {
            comparisons = 0;
            swaps = 0;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, SortStats stats) {
        int[] aux = new int[arr.length];
        mergeSortHelper(arr, aux, 0, arr.length - 1, stats);
    }
    private static void mergeSortHelper(int[] arr, int[] aux, int left, int right, SortStats stats) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSortHelper(arr, aux, left, mid, stats);
        mergeSortHelper(arr, aux, mid + 1, right, stats);
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            stats.comparisons++;
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
            }
            stats.swaps++;
        }
        while (i <= mid) {
            aux[k++] = arr[i++];
            stats.swaps++;
        }
        while (j <= right) {
            aux[k++] = arr[j++];
            stats.swaps++;
        }
        for (k = left; k <= right; k++) {
            arr[k] = aux[k];
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, SortStats stats) {
        quickSortHelper(arr, 0, arr.length - 1, stats);
    }
    private static void quickSortHelper(int[] arr, int low, int high, SortStats stats) {
        if (low < high) {
            int p = partition(arr, low, high, stats);
            quickSortHelper(arr, low, p - 1, stats);
            quickSortHelper(arr, p + 1, high, stats);
        }
    }
    private static int partition(int[] arr, int low, int high, SortStats stats) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            stats.comparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
                stats.swaps++;
            }
        }
        swap(arr, i + 1, high);
        stats.swaps++;
        return i + 1;
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Main: executa os testes e imprime tabela
    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000};
        String[] types = {"random", "sorted", "reverse"};
        Random rand = new Random(42);
        SortStats stats = new SortStats();

        System.out.printf("%-12s %-8s %-8s %12s %14s%n",
                "Algoritmo", "Tamanho", "Tipo", "Comparações", "Trocas/Partições");
        System.out.println("-----------------------------------------------------------------------");

        for (int n : sizes) {
            // base aleatória
            int[] base = new int[n];
            for (int i = 0; i < n; i++) {
                base[i] = rand.nextInt(10000);
            }
            // gera as 3 versões
            int[] arrRandom = Arrays.copyOf(base, n);

            int[] arrSorted = Arrays.copyOf(base, n);
            Arrays.sort(arrSorted);

            int[] arrReverse = Arrays.copyOf(arrSorted, n);
            for (int i = 0; i < n/2; i++) {
                int tmp = arrReverse[i];
                arrReverse[i] = arrReverse[n-1-i];
                arrReverse[n-1-i] = tmp;
            }

            for (String type : types) {
                int[] arr;
                switch (type) {
                    case "random":  arr = Arrays.copyOf(arrRandom, n); break;
                    case "sorted":  arr = Arrays.copyOf(arrSorted, n); break;
                    case "reverse": arr = Arrays.copyOf(arrReverse, n); break;
                    default:        arr = new int[0];
                }

                // Merge Sort
                stats.reset();
                mergeSort(arr, stats);
                System.out.printf("%-12s %-8d %-8s %12d %14d%n",
                        "Merge Sort", n, type, stats.comparisons, stats.swaps);

                // Quick Sort
                stats.reset();
                arr = ("random".equals(type) ? Arrays.copyOf(arrRandom, n)
                        : "sorted".equals(type) ? Arrays.copyOf(arrSorted, n)
                        : Arrays.copyOf(arrReverse, n));
                quickSort(arr, stats);
                System.out.printf("%-12s %-8d %-8s %12d %14d%n",
                        "Quick Sort", n, type, stats.comparisons, stats.swaps);
            }
        }
    }
}
