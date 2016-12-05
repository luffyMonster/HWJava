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
public class Bai22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s, res="";
        System.out.println("Nhap 1 xau: ");
        s = in.nextLine();
        System.out.println("Truoc: " + s);
        for (int i = 0; i < s.length(); i++) {
            res += (i%2 == 0 )? Character.toUpperCase(s.charAt(i)) : Character.toLowerCase(s.charAt(i));
        }
        System.out.println("Ket qua: " + res);
    }
}
