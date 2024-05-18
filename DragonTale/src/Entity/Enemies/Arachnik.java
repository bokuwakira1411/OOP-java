//package Entity.Enemies;
//
//import Entity.Animation;
//import Entity.Enemy;
//import TileMap.TileMap;
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//
//public class Arachnik extends Enemy{
//    private BufferedImage sprite;
//    private boolean facingTop, facingBottom;
//    public Arachnik(TileMap tm){
//        super(tm);
//        moveSpeed = 0.3;
//        maxSpeed = 0.3;
//        fallSpeed = 0.2;
//        maxFallSpeed = 10.0;
//        width = 30;
//        height = 30;
//        cwidth = 20;
//        cheight = 20;
//        health = maxHealth = 2;
//        damage = 1;
//        // load sprites
//        try{
//            sprite = ImageIO.read(
//                    getClass().getResourceAsStream("/image/Sprites/Enemies/arachnik.gif")
//            );
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//        animation = new Animation();
//        animation.setFrames(sprite);
//        animation.setDelay(300);
//        up = true;
//        facingTop = up;
//    }
//
//    private void getNextPosition(){
//        //movement
//        if(up){
//            dy -= moveSpeed;
//            if(dy < -maxSpeed){
//                dy = -maxSpeed;
//            }
//        }
//        else if(down){
//            dy += moveSpeed;
//            if(dy > maxSpeed){
//                dy = maxSpeed;
//            }
//        }
//        if(falling){
//            dy += fallSpeed;
//            if(dy > 0) jumping = false;
//        }
//    }
//    public void update(){
//        //update position
//        getNextPosition();
//        checkTileMapCollision();
//        setPosition(xtemp, ytemp);
//        // check flinching
//        if(flinching){
//            long elapsed = (System.nanoTime() - flinchTime) /1000000;
//            if(elapsed > 400){
//                flinching = false;
//            }
//        }
//        if(up && dy == 0){
//            up = false;
//            down = true;
//            facingTop = false;
//        }
//        else if(down && dy == 0){
//            up = true;
//            down = false;
//            facingBottom = false;
//        }
//        animation.update();
//
//    }    public void draw(Graphics2D g){
////        if(notOnScreen()) return;
//        setMapPosition();
//        super.draw(g);
//    }
//}
//
