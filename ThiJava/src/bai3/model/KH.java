/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3.model;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author luffy monster
 */
public class KH implements IO, Serializable{

    int id;
    String ten;
    String diaChi;
    String SDT;
    String loai;

    public int getId() {
        return id;
    }

    public String getName() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public String getLoai() {
        return loai;
    }
    
    @Override
    public String[] read(Scanner in) {
        String o[] =  new String[5];
        for (int i = 0; i < 5; i++) o[i] = in.nextLine();
        return o;
    }

    @Override
    public void write(PrintWriter pw) {
        pw.println(id);
        pw.println(ten);
        pw.println(diaChi);
        pw.println(SDT);
        pw.println(loai);
    }

    @Override
    public boolean set(String[] o) {
        try {
            id = Integer.parseInt(o[0]);
            ten = o[1];
            diaChi = o[2];
            SDT = o[3];
            loai = o[4];
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object[] toObject() {
        return new Object[]{id, ten, diaChi, SDT, loai};
    }
    
}
