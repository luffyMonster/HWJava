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
public class Bai9{
    
    static void doIt(){
        int dem = 0, n;
        Scanner in = new Scanner(System.in);
        Random rd = new Random();
        
//        System.out.println("Nhap vao 1 so > 0 ");
//        while (true){
//            n = in.nextInt();
//            if (n <= 0) {
//                System.out.println("Nhap lai: ");
//            }
//            else break;
//        }
        n = 1+ rd.nextInt(100000);
        
        System.out.println("Cac uoc cua " + n + ":");
        for (int i = 1; i <= n; i++) {
            if ( n%i == 0) {
                dem++;
                System.out.printf("%8d", i);
                if (dem%8 == 0) {
                    System.out.println("");
                }
            }
        }
        System.out.println("\n"+ n + " co " + dem + " uoc.");
    }
    public static void main(String[] args) {
            System.out.printf("Ket qua: \n");
            doIt();       
    }
}
