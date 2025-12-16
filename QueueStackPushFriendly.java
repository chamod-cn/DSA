/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QueueStackPushFriendly;

/**
 *
 * @author chamod Navinda
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;
public class QueueStackPushFriendly {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    
    public QueueStackPushFriendly(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x){
        q1.add(x); // enqueue
    }
    
    public boolean empty(){
        return q1.isEmpty(); // isEmpty
    }
    
    public int pop(){
        if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        
        while(q1.size()>1){
            q2.add(q1.remove()); 
        }
        
        int popped = q1.remove(); // dequeue
        
        Queue<Integer> temp = q1;
        q1 = q2; 
        q2 = temp; 
        
        return popped;
    }
    
    public int peek(){
         if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        
        while(q1.size()>1){
            q2.add(q1.remove()); 
        }
        
        int top = q1.peek(); // peek
        q2.add(q1.remove()); // put element back
        
        Queue<Integer> temp = q1;
        q1 = q2; 
        q1 = temp; 
        
        return top;
    }
    public static void main(String[] args) {
        QueueStackPushFriendly s = new QueueStackPushFriendly();
        
        System.out.println("Testing Queue Stack (Push Friendly)\n");
        System.out.println("[  ]");
        System.out.println("isEmpty : " + s.empty());
        
        s.push(3);
        System.out.println("Push : 3");
        s.push(5);
        System.out.println("Push : 5");
        s.push(7);
        System.out.println("Push : 7");
        System.out.println("[3,5,7]");
        
        
        System.out.println("Pop : " + s.pop()); // remove 7
        System.out.println("[3,5]\n");
        
        s.push(9);
        System.out.println("Push : 9");
        System.out.println("[3,5,9]\n");
        
        System.out.println("Pop : " + s.pop()); // remove 9
        System.out.println("[3,5]\n");
        
        System.out.println("Pop : " + s.pop()); // remove 5
        System.out.println("[3]\n");
        
        System.out.println("Peek : " + s.peek()); // show 3
        System.out.println("isEmpty : " + s.empty());
    }
    
}
