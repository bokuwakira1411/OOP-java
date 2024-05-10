package Singleton;

public class Main {
    public static void main(String[] args){
        char[][] grid = new char[10][10];
        TextGraphics graphics = TextGraphics.getInstance();
        graphics.init(15, 10);
        graphics.drawPoint('*', 1, 1);
        graphics.fillRect('o', 2, 2, 5, 2);
        graphics.render();
    }
    
}
