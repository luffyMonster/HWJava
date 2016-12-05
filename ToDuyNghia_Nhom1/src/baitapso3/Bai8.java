/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso3;

import java.util.Scanner;

/**
 *
 * @author LuffyMonster
 */

public class Bai8 {
    
    public static int getUuTien(char c1){
        if (c1 == '+' || c1 == '-') return 0;
        if ( c1 == '/' || c1 == 'x')return 1;
        return -1;
    }
    public static void main(String[] args) {
        final int MAX_SIZE = 1000;
        StackOfChars stack = new StackOfChars(MAX_SIZE);
        String prefix = "";
        String s;
        Scanner in = new Scanner(System.in);
        System.out.println("Toan hang chi chua 1 kitu so.");
        System.out.println("Nhap bieu thuc can chuyen: ");
        s = in.nextLine();
       // s = "2-(4+3)x5";
        System.out.println("Trung to: " + s);
        
        
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           if ( c == '(' ) stack.push(c);
           if ( c >= '0' && c <= '9') prefix += c;
           if ( c == '+' || c == '-' || c == 'x' || c == '/') {
                char c1 = stack.peak();
                if (  getUuTien(c1) >= getUuTien(c) ) {
                    prefix += stack.pop();
                }
                stack.push(c);
           }
           if ( c == ')') {
               while(true){
                 char c1 = stack.pop();
                 if ( c1 == '(') break;
                 prefix += c1;
                 
               }
               
           }
        }
        while(!stack.isEmpty()) prefix += stack.pop();
        System.out.println("Hau to: " + prefix);
    }
}
