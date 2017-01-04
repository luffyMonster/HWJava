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
public class MH implements IO, Serializable{

    int id;
    String ten;
    String nhomHang;
    double gia;


    @Override
    public String[] read(Scanner in) {
        String o[] =  new String[5];
        for (int i = 0; i < 4; i++) o[i] = in.nextLine();
        return o;
    }

    @Override
    public void write(PrintWriter pw) {
        pw.println(id);
        pw.println(ten);
        pw.println(nhomHang);
        pw.println(gia);
    }

    @Override
    public boolean set(String[] o) {
        try {
            id = Integer.parseInt(o[0]);
            ten = o[1];
            nhomHang= o[2];
            gia = Double.parseDouble(o[3]);
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object[] toObject() {
        return new Object[]{id, ten, nhomHang, gia};
    }
    
}
