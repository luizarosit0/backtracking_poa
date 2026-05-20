Alunos: Ana Paula Pereira, Eduarda Rubin, Julia Fernandes e Luiza Rosito
# N-Rainhas
## Análise de complexidade: 

* Primeira solução:
A complexidade no pior caso é O(n!), pois o algoritmo posiciona uma rainha por linha e testa as colunas possíveis, usando backtracking para abandonar posições inválidas. Como essa versão para ao encontrar a primeira solução, em alguns casos ela pode executar menos do que o pior caso.

* Todas as soluções:
A complexidade também é O(n!), pois o algoritmo precisa explorar todo o espaço de busca para encontrar todas as soluções válidas. Essa versão não para na primeira solução encontrada, por isso geralmente possui mais iterações e maior tempo de execução.

* Tabela de resultados:

| N | Primeira solução | Total de soluções | Iterações - primeira solução | Instruções - primeira solução | Tempo - primeira solução | Iterações - todas soluções | Instruções - todas soluções | Tempo - todas soluções |
|---|------------------|-------------------|-------------------------------|--------------------------------|---------------------------|-----------------------------|------------------------------|-------------------------|
| 4 | Encontrada | 2 | 26 | 78 | 512948 ns | 60 | 180 | 2850516 ns |
| 5 | Encontrada | 10 | 15 | 45 | 736695 ns | 220 | 660 | 47154771 ns |
| 6 | Encontrada | 4 | 171 | 513 | 4370915 ns | 894 | 2682 | 14351468 ns |
| 7 | Encontrada | 40 | 42 | 126 | 1137534 ns | 3584 | 10752 | 48520050 ns |
| 8 | Encontrada | 92 | 876 | 2628 | 2521489 ns | 15720 | 47160 | 112628087 ns |

# Soma dos Subconjuntos
## Análise de complexidade:

* Primeira Solução: 
A complexidade no pior caso é O(2^n), quando o subconjunto com soma zero não existe ou é a última combinação testada. Contudo, em conjuntos com alta densidade de números positivos e negativos aleatórios, a probabilidade de encontrar uma soma zero rapidamente é alta, fazendo com que o algoritmo encontre a primeira solução em pouquíssimas iterações no caso médio.

* Todas as Soluções: 
A complexidade é O(2^n). O algoritmo realiza uma busca exaustiva por todas as combinações possíveis do conjunto das partes. A árvore de decisão binária gerada tem 2^(n+1)-1 nós totais visitados, exigindo que o algoritmo passe por todas as folhas para validar cada subconjunto único.

* Análise de Performance e Complexidade (Item 5)

Utilizando o gerador automático para analisar o comportamento do algoritmo em conjuntos maiores, coletamos os seguintes dados de iterações para a busca de **Todas as Soluções**:

- Para N = 20: 2.097.151 iterações (Tempo: ~33 ms)
- Para N = 25: 67.108.863 iterações (Tempo: ~293 ms)
- Para N = 30: 2.147.483.647 iterações (Tempo: ~8,8 segundos)

Crescimento Exponencial: ao aumentar o tamanho do conjunto de 25 para 30 (apenas 5 elementos a mais), o número de iterações saltou de 67 milhões para mais de 2 bilhões, e o tempo subiu de milissegundos para quase 9 segundos. Isso descreve perfeitamente o comportamento da curva de crescimento O(2^n).

* Tabela de resultados:

| Conjunto de Teste | Tamanho (N) | Iterações - primeira solução | Instruções - primeira solução | Tempo - primeira solução | Iterações - todas soluções | Instruções - todas soluções | Total Soluções | Tempo - todas soluções |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| `{-7, -3, -2, 5, 8}` | 5 | 36 | 108 | 101.039 ns | 63 | 126 | 1 | 24.258.379 ns |
| `{1, 2, 3, 4, 5, 10}` | 6 | 127 | 381 | 131.495 ns | 127 | 254 | 0 | 77.124 ns |
| `{-5, 2, 3, -1, 1}` | 5 | 4 | 12 | 319.265 ns | 63 | 126 | 3 | 32.806.225 ns |