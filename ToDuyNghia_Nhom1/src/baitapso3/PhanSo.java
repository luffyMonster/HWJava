/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso3;

import java.util.Scanner;

/**
 *
 * @author LuffyMonster
 */
public class PhanSo {
    private int ts;
    private int ms;
    
    public PhanSo(){
        ts = 0;
        ms = 1;
    }

    public PhanSo(int ts, int ms) {
        this.ts = ts;
        this.ms = ms;
    }
    @Override
    public String toString(){
        if (mauBangKhong()) {
            return " Phan so co mau bang khong. ";
        }
        return ts + "/" + ms;
    }
    public int getTs() {
        return ts;
    }

    public int getMs() {
        return ms;
    }
    
    public PhanSo cong(PhanSo p){
        return new PhanSo(this.ts*p.getMs() + p.getTs()*this.ms, this.ms * p.getMs());
    }
    public PhanSo doiDau(){
        return new PhanSo(-ts, ms);
    }
    public PhanSo tru(PhanSo p){
        return this.cong( p.doiDau());
    }
    public PhanSo nhan(PhanSo p){
        return new PhanSo(ts*p.getTs(), ms*p.getMs());
    }
    public PhanSo chia(PhanSo p){
        return new PhanSo(ts*p.getMs(), ms*p.getTs());
    }
    public PhanSo toiGian(){
        int uc = UCLN(ts, ms);
        return new PhanSo(ts/uc, ms/uc);
    }
    public PhanSo nghichDao(){
        return new PhanSo(ms, ts);
    }
    public boolean bangNhau(PhanSo p){
        return (ts/ms) == (p.getTs()/getMs());
    }
    public boolean lonHon(PhanSo p){
        return (ts/ms) > (p.getTs()/getMs());
    }
    public boolean nhoHon(PhanSo p){
        return (ts/ms) < (p.getTs()/getMs());
    }
    public void hien(){
        System.out.print(this);
    }
    public void nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap tu so: ");
        ts = in.nextInt();
        System.out.println("Nhap mau so: ");
        ms = in.nextInt();
    }
    public boolean mauBangKhong(){
        return ms == 0;
    } 
    private int UCLN(int a, int b){
        while (b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
