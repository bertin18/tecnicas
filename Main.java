import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Conjunto conjuntoA = null;
            Conjunto conjuntoB = null;
            int opcao;
            int tamanhoA = 0, tamanhoB = 0;
            
            System.out.print("Digite o tamanho do primeiro conjunto (A): ");
            tamanhoA = scanner.nextInt();
            conjuntoA = new Conjunto(tamanhoA);
            System.out.println("Conjunto A gerado com sucesso.");
            
            // Perguntando se o usuário quer definir um segundo conjunto
           System.out.print("Deseja definir um segundo conjunto (B)? (1 - Sim, 0 - Nao): ");
            int resposta = scanner.nextInt();
            if (resposta == 1) {
                
                System.out.print("Digite o tamanho do segundo conjunto (B): ");
                tamanhoB = scanner.nextInt();
                conjuntoB = new Conjunto(tamanhoB);
                System.out.println("Conjunto B gerado com sucesso.");
            }
            
            // Operações em loop
            do {
                System.out.println("\n======= MENU =======");
                System.out.println("1 - Mostrar ambos os conjuntos");
                System.out.println("2 - Buscar elemento em um conjunto");
                System.out.println("3 - Ordenar conjuntos");
                System.out.println("4 - Calcular a diferenca entre os conjuntos A e B");
                System.out.println("5 - Calcular complemento de A em relacao a B");
                System.out.println("6 - Calcular intersecao entre A e B");
                System.out.println("7 - Calcular uniao entre A e B");
                System.out.println("8 - Multiplicar um conjunto por um escalar");
                System.out.println("9 - Calcular produto escalar entre A e B");
                System.out.println("10 - Intercalar os conjuntos A e B");
                System.out.println("0 - Encerrar");
                System.out.print("Digite uma opcao: ");
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1 -> {
                        conjuntoA.mostrarConjunto();
                        if (conjuntoB != null) conjuntoB.mostrarConjunto();
                    }
                    
                    case 2 -> {
                        System.out.print("Buscar em qual conjunto? (A - 1, B - 2): ");
                        int escolha = scanner.nextInt();
                        Conjunto conjuntoEscolhido = null;
                        if(escolha == 1){
                            conjuntoEscolhido = conjuntoA;
                        } else if(escolha == 2){
                            conjuntoEscolhido = conjuntoB;
                        }
                        if (conjuntoEscolhido != null) {
                            System.out.print("Digite o elemento a ser buscado: ");
                            int elemento = scanner.nextInt();
                            // Utilizando apenas a busca binária
                            int posicao = conjuntoEscolhido.buscaBinaria(elemento, conjuntoEscolhido);
                            
                            if (posicao != -1) {
                                System.out.println("Elemento encontrado na posicao: " + posicao);
                            } else {
                                System.out.println("Elemento nao encontrado.");
                            }
                        } else {
                            System.out.println("Conjunto nao foi gerado.");
                        }
                    }
                    
                    case 3 -> {conjuntoA.ordenacaoSelectionSort();
                               if (conjuntoB != null) conjuntoB.ordenacaoSelectionSort();
                                System.out.println("Conjuntos ordenados com sucesso.");}
                              
                    
                    case 4 -> {
                        if (conjuntoB != null) {
                            int[] diferenca = Conjunto.calcularDiferenca(conjuntoA.array, conjuntoB.array);
                            System.out.println("Diferença entre A e B: ");
                            for (int i : diferenca) {
                                System.out.print(i + " ");
                            }
                            System.out.println();
                        } else {
                            System.out.println("Conjunto B não foi gerado.");
                        }
                    }
                    
                    case 5 -> {
                        if (conjuntoB != null) {
                            List<Integer> complemento = Conjunto.complemento(conjuntoA.array, conjuntoB.array);
                            System.out.println("Complemento de A em relação a B: " + complemento);
                        } else {
                            System.out.println("Conjunto B não foi gerado.");
                        }
                    }
                    
                    case 6 -> {
                        if (conjuntoB != null) {
                            List<Integer> intersecao = Conjunto.intersecao(conjuntoA, conjuntoB);
                            System.out.println("Interseção entre A e B: " + intersecao);
                        } else {
                            System.out.println("Conjunto B não foi gerado.");
                        }
                    }
                    
                    case 7 -> {
                        if (conjuntoB != null) {
                            List<Integer> uniao = Conjunto.uniao(conjuntoA, conjuntoB);
                            System.out.println("União entre A e B: " + uniao);
                        } else {
                            System.out.println("Conjunto B não foi gerado.");
                        }
                    }
                    
                    case 8 -> {
                        System.out.print("Digite o valor escalar: ");
                        int escalar = scanner.nextInt();
                        List<Integer> resultado = Conjunto.multiplicarPorEscalar(conjuntoA, escalar);
                        System.out.println("Resultado da multiplicação por escalar: " + resultado);
                    }
                    
                    case 9 -> {
                        if (conjuntoB != null) {
                            int produto = Conjunto.produtoEscalar(conjuntoA, conjuntoB);
                            System.out.println("Produto escalar entre A e B: " + produto);
                        } else {
                            System.out.println("Conjunto B não foi gerado.");
                        }
                    }
                    
                    case 10 -> {
                        if (conjuntoB != null) {
                            List<Integer> intercalado = Conjunto.intercalarVetores(conjuntoA, conjuntoB);
                            System.out.println("Vetores intercalados: " + intercalado);
                        } else {
                            System.out.println("Conjunto B não foi gerado.");
                        }
                    }
                    
                    case 0 -> System.out.println("Encerrando o programa.");
                    
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 0);
        }
    }
}