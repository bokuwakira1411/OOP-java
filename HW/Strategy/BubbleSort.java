package Strategy;
public class BubbleSort implements SortAlgorithm{
    public void sort(double[] a){
        int size = a.length;
        for(int i = 0; i < size - 1; i++){
            for(int j = i + 1; j < size; j++){
                if(a[i] > a[j]){
                    double tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }
    }


}

