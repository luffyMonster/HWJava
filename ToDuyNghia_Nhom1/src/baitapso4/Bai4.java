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

/**
 *
 * @author LuffyMonster
 */
public class Bai4 {

    static PrintWriter pw = null;
    static int step = 1;

    public static void main(String[] args) {
        int a[];
        File file = new File("SXNHANH.OUT");
        try {
            pw = new PrintWriter(file);
            //Method.creatFile();
            a = Method.readFile(new File("DAYSO.INP"));
            pw.print("Array " + "(" + a.length + "): ");
            Method.display(pw, a, 0, a.length);
            pw.println();
           // Arrays.sort(a);
            // Method.display(pw, a, 0, a.length);
            quick_sort(a, 0, a.length - 1,false);
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
    //Hide de an in ra ket qua tung buoc, ap dung cho tim kiem nhi phan

    static void quick_sort(int a[], int l, int r, boolean hide) {
        if (l >= r) {
            return;
        }
        int key = a[(l + r) / 2];
        int i = l, j = r;
        while (i <= j) {
            while (a[i] < key) {
                i++;
            }
            while (j >= 0 && a[j] >= key) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        if (!hide && pw != null) {
            pw.print("Buoc " + step++ + ": ");
            Method.display(pw, a, 0, i);
            pw.print(" [" + key + "]");
            Method.display(pw, a, i + 1, a.length);
            pw.println();
        }

        quick_sort(a, l, i - 1, false);
        quick_sort(a, i + 1, r, false);
    }
    /**
     * 2 6 3 7 4 5 1
     * 2 6 3 1 4 5 7
     * 1 6 3 2 4 5 7
     * *
     */

}
