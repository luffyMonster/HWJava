/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1.view;

import bai1.model.BanDoc;
import bai1.model.IO;
import bai1.model.QL;
import bai1.model.Sach;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luffy monster
 */
public class View extends javax.swing.JFrame {
    
    ArrayList<Sach> lS = new ArrayList<Sach>();
    ArrayList<BanDoc> lBD = new ArrayList<BanDoc>();
    ArrayList<QL> lQL = new ArrayList<QL>();
    int idS;
    int idBD;
    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        docFile(Sach.class, lS, "SACH.INP");
        docFile(BanDoc.class, lBD, "BD.INP");
        loadTable(tbSach, lS);
        loadTable(tbBD, lBD);
        loadTable(tbQL, lQL);
        idS = 1000 + lS.size();
        idBD = 1000 + lBD.size();
        
        for (BanDoc bd:lBD){
            cbBD.addItem(bd.getId());
        }
        for (Sach s: lS){
            cbS.addItem(s.getId());
        }
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                try {
                    ghiFile(lS, "SACH.INP");
                    ghiFile(lBD, "BD.INP");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
    }
    <E extends IO> void loadTable(JTable table, ArrayList<E> l){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.getDataVector().removeAllElements();
        for( E e: l){
            model.addRow(e.toObject());
        }
    }
    <E extends IO> void docFile(Class<E> cl, ArrayList<E> list, String f){
        try {
            Scanner in = new Scanner(new File(f));
            while (true){
                E e = cl.newInstance();
                String[] o = e.read(in);
                if(e.set(o)) {
                    list.add(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            //Het file
        }      
    }
    <E extends IO>void ghiFile(ArrayList<E> list, String f) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File(f));
        for (E e: list){
            e.write(pw);
        }
        pw.close();
    }
    void themS(){
        String o[] = new String[5];
        o[0] = ""+idS++;
        o[1] = tfTenS.getText().trim();
        o[2] = tfTacGia.getText().trim();
        o[3] = cbChuyenNganh.getSelectedItem().toString();
        o[4] = tfNam.getText().trim();
        Sach s = new Sach();
        if (s.set(o)){
            lS.add(s);
            ((DefaultTableModel)tbSach.getModel()).addRow(s.toObject());
            cbS.addItem(s.getId());
        }  else {
            JOptionPane.showMessageDialog(this, "Fail");
        }
    }
    void themBD(){
        String o[] = new String[5];
        o[0] = ""+idBD++;
        o[1] = tfTenBD.getText().trim();
        o[2] = tfDiaChi.getText().trim();
        o[3] = tfSDT.getText().trim();
        o[4] = tfLoai.getText().trim();
        BanDoc s = new BanDoc();
        if (s.set(o)){
            System.out.println(Arrays.toString(o));
            lBD.add(s);
            ((DefaultTableModel)tbBD.getModel()).addRow(o);
            cbBD.addItem(s.getId());
        }   else {
            JOptionPane.showMessageDialog(this, "Fail");
        }
    }
    void themQL(){
        int idBD = Integer.parseInt(cbBD.getSelectedItem().toString());
        int idS = Integer.parseInt(cbS.getSelectedItem().toString());
        int sl;
        try {
           sl = Integer.parseInt(tfSL.getText().trim());
           if (sl > 3 || sl < 0 ) throw new Exception();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fail");
            return;
        }

        QL ql = findQL(idBD);
        if (ql == null){
            ql = new QL(findBD(idBD));
            if (ql.add(findS(idS), sl)){
                ((DefaultTableModel)tbQL.getModel()).addRow(ql.toObject());
                lQL.add(ql);
            } else {
                JOptionPane.showMessageDialog(this, "Thu lai");
            }
            
        } else {
            if (ql.add(findS(idS), sl)){
                update(ql, idBD);
            } else {
                JOptionPane.showMessageDialog(this, "Thu lai");
            }
        }       
        
    }
    void update(QL ql,int idBD){
        DefaultTableModel model = (DefaultTableModel) tbQL.getModel();
                int n = model.getRowCount();
                for (int i = 0; i < n; i++) {
                    int value = Integer.parseInt(model.getValueAt(i, 0).toString());
                    if (value == idBD) {
                        model.removeRow(i);
                        model.insertRow(i, ql.toObject());
                        break;
                    }
                }
    }
    Sach findS(int id){
        for (Sach s:lS){
            if(s.getId() == id) return s;
        }
        return null;
    }
    BanDoc findBD(int id){
        for (BanDoc bd:lBD){
            if(bd.getId() == id) return bd;
        }
        return null;
    }
    
    QL findQL(int id){
        for (QL ql:lQL){
            if (ql.getBd().getId() == id){
                return ql;
            }
        }
        return null;
    }
    void TKBT(){
        try {
            int id = Integer.parseInt(tfTK.getText().trim());
            QL ql = findQL(id);
            if (ql==null) throw new Exception();
            loadTable(tbTK, new ArrayList<>());
            ((DefaultTableModel)tbTK.getModel()).addRow(ql.toObject());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fail");
        }
        
    }
    void SXBT(){
        if (cbSX.getSelectedIndex() == 0) {
            sxTheoTen();
            loadTable(tbQL, lQL);
            System.out.println(lQL.size());
        }
        else {
            sxTheoSL();
            loadTable(tbQL, lQL);
        }
    }
    void sxTheoTen(){
        Collections.sort(lQL, new Comparator<QL>() {

            @Override
            public int compare(QL o1, QL o2) {
                return o1.getBd().getTen().compareTo(o2.getBd().getTen());
            }
        });
    }
     void sxTheoSL(){
        Collections.sort(lQL, new Comparator<QL>() {

            @Override
            public int compare(QL o1, QL o2) {
                return o1.getSl() - o2.getSl();
            }
        });
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSach = new javax.swing.JTable();
        tfTenS = new javax.swing.JTextField();
        tfTacGia = new javax.swing.JTextField();
        btThemS = new javax.swing.JButton();
        tfNam = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbChuyenNganh = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBD = new javax.swing.JTable();
        tfTenBD = new javax.swing.JTextField();
        tfDiaChi = new javax.swing.JTextField();
        tfSDT = new javax.swing.JTextField();
        btThemBD = new javax.swing.JButton();
        tfLoai = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbQL = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbBD = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cbS = new javax.swing.JComboBox();
        btThemQL = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        tfSL = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbSX = new javax.swing.JComboBox();
        btSX = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfTK = new javax.swing.JTextField();
        btTK = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbTK = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Them Sach");

        jLabel2.setText("Ten sach");

        jLabel3.setText("Tac gia");

        jLabel4.setText("Chuyen nganh");

        tbSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ten Sach", "Chuyen Nganh", "Tac Gia"
            }
        ));
        jScrollPane1.setViewportView(tbSach);

        tfTenS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTenSActionPerformed(evt);
            }
        });

        btThemS.setText("Them");
        btThemS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemSActionPerformed(evt);
            }
        });

        tfNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamActionPerformed(evt);
            }
        });

        jLabel13.setText("Nam");

        cbChuyenNganh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KHTN", "VHNT", "DTVT", "CNTT" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13))
                        .addGap(124, 124, 124)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbChuyenNganh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfTenS, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(tfTacGia)
                            .addComponent(tfNam)
                            .addComponent(btThemS, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(87, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTenS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbChuyenNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(btThemS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sach", jPanel1);

        jLabel9.setText("BD");

        jLabel10.setText("Ten");

        jLabel11.setText("DiaChi");

        jLabel12.setText("SDT");

        tbBD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbBD);

        tfTenBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTenBDActionPerformed(evt);
            }
        });

        tfSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSDTActionPerformed(evt);
            }
        });

        btThemBD.setText("Them");
        btThemBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemBDActionPerformed(evt);
            }
        });

        jLabel5.setText("Loai");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btThemBD)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(135, 135, 135)
                            .addComponent(jLabel9))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel10)
                                .addComponent(jLabel12)
                                .addComponent(jLabel5))
                            .addGap(124, 124, 124)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfLoai, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfTenBD, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(tfDiaChi)
                                .addComponent(tfSDT)))))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTenBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btThemBD)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("BanDoc", jPanel2);

        tbQL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID BD", "Ten BD", "ID Sach / SL"
            }
        ));
        jScrollPane2.setViewportView(tbQL);

        jLabel6.setText("QL");

        jLabel7.setText("BanDoc");

        jLabel8.setText("Sach");

        btThemQL.setText("Them");
        btThemQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemQLActionPerformed(evt);
            }
        });

        jLabel14.setText("jLabel14");

        tfSL.setText("1");

        jLabel15.setText("Sap xep");

        cbSX.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "theo ten", "theo SL" }));

        btSX.setText("thuc hien");
        btSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbBD, 0, 109, Short.MAX_VALUE)
                            .addComponent(cbS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfSL)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btSX)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(36, 36, 36)
                                .addComponent(cbSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(btThemQL)))
                .addGap(90, 90, 90))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(16, 16, 16)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cbS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btThemQL)
                            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSX)
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(tfSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("QL", jPanel);

        jLabel16.setText("jLabel16");

        jLabel17.setText("Nhap ID BD");

        btTK.setText("Tim Kiem");
        btTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTKActionPerformed(evt);
            }
        });

        tbTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbTK);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel16))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel17)
                        .addGap(79, 79, 79)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btTK)
                            .addComponent(tfTK, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(tfTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(btTK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("TK", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfTenSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTenSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTenSActionPerformed

    private void tfTenBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTenBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTenBDActionPerformed

    private void tfSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSDTActionPerformed

    private void tfNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamActionPerformed

    private void btThemBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemBDActionPerformed
        // TODO add your handling code here:the
        themBD();
    }//GEN-LAST:event_btThemBDActionPerformed

    private void btThemSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemSActionPerformed
        // TODO add your handling code here:
        themS();
    }//GEN-LAST:event_btThemSActionPerformed

    private void btThemQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemQLActionPerformed
            // TODO add your handling code here:
        themQL();
    }//GEN-LAST:event_btThemQLActionPerformed

    private void btTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTKActionPerformed
        // TODO add your handling code here:
        TKBT();
    }//GEN-LAST:event_btTKActionPerformed

    private void btSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSXActionPerformed
        SXBT();
        // TODO add your handling code here:
    }//GEN-LAST:event_btSXActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSX;
    private javax.swing.JButton btTK;
    private javax.swing.JButton btThemBD;
    private javax.swing.JButton btThemQL;
    private javax.swing.JButton btThemS;
    private javax.swing.JComboBox cbBD;
    private javax.swing.JComboBox cbChuyenNganh;
    private javax.swing.JComboBox cbS;
    private javax.swing.JComboBox cbSX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbBD;
    private javax.swing.JTable tbQL;
    private javax.swing.JTable tbSach;
    private javax.swing.JTable tbTK;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfLoai;
    private javax.swing.JTextField tfNam;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfSL;
    private javax.swing.JTextField tfTK;
    private javax.swing.JTextField tfTacGia;
    private javax.swing.JTextField tfTenBD;
    private javax.swing.JTextField tfTenS;
    // End of variables declaration//GEN-END:variables
}
