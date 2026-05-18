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