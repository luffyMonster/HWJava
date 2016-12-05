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
public class Bai1 {

    public static void main(String[] args) {
        int a[];
        try {
           // Method.creatFile();
            a = Method.readFile(new File("DAYSO.INP"));
            sxChon(a);
        } catch (InputMismatchException ime) {
            System.out.println("Du lieu vao bi loi.");
            ime.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("Loi vao ra file");
            ioe.printStackTrace();
        }
    }

    public static void sxChon(int[] a) {
        PrintWriter pw = null;
        try {
            File file = new File("SXCHON.OUT");
            pw = new PrintWriter(file);
            pw.print("Array " + "(" + a.length + "): ");
            Method.display(pw, a, 0, a.length);
            pw.println("");
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] < a[i]) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
                
                pw.print("Buoc " + i + ": ");
                Method.display(pw, a, 0, i + 1);
                pw.print(" -- ");
                Method.display(pw, a, i + 1, a.length);
                pw.println("");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }
}
