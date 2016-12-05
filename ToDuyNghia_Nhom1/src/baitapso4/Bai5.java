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
public class Bai5 {

    static PrintWriter pw;
    static int step = 1;
    public static void main(String[] args) {
        int a[];
        File file = new File("SXTRON.OUT");
        try {
            pw = new PrintWriter(file);
           // Method.creatFile();
            a = Method.readFile(new File("DAYSO.INP"));
            pw.print("Array " + "(" + a.length + "): ");
            Method.display(pw, a, 0, a.length);
            pw.println();
            merge_sort(a, 0, a.length - 1);
           // Method.display(pw, a, 0, a.length);
            
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

    private static void merge_sort(int a[], int l, int r) {
        if (l < r) {
            int mid = (l+r)/2;
            merge_sort(a, l, mid);
            merge_sort(a, mid+1, r);
            merge(a,l,mid,r);
            pw.print("Buoc " + step++ + ": ");
            Method.display(pw, a, 0, l);
            pw.print("[");
            Method.display(pw, a, l, mid+1);
            pw.print("]");
            pw.print("[");
            Method.display(pw, a, mid+1, r+1);
            pw.print("]");
            Method.display(pw, a, r+1, a.length);
            pw.println();
        }
    }
    private static void merge(int[] a, int l, int mid, int r){
        int l1, r1, l2, r2;
        l1 = l;
        r1 = mid;
        l2 = mid+1;
        r2 = r;
        int t[] = new int[r-l+1];
//        2 2 6 1 4 7
//      
        int index =0;
        while (l1 <= r1 && l2 <= r2){
            if (a[l1] > a[l2]) {
                t[index] = a[l2++];
            }
            else t[index] = a[l1++]; 
            index++;
        }
        if (l1 <= r1 ) {
            for (int i = l1; i <= r1; i++) {
                t[index++] = a[i];
            }
        }
        if (l2 <= r2 ) {
            for (int i = l2; i <= r2; i++) {
                t[index++] = a[i];
            }
        }
        for (int i = 0; i < r-l+1; i++) {
            a[l+i] = t[i];
        }
    }

}
