/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1.model;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luffy monster
 */
public class QL implements IO{
    private BanDoc bd;
    private java.util.ArrayList<ListMuon> lMuon;
    private int sl;

    public int getSl() {
        return sl;
    }
    public QL() {
    }

    public QL(BanDoc bd) {
        this.bd = bd;
        this.lMuon = new ArrayList<ListMuon>();
    }

    
    public BanDoc getBd() {
        return bd;
    }
    public boolean add(Sach s, int sl){
        if (lMuon.size() == 5) return false;
        for (ListMuon lm:lMuon){
            if (lm.s.getId() == s.getId() ){
                return false;
            }
        }
        lMuon.add(new ListMuon(s, sl));
        this.sl += sl;
        return true;
    }
    public ArrayList<ListMuon> getLMuon() {
        return lMuon;
    }

    @Override
    public String[] read(Scanner in) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(PrintWriter pw) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean set(String[] o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toObject() {
        Object o[] = new Object[3];
        o[0] = bd.getId();
        o[1] = bd.getTen();
        String s = "";
        for (ListMuon l:lMuon){
            s += "(" + l.s.getId() + "," + l.sl + ") ";
        }
        o[2] = s;
        return o;
    }
    static class ListMuon{
        Sach s;
        int sl;

        public ListMuon(Sach s, int sl) {
            this.s = s;
            this.sl = sl;
        }

        public Sach getS() {
            return s;
        }

        public int getSl() {
            return sl;
        }
        
    }
}
