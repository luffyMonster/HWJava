/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapso3;

/**
 *
 * @author LuffyMonster
 */
public class StackOfChars {
    private char[] elements;
    private int size;
    
    public StackOfChars() {
        this.size = 0;
        this.elements = new char[16];
    }
    
    public StackOfChars(int size) {
        this.size = 0;
        this.elements = new char[size];
    }
    
    public boolean isFull(){
        return this.size == elements.length;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    public char peak(){
        if (this.isEmpty()) {
            System.out.println("Stack is Empty, return /0"); 
           //throw new Exception("Stack is empty");
            return 0;
        }
        return this.elements[size-1];
    }
    
    public char pop(){
        if (this.isEmpty()) {
            System.out.println("Stack is Empty, return -1"); 
           //throw new Exception("Stack is empty");
            return 0;
        }
        return this.elements[size-- - 1];
    }
    
    public void push(char x){
        if (this.isFull()) {
            System.out.println("Stack is full, can't put it");
            return ;
        }
        this.elements[this.size++] = x;
    }
    
    public int getSize() {
        return size;
    }
    
}
