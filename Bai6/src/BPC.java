
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
public class BPC implements IO,Serializable{
    private CT ct;
    private VT vt;
    private int soTran;

    public BPC(CT ct, VT vt, int soTran) {
        this.ct = ct;
        this.vt = vt;
        this.soTran = soTran;
    }

    public CT getCt() {
        return ct;
    }

    public VT getVt() {
        return vt;
    }

    public int getSoTran() {
        return soTran;
    }
    
    public Object[] toObject(){
        return new Object[]{ct.getId(), ct.getTen(), vt.getTen(), soTran};
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
