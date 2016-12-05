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
public class Bai11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] m, mm;
        int row, collum;
        System.out.println("Nhap so hang: ");
        row = in.nextInt();
        System.out.println("Nhap so cot: ");
        collum = in.nextInt();
        m = Main.scanMatrix(row, collum);
        mm = new int[collum][row];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                mm[j][i] = m[i][j];
            }
        }
        System.out.println("Ma tran: ");
        Main.showMatrix(m);
        System.out.println("Ma tran chuyen vi: ");
        Main.showMatrix(mm);
        
    }
}
