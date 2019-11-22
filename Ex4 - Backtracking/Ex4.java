import java.io.*; 
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI; 
public class Ex4{
    public static boolean[][] tab;
    public static int n;
    public static int q;
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Insira no tamanho do tabuleiro (maior que 2 menor que 10): ");
            n = in.nextInt();
        } while (n<4 || n>10);
        
        rainhas();
        System.out.println("Done");
    }
    
    public static void createTab() {
        tab = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tab[i][j] = false;
            }
        }
    }
    
    public static void printTab(Stack<Integer> pilha) {
        String txt = "";
        String a = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if(i*q+j<10) a = "00" + (i*q+j);
                if(i*q+j<q) a = "0" + (i*q+j);
                else a = (i*q+j) + "";

                if (pilha.contains((q*i)+j))txt = txt + RED + a + RESET + " ";
                else if (tab[i][j]) txt = txt + GREEN + a + RESET + " ";
                else txt = txt +  CYAN + a + CYAN + " ";
            }
            txt = txt + "\n";
        }
        System.out.println(txt);
    }
    
    public static void setOccupation(int x, int y) {
        for(int i = 0; i<=n-1; i++) {
            if(!tab[x][i]) tab[x][i] = true;
            if(!tab[i][y]) tab[i][y] = true;
        }
        int i = x;
        int j = y;
        while(i<=n-1 && j>=0){
            if(!tab[i][j]) tab[i][j] = true;
            i++;
            j--;
        }
        i = x;
        j = y;
        while(i<=n-1 && j<=n-1){
            if(!tab[i][j]) tab[i][j] = true;
            i++;
            j++;
        }
        i = x;
        j = y;
        while(i>=0 && j<=n-1){
            if(!tab[i][j]) tab[i][j] = true;
            i--;
            j++;
        }
        i = x;
        j = y;
        while(i>=0 && j>=0){
            if(!tab[i][j]) tab[i][j] = true;
            i--;
            j--;
        }
    }

    public static int isThereValid(int x, int y) {
        while (x<n) {
            if (!tab[x][y]) {
                return x;
            }
            x++;
        }
        return -1;
    }
    
    public static void rainhas() {
        q = 10;
        createTab();
        Stack<Integer> pilha = new Stack<Integer>();
        int x = 0;
        int y = 0;
        
        while(true) { 
            if (isThereValid(x, y)!=-1) {
                x = isThereValid(x, y);
                pilha.push(x*q+y);
                setOccupation(x, y);
                y++;
                x = 0; 
            }
            else {
                if (pilha.size()==0) break;
                else {

                    int a = pilha.pop();
                    y = a%q;
                    x = a/q+1;
                    createTab();
                    for (int i = 0; i < pilha.size(); i++) {
                        setOccupation(pilha.get(i)/q, pilha.get(i)%q);
                    }
                    
                }
            }
            if (pilha.size()==n) {
                System.out.println(pilha);
                printTab(pilha);
                int a = pilha.pop();
                y = a%q;
                x = a/q+1;
                createTab();
                for (int i = 0; i < pilha.size(); i++) {
                    setOccupation(pilha.get(i)/q, pilha.get(i)%q);
                }   
            }
        }    
    }
}
