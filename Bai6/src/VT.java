
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
public class VT implements IO, Serializable{
    
    private int id;
    private String ten;
    private int mucThuong;

    @Override
    public String[] read(Scanner in) {
        String[] o = new String[3];
        for (int i = 1; i < 3; i++){
            o[i] = in.nextLine();
        }
        return o;
    }

    @Override
    public void write(PrintWriter pw) {
        pw.println(ten);
        pw.println(mucThuong);
    }

    @Override
    public boolean set(String[] o) {
        for (String s:o){
            if (s.equals("")) return false;
        }
        try {
            id = Integer.parseInt(o[0]);
            ten = o[1];
            mucThuong = Integer.parseInt(o[2]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object[] toObject() {
        return new Object[]{id, ten, mucThuong};
    }

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public int getMucThuong() {
        return mucThuong;
    }
    
}
