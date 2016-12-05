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
public class Bai25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        
        System.out.println("Nhap chieu cao cua tam giac Pascal: ");
        n = in.nextInt();
        
        int c[][] = new int[n+1][];
        for (int i = 0; i <= n; i++) {
            c[i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                if ( j == 0 || j == i) {
                    c[i][j] = 1;
                }
                else c[i][j] = c[i-1][j-1] + c[i-1][j];
            }
        }
        
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%6d", c[i][j]);
            }
            System.out.println("");
        }
        
    }
}
