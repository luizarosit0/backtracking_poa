import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NRainhas {

    // Conta quantas soluções foram encontradas
    static int totalSolucoes = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de N: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("Não deve ser menor que 2.");
            return;
        }

        int[] tabuleiro = new int[n];

        // Inicializa todas as posições com -1
        // Isso significa que ainda não há rainha naquela linha
        for (int i = 0; i < n; i++) {
            tabuleiro[i] = -1;
        }

        System.out.println("\n=== UMA SOLUÇÃO ===");

        if (resolverUmaSolucao(tabuleiro, 0, n)) {
            imprimirTabuleiro(tabuleiro, n);
        } else {
            System.out.println("Não existe solução para N = " + n);
        }

        System.out.println("\n=== TODAS AS SOLUÇÕES ===");

        totalSolucoes = 0;

        for (int i = 0; i < n; i++) {
            tabuleiro[i] = -1;
        }

        resolverTodasSolucoes(tabuleiro, 0, n);

        System.out.println("Total de soluções encontradas: " + totalSolucoes);
    }

    // Parte 1: encontra apenas uma solução
    public static boolean resolverUmaSolucao(int[] tabuleiro, int linha, int n) {

        // Caso base:
        // Se linha == n, significa que conseguimos colocar N rainhas
        if (linha == n) {
            return true;
        }

        // Tenta colocar uma rainha em cada coluna da linha atual
        for (int coluna = 0; coluna < n; coluna++) {

            // Verifica se é seguro colocar a rainha nessa posição
            if (posicaoSegura(tabuleiro, linha, coluna)) {

                // Faz a escolha
                tabuleiro[linha] = coluna;

                // Chama recursivamente para a próxima linha
                if (resolverUmaSolucao(tabuleiro, linha + 1, n)) {
                    return true;
                }

                // Desfaz a escolha, pois ela não levou a uma solução
                tabuleiro[linha] = -1;
            }
        }

        // Se nenhuma coluna funcionou, retorna falso
        return false;
    }

    // Parte 2: encontra todas as soluções possíveis
    public static void resolverTodasSolucoes(int[] tabuleiro, int linha, int n) {

        // Se linha == n, encontramos uma solução completa
        if (linha == n) {
            totalSolucoes++;
            System.out.println("\nSolução " + totalSolucoes + ":");
            imprimirTabuleiro(tabuleiro, n);
            return;
        }

        // Tenta todas as colunas da linha atual
        for (int coluna = 0; coluna < n; coluna++) {

            if (posicaoSegura(tabuleiro, linha, coluna)) {

                // Coloca a rainha
                tabuleiro[linha] = coluna;

                // Continua tentando preencher a próxima linha
                resolverTodasSolucoes(tabuleiro, linha + 1, n);

                // Backtracking: remove a rainha para testar outra coluna
                tabuleiro[linha] = -1;
            }
        }
    }

    // Verifica se é seguro colocar uma rainha em determinada linha e coluna
    public static boolean posicaoSegura(int[] tabuleiro, int linha, int coluna) {

        // Verifica todas as rainhas colocadas nas linhas anteriores
        for (int i = 0; i < linha; i++) {

            int colunaRainhaAnterior = tabuleiro[i];

            // Mesma coluna
            if (colunaRainhaAnterior == coluna) {
                return false;
            }

            // Mesma diagonal
            if (Math.abs(colunaRainhaAnterior - coluna) == Math.abs(i - linha)) {
                return false;
            }
        }

        return true;
    }

    // Imprime o tabuleiro
    public static void imprimirTabuleiro(int[] tabuleiro, int n) {

        for (int linha = 0; linha < n; linha++) {

            for (int coluna = 0; coluna < n; coluna++) {

                if (tabuleiro[linha] == coluna) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }

            System.out.println();
        }
    }
}