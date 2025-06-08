package day26_05;

import java.util.Arrays;

public class Sorts {

    static long compCount;
    static long swapCount;

    public static void bubbleSort(int[] a) {
        compCount = 0;
        swapCount = 0;
        int n = a.length;
        boolean trocou;
        for (int pass = 0; pass < n - 1; pass++) {  //On
            trocou = false;
            for (int i = 0; i < n - 1 - pass; i++) {//On
                compCount++;
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    swapCount++;
                    trocou = true;
                }
            }
            if (!trocou) break; //On * On = On2
        }
        System.out.printf("Bubble: Comparações=%d, Trocas=%d%n", compCount, swapCount);
    }

    public static void selectionSort(int[] a) {
        compCount = 0;
        swapCount = 0;
        int n = a.length;
        for (int i = 0; i < n - 1; i++) { //On
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {//On
                compCount++;
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = tmp;
                swapCount++;
            }
        }  //On * On = On2
        System.out.printf("Selection: Comparações=%d, Trocas=%d%n", compCount, swapCount);
    }

    public static void insertionSort(int[] a) {
        compCount = 0;
        swapCount = 0;
        int n = a.length;
        for (int i = 1; i < n; i++) { //On
            int key = a[i];
            int j = i - 1;
            while (j >= 0) {
                compCount++;
                if (a[j] > key) {
                    a[j + 1] = a[j];
                    swapCount++;
                    j--;
                } else {
                    break;
                }
            }
            a[j + 1] = key;
        }// On
        System.out.printf("Insertion: Comparações=%d, Deslocamentos=%d%n", compCount, swapCount);
    }

    public static void main(String[] args) {
        int[] original = {5, 2, 9, 1, 5, 6};

        // Testa Bubble
        int[] a = original.clone();
        bubbleSort(a);
        System.out.println("Resultado: " + Arrays.toString(a));

        // Testa Selection
        a = original.clone();
        selectionSort(a);
        System.out.println("Resultado: " + Arrays.toString(a));

        // Testa Insertion
        a = original.clone();
        insertionSort(a);
        System.out.println("Resultado: " + Arrays.toString(a));
    }
}
