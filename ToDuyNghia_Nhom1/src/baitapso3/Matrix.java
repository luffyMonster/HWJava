/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author LuffyMonster
 */
public class Matrix {
    private float a[][];

    public float[][] getA() {
        return a;
    }

  
    public Matrix(){
        this.a = new float[3][3];
    }
    
    public Matrix( int rows, int cols ){
        this.a = new float[rows][cols];
    }
    
    public Matrix add(Matrix m){
        if (this.a.length != m.getA().length || this.a[0].length != m.getA()[0].length) {
            System.out.println("Khong the cong 2 ma tran nay!");
            return null;
        }
        Matrix m1 = new Matrix(a.length, a[0].length);
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                m1.getA()[i][j] = a[i][j] + m.getA()[i][j];
            }
        }
        
        return m1;
    }
    
    public Matrix neg(){
        Matrix m = new Matrix(a.length, a[0].length);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                m.getA()[i][j] = -a[i][j];
            }
        }
        return m;
    }
    
    public Matrix sub(Matrix m){
        if (a.length != m.getA().length || a[0].length != m.getA()[0].length) {
            System.out.println("Khong the tru 2 ma tran nay!");
            return null;
        }
        return this.add( m.neg() );
    }
    
    public Matrix transpose(){
        Matrix m = new Matrix(a[0].length, a.length);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                m.getA()[j][i] = a[i][j];
            }
        }
        return m;
    }
    
    public Matrix mul(Matrix m){
        if (a[0].length != m.getA().length) {
            System.out.println("So hang cot cua 2 ma tran  khong hop le!");
            return null;
        }
        
        int r = a.length, c = m.getA()[0].length;
        Matrix res = new Matrix(r, c);
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res.getA()[i][j] = 0;
                for (int k = 0; k < a[0].length; k++) {
                    res.getA()[i][j] += a[i][k]*m.getA()[k][j];
                }
            }
        }
        return res;
    }
    public void print(){
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("Nhap a[" +i+"]["+j+"]: ");
                a[i][j] = in.nextFloat();                
            }
        }
    }
}
