/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso3;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author LuffyMonster
 */
public class SinhVien {
    private String msv;
    private String ten;
    private String lop;
    private int khoa;

    public SinhVien() {
    }
    
    public SinhVien(String msv, String ten, String lop, int khoa) {
        this.msv = msv;
        this.ten = ten;
        this.lop = lop;
        this.khoa = khoa;
    }

    public String getTen() {
        return ten;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "msv=" + msv + ", ten=" + ten + ", lop=" + lop + ", khoa=" + khoa + '}';
    }
    
    public void scan(){
        Scanner in = new Scanner(System.in);
        
        System.out.print("\tNhap MSV: ");
        msv = in.nextLine().toUpperCase();
        
        System.out.print("\tNhap ten: ");
        ten = in.nextLine();
        
        System.out.print("\tNhap lop: ");
        lop = in.nextLine().toUpperCase();
        
        System.out.print("\tNhap khoa: ");
        khoa = Integer.parseInt(in.nextLine());
        
    }

    public String getLop() {
        return lop;
    }

    


    public void show(){
        //System.out.println(this);
        System.out.printf("\n%10s %20s %10s %6s", "MSV", "TEN", "LOP", "KHOA");
        System.out.printf("\n%10s %20s %10s %6s", msv, ten, lop, khoa);
    }

    
}
