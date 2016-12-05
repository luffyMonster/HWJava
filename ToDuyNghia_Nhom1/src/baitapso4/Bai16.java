/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author luffy monster
 */
public class Bai16 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Su dung HashMap");
        /*
         * Sử dụng lưu trữ 1 cặp giá trị key-value, dựa trên hashcode của key
         * Key nên được override equals và hashcode method
         * Không được trùng key, nếu trùng key sẽ update value của key đó
         * null được chấp nhận là 1 key
         * Phép lấy/xóa value của 1 key mất O(1) vì lấy/xóa theo hashcode của key
         */
        HashMap<String, Integer> hmap = new HashMap<>();
        System.out.println("Ban dau: " + hmap);

        hmap.put("USA", 100);
        hmap.put("VN", 200);
        hmap.put("BRS", 300);
        System.out.println("Thêm 1 số cặp key-value: " + hmap);

        hmap.put("VN", 500);
        System.out.println("Thêm vào cặp key-value(VN-500) mà key đó đã có trong hashmap: " + hmap);
        System.out.println("//Gia tri cua USA da bi sua doi tu 200 -> 100\n");

        hmap.put(null, 0);
        System.out.println("Them 1 khoa null: " + hmap);

        hmap.put("Japan", 310);
        hmap.put("China", -1);
        hmap.put("Cuba", 100);
        System.out.println("(Them 1 so phan tu vao hashmap)..." + hmap);

        System.out.println("Lay value cua 1 key(VN): " + hmap.get("VN"));
        System.out.println("Lay value cua 1 key ma chua co trong hashmap: " + hmap.get("xxx"));

        hmap.remove("China");
        hmap.remove("Unknow");//Nếu key ko có trong hashmap thì ko xoa 
        System.out.println("Xoa phan tu co key la China: " + hmap);

        //hmap.remove("BRS", 300);
        hmap.remove("BRS", 200);
        System.out.println("Xoa phan tu co key la BRS neu no co value dung bang 300, neu khong khong xoa: " + hmap);

        System.out.println("Kiem tra 1 key(VN) da co trong hashmap chua: " + hmap.containsKey("VN"));
        System.out.println("Kiem tra 1 value(101) da co trong hashmap chua: " + hmap.containsValue(101));

        System.out.println("Kich thuoc hashmap: " + hmap.size());
        System.out.println("Kiem tra rong: " + hmap.isEmpty());
        System.out.println("Tap cac key: " + hmap.keySet());
        System.out.println("Tap cac value: " + hmap.values());
        System.out.println("Entry set(Khoan muc): " + hmap.entrySet());

        hmap.clear();
        System.out.println("Xoa tat ca key-value: " + hmap);

        System.out.println("------------------------------------");
        System.out.println("Vi du su dung: Doc tat ca User va password tu file.\n"
                + " In ra man hinh tat ca User va password tuong ung.\n"
                + " Neu account duoc lap lai thi cap nhat password.\n"
                + " Pass khong chua khoang trang");
        new Bai16().VDHashMap();

    }

    void VDHashMap() throws FileNotFoundException {
        System.setIn(new FileInputStream(new File("VDHASHMAP.INP")));
        Scanner in = new Scanner(System.in);
        HashMap<String, String> acc = new HashMap<>();
        try {
            while (true) {
                acc.put(in.next(), in.nextLine().trim());
            }
        } catch (Exception e) {
            //het file
        }
        
        for (String key : acc.keySet()) {
            System.out.println("User: " + key + "\tPassword: " + acc.get(key));
        }
    }
}
