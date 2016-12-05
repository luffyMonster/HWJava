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
public class Bai8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a, b, c;
        int p;
        System.out.print("\nNhap mang A : ");
        a = Main.scanArray();
        System.out.print("\nNhap mang B : ");
        b = Main.scanArray();
        System.out.print("\nNhap so p < " + a.length + ": ");
        while (true){
            p = in.nextInt();
            if ( p < 0 || p > a.length) {
                System.out.print("\nNhap lai p: ");
            }
            else break;
        } 
        System.out.print("\nMang A: ");
        Main.displayArray(a);
        System.out.print("\nMang B: ");
        Main.displayArray(b);
        System.out.println("\nMang A sau khi chen B vào vị trí " + p);
        c = Main.insertArray(a, b, p);
        Main.displayArray(c);
    }
}
