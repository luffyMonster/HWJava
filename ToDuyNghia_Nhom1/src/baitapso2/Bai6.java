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
public class Bai6 {
    public static void main(String[] args) {
        int a[] = Main.makeRandomArray();
        System.out.print("Mang truoc: ");
        Main.displayArray(a);
        System.out.print("\nMang sau: ");
        for (int i = 0; i < a.length; i++) {
            boolean check = true;
            for (int j = 0; j < i; j++) {
                if ( a[i] == a[j]) {
                    check = false;
                    break;
                }
            }
            if (check) System.out.print(" " + a[i]);
        }
    }
}
