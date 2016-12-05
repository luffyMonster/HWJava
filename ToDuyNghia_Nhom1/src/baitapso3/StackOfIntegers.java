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
public class StackOfIntegers {
    private int[] elements;
    private int size;
    
    public StackOfIntegers() {
        this.size = 0;
        this.elements = new int[16];
    }
    
    public StackOfIntegers(int size) {
        this.size = 0;
        this.elements = new int[size];
    }
    
    public boolean isFull(){
        return this.size == elements.length;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    public int peak(){
        if (this.isEmpty()) {
            System.out.println("Stack is Empty, return -1"); 
           //throw new Exception("Stack is empty");
            return -1;
        }
        return this.elements[size-1];
    }
    
    public int pop(){
        if (this.isEmpty()) {
            System.out.println("Stack is Empty, return -1"); 
           //throw new Exception("Stack is empty");
            return -1;
        }
        return this.elements[size-- - 1];
    }
    
    public void push(int x){
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
