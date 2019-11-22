import java.util.ArrayList;

public class Main{
    public static int contEdicao = 0;
    public static int mochila = 165;
    public static int cont = 0;
    public static int contDinamico = 0;
    public static void main(String args[]){
        Pecas p1 = new Pecas(2, 5, 0);
        Pecas p2 = new Pecas(4, 2, 0);
        Pecas p3 = new Pecas(2, 2, 0);
        Pecas p4 = new Pecas(3, 1, 0);
        Pecas p5 = new Pecas(1, 1, 0);

         Pecas[] lista = new Pecas[4];
         lista[0] = p1;
         lista[1] = p2;
         lista[2] = p3;
         lista[3] = p4;
         
        //Mochila Forca Bruta
         System.out.println("Melhor valor (algoritmo força bruta): " + calculaMelhor(lista));
         System.out.println("Iteracoes do algoritmo de força bruta: " + cont);
         System.out.println("\n");

         Pecas[] listaDin = new Pecas[5];
         listaDin[0] = null;
         listaDin[1] = p1;
         listaDin[2] = p2;
         listaDin[3] = p3;
         listaDin[4] = p4;

        int tamanho = listaDin.length;

        //Mochila Knapsack
         System.out.println("Melhor valor (Knapsack): " + knapsack(tamanho, listaDin));
         System.out.println("Iterações do algoritmo dinamico: " + contDinamico);
         System.out.println("\n");



         String palavra1 = "teste";
         String palavra2 = "testeRESTO";
         
         //Distancia Edicao Recursivo
          System.out.println("Distancia Edicao Recursivo: " + distEd(palavra1, palavra2, palavra1.length(), palavra2.length()));
          System.out.println("iterações do Método: " + contEdicao);
          System.out.println("\n");

          //Distancia Edicao Dinamica
          System.out.println("Distancia de Edicao Dinamica: " + distEdDin(palavra1, palavra2));
          System.out.println("iterações do Método: " + contEdicaoDin);
 
     }
 

 
    //EX 1 - Forca bruta
    public static double calculaMelhor(Pecas[] lista){
        for (int i=0; i<lista.length; i++) {
            double peso = lista[i].getPeso();
            double valor = lista[i].getValor();
            lista[i].setValor_kilo(valor/peso); 
            cont++;
        }
        double pesoPecas = 0;
        double melhor = 0;
        
        sort(lista);


        for(int i=0;i<lista.length; i++){
            double pesoPecasFuturo = pesoPecas + lista[i].getPeso();
            if(pesoPecasFuturo < mochila){
                pesoPecas = pesoPecas + lista[i].getPeso();
                melhor = melhor + lista[i].getValor();
            }
            cont++;
        }
        return melhor;
    }

    public static void sort(Pecas[] lista) {
        for(int i=0;i<lista.length; i++){
            for(int j=0;j<lista.length; j++){
                if(lista[i].getValor_kilo() > lista[j].getValor_kilo()){
                    Pecas aux = new Pecas(lista[j].getValor(), lista[j].getPeso(), lista[j].getValor_kilo());
                    lista[j] = lista[i];
                    lista[i] = aux;
                }
                cont++;
            }
        }  

    }

    //EX 2 - knapsack
    public static double knapsack(int n, Pecas[] itens){
        double[][] maxTab = new double[n+1][mochila+1];

        for(int i=0; i<n+1;i++){
            contDinamico++;
            maxTab[i][0] = 0;
        }
        for(int j=0; j<mochila+1;j++){
            contDinamico++;
            maxTab[0][j] = 0;
        }

        for(int i=1; i<n;i++){
            for(int j=1; j<mochila;j++){
                if(itens[i].getPeso()<=j){
                    maxTab[i][j] = Math.max(maxTab[i-1][j], itens[i].getValor() + maxTab[i-1][j-(int)itens[i].getPeso()]);
                }else{
                    maxTab[i][j] = maxTab[i-1][j];
                }
                contDinamico++;
            }
        }

        return maxTab[n-1][mochila-1];

    }

    //EX 3 - Distancia de Edicao Recursivo
    public static int distEd(String s, String t, int i, int j){
        int sub, ins, rem;
        if(i == 0){
            contEdicao++;
            return j;
        }
        if(j== 0){
            contEdicao++;
            return i;
        }
        if(s.charAt(i-1) == t.charAt(j-1)) return distEd(s, t, i-1, j-1) + 0;
        contEdicao++;
        sub = distEd(s, t, i-1, j-1) + 1;
        ins = distEd(s, t, i, j-1) + 1;
        rem = distEd(s, t, i-1, j) + 1;

        return Math.min(sub, Math.min(ins, rem));
    }

    //EX 4 - Distancia de Edicao Dinamica
    public static int contEdicaoDin = 0;
    public static int distEdDin(String s, String t){
        int custoExtra = 0;
        int m = s.length();
        int n = t.length();

        int[][] matriz = new int[m][n];
        matriz[0][0] = 0;

        for(int i=1; i<m; i++){
            matriz[i][0] = matriz[i-1][0] + 1;
            contEdicaoDin++;
        }
        for(int j=1; j<n; j++){
            matriz[0][j] = matriz[0][j-1] + 1;
            contEdicaoDin++;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                contEdicaoDin++;
                if(i == m-1 && j == n-1){
                    if(s.charAt(i) == t.charAt(j)){
                        custoExtra = 0;
                    }else{
                        custoExtra = 1;
                    }
                    matriz[i][j] = Math.min(matriz[i-1][j] +1, Math.min(matriz[i][j-1] +1, matriz[i-1][j-1] + custoExtra));
                }else{
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        custoExtra = 0;
                    }else{
                        custoExtra = 1;
                    }
                    matriz[i][j] = Math.min(matriz[i-1][j] +1, Math.min(matriz[i][j-1] +1, matriz[i-1][j-1] + custoExtra));
                }
            }
        }
        return matriz[m-1][n-1];
    }



}