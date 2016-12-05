/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso1;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author LuffyMonster
 */
public class Bai2 {
    static void doIt(){
        int w, h;
        Random rd = new Random();
//        Scanner in = new Scanner(System.in);
//        w = in.nextInt();
//        h = in.nextInt();
        w = 1 + rd.nextInt(10);
        h = 1 + rd.nextInt(10);
        System.out.printf("Rong: %d \t Cao: %d\n", w, h);
        if (w <= 0 || h <= 0) {
            System.out.println("\tLoi du lieu vao! ");
        }
        
        for (int i = 0; i < h ; i++) {
            System.out.print("* ");
            for (int j = 0; j < w - 2; j++) {
                if ( i == 0 || i == h - 1 ) {
                    System.out.print("* ");
                }
                else System.out.print("  ");
            }
            if ( w > 1) {
                System.out.print("* ");
            }
            System.out.println("");
        }
        
    }
    public static void main(String[] args) {
        System.out.println("Ket qua: ");
        doIt();       
    }
    
    
} 
