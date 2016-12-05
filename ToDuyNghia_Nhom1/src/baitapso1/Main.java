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
public class Main {
    
    public static boolean laThuanNghich(int i){
        String s = Integer.toString(i);
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
    
    public static boolean laNguyento(int n){
        if ( n < 2) {
            return false;
        }
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int tongChuSo(int n){
        int sum = n%10;
        while (n>0){
            sum += (n/=10)%10;
        }
        return sum;
    }
    public static boolean chiChuSoLe(int n){
        while (n > 0 ){
            if ((n%10)%2 == 0) {
               return false;
            }
            n /= 10;
        }
        return true;
    } 
    public static boolean chiCo068(int n){
        while (n> 0){
            int r = n%10;
            if (r != 0 && r != 6 && r != 8) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
    public static int soDao(int n){
        StringBuilder nn = new StringBuilder(n+"");
        return Integer.parseInt(nn.reverse().toString());
    }
    
    public static boolean allDigitIsPrime(int n){
        while ( n > 0 ){
            if ( !laNguyento(n%10) ) {
                return false;
            }
            n/=10;
        }
        return true;
    }
}
