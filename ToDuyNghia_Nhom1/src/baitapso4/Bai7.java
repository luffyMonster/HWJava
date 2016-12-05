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
public class Bai7 {

    static PrintWriter pw;
    static int step = 1;

    public static void main(String[] args) {
        int a[];
        File file = new File("TKNHIPHAN.OUT");
        try {
            pw = new PrintWriter(file);
            //Method.creatFile();
            a = Method.readFile(new File("DAYSO.INP"));
            pw.print("Array " + "(" + a.length + "): ");
            Bai4.quick_sort(a, 0, a.length - 1, true);
            Method.display(pw, a, 0, a.length);
            pw.println();
            int x = new Random().nextInt(1000);

            int u = TKNhiPhan(a, x);
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

    private static int TKNhiPhan(int a[], int key) {
        int mid;
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (a[mid] == key) {
                pw.println("Buoc " + step++ + " : " + "a[" + l + "..." + mid + "..." + r + "] == " + key + " " + "YES");
                return mid;
            }
            pw.println("Buoc " + step++ + " : " + "a[" +  l + "..." + mid + "..." + r  + "] == " + key + " " + "NO");
            if (a[mid] > key) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
