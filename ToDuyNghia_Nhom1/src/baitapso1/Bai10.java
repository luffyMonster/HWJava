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
public class Bai10 {
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
        
        System.out.println("Nhap 2 so a, b: ");
//        a = in.nextInt();
//        b = in.nextInt();
        a = rd.nextInt(10000);
        b = rd.nextInt(10000);
        
        uc = UCLN(a, b);
        System.out.printf("UCLN(%1$d, %2$d) = %3$d\t BCNN(%1$d, %2$d) = %4$d ", a, b, uc, a*b/uc);
    }
    public static void main(String[] args) {
            System.out.printf("Ket qua: \n");
            doIt();       
    }
}
