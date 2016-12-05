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
public class Bai17 {
    public static void inXoanOc(){
        int n, m, a[][];
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap m, n: ");
        m = in.nextInt();
        n = in.nextInt();
        System.out.println("Ma tran xuan oc cap mxn: ");
        a = new int[m][n];
        
        int tren = 0, duoi = m-1, trai = 0, phai = n-1, dd = 1;
        while (dd <= m*n){
            for (int i = trai; i <= phai; i++) {
                if(a[tren][i] == 0) a[tren][i] = dd++;
            }
            for (int i = tren+1; i <= duoi; i++) {
                if (a[i][phai] == 0) a[i][phai] = dd++;
            }
            for (int i = phai-1; i >= trai ; i--) {
                if (a[duoi][i] == 0)a[duoi][i] = dd++;
            }
            for (int i = duoi-1; i > tren; i--) {
                if (a[i][trai] == 0) a[i][trai] = dd++;
            }
            tren++; duoi--; phai--; trai++;
            
        }
        Main.showMatrix(a);
    }
    public static void main(String[] args) {
        inXoanOc();
    }
}
