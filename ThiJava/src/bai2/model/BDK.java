/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2.model;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author luffy monster
 */
public class BDK implements IO{
    SinhVien sv;
    MonHoc mh;
    Date date;
 
    public BDK(SinhVien sv, MonHoc mh) {
        this.sv = sv;
        this.mh = mh;
        date = new Date();
    }

    public SinhVien getSv() {
        return sv;
    }

    public MonHoc getMh() {
        return mh;
    }

    public Date getDate() {
        return date;
    }
    
    public Object[] toObject(){
        return new Object[]{sv.getId(), sv.getTen(), mh.getTen(), date};
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
