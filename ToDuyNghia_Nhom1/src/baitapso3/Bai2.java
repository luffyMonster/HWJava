/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author LuffyMonster
 */
public class Bai2 {
    public static void sort(SinhVien[] sv){
        for (int i = 0; i < sv.length; i++) {
            for (int j = i+1; j < sv.length; j++) {
                if (sv[i].getTen().compareTo(sv[j].getTen()) > 0) {
                    SinhVien t  = sv[i];
                    sv[i] = sv[j];
                    sv[j] = t;
                }
            }
            
        }
    } 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SinhVien svs[];
        int n ;
        
        System.out.print("Nhap so SV: ");
        n = Integer.parseInt(in.nextLine());
        svs = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            svs[i] = new SinhVien();
            System.out.println("Nhap thong tin SV thu " + i + " : ");
            svs[i].scan();
            
        }
        
        System.out.println("\n=======================\nList SV: ");
        for (SinhVien sv : svs){
            sv.show();
        }
        
        
        sort(svs);
        System.out.println("\n======================\nList SV sorted: ");
        for (SinhVien sv : svs){
            sv.show();
        }
        
        System.out.println("\n=====================\nNhap lop muon xem: ");
        String lop = in.nextLine();
        for (SinhVien sv : svs){
            if (sv.getLop().equals(lop)) {
                sv.show();
            }
        }
    }
}
