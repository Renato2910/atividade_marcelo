package day19_05;
import java.util.Scanner;

public class BuscaLinearBasica_EX1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[10];

        // Leitura dos 10 números inteiros
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("vetor[" + i + "]: ");
            vetor[i] = sc.nextInt();
        }

        // Leitura do número a ser buscado
        System.out.print("Digite o número a buscar: ");
        int chave = sc.nextInt();

        // Busca linear
        boolean encontrado = false;
        int posicao  = -1;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chave) {
                encontrado = true;
                posicao    = i;
                break;  // interrompe na primeira ocorrência
            }
        }

        // Saída de acordo com o resultado
        if (encontrado) {
            System.out.println("Número encontrado na posição: " + posicao);
        } else {
            System.out.println("Não encontrado");
        }

        sc.close();
    }
}
