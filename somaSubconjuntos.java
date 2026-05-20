import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class somaSubconjuntos {

    // contadores 
    static int totalSolucoes = 0;
    static long iteracoesPrimeira = 0;
    static long iteracoesTodos = 0;
    static long instrucoesPrimeira = 0;
    static long instrucoesTodos = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o modo de teste:");
        System.out.println("1 - Entrada manual de conjunto");
        System.out.println("2 - Gerar conjunto grande automaticamente");
        int opcao = scanner.nextInt();

        int[] conjunto;

        if (opcao == 2) {
            System.out.print("Digite o tamanho do conjunto (ex: 50 a 1000): ");
            int tamanho = scanner.nextInt();
            conjunto = gerarConjuntoAleatorio(tamanho);
            System.out.println("Conjunto gerado.");
        } else {
            System.out.print("Digite a quantidade de números do array: ");
            int n = scanner.nextInt();
            conjunto = new int[n];
            System.out.println("Digite os números do conjunto:");
            for (int i = 0; i < n; i++) {
                conjunto[i] = scanner.nextInt();
            }
        }

        // Encontrar UM subconjunto cuja soma seja zero
        List<Integer> subconjunto = new ArrayList<>();

        System.out.println("\n--- Buscando Um Subconjunto ---");

        long tempoInicio = System.nanoTime();
        // Chama o método de backtracking
        boolean encontrou = resolverSubconjunto(
                conjunto,
                0,
                subconjunto,
                0
        );

        long tempoFim = System.nanoTime();

        if (encontrou) {
            System.out.println("Subconjunto encontrado com soma zero:");
            System.out.println(subconjunto);
        } else {
            System.out.println("Não existe subconjunto não-vazio com soma zero.");
        }

        System.out.println("Iterações: " + iteracoesPrimeira);
        System.out.println("Instruções aprox: " + instrucoesPrimeira);
        System.out.println("Tempo: " + (tempoFim - tempoInicio) + " ns");

        // Encontrar TODOS os subconjuntos cuja soma seja zero
        System.out.println("\n--- Todos os Subconjuntos ---");

        totalSolucoes = 0;

        tempoInicio = System.nanoTime();
        resolverTodosSubconjuntos(conjunto, 0, new ArrayList<>(), 0);
        tempoFim = System.nanoTime();

        System.out.println("\nTotal de soluções encontradas: " + totalSolucoes);
        System.out.println("Iterações: " + iteracoesTodos);
        System.out.println("Instruções aprox: " + instrucoesTodos);
        System.out.println("Tempo: " + (tempoFim - tempoInicio) + " ns");

        scanner.close();
    }

    // Método que usa backtracking para encontrar um subconjunto cuja soma seja zero
    public static boolean resolverSubconjunto(int[] conjunto, int indice, List<Integer> subconjunto, int somaAtual) {
        iteracoesPrimeira++;
        instrucoesPrimeira += 3;
        
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
        iteracoesTodos++;
        instrucoesTodos += 2;

        // Caso base:
        // Se encontrou uma soma zero e o subconjunto não está vazio
        if (indice == conjunto.length) {
            if (somaAtual == 0 && !subconjunto.isEmpty()) {
                totalSolucoes++;
                // comentar para testar com o gerador
                //System.out.println("Solução " + totalSolucoes + ": " + subconjunto);
            }
            return; // retorna pois chegamos ao fim da combinação
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

    //gera conjuntos grandes de números positivos e negativos (entre 50 e 1000 elementos)
    public static int[] gerarConjuntoAleatorio(int tamanho) {
        Random random = new Random();
        int[] conjunto = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            // numeros entre -50 e 50
            conjunto[i] = random.nextInt(101) - 50; 
            if (conjunto[i] == 0) conjunto[i] = 1; // evita zeros absolutos faceis
        }
        return conjunto;
    }
}