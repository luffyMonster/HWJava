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
public class MonHoc implements IO{
    
    int id;
    String ten;
    int tongSotiet;
    String loai;

    @Override
    public String[] read(Scanner in) {
        String[] o = new String[4];
        for (int i = 0; i < 4; i++) o[i] = in.nextLine();
        return o;
    }

    @Override
    public void write(PrintWriter pw) {
        pw.println(id);
        pw.println(ten);
        pw.println(tongSotiet);
        pw.println(loai);
    }

    @Override
    public boolean set(String[] o) {
        for (String s: o){
            if ( s.equals("")) return false;
        }
        try {
            id = Integer.parseInt(o[0]);
            ten = o[1];
            tongSotiet = Integer.parseInt(o[2]);
            loai = o[3];
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object[] toObject() {
        return new Object[]{id, ten, tongSotiet, loai};
    }

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public int getTongSotiet() {
        return tongSotiet;
    }

    public String getLoai() {
        return loai;
    }
    
}
