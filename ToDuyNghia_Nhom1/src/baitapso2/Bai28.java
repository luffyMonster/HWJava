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
public class Bai28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s, res[] = new String[20];
        int n = 0;
        System.out.print("Nhap 1 cau <= 20 tu: ");
        s = in.nextLine();
        
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()){
            res[n++] = st.nextToken();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (res[i].compareToIgnoreCase(res[j]) > 0 ) {
                    String t = res[i];
                    res[i] = res[j];
                    res[j] = t;
                }
            }
        }
        System.out.print("Ket qua sau sap xep Anphabet:  ");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + res[i]);
        }
    }
}
