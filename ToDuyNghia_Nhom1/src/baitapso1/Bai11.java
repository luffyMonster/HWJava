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
public class Bai11 {
    
     static int UCLN(int a, int b){
        while (b != 0 ){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    static void doIt(){
        Scanner in = new Scanner(System.in);
        Random rd = new Random();
        int a, b, uc;
        
        System.out.println("Nhap 2 so a, b > 0: ");
//        a = in.nextInt();
//        b = in.nextInt();
        a = rd.nextInt(100);
        b = a + rd.nextInt(100);
        
        System.out.printf("Cap so nguyen to cung nhau thuoc [%d, %d]: \n", a, b);
        
        int dem = 0;
        for (int i = a; i <= b; i++) {
            for (int j = i + 1; j <= b ; j++) {
                if (UCLN(i,j) == 1 ){
                    dem++;
                    System.out.printf("(%d, %d)\t", i ,j);
                    if ( dem % 8 == 0) {
                        System.out.println("");
                    }
                }
            }
        }
        System.out.println("\nCo " + dem + " cap.");
    }
   
    public static void main(String[] args) {
            System.out.printf("Ket qua: \n");
            doIt();       
    }
}
