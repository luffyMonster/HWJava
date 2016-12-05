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
public class Bai12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] a, b, c;
        int m, n, k;
        
        System.out.println("Nhap m, n, k: ");
        m = in.nextInt();
        n = in.nextInt();
        k = in.nextInt();
        System.out.println("Ma tran A: ");
        a = Main.scanMatrix(m, n);
        System.out.println("Ma tran B: ");
        b = Main.scanMatrix(n, k);
        
        c = new int[m][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                c[i][j] = 0;
                for (int l = 0; l < n; l++) {
                    c[i][j] += a[i][l] * b[l][j];
                }
            }
        }
        
        System.out.println("Ma tran A: ");
        Main.showMatrix(a);
        System.out.println("Ma tran B: ");
        Main.showMatrix(b);
        System.out.println("Tich AxB: ");
        Main.showMatrix(c);
    }
}
