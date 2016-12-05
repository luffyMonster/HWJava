/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author LuffyMonster
 */

public class Bai29 {
    public static ArrayList<String> makeWords(String s){
        ArrayList<String> l = new ArrayList();
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()){
            l.add(st.nextToken());
        }
        return l;
    }
    public static boolean check(String s, ArrayList<String> ss){
        for (String s1 : ss){
            if (s1.equals(s)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1, s2;
        ArrayList<String> l1, l2;
        int n = 0;
        System.out.print("Nhap cau thu 1: ");
        s1 = in.nextLine();
        
        System.out.print("Nhap cau thu 2: ");
        s2 = in.nextLine();
        
        l1 = makeWords(s1);
        l2 = makeWords(s2);
        
        System.out.print("\nHop tap tu: ");
        for (String s : l1) {
            System.out.print(" " + s);
        }
        for (String s: l2){
            if (!check(s, l1)) {
                System.out.print(" " + s);
            }
        }
        
        System.out.print("\nGiao tap tu: ");
        for (String s : l1) {
            if (check(s, l2)) {
                System.out.print(" " + s);
            }
        }
        
        System.out.print("\nHieu tap tu s1/s2: ");
        for (String s : l1) {
            if (!check(s, l2) ){
                System.out.print(" " + s);
            }
        }
        
        
        
    }
}
