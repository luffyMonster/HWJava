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
public class Bai13{
    
    static void doIt(){
        Scanner in = new Scanner(System.in);
        Random rd = new Random();
        int n;
        
        System.out.println("Nhap 1 so : ");
        n = in.nextInt();
       // n = rd.nextInt(10000);
        
        int div = 2;
        System.out.println("Phan tich " + n + " thanh nguyen to: ");
        while (n > 1){
            if ( n%div == 0) {
                System.out.print(" " + div);
                n /= div;
            }
            else div++;
        }
    }
    public static void main(String[] args) {
            System.out.printf("Ket qua: \n");
            doIt();       
    }
}
