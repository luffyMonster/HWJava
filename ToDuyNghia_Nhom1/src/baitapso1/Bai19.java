/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso1;

import java.util.Scanner;

/**
 *
 * @author LuffyMonster
 */
public class Bai19 {
    public static void main(String[] args) {
        double c;
        Scanner in = new Scanner(System.in);
        System.out.println("nhap 1 so Double: ");
        c = in.nextDouble();
        
        int n = 0, dau = 1;
        double pi= 0;
        while (true ){
            pi += dau*1.0/(2*n+1);
            n++;
            dau *= -1;
            if (c >= 1.0/(2*n+1)) {
                break;
            }
        }
        
        System.out.println("Voi c = " + c + " , PI = " + 4*pi);  
    }
}
