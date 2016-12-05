/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso4;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author luffy monster
 */
public class Bai17 {
    Timer timer;
    Bai17(long dt){
        timer  = new Timer();
        timer.schedule(new Demo(), dt);
    }
    class Demo extends TimerTask{
        @Override
        public void run() {
            System.out.println("1 Timer dang chay trong luong " + Thread.currentThread().getName());
            System.out.println("Ket thuc Timer va cancel (huy bo luong.");
            timer.cancel();
        }
        
    }
    public static void main(String[] args) {
        
        /*
        * Timer de len lich thuc thi 1 cong viec nao do
        * Thuc hien trong 1 luong
        */
        System.out.println("Day la luong " + Thread.currentThread().getName());
        System.out.println("Doi 5s thi thuc hien cong viec trong Demo");
        new Bai17(5000);
        System.out.println("Doi...");
        
        
    }
}
