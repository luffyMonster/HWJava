/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2.model;

/**
 *
 * @author luffy monster
 */
public interface IO {
    String[] read(java.util.Scanner in);
    void write(java.io.PrintWriter pw);
    boolean set(String[] o);
    Object[] toObject();
}
