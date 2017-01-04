
import java.io.PrintWriter;
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
public class NV implements IO {

    private int id;
    private String ten;
    private String diaChi;
    private String sdt;
    private double bacLuong;

    @Override
    public String[] read(Scanner in) {
        String[] o = new String[5];
        for (int i = 1; i < 5; i++) {
            o[i] = in.nextLine();
        }
        return o;
    }

    @Override
    public void write(PrintWriter pw) {
        pw.println(ten);
        pw.println(diaChi);
        pw.println(sdt);
        pw.println(bacLuong);
    }

    @Override
    public boolean set(String[] o) {
        for (String l:o){
            if (l.equals("")){
                return false;
            }
        }
        try {
            id = Integer.parseInt(o[0]);
            ten = o[1];
            diaChi = o[2];
            sdt = o[3];
            bacLuong = Double.parseDouble(o[4]);
            if (bacLuong < 1 || bacLuong > 9) return false;
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Object[] toObject() {
        return new Object[]{id, ten, diaChi, sdt, bacLuong};
    }

}
