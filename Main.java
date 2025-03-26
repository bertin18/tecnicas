import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Conjunto conjuntoA = null, conjuntoB = null;
            int opcao;
            int tamanhoA = 0, tamanhoB = 0;
            // Definindo o tamanho do primeiro conjunto
            System.out.print("Digite o tamanho do primeiro conjunto (A): ");
            tamanhoA = scanner.nextInt();
            conjuntoA = new Conjunto(tamanhoA);
            System.out.println("Conjunto A gerado com sucesso.");
            // Perguntando se o usuário quer definir um segundo conjunto
            System.out.print("Deseja definir um segundo conjunto (B)? (1 - Sim, 0 - Não): ");
            int resposta = scanner.nextInt();
            if (resposta == 1) {
                System.out.print("Digite o tamanho do segundo conjunto (B): ");
                tamanhoB = scanner.nextInt();
                conjuntoB = new Conjunto(tamanhoB);
                System.out.println("Conjunto B gerado com sucesso.");
            }   // Operações em loop
            do {
                System.out.println("\n======= MENU =======");
                System.out.println("3 - Mostrar ambos os conjuntos");
                System.out.println("4 - Buscar elemento no conjunto A (sequencial)");
                System.out.println("5 - Ordenar conjunto A");
                System.out.println("6 - Buscar binária no conjunto A");
                System.out.println("7 - Calcular a diferença entre os conjuntos A e B");
                System.out.println("8 - Encerrar");
                System.out.print("Digite uma opção: ");
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 3 -> {
                        if (conjuntoA != null) {
                            System.out.print("Conjunto A: ");
                            conjuntoA.mostrarConjunto();
                        } else {
                            System.out.println("Conjunto A não foi gerado.");
                        }
                        
                        if (conjuntoB != null) {
                            System.out.print("Conjunto B: ");
                            conjuntoB.mostrarConjunto();
                        } else {
                            System.out.println("Conjunto B não foi gerado.");
                        }
                    }
                        
                    case 4 -> {
                        if (conjuntoA != null) {
                            System.out.print("Digite o elemento de busca para o conjunto A: ");
                            int elementoA = scanner.nextInt();
                            int posicaoA = conjuntoA.buscarSequencialAprimorada(elementoA);
                            if (posicaoA != -1) {
                                System.out.println("Elemento encontrado no conjunto A na posição: " + posicaoA);
                            } else {
                                System.out.println("Elemento não encontrado no conjunto A.");
                            }
                        } else {
                            System.out.println("Conjunto A não foi gerado.");
                        }
                    }
                        
                    case 5 -> {
                        if (conjuntoA != null) {
                            conjuntoA.ordenacaoSelectionSort();
                            System.out.println("Conjunto A ordenado com sucesso.");
                        } else {
                            System.out.println("Conjunto A não foi gerado.");
                        }
                    }
                        
                    case 6 -> {
                        if (conjuntoA != null) {
                            System.out.print("Digite o elemento de busca para o conjunto A: ");
                            int elementoB = scanner.nextInt();
                            int posicaoB = conjuntoA.buscaBinaria(elementoB);
                            if (posicaoB != -1) {
                                System.out.println("Elemento encontrado no conjunto A na posição: " + posicaoB);
                            } else {
                                System.out.println("Elemento não encontrado no conjunto A.");
                            }
                        } else {
                            System.out.println("Conjunto A não foi gerado.");
                        }
                    }
                        
                    case 7 -> {
                        if (conjuntoA != null && conjuntoB != null) {
                            try {
                                int[] diff = Conjunto.calcularDiferenca(conjuntoA.array, conjuntoB.array);
                                System.out.print("Diferença entre os conjuntos A e B: [");
                                for (int i = 0; i < diff.length; i++) {
                                    System.out.print(diff[i]);
                                    if (i < diff.length - 1) {
                                        System.out.print(", ");
                                    }
                                }
                                System.out.println("]");
                            } catch (IllegalArgumentException e) {
                                System.out.println("Erro: Os conjuntos A e B devem ter o mesmo tamanho.");
                            }
                        } else {
                            System.out.println("Os conjuntos A e B devem ser gerados para calcular a diferença.");
                        }
                    }
                        
                    case 8 -> System.out.println("Encerrando o programa.");
                        
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 8);
        }
    }
}
