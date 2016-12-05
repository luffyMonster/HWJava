/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso4;

import java.util.ArrayList;

/**
 *
 * @author LuffyMonster
 */
public class Bai8 {
    public static void main(String[] args) {
        ArrayList <Integer> aList = new ArrayList<>();
        System.out.println("Thao tac voi ArrayList implements List interface");
        System.out.println("Co truy cap chi so nhu array, lay phan tu vi tri bat ki mat O(1)");
        System.out.println("Cau truc cua ArrayList la 1 array, nen co han che cung nhu thuan loi cua 1 mang.");
        System.out.println("Ban dau: " + aList);
        int i;
        aList.add(1);
        System.out.println("Them 1 vao ArrayList: " + aList);
        aList.add(6);
        aList.add(3);
        System.out.println("Them 6,3 vao ArrayList: " + aList);
        i = 1;
        aList.add(i,5);
        System.out.println("Them 5 vao ArrayList tai vi tri i = 1: " + aList);
        i = 2;
        aList.remove(i);
        System.out.println("Xoa phan tu vi tri i = 2: " + aList);
        System.out.println("Lay phan tu vi tri i = 2: " + aList.get(i));
        System.out.println("Kich thuoc ArrayList hien tai: " + aList.size());
        System.out.println("Kiem tra ArrayList co chua 7 hay khong: " + aList.contains(6));
        i = 1;
        aList.set(i, 6);
        System.out.println("Gan lai gia tri cua phan tu vi tri i = 1 thanh 6:  " + aList);
        aList.sort(null);
        System.out.println("Sap xep ArrayList tang dan: " + aList);
        aList.clear();
        System.out.println("Xoa toan bo ArrayList: " + aList);
    }
}
