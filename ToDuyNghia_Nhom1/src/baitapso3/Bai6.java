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
public class Bai6 {
    public static void main(String[] args) {
        final int MAX_SIZE = 1000;
        int n;
        Scanner in = new Scanner(System.in);
        StackOfIntegers stack = new StackOfIntegers(MAX_SIZE);
        
        System.out.println("Nhap so n: ");
        n = in.nextInt();
        
        while (n != 0){
            stack.push(n%2);
            n /= 2;
        }
        System.out.println("Ma nhi phan cua " + n + " : ");
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
