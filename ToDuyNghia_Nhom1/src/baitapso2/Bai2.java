/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso2;

import java.util.Arrays;

/**
 *
 * @author LuffyMonster
 */
public class Bai2 {
    public static void main(String[] args) {
        int a[] = Main.scanArray();
        System.out.println("\nTruoc sap xep: ");
        Main.displayArray(a);
        Main.sort(a);
        System.out.println("\nSau sap xep: ");
        Main.displayArray(a);
    }
}
