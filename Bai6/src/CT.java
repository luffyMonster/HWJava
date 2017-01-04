
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luffy monster
 */
public class CT implements IO, Serializable{
    
    private int id;
    private String ten;
    private String diaChi;
    private String sdt;
    private int mucLuong;

    @Override
    public String[] read(Scanner in) {
        String[] o = new String[5];
        for (int i = 1; i < 5; i++){
            o[i] = in.nextLine();
        }
        return o;
    }

    @Override
    public void write(PrintWriter pw) {
        pw.println(ten);
        pw.println(diaChi);
        pw.println(sdt);
        pw.println(mucLuong);
    }

    @Override
    public boolean set(String[] o) {
        for (String s:o){
            if (s.equals("")) 
                return false;
        }
        try {
            id = Integer.parseInt(o[0]);
            ten = o[1];
            diaChi = o[2];
            sdt = o[3];
            mucLuong = Integer.parseInt(o[4]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object[] toObject() {
        return new Object[]{id, ten, diaChi, sdt, mucLuong};
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

    public int getMucLuong() {
        return mucLuong;
    }
    
}
