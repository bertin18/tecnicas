import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Conjunto {

    public  int[] array;
    private final  int tamanho;


    public Conjunto(int tamanho) {
        this.tamanho = tamanho;
        this.array = new int[tamanho];
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            array[i] = rand.nextInt(101); // números aleatórios de 0 a 100
        }
    }

    public int obterTamanhoConjunto() {
        return tamanho;
    }

    
    public void mostrarConjunto() {
        System.out.print("Conjunto gerado: [");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("]");
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
 public int buscaBinaria(int elemento, Conjunto X) {
    X.ordenacaoSelectionSort(); // Ordena o conjunto X para a busca binária
    int low = 0;
    int high = X.obterTamanhoConjunto() - 1; // Usa o tamanho do conjunto X
    while (low <= high) {
        int mid = (low + high) / 2;
        if (X.array[mid] == elemento) {
            return mid; // Retorna a posição do elemento encontrado no conjunto X
        }
        if (X.array[mid] < elemento) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1; // Retorna -1 se o elemento não for encontrado
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
    
    public static List<Integer> intersecao(Conjunto A, Conjunto B) {
    List<Integer> intersecao = new ArrayList<>();

    for (int i = 0; i < A.tamanho; i++) {
        if (B.buscaBinaria(A.array[i],B) != -1) { // Se encontrar o elemento em B
            intersecao.add(A.array[i]);
        }
    }

    return intersecao;
    }
    
    public static List<Integer> uniao(Conjunto A, Conjunto B) {
    A.ordenacaoSelectionSort(); // Ordenamos A para facilitar a busca
    List<Integer> uniao = new ArrayList<>();

    // Adiciona todos os elementos de A à união
    for (int i = 0; i < A.tamanho; i++) {
        uniao.add(A.array[i]);
    }
    B.ordenacaoSelectionSort();
    // Adiciona elementos de B que não estão em A
    for (int i = 0; i < B.tamanho; i++) {
        if (A.buscaBinaria(B.array[i],A) == -1) { // Se não estiver em A, adiciona
            uniao.add(B.array[i]);
        }
    }

    return uniao;
}

    public static List<Integer> multiplicarPorEscalar(Conjunto A, int escalar) {
    List<Integer> resultado = new ArrayList<>();

    for (int i = 0; i < A.tamanho; i++) {
        resultado.add(A.array[i] * escalar);
    }

    return resultado;
}
    
    public static int produtoEscalar(Conjunto A, Conjunto B) {
    if (A.tamanho != B.tamanho) {
        throw new IllegalArgumentException("Os vetores devem ter o mesmo tamanho para o produto escalar.");
    }

    int produto = 0;
    for (int i = 0; i < A.tamanho; i++) {
        produto += A.array[i] * B.array[i];
    }

    return produto;
}
    
    public static List<Integer> intercalarVetores(Conjunto A, Conjunto B) {
    List<Integer> intercalado = new ArrayList<>();
    
    int i = 0, j = 0;

    // Intercala os elementos enquanto ambos os vetores tiverem elementos
    while (i < A.tamanho && j < B.tamanho) {
        intercalado.add(A.array[i++]); // Adiciona um elemento de A
        intercalado.add(B.array[j++]); // Adiciona um elemento de B
    }

    // Se A ainda tiver elementos, adiciona ao final
    while (i < A.tamanho) {
        intercalado.add(A.array[i++]);
    }

    // Se B ainda tiver elementos, adiciona ao final
    while (j < B.tamanho) {
        intercalado.add(B.array[j++]);
    }

    return intercalado;
}

}
