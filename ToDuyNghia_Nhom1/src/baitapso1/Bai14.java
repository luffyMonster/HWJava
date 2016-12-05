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
public class Bai14 {
    
    static boolean laNgto(int n){
        if ( n < 2) {
            return false;
        }
        if ( n < 4) {
            return true;
        }
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
    static void doIt(){
         Scanner in = new Scanner(System.in);
        Random rd = new Random();
        int n;
        
        System.out.println("Nhap 1 so : ");
        n = in.nextInt();
       // n = rd.nextInt(10000);
        
        int dem = 0;
        System.out.println("Cac so nguyen to < " + n);
        for (int i = 2; i < n; i++) {
            if (laNgto(i)) {
                dem++;
                System.out.print("\t" + i);
                if (dem%8 == 0) {
                    System.out.println("");
                }
            }
        }
        System.out.println("\nCo " + dem + " so.");
    }
    public static void main(String[] args) {
            System.out.printf("Ket qua: \n");
            doIt();       
    }
}
