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
public class Bai11 {
    public static void main(String[] args) {
         
        MyPoint[] points = new MyPoint[3];
        Scanner in = new Scanner(System.in);
        
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhap diem thu " + i + " : ");
            int x = in.nextInt(), y = in.nextInt();
            points[i] = new MyPoint(x, y);
        }
        
        double d1 = MyPoint.distance(points[0], points[1]);
        double d2 = MyPoint.distance(points[0], points[2]);
        double d3 = MyPoint.distance(points[1], points[2]);
        
        if ((d1 + d2 > d3) && (d1 + d3 > d2) && (d2 + d3 > d1)) {
            System.out.println("Co the tao thanh tam giac! ");
            if (d1 == d2 && d2 == d3) {
                System.out.println("No deu!");
            } else if (d1 == d2 || d1 == d3 || d2 == d3) {
                System.out.println("No can!");
            }
 
            if ((d1*d1 + d2*d2 == d3*d3) || (d1*d1 + d3*d3 == d2*d2) || (d2*d2 + d3*d3 == d1*d1)  ) {
                System.out.println("No vuong!");
            }
        }
        else System.out.println("Khong tao duoc tam giac!");
    }
}
