import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
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

    public static long floor(long number){
        long b = (long)Math.floor(number);
        return b;
    }



    public static int cont =0;
    public static long multiply(long x, long y, long n) {    
        if(n == 1){
            cont++;
            return x * y;
        }else{
            cont++;
            long m = (long)Math.ceil(n/2);

            long a = (long)Math.floor(x/(powerN(2, m)));
            long b = x%(powerN(2, m));
            
            long c = (long)Math.floor(y/(powerN(2, m)));
            long d = y%(powerN(2, m));
            
            long e = multiply(a, c, m);
            long f = multiply(b, d, m);
            long g = multiply(b, c, m);
            long h = multiply(a, d, m);
            return ((powerN(2, 2*m)*e) + (powerN(2, m)*(g + h)) + f);
        }
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        long inicio = System.currentTimeMillis();  
        System.out.println("Insira 2 números para multiplicar (separados por espaço, com mesmo número de bits)");
        
        String a = in.nextLine();
        String b = in.nextLine();
        long c = a.length();

        System.out.println(multiply(Long.parseLong(a), Long.parseLong(b), c));

        System.out.println("Tempo de execucao: " +  (System.currentTimeMillis() - inicio) + " milisegundos");
        System.out.println("Operações: " + cont);

    }
}