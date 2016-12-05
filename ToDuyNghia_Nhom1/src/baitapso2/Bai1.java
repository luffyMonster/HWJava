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
public class Bai1 {
    
    public static void main(String[] args) {
        int a[] = Main.scanArray();
        
        System.out.println("Mang vua nhap: ");
        Main.displayArray(a);
        if (Main.laMangDoiXung(a)) {
            System.out.println("La mang doi xung. ");
        } else {
            System.out.println("Khong phai mang doi xung. ");
        }
    }
}
