/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso5.bai1;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author luffy monster
 */
public class Sach implements Serializable, TableIO{
    private final int ID;
    private String ten;
    private String tacGia;
    private String chuyenNganh;
    private int namXuatBan;
    
    
    public Sach(int id){
        this.ID = id;
    }

    public void nhap(Scanner in){

        System.out.println("Nhap ten sach: ");
        ten = in.nextLine();
        
        System.out.println("Nhap chuyen nganh: ");
        String[] cn = new String[]{"Khoa hoc tu nhien","Dien tu vien thong",
                                    "Van hoc nghe thuat", "Cong nghe thong tin"};
        for (int i = 1; i <= cn.length; i++) System.out.println(i + ", " + cn[i-1]);
        System.out.println("Lua chon(1-4): ");
        while (true){
            try {
                int i = Integer.parseInt(in.nextLine());
                chuyenNganh = cn[i-1];
                break;
            } catch (Exception e) {
                System.out.println("Loi. Nhap lai.");
            }
        }
        
        System.out.println("Nhap tac gia: ");
        tacGia = in.nextLine();
        System.out.println("Nhap nam xuat ban: ");
        while (true){
            try {
                namXuatBan = Integer.parseInt(in.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Loi. Nhap lai.");
            }
        }
    }

    public int getID() {
        return ID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.ID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sach other = (Sach) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
//    @Override
//    public String toString() {
//        return  ID + ", " + ten + ", " + tacGia + ", " + chuyenNganh + ", " + namXuatBan ;
//    }

    @Override
    public String toString() {
        return "Sach{" + "ID=" + ID + ", ten=" + ten + ", tacGia=" + tacGia + ", chuyenNganh=" + chuyenNganh + ", namXuatBan=" + namXuatBan + '}';
    }
    
     
    @Override
    public Object[] toObject() {
        return new Object[]{ID,ten,tacGia,chuyenNganh,namXuatBan};
    }
    
}
