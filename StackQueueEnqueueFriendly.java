/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package StackQueueEnqueueFriendly;

/**
 *
 * @author chamod Navinda
 */
import java.util.Stack;


class EnqueueFriendlyQueue {

    Stack<Integer> s1 = new Stack<>(); // Main stack
    Stack<Integer> s2 = new Stack<>(); // Helper stack

    
    public void enqueue(int x) {
        s1.push(x);
        System.out.println("Enqueue : " + x);
    }

    
    public int dequeue() {

        if (s1.isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }

       
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        
        int dequeued = s2.pop();
        System.out.println("Dequeue : " + dequeued);

        
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return dequeued;
    }

    
    public int peek() {
        if (s1.isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int front = s2.peek();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return front;
    }

    // EMPTY check
    public boolean isEmpty() {
        return s1.isEmpty();
    }

    // DISPLAY queue
    public void display() {
        System.out.println("Queue : " + s1);
    }


    public static void main(String[] args) {

        EnqueueFriendlyQueue q = new EnqueueFriendlyQueue();

        System.out.println("Testing Stack Queue Enqueue Friendly\n");

        System.out.println("isEmpty : " + q.isEmpty());
        System.out.println("[ ]");

        q.enqueue(3);
        q.enqueue(5);
        q.display();

        System.out.println("= = = = =");

        q.dequeue();
        q.display();

        System.out.println("= = = = =");

        q.enqueue(7);
        q.display();

        System.out.println("= = = = =");

        q.dequeue();
        q.display();

        System.out.println("= = = = =");

        System.out.println("Peek : " + q.peek());
        System.out.println("isEmpty : " + q.isEmpty());
    }
}