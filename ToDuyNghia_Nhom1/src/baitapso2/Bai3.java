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
public class Bai3 {
    public static void main(String[] args) {
        int a[] = Main.scanArray(), b[] = Main.count(a);
        
        System.out.println("Mang vua nhap: ");
        Main.displayArray(a);
        
        System.out.println("\nSo lan xuat hien: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(" a["+i+"] : " + b[i]);
        }
        
        System.out.println("Phan tu xuat hien nhieu nhat: " + a[Main.indexMax(b)]);
    }
}
