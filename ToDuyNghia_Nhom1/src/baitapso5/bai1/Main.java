/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso5.bai1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author luffy monster
 */
public class Main {

    static Scanner in;
    static ArrayList<Sach> listSach;
    static ArrayList<BanDoc> listBD;
    static ArrayList<QuanLy> listQL;
    static int idS;
    static int idBD;

    static void docFile(String fname) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream f;
        ObjectInputStream ois;
        try {
            f = new FileInputStream(fname);
            ois = new ObjectInputStream(f);
            while (true) {
                try {
                    Object o = ois.readObject();
                    if (o instanceof Sach) {
                        listSach.add((Sach) o);
                    } else if (o instanceof BanDoc) {
                        listBD.add((BanDoc) o);
                    } else if (o instanceof QuanLy) {
                        listQL.add((QuanLy) o);
                    } else {
                        throw new Exception();
                    }
                } catch (EOFException e) {
                    break;
                } catch (Exception e) {
                    // e.printStackTrace();
                    ois = new ObjectInputStream(f);
                }
            }
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            System.err.println("Luong doc loi!");
//            e.printStackTrace();
        } finally {
        }
    }

    static void ghiFile(ArrayList list, String fname) throws FileNotFoundException, IOException {
        FileOutputStream f = new FileOutputStream(fname);
        ObjectOutputStream oos = new ObjectOutputStream(f);
        for (Object s : list) {
            oos.writeObject(s);
        }
        f.close();
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        in = new Scanner(System.in);
        listBD = new ArrayList<>();
        listSach = new ArrayList<>();
        listQL = new ArrayList<>();
        docFile("SACH.INP");
        docFile("BD.INP");
        docFile("QL.INP");
        idS = listSach.size() + 1000;
        idBD = listBD.size() + 1000;
        loop:
        while (true) {
            System.out.println("================================");
            System.out.println(">>Nhan phim bat ky de thoat<<");
            System.out.println("1, Nhap list dau sach moi. ");
            System.out.println("11, In list dau sach da co.");
            System.out.println("2, Nhap list ban doc.");
            System.out.println("21,  In list ban doc da co.");
            System.out.println("3, Lap Bang QL muon sach.");
            System.out.println("31, Hien thi bang QL");
            System.out.println("41, Sap xep theo ten.");
            System.out.println("41, Sap xep theo tong so cuon sach muon.");
            System.out.println("5, Tim kiem va hien thi theo ten.");
            System.out.print("Lua chon: ");
            int t = -1;
            try {
                t = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
            }
            switch (t) {
                case 1:
                    themSach();
                    break;
                case 11:
                    hienThi(listSach);
                    break;

                case 2:
                    themBD();
                    break;
                case 21:
                    hienThi(listBD);
                    break;
                case 3:
                    quanLy();
                    break;
                case 31:
                    inBQL();
                    break;
                case 41:
                    sxByName();
                    inBQL();
                    break;
                case 42:
                    sxByTongSoCuon();
                    inBQL();
                    break;
                case 5:
                    timKiem();
                    break;
                default:
                    break loop;
            }
        }
        ghiFile(listSach, "SACH.INP");
        ghiFile(listBD, "BD.INP");
        ghiFile(listQL, "QL.INP");
    }

    static void timKiem() {
        System.out.println("=================================");
        int id;
        System.out.println("Nhap ID ban doc: ");
        BanDoc target;
        loop: while (true) {
            try {
                id = Integer.parseInt(in.nextLine());
                for (BanDoc bd : listBD) {
                    if (bd.getID() == id) {
                        target = bd;
                        break loop;
                    }
                }
            } catch (Exception e) {
                System.out.println("Nhap lai.");
            }
        }
        for (QuanLy ql:listQL){
            if (ql.getBanDoc().equals(target)){
                ql.hienThi();
            }
        }
    }

    static void hienThi(ArrayList list) {
        if (list.size() == 0) {
            System.out.println("Rong.");
            return;
        }
        if (list.get(0) instanceof Sach) {
            System.out.println("Dau sach da co: ");
            System.out.println("(ID, Ten, Tac Gia, Nam XB)");
        } else {
            System.out.println("Danh sach ban doc: ");
            System.out.println("(ID, Ten, Dia chi, SDT, Loai)");
        }
        for (Object o : list) {
            System.out.println(o);
        }
    }

    static void themSach() {
        System.out.println("=================================");
        Sach s = new Sach(idS++);
        s.nhap(in);
        listSach.add(s);
    }

    static void themBD() {
        System.out.println("=================================");
        BanDoc bd = new BanDoc(idBD++);
        bd.nhap(in);
        listBD.add(bd);
    }

    static void quanLy() {
        System.out.println("==============================");
        for (BanDoc bd : listBD) {
            QuanLy temp = getQL(bd);

            if (temp == null) {
                temp = new QuanLy(bd);
                listQL.add(temp);
            }
            System.out.println("---------------------------");
            System.out.println(bd);
            for (int i = 0; i < 5; i++) {
                if (temp.lSachSize() == listSach.size()) {
                    System.out.println("Ban da muon tat ca dau sach!");
                    break;
                }
                System.out.println("Nhap ID dau sach muon them: ");
                int sl = 0;
                Sach s = null;
                while (true) {
                    try {
                        int id = Integer.parseInt(in.nextLine());
                        if ((s = getSach(id)) == null || temp.exist(id)) {
                            throw new Exception();
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Loi. Nhap lai.");
                    }
                }
                while (true) {
                    System.out.println("Nhap so luong can muon: ");
                    try {
                        sl = Integer.parseInt(in.nextLine());
                        if (sl < 1 || sl > 3) {
                            throw new Exception();
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Loi. Ban chi duoc muon 1-3 cuon.");
                    }
                }
                temp.add(s, sl);
                System.out.println("Tiep tuc? (Nhan 1)");
                try {
                    if (in.nextLine() != "1") {
                        break;
                    }
                } catch (Exception e) {
                    break;
                }

            }

        }
    }

    static QuanLy getQL(BanDoc bd) {
        for (QuanLy ql : listQL) {
            if (bd.equals(ql.getBanDoc())) {
                return ql;
            }
        }
        return null;
    }

    static void sxByName() {
        System.out.println("===============================");
        System.out.println("Sap xep theo ten");
        Collections.sort(listQL, new Comparator<QuanLy>() {
            @Override
            public int compare(QuanLy o1, QuanLy o2) {
                return o1.getBanDoc().getTen().compareTo(o2.getBanDoc().getTen());
            }
        });
    }

    static void sxByTongSoCuon() {
        System.out.println("================================");
        System.out.println("Sap xep theo tong so cuong sach muon");
        Collections.sort(listQL, new Comparator<QuanLy>() {
            @Override
            public int compare(QuanLy o1, QuanLy o2) {
                return o1.getTong() - o2.getTong();
            }
        });
    }

    static void inBQL() {
        for (QuanLy ql : listQL) {
            ql.hienThi();
        }
    }

    static Sach getSach(int id) {
        for (Sach s : listSach) {
            if (id == s.getID()) {
                return s;
            }
        }
        return null;
    }

}
