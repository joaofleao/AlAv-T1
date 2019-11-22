import java.*;
import java.util.Random;

public class Ex1 {
    public static int operations;
    public static void main (String args[]) {
        operations = 0;
        long start = System.currentTimeMillis(); 
        
        int[] list = random(32);
        //print(list);
        mergeSort(list);
        
        long end = System.currentTimeMillis(); 
        System.out.println("Done: " + (end - start) + "ms, " + operations + " operações"); 

        operations = 0;
        start = System.currentTimeMillis(); 
        
        list = random(2048);
        //print(list);
        mergeSort(list);
        
        end = System.currentTimeMillis(); 
        System.out.println("Done: " + (end - start) + "ms, " + operations + " operações"); 

        operations = 0;
        start = System.currentTimeMillis(); 
        
        list = random(1048576);
        //print(list);
        mergeSort(list);
        
        end = System.currentTimeMillis(); 
        System.out.println("Done: " + (end - start) + "ms, " + operations + " operações"); 
    }
    
    public static int[] merge(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int j = 0;
        int k = 0;
        
        for (int i = 0; i < merged.length; i++) {
            if (j==b.length) {
                merged[i] = a[k];
                k++;
            }
            else if (k==a.length) {
                merged[i] = b[j];
                j++;
            }
            else {
                if (a[k]<b[j]) {
                    merged[i] = a[k];
                    k++;
                }
                else {
                    merged[i] = b[j];
                    j++;
                }
            }
            operations++;
        }
        return merged;
    }
    
    public static int[] start(int[] list) {
        int x = (list.length/2);
        int[] a = new int[x];
        for (int i = 0; i < x; i++) {
            a[i] = list[i];
            operations++;
        }
        return a;
    }
    
    public static int[] end(int[] list) {
        int x = list.length/2;
        int[] a = new int[x];
        for (int i = 0; x < list.length; i++) {
            a[i] = list[x];
            x++;
            operations++;
        }
        return a;
    }
    
    public static int[] mergeSort(int[] list) {
        if(list.length==1) return list;
        int[] a = mergeSort(start(list));
        int[] b = mergeSort(end(list));
        list = merge(a, b);
        
        operations++;
        return list;
    }

    public static void print(int[] x) {
        String txt = "";
        for (int j = 0; j < x.length; j++) {
            txt = txt + x[j] + ", ";
        }
        System.out.println(txt);
    }
    
    public static int[] random(int n) {
        Random ran = new Random();
        int[] i = new int[n];
        for (int j = 0; j < i.length; j++) {
            i[j] = (int) ran.nextInt(100);
        }
        return i;
    }
}