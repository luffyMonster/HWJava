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
public class Bai27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s, res = "";
        System.out.print("Nhap 1 name: ");
        s = in.nextLine();
        
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()){
            String str = st.nextToken();
            if (!st.hasMoreTokens()) {
                res = str + res;
            }
            else res += ( " " + str);
        }
        
        System.out.println("Ket qua: " + res);
    }
}
