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
public class Bai1 {

    public static void main(String[] args) {
        SinhVien sv = new SinhVien();

        System.out.println("Nhap thong tin sinh vien: ");
        sv.scan();

        System.out.println("Thong tin SV: ");
        sv.show();

    }
}
