/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1.model;

/**
 *
 * @author luffy monster
 */
public class Sach implements IO{
    private int id;
    private String ten;
    private String tacGia;
    private String chuyenNganh;
    private int nam;
    public Sach(){
        
    }
    public Sach(int id, String ten, String tacGia, String chuyenNganh, int nam) {
        this.id = id;
        this.ten = ten;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.nam = nam;
    }

    @Override
    public String[] read(java.util.Scanner in) throws Exception{
        String o[] = new String[5];
        for (int i = 0; i < 5; i++){
            o[i] = in.nextLine();
        }
        return o;
    }
    public boolean set(String[] o){
        for (String s : o){
            if (s.equals("")){
                return false;
            }
        }
        try {
            id = Integer.parseInt(o[0]);
            ten = o[1];
            tacGia = o[2];
            chuyenNganh = o[3];
            nam = Integer.parseInt(o[4]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public void write(java.io.PrintWriter pw) {
        pw.println(id);
        pw.println(ten);
        pw.println(tacGia);
        pw.println(chuyenNganh);
        pw.println(nam);       
    }

    @Override
    public Object[] toObject() {
        return new Object[]{id, ten, tacGia, chuyenNganh, nam};
    }

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public int getNam() {
        return nam;
    }
    
}
