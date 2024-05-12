package Strategy;

public class Main {
    public static void main(String[] args){
        double[] numbers = {5.4, 2.1, 7.8, 1.3, 9.6};
        NumList numList = new NumList(numbers);
        numList.setBubbleSort();
        numList.sort();
        double[] sortedNumbers = numList.getNumList();
        for(double number: sortedNumbers){
            System.out.println(number);
        }
    }
}
