package Proxy;

import java.awt.*;

public class PictureProxy implements Graphic{
    public static String fileName;
    public static Dimension extent;
    public static Point position;
    public static Picture picture;
    public Picture getPicture(){
        return picture;
    }
    @Override
    public void draw(Point position) {

    }

    @Override
    public Dimension getExtent() {
        return null;
    }

    @Override
    public Point getPosition() {
        return null;
    }

    @Override
    public void handleMouse(Event mouseEvent) {

    }

    @Override
    public void store() {

    }

    @Override
    public void load() {

    }


}
