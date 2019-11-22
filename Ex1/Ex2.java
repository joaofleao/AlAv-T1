import java.util.Random;
import java.util.Scanner;

public class Ex2 {

    public static int maxVal1(int A[], int n) {  
        int cont = 0;
        int max = A[0];
        long inicio = System.currentTimeMillis();  
        for (int i = 1; i < n; i++) {  
            if( A[i] > max ) 
            max = A[i];
            cont++;
        } 
        System.out.println("Numero de operacoes: " + cont);
        System.out.println("Tempo de execucao: " +  (System.currentTimeMillis() - inicio) + " milisegundos");
        return max;
    }

    public static void main(String args[]){
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        System.out.println("Informe um tamanho: ");
        int tamanho = in.nextInt();
        int arr[] = new int[tamanho];
        for(int i = 0; i < tamanho; i++){
            arr[i]=rand.nextInt(100000);
        }
        System.out.println("O maior valor de numeros gerados de 0 a 100000 e: " + maxVal1(arr, tamanho));        
    }
}