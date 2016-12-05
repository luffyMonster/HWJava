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
public class Bai12 {
    
    static int sumOfDigits(int n){
        int s = n%10;
        while ( n > 0 ){
            s += (n/=10)%10;
        }
        return s;
    }
    static void doIt(){
        Scanner in = new Scanner(System.in);
        Random rd = new Random();
        int n, s;
        
        System.out.println("Nhap 1 so : ");
       // n = in.nextInt();
        n = rd.nextInt(100000000);
        
        System.out.println("Tong chu so cua  " + n + " : " + sumOfDigits(n));
        
        
    }
    public static void main(String[] args) {
            System.out.printf("Ket qua: \n");
            doIt();       
    }
}
