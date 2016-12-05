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
public class Bai14 {
    public static void main(String[] args) {
        SoPhuc sp1, sp2;
        sp1 = new SoPhuc();
        sp2 = new SoPhuc();
        
        System.out.println("Nhap so phuc 1st: ");
        sp1.nhap();
        System.out.println("Nhap so phuc 2rd: ");
        sp2.nhap();
        
        System.out.println("Tong : " + sp1 + " + " + sp2 + " = " + sp1.cong(sp2));
        System.out.println("Hieu : " + sp1 + " - " + sp2 + " = " + sp1.tru(sp2));
        System.out.println("Tich : " + sp1 + " x " + sp2 + " = " + sp1.nhan(sp2));
        System.out.println("Thuong : " + sp1 + " : " + sp2 + " = " + sp1.chia(sp2));
        
        System.out.println("Nghich dao: z1^(-1) = " + sp1.nghichDao() + " , z2^(-2) = " +  sp2.nghichDao());
        
        if (sp1.bangNhau(sp2)) {
            System.out.println("Bang nhau.");
        } else if (sp1.lonHon(sp2)) {
            System.out.println(sp1 + " co modul lon hon " + sp2);
        } else if (sp1.nhoHon(sp2)) {
            System.out.println(sp1 + " co modul nho hon " + sp2);
        } else System.out.println(sp1 + " co modul bang " + sp2);
    }
}
