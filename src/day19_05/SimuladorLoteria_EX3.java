package day19_05;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class SimuladorLoteria_EX3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] sorteados = new int[6];

        // Gera 6 números únicos aleatórios entre 1 e 60
        for (int i = 0; i < sorteados.length; i++) {
            int num;
            boolean existe;
            do {
                num = rand.nextInt(60) + 1;
                existe = false;
                for (int j = 0; j < i; j++) {
                    if (sorteados[j] == num) {
                        existe = true;
                        break;
                    }
                }
            } while (existe);
            sorteados[i] = num;
        }

        // Exibe os números sorteados
        System.out.println("Números sorteados: " + Arrays.toString(sorteados));

        // Leitura dos 6 números da aposta do usuário
        System.out.println("Digite sua aposta (6 números inteiros entre 1 e 60):");
        int[] aposta = new int[6];
        for (int i = 0; i < aposta.length; i++) {
            System.out.print("Número [" + (i+1) + "]: ");
            aposta[i] = sc.nextInt();
        }

        // Verifica acertos usando busca linear
        ArrayList<Integer> acertos = new ArrayList<>();
        for (int i = 0; i < aposta.length; i++) {
            for (int j = 0; j < sorteados.length; j++) {
                if (aposta[i] == sorteados[j]) {
                    acertos.add(aposta[i]);
                    break; // interrompe busca após encontrar este número
                }
            }
        }

        // Exibe resultados
        System.out.println("\nVocê acertou " + acertos.size() + " números.");
        if (!acertos.isEmpty()) {
            System.out.print("Números acertados: ");
            for (int n : acertos) {
                System.out.print(n + " ");
            }
            System.out.println();
        } else {
            System.out.println("Nenhum acerto.");
        }

        sc.close();
    }
}
