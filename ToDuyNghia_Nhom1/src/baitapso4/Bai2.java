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
public class Bai2 {

    public static void main(String[] args) {
        int a[];
        try {
            //Method.creatFile();
            a = Method.readFile(new File("DAYSO.INP"));
            sxChen(a);
        } catch (InputMismatchException ime) {
            System.out.println("Du lieu vao bi loi.");
            ime.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("Loi vao ra file");
            ioe.printStackTrace();
        }
    }

    public static void sxChen(int[] a) {
        PrintWriter pw = null;
        try {

            File file = new File("SXCHEN.OUT");
            pw = new PrintWriter(file);
            pw.print("Array " + "(" + a.length + "): ");
            Method.display(pw, a, 0, a.length);
            pw.println("");
            for (int i = 0; i < a.length; i++) {
                int index = 0;//vi tri chen a[i]
                while (a[index] < a[i]) {
                    index++;
                }

                int temp = a[i];
                for (int j = i; j > index; j--) {
                    a[j] = a[j - 1];
                }
                a[index] = temp;

                pw.print("Buoc " + i + ": ");
                Method.display(pw, a, 0, i + 1);
                pw.print(" -- ");
                Method.display(pw, a, i + 1, a.length);
                pw.println("");

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }
}
