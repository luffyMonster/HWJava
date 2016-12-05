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
public class Bai12 {
    
    public static void main(String[] args) {
        int c;
        Scanner in = new Scanner(System.in);
        Matrix m1, m2, m;
        while (true){
            System.out.println("==================================");
            System.out.println("1, Tinh tong va hieu 2 ma tran.");
            System.out.println("2, Tinh tich 2 ma tran.");
            System.out.println("3, Tinh chuyen vi cua 1 ma tran");
            System.out.println("4, Thoat.");
            System.out.println("Nhap chuc nang: ");
            while (true){
                c = in.nextInt();
                if (c < 1 || c > 4) {
                    System.out.println("Nhap sai, moi nhap lai: ");
                } else break;
            }

            switch(c){
                case 1: System.out.println("Nhap so hang, cot cua ma tran 1: ");
                        m1 = nhap();
                        System.out.println("Nhap so hang, cot cua ma tran 2: ");
                        m2 = nhap();
                        System.out.println("Ma tran 1: ");
                        m1.print();
                        System.out.println("Ma tran 2: ");
                        m2.print();
                        System.out.println("Tong 2 ma tran vua nhap: ");
                        m = m1.add(m2);
                        if ( m != null ) m.print();
                        System.out.println("Hieu 2 ma tran vua nhap: ");
                        m = m1.sub(m2);
                        if ( m != null ) m.print();
                        break;

                case 2: System.out.println("Nhap so hang, cot cua ma tran 1: ");
                        m1 = nhap();
                        System.out.println("Nhap so hang, cot cua ma tran 2: ");
                        m2 = nhap();
                        System.out.println("Ma tran 1: ");
                        m1.print();
                        System.out.println("Ma tran 2: ");
                        m2.print();
                        System.out.println("Tich 2 ma tran vua nhap: ");
                        m = m1.mul(m2);
                        if ( m != null ) m.print();
                        break;
                case 3: System.out.println("Nhap so hang, cot cua ma tran: ");
                        m1 = nhap();
                        System.out.println("Ma tran 1: ");
                        m1.print();
                        System.out.println("Chuyen vi cua ma tran vua nhap: ");
                        m1.transpose().print();
                        break;
                case 4: System.exit(0); break;
            }
        }
        
    }
    static Matrix nhap(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); 
        int m = in.nextInt();
        Matrix matrix = new Matrix(n, m);
        matrix.input();
        return matrix;
    }
}
