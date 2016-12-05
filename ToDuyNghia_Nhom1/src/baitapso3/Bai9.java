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
public class Bai9 {
    public static void main(String[] args) {
        final int MAX_SIZE = 1000;
        StackOfChars stack = new StackOfChars(MAX_SIZE);
        int n, b;
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap n, b: ");
        n = in.nextInt();
        b = in.nextInt();
        System.out.print(n);
        while ( n != 0 ){
            int x = n%b;
            if ( x < 10 && x >= 0) x += '0';
            else x = x - 10 + 'a';
            stack.push( (char)x );
            n /= b;
        }
        
        System.out.print(" o he co so " + b + " : " );
        while (!stack.isEmpty()) System.out.print(stack.pop());
    }
}
