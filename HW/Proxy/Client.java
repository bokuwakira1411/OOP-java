package Proxy;

public class Client {
    public static void main(String[] args){
        Graphic graphic = new PictureProxy();
        ((PictureProxy) graphic).getPicture();

    }
}
