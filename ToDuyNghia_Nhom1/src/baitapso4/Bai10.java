/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso4;

import java.util.LinkedList;

/**
 *
 * @author luffy monster
 */
public class Bai10 {
    public static void main(String[] args) {
        System.out.println("Su dung LinkedList implements List interface");
        System.out.println("Xoa va them phan tu nhanh O(1), vi chi can noi thay doi phan tu truoc va sau no.");
        System.out.println("Khong co truy cap RandomAcess nhu array, lay phan tu tai vi tri n mat O(n)");
        LinkedList<Integer> ll = new LinkedList<>();
        System.out.println("Ban dau: " + ll);
        ll.add(3);
        ll.add(1);
        ll.add(5);
        System.out.println("Them 3, 1, 5 vào linkedlist: " + ll);
        ll.addFirst(4);
        System.out.println("Them 4 vao dau linkedlist: " + ll);
        ll.addLast(7);
        System.out.println("Them 7 vao cuoi linkedlist: " + ll);
        System.out.println("Lay phan tu dau cua linkedlist(khong xoa): " + ll.peekFirst() + " | " + ll);
        System.out.println("Lay phan tu cuoi cua linkedlist(khong xoa): " + ll.peekLast() + " | " + ll);
        System.out.println("Lay va xoa phan tu dau cua linked list: " + ll.pollFirst() + " | " + ll);
        System.out.println("Lay va xoa phan tu cuoi cua linked list: " + ll.pollLast() + " | " + ll);
        System.out.println("Kiem tra linkedlist rong? " + ll.isEmpty());
        System.out.print("Duyet linkedlist: " );
        for (Integer i:ll) System.out.print(" " + i);
        System.out.println("");
        System.out.println("LinkedList la 1 Queue, vao truoc ra truoc.");
        
    }
}
