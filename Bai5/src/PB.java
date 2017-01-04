
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
public class PB implements IO {

    private int id;
    private String ten;
    private String moTa;
    private int heSo;

    @Override
    public String[] read(Scanner in) {
        String[] o = new String[4];
        for (int i = 1; i < 4; i++) {
            o[i] = in.nextLine();
        }
        return o;
    }

    @Override
    public void write(PrintWriter pw) {
        pw.println(ten);
        pw.println(moTa);
        pw.println(heSo);
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
            moTa = o[2];
            heSo = Integer.parseInt(o[3]);
            if (heSo < 1 || heSo > 20) return false;
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Object[] toObject() {
        return new Object[]{id, ten, moTa, heSo};
    }

}
