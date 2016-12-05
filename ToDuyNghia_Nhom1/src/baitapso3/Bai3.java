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
public class Bai3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Rectange r = new Rectange();
        System.out.print("Nhap chieu dai: ");
        r.setHeight(Double.parseDouble(in.nextLine()));
        System.out.print("Nhap chieu rong: ");
        r.setWidth(Double.parseDouble(in.nextLine()));
        System.out.print("Nhap mau: ");
        r.setColor(in.nextLine());
        
        
        System.out.println("Thong tin HCN: " +" Mau = " +  r.getColor() + " Dai = " + r.getHeight() + " Rong: " + r.getWidth());
        System.out.println("Dien tich: " + r.findArea());
        System.out.println("Chu vi: " + r.findPerimeter());
        
    }
}
