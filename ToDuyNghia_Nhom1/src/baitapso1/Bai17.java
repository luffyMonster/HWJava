/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso1;

/**
 *
 * @author LuffyMonster
 */
public class Bai17 {
    
    public static void main(String[] args) {
        int dem = 0;
        for (int i = 100000; i <= 999999; i++) {
            if (Main.laThuanNghich(i)) {
                System.out.printf("%8d", i);
                dem++;
                if (dem%10 == 0) {
                    System.out.println("");
                }
            }
        }
    }
}
