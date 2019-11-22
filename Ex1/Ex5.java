import java.util.Random;
import java.util.Scanner;

public class Ex5 {

    public static long powerN(long number, long power){
        long res = 1;
        long sq = number;
        while(power > 0){
            if(power % 2 == 1){
                res *= sq; 
            }
            sq = sq * sq;
            power /= 2;
        }
        return res;
    }

    public static int cont =0;
    public static long multiply(long x, long y, long n) {    
        if(n == 1){
            cont++;
            return x * y;
        }else{
            cont++;
            long m = Math.round(n/2);
            long a = Math.round(x/(powerN(2, m)));
            long b = x%(powerN(2, m));
            long d = y%(powerN(2, m));
            long c = Math.round(y/(powerN(2, m)));
            long e = multiply(a, c, m);
            long f = multiply(b, d, m);
            long g = multiply(b, c, m);
            long h = multiply(a, d, m);
            long result = (2*m)*e;
            long result2 = m*(g+h);
            return powerN(2, result) + (powerN(2, result2) + f);
        }
    }

    public static void main(String args[]){
        long inicio = System.currentTimeMillis();  
        //System.out.println(multiply(2, 3, 1));
        //Escolher valor com dependendo do numero de bits
        System.out.println("Tempo de execucao: " +  (System.currentTimeMillis() - inicio) + " milisegundos");
        System.out.println("Operações: " + cont);
    }
}