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
public class Bai25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s, res = "";
        System.out.print("Nhap 1 xau: ");
        s = in.nextLine();
        System.out.println("Xau: " + s);
      
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()){
            String str = st.nextToken(" ");
            if (str.length() > res.length() ) {
                res = str;
            }
        }
        System.out.println("Tu dai nhat: " + res);
        System.out.println("Vi tri: " + s.indexOf(res));
    }
}
