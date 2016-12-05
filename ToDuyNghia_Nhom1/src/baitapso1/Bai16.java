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
public class Bai16 {
    
    
    static void doIt(){
        Scanner in = new Scanner(System.in);
        Random rd = new Random();
        int n;
        
        System.out.println("Nhap 1 so : ");
        while (true){
            n = in.nextInt();
            //n = rd.nextInt(10000);
            if (n < 2 || n > 90 ) {
                System.out.println("Nhap lai: ");
            }
            else break;
        }
        
        long  f0 = 0, f1 = 1;
        System.out.printf(n + " so FIBONACI dau tien :\nF[0] = %20d\tF[1] = %20d\t",0, 1 );
        for (int i = 3; i <= n; i++) {
            long f = f0 + f1;
            f0 = f1;
            f1 = f;
            System.out.printf("F[%d] = %20d\t", i-1, f1);
            if (i%5 == 0) {
                System.out.println("");
            }
        }
    }
    public static void main(String[] args) {
            System.out.printf("Ket qua: \n");
            doIt();       
    }
}
