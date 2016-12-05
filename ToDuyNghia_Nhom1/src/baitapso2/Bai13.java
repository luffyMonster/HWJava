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
public class Bai13 {
    public static void main(String[] args) {
        int a[][], m, n;
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap m, n: ");
        m = in.nextInt();
        n = in.nextInt();
        a = Main.scanMatrix(m, n);
        System.out.println("Truoc: ");
        Main.showMatrix(a);
        Main.sort(a);
        System.out.println("Ma tran sap xep: ");
        Main.showMatrix(a);
    }
}
