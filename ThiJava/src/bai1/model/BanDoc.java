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
public class BanDoc implements IO{
    private int id;
    private String ten;
    private String diaChi;
    private String sdt;
    private String loai;
    public BanDoc(){
        
    }

    public BanDoc(int id, String ten, String diaChi, String sdt, String loai) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.loai = loai;
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
            diaChi = o[2];
            sdt = o[3];
            loai = o[4];
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public void write(java.io.PrintWriter pw) {
        pw.println(id);
        pw.println(ten);
        pw.println(diaChi);
        pw.println(sdt);
        pw.println(loai);       
    }

    @Override
    public Object[] toObject() {
        return new Object[]{id, ten, diaChi, sdt, loai};
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

    public String getLoai() {
        return loai;
    }
    
}
