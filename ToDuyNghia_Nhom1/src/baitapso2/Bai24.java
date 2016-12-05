/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso2;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author LuffyMonster
 */
public class Bai24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        System.out.println("Nhap 1 xau: ");
        s = in.nextLine();
        System.out.println("Truoc: " + s);
        System.out.print("Chuan hoa: ");
      
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()){
            String str = st.nextToken();
            StringBuilder sb = new StringBuilder(str.toLowerCase());
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            str = sb.toString();
            System.out.print(str + " ");
        }
    }
}
