/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LuffyMonster
 */
public class Main {
    public static int[] scanArray(){
        Scanner in = new Scanner(System.in);
        int a[], n ;
        System.out.println("Nhap so phan tu: ");
        n = in.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap a[" + i + "]: ");
            a[i] = in.nextInt();
        }
        return a;
    }
    public static int[][] scanMatrix(int row, int collum){
        Scanner in = new Scanner(System.in);
        int[][] matrix;
        matrix = new int[row][collum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < collum; j++) {
                System.out.printf("Nhap phan tu [%d, %d]: ", i, j);
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }
    public static void sort(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                for (int k = i; k < a.length; k++) {
                    for (int l = j; l < a[k].length; l++) {
                        if (a[i][j] > a[k][l] ) {
                            int t = a[i][j];
                            a[i][j] = a[k][l];
                            a[k][l] = t;
                        }
                    }
                }
            }
        }
    }
    public static void showMatrix(int[][] m){
        for (int[] m1 : m) {
            for (int i : m1) {
                System.out.printf("%7d", i);
            }
            System.out.println("");
        }
    }
    //0924640479761
    public static int[] makeRandomArray(){
        Random rd = new Random();
        int n = rd.nextInt(100);
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(1000) - rd.nextInt(100);
        }
        return a;
    }
    public static int[] insertArray(int[] a, int[] b, int p){
        int aa[] = new int[a.length + b.length];
        int k = 0;
        for (int i = 0 ; i < p; i++) {
            aa[k++] = a[i];
        }
        for ( int i = 0; i < b.length; i++) {
            aa[k++] = b[i];
        }
        for (int i = p; i < a.length; i++) {
            aa[k++] = a[i];
        }
        return aa;
    }
    public static void displayArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }
    public static void sort(int a[]){
        Arrays.sort(a);
    }
    public static boolean laMangDoiXung(int a[]){
        int i = 0, j = a.length - 1;
        while (i<j){
            if (a[i++] != a[j--]) {
                return false;
            }
        }
        return true;
    }
    public static int[] deleteSimilar(int[] a){
        int aa[], nn = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i-1]) {
                nn++;
            }
        }
        aa = new int[nn];
        int k = 1;
        aa[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i-1]) {
                aa[k++] = a[i];
            }
        }
        return aa;
    }
    public static int[] count(int[] a){
        int b[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    b[i]++;
                }
            }
        }
        return b;
    }
    public static int indexMax(int[] a){
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[index]) {
                index = i;
            }
        }
        return index;
    }
}
