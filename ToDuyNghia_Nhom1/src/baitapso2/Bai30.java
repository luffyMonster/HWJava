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
public class Bai30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1, s2;
        int n = 0;
        System.out.print("Nhap xau thu 1: ");
        s1 = in.nextLine();
        
        System.out.print("Nhap xau thu 2: ");
        s2 = in.nextLine();
        
        StringBuilder sb = new StringBuilder(s1);
        while (true ){
            int index = sb.indexOf(s2);
            if (index == -1) {
                s1 = sb.toString();
                break;
            }
            sb.delete(index, index+s2.length());
        }
        System.out.print("Ket qua sau khi loai bo s2 khoi s1: " + s1);
    }
}
