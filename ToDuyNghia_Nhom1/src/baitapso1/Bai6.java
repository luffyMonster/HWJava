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
public class Bai6 {
        static void doIt(){
            Scanner in = new Scanner(System.in);
            Random rd = new Random();
            int numIn, numRandom, id = 1;
            
            System.out.println("Nhap vao 1 so [10,99] ");
            while (true){
                numIn = in.nextInt();
                if (numIn < 10 || numIn > 99) {
                    System.out.println("Nhap lai: ");
                }
                else break;
            }
           
            while (true){
                numRandom = 10 + rd.nextInt(90);
                System.out.println("Buoc " + id++ + ": " + numRandom);
                if ( numRandom == numIn) {
                    System.out.println("Done!");
                    break;
                }
            }
            
        }
        public static void main(String[] args) {
            System.out.printf("Ket qua: \n");
            doIt();       
        }
}
