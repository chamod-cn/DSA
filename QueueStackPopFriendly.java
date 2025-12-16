/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QueueStackPopFriendly;

/**
 *
 * @author chamod Navinda
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;
public class QueueStackPopFriendly {
  private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    
    public QueueStackPopFriendly(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public boolean empty(){
        return q1.isEmpty(); 
    }
    
    public void push(int x){
        q2.add(x);
        
        while(!q1.isEmpty()){
            q2.add((q1.remove())); 
        }
        
        Queue<Integer> temp = q1;
        q1 = q2; 
        q2 = temp; 
    }
    
    public int pop(){
        if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        return q1.remove(); 
    }
    
    public int peek(){
       if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
       return q1.peek(); 
    }
    public static void main(String[] args) {
        QueueStackPopFriendly s = new QueueStackPopFriendly();
        
        System.out.println("Testing Queue Stack (Pop Friendly)\n");
        System.out.println("[  ]");
        System.out.println("isEmpty : " + s.empty());
        
        s.push(3);
        System.out.println("Push : 3");
        s.push(5);
        System.out.println("Push : 5");
        s.push(7);
        System.out.println("Push : 7");
        System.out.println("[3,5,7]");
        System.out.println("= = = = = = = =");
        
        System.out.println("Pop : " + s.pop()); 
        System.out.println("[3,5]\n");
        
        s.push(9);
        System.out.println("Push : 9");
        System.out.println("[3,5,9]\n");
        
        System.out.println("Pop : " + s.pop()); 
        System.out.println("[3,5]\n");
        
        System.out.println("Pop : " + s.pop()); 
        System.out.println("[3]\n");
        
        System.out.println("Peek : " + s.peek()); 
        System.out.println("isEmpty : " + s.empty());
        
    }
    
}
