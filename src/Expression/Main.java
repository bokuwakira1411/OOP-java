package Expression;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Numeral one = new Numeral(a);
        Numeral two = new Numeral(b);
        Square one_square = new Square(one);
        Square two_square = new Square(two);
        Expression e1=new Addition(one_square,two_square);
        System.out.print(e1.toString() + " = " + e1.evaluate());
    }
}