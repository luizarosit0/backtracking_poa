import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class somaSubconjuntos {

    // Conta quantas soluções foram encontradas
    static int totalSolucoes = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de números do array: ");
        int n = scanner.nextInt();

        int[] conjunto = new int[n];

        System.out.println("Digite os números do conjunto:");

        for (int i = 0; i < n; i++) {
            conjunto[i] = scanner.nextInt();
        }

        // Encontrar UM subconjunto cuja soma seja zero
        List<Integer> subconjunto = new ArrayList<>();

        System.out.println("\n--- Buscando Um Subconjunto ---");

        // Chama o método de backtracking
        boolean encontrou = resolverSubconjunto(
                conjunto,
                0,
                subconjunto,
                0
        );

        if (encontrou) {
            System.out.println("Subconjunto encontrado com soma zero:");
            System.out.println(subconjunto);
        } else {
            System.out.println("Não existe subconjunto não-vazio com soma zero.");
        }

        // Encontrar TODOS os subconjuntos cuja soma seja zero
        System.out.println("\n--- Todos os Subconjuntos ---");

        totalSolucoes = 0;

        resolverTodosSubconjuntos(conjunto, 0, new ArrayList<>(), 0);

        System.out.println("\nTotal de soluções encontradas: "
                + totalSolucoes);

        scanner.close();
    }

    // Método que usa backtracking para encontrar um subconjunto cuja soma seja zero
    public static boolean resolverSubconjunto(int[] conjunto, int indice, List<Integer> subconjunto, int somaAtual) {

        // Caso base:
        // Se a soma for zero e o subconjunto não estiver vazio
        if (somaAtual == 0 && !subconjunto.isEmpty()) {
            return true;
        }

        // Se chegou ao final do vetor e não encontrou solução
        if (indice == conjunto.length) {
            return false;
        }

        // Escolha 1: incluir o número atual no subconjunto

        subconjunto.add(conjunto[indice]);

        // Chama recursivamente para o próximo índice
        if (resolverSubconjunto(conjunto, indice + 1, subconjunto, somaAtual + conjunto[indice])) {

            return true;
        }

        // Backtracking:
        // Remove o elemento pois não levou à solução
        subconjunto.remove(subconjunto.size() - 1);

        // Escolha 2: não incluir o número

        return resolverSubconjunto(conjunto, indice + 1, subconjunto, somaAtual);
    }

    // Método que usa backtracking para encontrar TODOS subconjuntos cuja soma seja zero
    public static void resolverTodosSubconjuntos(int[] conjunto, int indice, List<Integer> subconjunto, int somaAtual) {

        // Caso base:
        // Se encontrou uma soma zero e o subconjunto não está vazio
        if (somaAtual == 0 && !subconjunto.isEmpty()) {

            totalSolucoes++;

            System.out.println("Solução "
                    + totalSolucoes
                    + ": "
                    + subconjunto);

            return;
        }

        // Se chegou ao final do vetor
        if (indice == conjunto.length) {
            return;
        }

        // Escolha 1: incluir o número atual

        subconjunto.add(conjunto[indice]);

        // Chama recursivamente para o próximo índice
        resolverTodosSubconjuntos(conjunto, indice + 1, subconjunto, somaAtual + conjunto[indice]);

        // Backtracking:
        // Remove o elemento para testar outras possibilidades
        subconjunto.remove(subconjunto.size() - 1);

        // Escolha 2: não incluir o número atual

        resolverTodosSubconjuntos(conjunto, indice + 1, subconjunto, somaAtual);
    }
}