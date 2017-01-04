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
public class DSMH implements Serializable,IO{
    private KH kh;
    private MH mh;
    private int sl;

    public DSMH(KH kh, MH mh, int sl) {
        this.kh = kh;
        this.mh = mh;
        this.sl = sl;
    }

    public KH getKh() {
        return kh;
    }

    public void setKh(KH kh) {
        this.kh = kh;
    }

    public MH getMh() {
        return mh;
    }

    public void setMh(MH mh) {
        this.mh = mh;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
    
    @Override
    public Object[] toObject() {
        return new Object[]{kh.id, kh.ten, mh.ten, sl};
    }
     @Override
    public String[] read(Scanner in) {
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
}
