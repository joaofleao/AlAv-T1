import java.util.ArrayList;

public class Main {
    public static void main (String args[]) {
        System.out.println("Gulosos");
        int[] s = {2, 4, 1, 6, 4, 6,  7,  9, 9,  3,  13};
        int[] f = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        int n  = s.length;
        //System.out.println(guloso(s, f, n));
        System.out.println(guloso(s, f, n));
        System.out.println("Done");
    }
    public static ArrayList<Integer> guloso(int[] s, int[] f, int n){
        f[0] = Integer.MIN_VALUE;
        ArrayList<Integer> x = new ArrayList<Integer>();
        int i = 0;
        for(int k = 1; k<n; k++) {
            if (s[k]>f[i]) {
                x.add(k);
                i = k;
            }
        }
        return x;
    }
}
