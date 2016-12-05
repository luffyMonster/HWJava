/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso2;

/**
 *
 * @author LuffyMonster
 */
public class Bai10 {
    public static void main(String[] args) {
        int a[] = Main.makeRandomArray();
        System.out.print("\nMang A: ");
        
        Main.sort(a);
        Main.displayArray(a);
        int index = 1, maxLength = 1, begIndex = 0;
        while (index < a.length){
            int beg = index;
            while (index < a.length && a[index] >= a[index-1]) index++;//1 2 4 2 3
            if (index - beg > maxLength) {
                maxLength = index - beg;
                begIndex = beg;
            }
            index = ++beg;
        }
        System.out.println("\nĐường chạy dài nhất: " + begIndex + " " + maxLength);
        System.out.print("Gồm: ");
        for (int i = 0; i < maxLength; i++) {
            System.out.print(a[begIndex + i]+ " ");
        }
    }
}