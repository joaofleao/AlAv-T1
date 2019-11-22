import java.util.Arrays;

class App{

    public void mergeSort(int[] array){
        int mid = (array.length - 1) / 2;
        sort(0, mid, array);
        sort(mid+1, array.length-1, array);
        System.out.println(Arrays.toString(array));
        merge(mid,array);
        System.out.println(Arrays.toString(array));
    }

    private void sort(int inicio, int fim, int[] array){
        if(fim - inicio == 0) return;
        //Nesse caso, possui dois elementos. Ordene-os, porra!
        if(fim - inicio == 1){
            if(array[inicio] > array[fim]){
                int aux = array[inicio];
                array[inicio] = array[fim];
                array[fim] = aux;
                return;
            }
            else{
                return;
            }
        }
        int mid = (fim - inicio) / 2;
        sort(mid+1, fim, array);
        sort(inicio, mid, array);
    }

    private void merge(int mid, int[] array){
        int j = mid + 1;
        for(int i = 0; i <= mid; i++){
            System.out.println(j);
            if(array[i] > array[j]){
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }
    }

    public static void main(String[] args) {

        App a = new App();
        int[] vet = {2,0,4,1,6,2};
        a.mergeSort(vet);
    }
}
