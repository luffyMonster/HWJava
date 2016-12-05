/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;

/**
 *
 * @author LuffyMonster
 */
public class Bai6 {

    static PrintWriter pw;
    static int step = 1;

    public static void main(String[] args) {
        int a[];
        File file = new File("TKTUANTU.OUT");
        try {
            pw = new PrintWriter(file);
            Method.creatFile();
            a = Method.readFile(new File("DAYSO.INP"));
            pw.print("Array " + "(" + a.length + "): ");
            Method.display(pw, a, 0, a.length);
            pw.println();
            int x = new Random().nextInt(1000);
            int u = TKTuanTu(a, x);
            if (u >= 0) {
                pw.println("Tim thay " + x + " o vi tri " + u);
            } else {
                pw.println("Khong tim thay " + x);
            }

        } catch (InputMismatchException ime) {
            System.out.println("Du lieu vao bi loi: " + ime);
        } catch (IOException ioe) {
            System.out.println("Loi vao ra file: " + ioe);
        } finally {
            try {
                pw.close();
            } catch (Exception e) {
                System.out.println("Loi dong file: " + e);
            }

        }
    }
//5 --  768 735 286 623 997 96 282 608 20 268 438 770 95 126 892 894

    private static int TKTuanTu(int a[], int x) {

        for (int i = 0; i < a.length; i++) {
            pw.println("Buoc " + i + ": " + a[i] + " == " + x + " : " + (a[i] == x ? "YES" : "NO"));
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }

}
