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
public class SoPhuc {
    private float a;
    private float b;

    public SoPhuc() {
        this.a = 0;
        this.b = 0;
    }
    public SoPhuc(float a, float b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString(){
        if (b<0) return "(" + a + b + "i)";
        return  "(" + a + "+" + b + "i)";
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }
    
    public SoPhuc cong(SoPhuc sp){
        return new SoPhuc(a+sp.getA(), b+sp.getB());
    }
    public SoPhuc tru(SoPhuc sp){
        return new SoPhuc(a-sp.getA(), b-sp.getB());
    }
    public SoPhuc nhan(SoPhuc sp){
        //(a+bi)(a'+b'i) = aa' + ab'i + a'bi - bb'
        return new SoPhuc(a*sp.getA()-b*sp.getB(), a*sp.getB() + b*sp.getA() );
    }
    public SoPhuc lienHop(){
        return new SoPhuc(a, -b);
    }
    public SoPhuc chia(SoPhuc sp){
        return this.nhan(sp.nghichDao());
    }
    public SoPhuc nghichDao(){
        //1/z = z_/(zz_) = (a-bi)/(a^2+b^2);
        return new SoPhuc(a/(a*a+b*b), -b/(a*a+b*b));
    }
    public boolean bangNhau(SoPhuc sp){
        return (a == sp.getA() && b == sp.getB());
    }
    
    public boolean lonHon(SoPhuc sp){
        return (a*a + b*b) > (sp.getA()*sp.getA() + sp.getB()*sp.getB());
    }
    
    public boolean nhoHon(SoPhuc sp){
        return (a*a + b*b) < (sp.getA()*sp.getA() + sp.getB()*sp.getB());
    }
    public void hien(){
        System.out.println(this);//goi ham tostring
    }
    public void nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap phan thuc: ");
        a = in.nextInt();
        System.out.println("Nhap phan ao: ");
        b = in.nextInt();
    }
}
