/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2.model;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author luffy monster
 */
public class SinhVien implements IO{
    
    int id;
    String ten;
    String diaChi;
    String sdt;
    String lop;
    
    int soMH;

    public SinhVien() {
        soMH = 0;
    }

    public int getSoMH() {
        return soMH;
    }

    public void setSoMH() {
        this.soMH++;
    }
    
    
    
    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getLop() {
        return lop;
    }

    @Override
    public String[] read(Scanner in) {
        String[] o = new String[5];
        for (int i = 0; i < 5; i++) o[i] = in.nextLine();
        return o;
    }

    @Override
    public void write(PrintWriter pw) {
        pw.println(id);
        pw.println(ten);
        pw.println(diaChi);
        pw.println(sdt);
        pw.println(lop);
    }

    @Override
    public boolean set(String[] o) {
        for (String s: o){
            if ( s.equals("")) return false;
        }
        try {
            id = Integer.parseInt(o[0]);
            ten = o[1];
            diaChi = o[2];
            sdt = o[3];
            lop = o[4];
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object[] toObject() {
        return new Object[]{id, ten, diaChi, sdt, lop};
    }
    
}
