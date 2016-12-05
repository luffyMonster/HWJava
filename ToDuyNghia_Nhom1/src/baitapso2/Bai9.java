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
public class Bai9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = Main.scanArray();
        double x ;
        System.out.println("Nhap X: ");
        x = in.nextDouble();
        Main.sort(a);
        System.out.print("\nTruoc: ");
        Main.displayArray(a);
        System.out.print("\nSau chèn x: ");
        int index = 0;
        while(index < a.length && a[index] <= x ){
            System.out.print(a[index++] + " ");
        }
        System.out.print(x + " ");
        for (int i = index; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
