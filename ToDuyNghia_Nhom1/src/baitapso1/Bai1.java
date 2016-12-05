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
public class Bai1 {
    static void doIt(){
        int w, h;
        Random rd = new Random();
        
//        Scanner in = new Scanner(System.in);
//        width = in.nextInt();
//        high = in.nextInt();
        
        w = 1 + rd.nextInt(10);
        h =  1 + rd.nextInt(10);
        
        System.out.printf("Rong: %d \t Cao: %d\n ", w, h);
        
        if (w <= 0 || h <= 0) {
            System.out.println("\tLoi du lieu vao! ");
        }
        System.out.println("");
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("Ket qua: ");
        doIt();       
    }
    
    
} 
