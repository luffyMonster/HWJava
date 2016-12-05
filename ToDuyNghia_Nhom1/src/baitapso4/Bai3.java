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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuffyMonster
 */
public class Bai3 {

    public static void main(String[] args) {
        int a[];
        try {
            //Method.creatFile();
            a = Method.readFile(new File("DAYSO.INP"));
            sxNoiBot(a);
        } catch (InputMismatchException ime) {
            System.out.println("Du lieu vao bi loi.");
            ime.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("Loi vao ra file");
            ioe.printStackTrace();
        }
    }
//5 --  768 735 286 623 997 96 282 608 20 268 438 770 95 126 892 894
    public static void sxNoiBot(int[] a) {
        PrintWriter pw = null;
        try {    
            File file = new File("SXNOIBOT.OUT");
            pw = new PrintWriter(file);
            
            pw.print("Array " + "(" + a.length + "): ");
            Method.display(pw, a, 0, a.length);
            pw.println("");
            for (int i = 0; i < a.length; i++) {
                for (int j = a.length-1; j > 0; j--) {
                    if (a[j] < a[j - 1]) {
                        int temp = a[j];
                        a[j] = a[j-1];
                        a[j-1] = temp;
                    }
                }
                pw.print("Buoc " + i + ": ");
                Method.display(pw, a, 0, i + 1);
                pw.print(" -- ");
                Method.display(pw, a, i + 1, a.length);
                pw.println("");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bai3.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                pw.close();
        }
    }
}
