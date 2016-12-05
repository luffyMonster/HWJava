/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso5.bai1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author luffy monster
 */
public class QuanLy implements Serializable, TableIO{
    private BanDoc banDoc;
    private ArrayList<QLSach> lSach;
    private int tong = 0;
    public QuanLy(BanDoc banDoc) {
        this.banDoc = banDoc;
        this.lSach = new ArrayList<>();
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public int getTong() {
        return tong;
    }

    @Override
    public Object[] toObject() {
        return new Object[]{banDoc, lSach};
    }
    
    class QLSach implements Serializable{
        Sach sach;
        int soLuong;

        public QLSach(Sach sach, int soLuong) {
            this.sach = sach;
            this.soLuong = soLuong;
        }

        @Override
        public String toString() {
            return "--" + sach + ", " + soLuong + " cuon";
        }
        
    }
    public boolean exist(int id){
        for (QLSach ql: lSach){
            if (ql.sach.getID() == id)
                return true;
        }
        return false;
    }
    public void add(Sach s, int sl){
        lSach.add(new QLSach(s, sl));
        tong += sl;
    }
    public int lSachSize(){
        return lSach.size();
    }
    public void hienThi(){
        System.out.println("------------------------------------");
        System.out.println(banDoc);
        System.out.println("List sach muon: ");
        for(QLSach qls : lSach ) System.out.println(qls);
    }
    
}
