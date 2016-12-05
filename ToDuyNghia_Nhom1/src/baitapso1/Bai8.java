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
public class Bai8 {
     static void doIt(){
        Scanner in = new Scanner(System.in);
        Random rd = new Random();
        int n;
        double sum;
        
        System.out.println("Nhap vao 1 so > 0 ");
        while (true){
            n = in.nextInt();
            if (n <= 0) {
                System.out.println("Nhap lai: ");
            }
            else break;
        }
        //n = 1+ rd.nextInt(100000);
        
        sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum += 1.0/i;
        }
        
        System.out.println("Tong cua day: " + sum);
    }
    public static void main(String[] args) {
            System.out.printf("Ket qua: \n");
            doIt();       
    }

    
}
