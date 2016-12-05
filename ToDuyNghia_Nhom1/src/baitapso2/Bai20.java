/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso2;

import java.util.Scanner;

/**
 *
 * @author LuffyMonster
 */
public class Bai20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, b;
        
        System.out.print("Nhap n: ");
        n = in.nextInt();
        System.out.print("Nhap b [1, 36]: ");
        while(true){
            b = in.nextInt();
            if (b < 1 || b > 36) {
                System.out.print("Nhap lai b: ");
            } else break;
        }
        
        System.out.println("So " + n + " o he co so " + b + " la : " + Integer.toString(n, b) );
        
    }
}
