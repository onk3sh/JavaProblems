package queue;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MyQueue<T>{
        Stack<T> s1 = new Stack<T>();
        Stack<T> s2 = new Stack<T>();
        
        public void enqueue(T value) { // Push onto newest stack
            s1.push(value);
        }
        
        public T peek() {
             prepOldestOnTop();
            return s2.peek();
        }
        
        public T dequeue() {
            prepOldestOnTop();
            return s2.pop();
        }
        
        private void prepOldestOnTop(){
            if(s2.empty()){
                while(!s1.empty()){
                    s2.push(s1.pop());
                }
            }
        }
    
	}

public class UsingTwoStacks{
	
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
            	System.out.println();
            	System.out.print(queue.peek());
            }
        }
        scan.close();
    }
}
