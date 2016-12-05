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
public class Bai24 {
    public static void main(String[] args) {
        int dem = 0;
        for (int i = 1000000; i <= 9999999; i++) {
            if ( Main.allDigitIsPrime(i) && Main.laNguyento(Main.soDao(i)) && Main.laNguyento(i) ) {
                System.out.printf("%8d", i);
                dem++;
                if (dem%10 == 0) {
                    System.out.println("");
                }
            }
        }
    }
}
