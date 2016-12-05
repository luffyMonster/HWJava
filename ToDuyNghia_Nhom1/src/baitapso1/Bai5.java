/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso1;

/**
 *
 * @author LuffyMonster
 */
public class Bai5 {
    
    static void doIt(){
        
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%d x %d = %d\n", i, j, i*j);
            }
            System.out.println("===========");
                
        }
    }
    public static void main(String[] args) {
            System.out.printf("Ket qua: \n");
            doIt();       
    }
}
