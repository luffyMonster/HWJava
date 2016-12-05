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
public class Bai20 {
    public static void main(String[] args) {
        double c, x;
        Scanner in = new Scanner(System.in);
        System.out.println("nhap 2 so Double: c, x ");
        c = in.nextDouble();
        x = in.nextDouble();
        
        int tu = 1, mau = 1, n = 0;
        double exp_x= 0;
        while (true ){
            exp_x += tu*1.0/mau;
            if (Math.abs((double)tu/mau) <= c ) {
                break;
            }
            n++;
            tu *=  x;
            mau *= n;
        }
        
        System.out.println("Voi c = " + c + " , x = " + x + " , e^" + x +" = " + exp_x);  
    }
}
