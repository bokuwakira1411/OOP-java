package Strategy;
public class QuickSort implements SortAlgorithm {
    public void sort(double[] numList){
        quicksort(numList, 0, numList.length - 1);
    }
    public void quicksort(double[] a, int l, int r){
        double p = a[(l + r)/2];
        int i = l, j = r;
        while(i < j){
            while(a[i] < p){
                i++;
            }
            while(a[j] > p){
                j--;
            }
            if(i <= j){
                double tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
            if(i < r){
                quicksort(a, i, r);
            }
            if(l < j){
                quicksort(a, l, j);
            }
        }
    }


}
