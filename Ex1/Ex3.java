import java.util.Random;
import java.util.Scanner;

public class Ex3 {
    public static int cont = 0;
    public static int max(int a, int b){
        if(a>b){
            return a;
        }
        else return b;
    }
    public static int maxVal2(int A[], int init, int end) {    
        if (end - init <= 1){
            cont++;
            return max(A[init], A[end]);
        }  
        else {
            cont++;
            int m = (init + end)/2;
            int v1 = maxVal2(A,init,m);   
            cont++;
            int v2 = maxVal2(A,m+1,end);  
            return max(v1,v2);
        }
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
        long inicio = System.currentTimeMillis();
        System.out.println("O maior valor de numeros gerados de 0 a 100000 e: " + maxVal2(arr, 0, tamanho-1));    
        System.out.println("Tempo de execucao: " +  (System.currentTimeMillis() - inicio) + " milisegundos");  
        System.out.println("Numero de operacoes: " + cont);  
    }
}