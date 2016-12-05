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
public class Bai4 {
        static void doIt(){
            int  high;
            Random rd = new Random();
//            Scanner in = new Scanner(System.in);S
//            high = in.nextInt();
            high = 1 + rd.nextInt(10);
            System.out.printf("Cao: %d\n", high);
            
            
            for (int i = 1; i <= high; i++) {
                for (int j = 1; j <= high - i ; j++) {
                    System.out.print("  ");
                }
                
                for (int j = 1; j <= i; j++) {
                    System.out.print(" " + j);
                }
                for (int j = i-1; j > 0; j--) {
                    System.out.print(" " + j);
                }
//                
//                for (int j = 0; j < 2*i + 1; j++) {
//                    System.out.print(" " + ( (j > i) ? i + 1 - (j+1)%(i+1) : (j+1) ) );
//                }
          
                System.out.println("");
            }
        }
        public static void main(String[] args) {
            System.out.println("Ket qua: ");
            doIt();       
    }
}
