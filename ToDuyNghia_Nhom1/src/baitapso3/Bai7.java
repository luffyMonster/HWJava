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
public class Bai7 {
    public static void main(String[] args) {
        final int MAX_SIZE = 1000;
        StackOfChars stack = new StackOfChars(MAX_SIZE);
        String prefix = "";
        String s;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Chi ap dung cho bieu thuc dung co day du ngoac!!");
        System.out.println("Nhap bieu thuc can tinh: ");
        s = in.nextLine();
       // s = "((((3+7)x(9-(6-2)))+(4/3)))";
       // s = "((((4+2)x3)x4)x(2-5))";
        System.out.println("Bieu thuc: " + s);
        
        
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           if ( c == '(' ) stack.push(c);
           if ( c >= '0' && c <= '9') prefix += c;
           if ( c == '+' || c == '-' || c == 'x' || c == '/') stack.push(c);
           if ( c == ')') {
               while(true){
                 char c1 = stack.pop();
                 if ( c1 == '(') break;
                 prefix += c1;
                 
               }
               
           }
        }
        while(!stack.isEmpty()) prefix += stack.pop();
        System.out.println(prefix);
        //37+962--+
        StackOfIntegers stackI = new StackOfIntegers(MAX_SIZE);
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if ( c >= '0' && c <= '9' ) stackI.push(c-'0');
            else {
                int num1 = stackI.pop();
                int num2 = stackI.pop();
                
                switch (c){
                        case '+':  stackI.push( num2 + num1 ); break;
                        case '-':  stackI.push( num2 - num1  ); break;
                        case 'x':  stackI.push( num2 * num1 ); break;
                        case '/':  stackI.push( num2 / num1 ); break;
                        default: break;
                }
            }
        }
        System.out.println("Ket qua: " + stackI.pop());
        
    }
}
