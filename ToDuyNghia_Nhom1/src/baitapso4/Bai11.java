/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author luffy monster
 */
public class Bai11 {

    public static void main(String[] args) throws FileNotFoundException {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Su dung stack(vao sau ra truoc)");
        System.out.println("Ke thua tu vector implements List interface");
        System.out.println("Stack ban dau: " + stack);
        System.out.println("Kiem tra stack rong? " + stack.empty());

        stack.push(4);
        stack.push(2);
        stack.push(3);
        System.out.println("Them 1 so phan tu(4, 2, 3) vao dinh stack: " + stack);

        System.out.println("Lay va xoa 1 phan tu dinh stack: " + stack.pop() + " | " + stack);
        System.out.println("Lay  1 phan tu dinh stack ( ko xoa) : " + stack.peek() + " | " + stack);

        System.out.println("Ung dung vao DFS: ");
        System.out.println("Co n dinh 1..n va luon tuon tai duong di giua 2 dinh bat ki");

        DFS(1);
    }

    public static void DFS(int u) throws FileNotFoundException {
        Stack<Integer> stack = new Stack<>();
        boolean visited[];
        Scanner in = new Scanner(new File("DOTHI.INP"));
        int n = in.nextInt();
        int a[][] = new int[n + 1][n + 1];

        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            visited[i] = false;
        }

        stack.push(u);
        visited[u] = true;
        System.out.print("DFS(1) = 1");
        while (!stack.empty()) {
            int v = stack.pop();

            for (int i = 2; i <= n; i++) {
                if ((!visited[i]) && (a[v][i] == 1)) {
                    stack.push(v);
                    stack.push(i);
                    visited[i] = true;
                    System.out.print(" " + i);
                    break;
                }
            }
            // System.out.println(stack);
        }
        System.out.println("");
    }
}
