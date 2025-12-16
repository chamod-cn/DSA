/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UnboundedArrayStack;

import java.util.NoSuchElementException;

/**
 *
 * @author chamod Navinda
 */
public class UnboundedArrayStack {

    private int[] stack;
    private int top;
    private int capacity;

    
    public UnboundedArrayStack() {
        capacity = 2;              // initial size
        stack = new int[capacity];
        top = -1;                  // stack is empty
    }

    
    public void push(int x) {

        // If stack is full, resize
        if (top == capacity - 1) {
            resize();
        }

        stack[++top] = x;
        System.out.println("Push : " + x +  " | Size : " + size() +  " | Capacity : " + capacity);
                
                
    }

    // POP operation
    public int pop() {

        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        }

        int popped = stack[top--];
        System.out.println("Pop : " + popped +  " | Size : " + size() +  " | Capacity : " + capacity);
              
        return popped;
    }

    
    public int peek() {

        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        }

        return stack[top];
    }

    
    public boolean isEmpty() {
        return top == -1;
    }

    
    public int size() {
        return top + 1;
    }

   
    private void resize() {
        capacity = capacity * 2;
        int[] newStack = new int[capacity];

        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
        System.out.println("Stack Resized → New Capacity : " + capacity);
    }

   
    public void display() {

        if (isEmpty()) {
            System.out.println("[ ]");
            return;
        }

        System.out.print("Stack : [ ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println("]");
    }

    
    public static void main(String[] args) {

        UnboundedArrayStack s = new UnboundedArrayStack();

        System.out.println("Testing Unbounded Array Stack\n");

        System.out.println("isEmpty : " + s.isEmpty());
        System.out.println("= = = = = =");

        s.push(3);
        s.push(5);
        s.display();

        System.out.println("= = = = = =");

        s.push(7);   
        s.display();

        System.out.println("= = = = = =");
        
        s.push(9);   
        s.display();

        System.out.println("= = = = = =");

        s.pop();
        s.display();

        System.out.println("= = = = = =");

        System.out.println("Peek : " + s.peek());
        System.out.println("isEmpty : " + s.isEmpty());
    }
}