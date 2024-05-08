package HW2;

class Shape {
    private double R, centerx, centery;
    public Shape(double R, double centerx, double centery){
        this.R = R;
        this.centerx = centerx;
        this.centery = centery;
    }
    public static Shape calculateCenter(String str){
        String[] parts = str.split(" ");
        double[] numbers = new double[parts.length];
        double R = Double.MAX_VALUE;
        double centerx = 0;
        double centery = 0;
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Double.parseDouble(parts[i]);
            if (i % 2 == 0) {
                centery += numbers[i];
            } else {
                centerx += numbers[i];
            }
        }
        centerx = centerx / parts.length * 2;
        centery = centery / parts.length * 2;

        for (int i = 0; i < parts.length; i++) {
            double tmp = Math.sqrt((numbers[i] - centerx) * (numbers[i] - centerx) + (numbers[i] - centery) * (numbers[i] - centery));
            R = Math.min(R, tmp);
        }
        return new Shape(R, centerx, centery);
    }
    public static boolean cross(Shape a, Shape b) {
        double d = Math.sqrt((a.centerx - b.centerx) * (a.centerx - b.centerx) + (a.centery - b.centery) * (a.centery - b.centery));
        if (d <= a.R - b.R) {
            return false;
        }
        return a.R + b.R > d;
    }

    public static int encircle(Shape a, Shape b) {
        double d = Math.sqrt(Math.pow(a.centerx - b.centerx, 2) + Math.pow(a.centery - b.centery, 2));
        if (d + b.R < a.R) return 2;
        else if (d < (a.R + b.R)) return 1;
        else return 0;
    }
}
public class ShapeClient {
    public static void main(String[] args) {
        Shape a = Shape.calculateCenter("0 0 0 1 1 1 1 0");
        Shape b = Shape.calculateCenter("10 10 10 11 11 11 11 10");
        Shape c = Shape.calculateCenter("0.5 0.5 0.5 -10 1.5 0");
        Shape d = Shape.calculateCenter("0.5 0.5 0.75 0.75 0.75 0.2");
        System.out.println("a crosses b: " + Shape.cross(a, b));
        System.out.println("a crosses c: " + Shape.cross(a, c));
        System.out.println("a crosses d: " + Shape.cross(a, d));
        System.out.println("a encircles b: " + Shape.encircle(a, b));
        System.out.println("a encircles c: " + Shape.encircle(a, c));
        System.out.println("a encircles d: " + Shape.encircle(a, d));
    }
}
