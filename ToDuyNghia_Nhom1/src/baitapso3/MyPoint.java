/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso3;

/**
 *
 * @author LuffyMonster
 */
public class MyPoint {
    private int x;
    private int y;

    public MyPoint() {
        this.x = 1;
        this.y = 1;
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public MyPoint(MyPoint p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public double distance(MyPoint p){
        return Math.hypot( p.getX() - this.getX(), p.getY() - this.getY() );
    }
    
    public static double distance(MyPoint p1, MyPoint p2){
        return Math.hypot( p1.getX() - p2.getX(), p1.getY() - p2.getY() );
    }
}
