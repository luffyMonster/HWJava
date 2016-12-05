/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso3;

import java.util.Scanner;

/**
 *
 * @author LuffyMonster
 */
public class Bai10 {

    public static void main(String[] args) {
        final int MAX_SIZE = 1000;
        MyPoint[] points = new MyPoint[MAX_SIZE];
        Scanner in = new Scanner(System.in);
        int n;

        System.out.print("Nhap so diem n: ");
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap diem thu " + i + " : ");
            int x = in.nextInt(), y = in.nextInt();
            points[i] = new MyPoint(x, y);
        }

        int ind1 = 0, ind2 = 0;
        double max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double d;
                if ((d = points[i].distance(points[j])) > max) {
                    max = d;
                    ind1 = i;
                    ind2 = j;
                }
            }
        }
        System.out.println("Khoang cach xa nhat: " + max);
        System.out.println("Tu: {" + points[ind1].getX() + "," + points[ind1].getY() + "} -> {" + points[ind2].getX() + "," + points[ind2].getY() + "}");
    }
}
