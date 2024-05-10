package Singleton;
public class Bugs{
    private static int w, h;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        char c = sc.next().charAt(0);
        TextGraphics g = TextGraphics.getInstance();
        Random random = new Random();
        for(int i = 0; i < n; i++){
            int x = random.nextInt(w);
            int y = ramdom.nextInt(h);
            g.drawPoint(c, x, y);
            update(x, y);
        }
        g.render();
    }
    public void update(int x, int y){
        if(x >= 0 && x < w){
            x += 1;
        }
        if(x = w && y <= h){
            y += 1;
            x -= 1;
        }
    }
}