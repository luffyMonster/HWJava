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
public class Bai5 {
    public static void main(String[] args) {
        int x, a[];
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap so x: ");
        x = in.nextInt();
        a = Main.scanArray();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (baitapso1.Main.laNguyento(a[i]) && Math.abs(a[i] - x) <  Math.abs(res - x ) ) {
                res = a[i];
            }
        }
        if (res == Integer.MAX_VALUE) {
            System.out.println("MAng khong co so nguyen to. ");
            
        } else{
            System.out.println("Phan tu trong mang gan x nhat: " + res);
        }
    }
}
