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
public class Bai18 {
    public static void main(String[] args) {
        int m, n;
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap 2 so nguyen m < n (>=0): ");
        m = in.nextInt();
        n = in.nextInt();
        
        int dem = 0;
        System.out.println("Cac so chinh phuong trong[" + m + "," + n + "] : ");
        for (int i = (int)Math.ceil(Math.sqrt(m)); i <= (int)Math.sqrt(n); i++) {
            dem++;
            System.out.print(i*i + "\t");
            if (dem%10 == 0) {
                System.out.println("");
            }
        }
        
    }
}
