/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso3;

/**
 *
 * @author LuffyMonster
 */
public class Bai13 {
    public static void main(String[] args) {
        PhanSo p1, p2;
        p1 = new PhanSo();
        p2 = new PhanSo();
        System.out.println("Nhap phan so 1: ");
        p1.nhap();
        System.out.println("Nhap phan so 2: ");
        p2.nhap();
        System.out.println("Tong: " + p1 + " + " + p2 + " = " + p1.cong(p2));
        System.out.println("Hieu: " + p1 + " - " + p2 + " = " + p1.tru(p2));
        System.out.println("Tich: " + p1 + " x " + p2 + " = " + p1.nhan(p2));
        System.out.println("Thuong: " + p1 + " : " + p2 + " = " + p1.chia(p2));
        System.out.println("Toi gian: p1 = " + p1 + " , p2 = " + p2);
        if (p1.bangNhau(p2)) {
            System.out.println(p1 + " = " + p2);
        }
        else if (p1.lonHon(p2)) {
            System.out.println(p1 + " > " + p2);
        }
        else System.out.println(p1 + " < " + p2);
    }
}

