/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso5.bai1;

import java.io.Serializable;

/**
 *
 * @author luffy monster
 */
public class BanDoc implements Serializable,TableIO{
    private final int ID;
    private String ten;
    private String diaChi;
    private String SDT;
    private String loai;
    
    public BanDoc(int id){
        this.ID = id;
    }

    public int getID() {
        return ID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.ID;
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
        final BanDoc other = (BanDoc) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
   
    public void nhap(java.util.Scanner in){
        System.out.println("-------------------------------");
        System.out.println("Nhap ten ban doc: ");
        ten = in.nextLine();
        
        System.out.println("Nhap loai ban doc: ");
        String[] cn = new String[]{"Sinh vien", "Hoc vien cao hoc", "Giao vien"};
        for (int i = 1; i <= cn.length; i++) System.out.println(i + ", " + cn[i-1]);
        System.out.println("Lua chon: ");
        while (true){
            try {
                int i = Integer.parseInt(in.nextLine());
                loai = cn[i-1];
                break;
            } catch (Exception e) {
                System.out.println("Loi. Nhap lai.");
            }
        }
        
        System.out.println("Nhap dia chi: ");
        diaChi = in.nextLine();
        System.out.println("Nhap sdt: ");
        SDT = in.nextLine();
    }

//    @Override
//    public String toString() {
//        return  ID + ", " + ten + ", " + diaChi + ", " + SDT + ", " + loai ;
//    }

    @Override
    public String toString() {
        return "BanDoc{" + "ID=" + ID + ", ten=" + ten + ", diaChi=" + diaChi + ", SDT=" + SDT + ", loai=" + loai + '}';
    }

    public String getTen() {
        return ten;
    }

    @Override
    public Object[] toObject() {
        return new Object[]{ID,ten,diaChi,SDT,loai};
    }
    
    
}
