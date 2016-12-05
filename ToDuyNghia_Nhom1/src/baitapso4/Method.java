/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LuffyMonster
 */
public class Method{
    //Gia tri max cua phan tu trong mang
    public static final int MAX = 1000;
    //Gia tri max cua do dai mang
    public static final int LENGTH = 1000;
    public static void creatFile() throws FileNotFoundException, IOException {
        File file = new File("DAYSO.INP");
        PrintWriter pw = new PrintWriter(file);
        file.createNewFile();
        
        Random rd = new Random();
        int n = rd.nextInt(LENGTH) + 1;//Do dai mang
        pw.println(n);
        for (int i = 0; i < n; i++) {
            pw.print(" " + rd.nextInt(MAX));
        }
        
        pw.close();

    }
    
    public static int[] readFile(File file) throws FileNotFoundException, InputMismatchException {
        Scanner in = new Scanner(file);
        int[] a = new int[in.nextInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }
        return a;
    }
    
    
    public static void display(PrintWriter pw, int[] a, int l, int r){
        for (int i = l; i < r; i++) {
            pw.print(" " + a[i]);
        }
    }
}
