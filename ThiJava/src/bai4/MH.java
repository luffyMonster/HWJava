/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author luffy monster
 */
public class MH implements IO{
    private int id;
    private String ten;
    private String nhomHang;
    private double gia;
    private int sl;

    @Override
    public String[] read(Scanner in) {
        String[] o = new String[5];
          for (int i = 0; i < 5; i++){
              o[i] = in.nextLine();
          }
          return o;
    }

    @Override
    public void write(PrintWriter pw) {
        pw.println(id);
        pw.println(ten);
        pw.println(nhomHang);
        pw.println(gia);
        pw.println(sl);
    }

    @Override
    public boolean set(String[] o) {
        try {
            id = Integer.parseInt(o[0]);
            ten = o[1];
            nhomHang = o[2];
            gia = Double.parseDouble(o[3]);
            sl = Integer.parseInt(o[4]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object[] toObject() {
        return new Object[]{id, ten, nhomHang, gia, sl};
    }
    
    
            
}
