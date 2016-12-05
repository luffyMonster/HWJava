/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso2;

/**
 *
 * @author LuffyMonster
 */
public class Bai4 {
    public static void main(String[] args) {
        int a[] = Main.scanArray(), b[] = Main.count(a);
        
        System.out.println("Mang vua nhap: ");
        Main.displayArray(a);
        
        for (int i = 0; i < a.length; i++) {
            boolean ok = true;
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    ok = false;
                }
            }
            if (ok) {
                System.out.print("\nSo "+ a[i] + " xuat hien " + b[i] + " lan. " );
            }
        }
    }
}
