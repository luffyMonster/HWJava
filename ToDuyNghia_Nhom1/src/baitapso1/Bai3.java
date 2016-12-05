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
public class Bai3 {
        static void doIt(){
            int  high;
            Random rd = new Random();
//            Scanner in = new Scanner(System.in);S
//            high = in.nextInt();
            high = 1 + rd.nextInt(10);
            System.out.printf("Cao: %d\n", high);
            for (int i = 0; i < high; i++) {
                for (int j = 0; j < high - i - 1; j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j < 2*i + 1; j++) {
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
