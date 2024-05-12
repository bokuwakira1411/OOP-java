package Strategy;

public class NumList{
    private SortAlgorithm sortAlgorithm;
    private double[] listOfNum;
    public NumList(double[] numbers){
        this.listOfNum = numbers;
    }
    public void add(double number){
        listOfNum[listOfNum.length + 1] = number;
    }
    public double[] getNumList(){
        return listOfNum;
    }
    public void setSortAlgorithm(SortAlgorithm sortAIgorithm){
        this.sortAlgorithm = sortAIgorithm;
    }
    public void setBubbleSort(){
        setSortAlgorithm(new BubbleSort());
    }
    public void setQuickSort(){
        setSortAlgorithm(new QuickSort());
    }
    public void setOrder(){

    }
    public void sort(){
        sortAlgorithm.sort(listOfNum);
    }

}
