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
public class Bai7 {
    
    public static void main(String[] args) {
        int a[] = Main.makeRandomArray(), n = a.length;
        System.out.print("\nMang truoc: ");
        Main.displayArray(a);
        System.out.print("\nSap xep: ");
        Main.sort(a);
        Main.displayArray(a);
        System.out.print("\nLoai bo trung: ");
        a = Main.deleteSimilar(a);
        Main.displayArray(a);
        System.out.println("\n" + (n - a.length) + " phần tử giống nhau bị xóa.");
        
    }
}
