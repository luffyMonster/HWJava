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
public class Bai21 {
    static boolean thuanNghich(int n){
        String s = n+"";
        int j = s.length()-1, i = 0;
        while (i<j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int d = 0;
        for (int i = 100000; i <= 999999; i++) {
            if (thuanNghich(i)) {
                if (d++ % 10 == 0 ) {
                    System.out.println("");
                }
                System.out.printf("%8d", i);
            }
        }
    }
}
