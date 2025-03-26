import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Conjunto {

    public  int[] array;
    private final  int tamanho;

    // Construtor que recebe o tamanho do conjunto e gera o conjunto com números aleatórios
    public Conjunto(int tamanho) {
        this.tamanho = tamanho;
        this.array = new int[tamanho];
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            array[i] = rand.nextInt(1001); // números aleatórios de 0 a 1000
        }
    }

    // Método para obter o tamanho do conjunto
    public int obterTamanhoConjunto() {
        return tamanho;
    }

    // Método para exibir o conjunto
    public void mostrarConjunto() {
        System.out.print("Conjunto gerado: [");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }

    // Busca sequencial aprimorada
    public int buscarSequencialAprimorada(int elemento) {
        ordenacaoSelectionSort();
        for (int i = 0; i < tamanho; i++) {
            if (array[i] > elemento) {
                break;
            }
            if (array[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    // Ordenação usando Selection Sort
    public void ordenacaoSelectionSort() {
        for (int i = 0; i < tamanho - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (array[j] < array[menor]) {
                    menor = j;
                }
            }
            int temp = array[i];
            array[i] = array[menor];
            array[menor] = temp;
        }
    }

    // Busca binária
    public int buscaBinaria(int elemento) {
        ordenacaoSelectionSort();
        int low = 0;
        int high = tamanho - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == elemento) {
                return mid;
            }
            if (array[mid] < elemento) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int[] calcularDiferenca(int[] A, int[] B) {
        if (A.length != B.length) {
            throw new IllegalArgumentException("Os vetores devem ter o mesmo tamanho.");
        }

        int[] C = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            C[i] = A[i] - B[i];
        }

        return C;
    }


    public static List<Integer> complemento(int[] A, int[] B) {
        List<Integer> resultado = new ArrayList<>();
        for (int elementoA : A) {
            boolean encontrado = false;
            for (int elementoB : B) {
                if (elementoA == elementoB) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                resultado.add(elementoA);
            }
        }
        return resultado;
    }
    
}
